package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.LojaNatureza;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaNaturezaRegraColecao;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;

public class ExecutaPersingLojaNatureza {
	
	private static long CODIGO_LOJA = 5;
	private static long CODIGO_NATUREZA = 2;

	public static void main(String[] args) {
		ColetaPrecoBrinquedoObj obj = new ColetaPrecoBrinquedoObj();
		try {
			executa();
			//obj.processaContagem();
		} catch (DaoException e) {
			e.printStackTrace();
		}
				
	}
	
	private static void executa() throws DaoException {
		LojaVirtualRegraColecao lojaSrv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		LojaNaturezaRegraColecao lojaNatSrv = FabricaRegra.getInstancia().getLojaNaturezaRegraColecao();
		NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
		
		LojaVirtual loja = lojaSrv.obtemPorChave(CODIGO_LOJA);
		System.out.println("Loja  :" + loja.getNomeLojaVirtual());
		
		NaturezaProduto natureza = naturezaSrv.obtemPorChave(CODIGO_NATUREZA);
		System.out.println("Natureza  :" + natureza.getNomeNaturezaProduto());
		
		LojaNatureza lojaNat = FabricaVo.criaLojaNatureza();
		lojaNat.setLojaVirtualReferenteA(loja);
		lojaNat.setParseCategoria(false);
		lojaNat.setNaturezaProdutoReferenteA(natureza);
		
		lojaSrv.getFiltro().setLojaNaturezaExecucao(lojaNat);
		
		lojaSrv.ExecutaNaturezaLoja();
				
	}

}
	