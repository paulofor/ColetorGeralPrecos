package coletapreco.app;

import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import br.com.digicom.lib.dao.DaoException;

public class ColetaPrecoBrinquedoApp {

	private final static LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
	
	public static String getDataVersao() {
		//return "24-06-2017 (1) -> Start: 04:30";
		return "30-07-2019";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColetaPrecoBrinquedoObj obj = new ColetaPrecoBrinquedoObj();
		try {
			
			obj.executaParsing1();
			//obj.coletaPorCliente();
			//obj.processaContagem();
			//obj.montadorVitrineProduto();
			
			//LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
			//srv.AtualizaNotebook();
			
			//obj.atualizaListasInteresse();
			
			//srv.AtualizaComputador();
			//obj.montadorVitrineProduto();
			//obj.enviaFacebook();
			//obj.chamaMobile();
			//obj.chamaMobileCliente();
			
			
			//obj.montadorVitrineProduto();
			//obj.enviaFacebook();
			//obj.chamaMobile();
			//obj.chamaMobileCliente();
			//obj.executaParsing2();
			//obj.verificaOportunidade();
			//obj.executaCelulares();
			//obj.enviaFacebook();
			//obj.coletaPorCliente();
			//obj.processaContagem();
			//obj.processaOportunidades();
			//obj.executa();
			//obj.corrigeTabelas();
			//obj.processaContagem();
			//obj.processaOportunidades();
			//obj.chamaMobileCliente();
			//obj.chamaMobile();
			//obj.executaSapatoFeminino();
			//System.gc();
			//obj.processaContagem();
			//obj.processaOportunidades();
			//obj.chamaMobile();
			//obj.chamaMobileCliente();
			//obj.enviaNotificacaoSapato();
			
			System.out.println("Terminou");
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
