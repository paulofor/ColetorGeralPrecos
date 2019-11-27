package coletapreco.app;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.MySqlDataSource;
import coletapreco.dao.basica.DataSourceAplicacao;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.LojaVirtual;
import coletapreco.parse.regracolecaoadaptador.custom.CategoriaLojaAdaptador;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;

public class SimuladorParaNovaLoja {
	
	private static long CODIGO_LOJA = 16;
	private static long CODIGO_NATUREZA = 17;
	
	//private static String URL_INICIAL = "http://www.zattini.com.br/calcados/feminino/?sortby=mais-vendidos";
	//private static String URL_INICIAL = "http://www.lojasrenner.com.br/c/feminino/calcados?ref_click=menu%7Cfeminino%7Ccalcados";
	//private static String URL_INICIAL = "http://www.passarela.com.br/vitrine/calcados/feminino/novo/N-26vtZ1z13eauZ1z12rxo";
	
	private static String URL_INICIAL = "https://www.arezzo.com.br/c/sapatos";
	
	
	
	public static void main(String[] args) {
		
		LojaVirtualRegraColecao lojaSrv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();

		try {
			MySqlDataSource ds1 = new DataSourceAplicacao();
			DaoConexao conexao = ds1.criaConexao();
		
			CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
			categoria.setUrl(URL_INICIAL);
			categoria.setIdNaturezaProdutoRa(CODIGO_NATUREZA);
			categoria.setIdLojaVirtualPa(CODIGO_LOJA);
		
			LojaVirtual loja = lojaSrv.obtemPorChave(CODIGO_LOJA);
			CategoriaLojaAdaptador adaptadorCategoria = new CategoriaLojaAdaptador();
			System.out.println("Categoria:" + categoria.getNome());
			adaptadorCategoria.setItem(loja);
			adaptadorCategoria.atualizaDetalhe(categoria, conexao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
