package coletapreco.desen;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.DBB;
import coletapreco.dao.LojaVirtualDao;
import coletapreco.dao.ProdutoDao;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.LojaVirtual;
import coletapreco.parse.regracolecaoadaptador.custom.CategoriaLojaAdaptador;

public class TesteLojaApp {

	public static void main(String[] args) {
		String url;
		//url = "https://www.atacadodemaquiagem.com.br/pagina/5c3a4/labios";
		//url = "https://www.carmosbr.com.br/categoria-produto/olhos/?orderby=popularity";
		//url = "https://www.cristalcosmetic.com.br/maquiagem?dir=asc&limit=36&order=position";
		//url = "https://www.virtualmake.com.br/maquiagem?by=bestsellers%2Fdesc";
		url = "https://www.americanas.com.br/categoria/beleza-e-perfumaria/maquiagem/labios?ordenacao=topSelling";
		ProdutoDao daoProduto = DBB.getInstancia().getProdutoDao();
		DaoConexao conexao;
		CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
		categoria.setUrl(url);
		categoria.setIdCategoriaLoja(999);
		categoria.setNome("Teste");
		categoria.setDataInclusao("2019-07-19");
		
		LojaVirtual loja = FabricaVo.criaLojaVirtual();
		loja.setIdLojaVirtual(1);
		
		CategoriaLojaAdaptador adaptadorCategoria = new CategoriaLojaAdaptador();
		//adaptadorCategoria.setItem(loja);
		try {
			conexao = getDao().criaConexao();
			adaptadorCategoria.setItem(loja);
			adaptadorCategoria.atualizaDetalhe(categoria, conexao);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final LojaVirtualDao getDao() {
		return DBB.getInstancia().getLojaVirtualDao();
	}

}
