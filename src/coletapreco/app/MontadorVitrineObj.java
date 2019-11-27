package coletapreco.app;

import java.util.ArrayList;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.ArquivoLog;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.modelo.Produto;
import coletapreco.modelo.ProdutoCliente;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;
import coletapreco.regracolecao.ProdutoClienteRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class MontadorVitrineObj {

	private AppProdutoRegraColecao appProdutoSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
	private ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
	private ProdutoClienteRegraColecao produtoClienteSrv = FabricaRegra.getInstancia().getProdutoClienteRegraColecao();
	
	private NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
	
	public void executa() throws DaoException {
		System.out.println("Ola Mundo ! - Iniciando MontadorVitrine de HOJE");
		List<AppProduto> listaApp = appProdutoSrv.ListaAtivoComVitrine();
		int contaProdutoApp = 0;
		for (AppProduto app : listaApp) {
			System.out.println("Aplicacao: " + app.getNome());
			List<NaturezaProduto> listaNatureza = naturezaSrv.getPorAtendidoPorAppProduto(app.getIdObj());
			for (NaturezaProduto natureza : listaNatureza) {
				System.out.println("Natureza: " + natureza.getNomeNaturezaProduto() + "(" + natureza.getIdNaturezaProduto() + ")");
				produtoSrv.getFiltro().setCodigoNatureza(natureza.getIdObj());
				produtoSrv.getFiltro().setLimitePosicionador(app.getLimitePosicionador());
				produtoSrv.getFiltro().setDiasPrecoVitrine(app.getDiasPrecoVitrine());
				coletapreco.log.ArquivoLog.getInstancia().salvaLogEtapa("Antes de Obter Lista Produto");
				List<Produto> listaProduto = produtoSrv.ListaMelhoresPorNaturezaLimite();
				
				// Tratamento loja Difiti
				if (natureza.getIdNaturezaProduto()==17) {
					produtoSrv.setListaEntradaItem(listaProduto);
					produtoSrv.AjustaNomeLista();
				}
				
				coletapreco.log.ArquivoLog.getInstancia().salvaLogEtapa("Após de Obter Lista Produto");
				List<ProdutoCliente> listaProdutoCliente = new ArrayList<ProdutoCliente>();
				//for (Produto produto : listaProduto) {
				//	System.out.println("ID:" + produto.getIdProduto() + " Nome: " + produto.getNome());
				//}
				
				for (Produto produto : listaProduto) {
					produtoClienteSrv.getFiltro().setOrigem(produto);
					produtoClienteSrv.getFiltro().setCodigoNatureza(natureza.getIdNaturezaProduto());
					ProdutoCliente produtoCliente = produtoClienteSrv.CriaDeOrigem(null);
					produtoCliente.setData(DatasUtils.getDataDD_MM_AAAA());
					contaProdutoApp++;
					System.out.println(contaProdutoApp + " - " + produtoCliente.getNome() + " (" + produtoCliente.getIdObj() + ") ");
					listaProdutoCliente.add(produtoCliente);
				}
				coletapreco.log.ArquivoLog.getInstancia().salvaLogEtapa("Final loop de produtos");
				produtoClienteSrv.setListaEntradaItem(listaProdutoCliente);
				listaProdutoCliente = produtoClienteSrv.RetiraDuplicata();
				coletapreco.log.ArquivoLog.getInstancia().salvaLogEtapa("Final RetiraDuplicata");
				produtoClienteSrv.setListaEntradaItem(listaProdutoCliente);
				
				produtoClienteSrv.getFiltro().setCodigoNatureza(natureza.getIdNaturezaProduto());
				produtoClienteSrv.ReinicializaNaturezaLista();
				System.out.println("Finalizou natureza");
			}
		}
		System.out.println("Finalizou o montador Vitrine.");
	}
}
