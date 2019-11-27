package coletapreco.app;

import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.LojaNatureza;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaNaturezaRegraColecao;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;

public class TestaColetorLojaVirtual {

	
	private static long CODIGO_LOJA = 16;
	private static long CODIGO_NAUREZA = 17;
	
	public static void main(String[] args) {
		
		LojaNaturezaRegraColecao lojaNatSrv = FabricaRegra.getInstancia().getLojaNaturezaRegraColecao();
		LojaVirtualRegraColecao lojaSrv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
		
		try {
			LojaVirtual loja = lojaSrv.obtemPorChave(CODIGO_LOJA);
			NaturezaProduto natureza = naturezaSrv.obtemPorChave(CODIGO_NAUREZA);
			
			LojaNatureza lojaNat = FabricaVo.criaLojaNatureza();
			lojaNat.setIdLojaNatureza(CODIGO_NAUREZA);
			lojaNat.setIdLojaVirtualRa(CODIGO_LOJA);
			
			lojaNat.setLojaVirtualReferenteA(loja);
			lojaNat.setNaturezaProdutoReferenteA(natureza);
			
			lojaSrv.getFiltro().setLojaNaturezaExecucao(lojaNat);
			lojaSrv.ExecutaNaturezaLoja();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
