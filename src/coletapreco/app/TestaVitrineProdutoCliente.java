package coletapreco.app;

import java.util.ArrayList;
import java.util.List;

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

public class TestaVitrineProdutoCliente {

	
	private static long CODIGO_NAUREZA = 17;
	private static long CODIGO_APP = 1;
	
	static private AppProdutoRegraColecao appProdutoSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
	static private ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
	static private ProdutoClienteRegraColecao produtoClienteSrv = FabricaRegra.getInstancia().getProdutoClienteRegraColecao();
	
	static private NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();

	
	public static void main(String[] args) {
		
		// Extraido de MontadorVitrineObj
		
		try {
			
			AppProduto app = appProdutoSrv.obtemPorChave(CODIGO_APP);
			NaturezaProduto natureza = naturezaSrv.obtemPorChave(CODIGO_NAUREZA);
			System.out.println("Natureza: " + natureza.getNomeNaturezaProduto() + "(" + natureza.getIdNaturezaProduto() + ")");
			produtoSrv.getFiltro().setCodigoNatureza(natureza.getIdObj());
			produtoSrv.getFiltro().setLimitePosicionador(app.getLimitePosicionador());
			produtoSrv.getFiltro().setDiasPrecoVitrine(app.getDiasPrecoVitrine());
			List<Produto> listaProduto = produtoSrv.ListaMelhoresPorNaturezaLimite();
			
			produtoSrv.setListaEntradaItem(listaProduto);
			produtoSrv.AjustaNomeLista();
			
			List<ProdutoCliente> listaProdutoCliente = new ArrayList<ProdutoCliente>();
			
			int contaProdutoApp = 0;
			for (Produto produto : listaProduto) {
				produtoClienteSrv.getFiltro().setOrigem(produto);
				produtoClienteSrv.getFiltro().setCodigoNatureza(natureza.getIdNaturezaProduto());
				ProdutoCliente produtoCliente = produtoClienteSrv.CriaDeOrigem(null);
				produtoCliente.setData(DatasUtils.getDataDD_MM_AAAA());
				contaProdutoApp++;
				System.out.println(contaProdutoApp + " - " + produtoCliente.getNome() + " (" + produtoCliente.getIdObj() + ") ");
				listaProdutoCliente.add(produtoCliente);
			}
			produtoClienteSrv.setListaEntradaItem(listaProdutoCliente);
			listaProdutoCliente = produtoClienteSrv.RetiraDuplicata();
			produtoClienteSrv.setListaEntradaItem(listaProdutoCliente);
			produtoClienteSrv.getFiltro().setCodigoNatureza(natureza.getIdNaturezaProduto());
			produtoClienteSrv.ReinicializaNaturezaLista();
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
	}

}