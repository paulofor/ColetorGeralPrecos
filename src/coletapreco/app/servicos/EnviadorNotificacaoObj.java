package coletapreco.app.servicos;

import java.util.Timer;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.AppProduto;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.timer.NotificadorMobileTimer;

public class EnviadorNotificacaoObj {
	
	private int INTERVALO_MINUTOS = 3;
	//private int ID_APP = 5;
	private long QUANTIDADE_CHAMADAS_POR_VEZ = 100;
	
	private Timer timer = new Timer();

	public void executa() throws DaoException {
		int ms = 60000 * INTERVALO_MINUTOS;
		
		NotificadorMobileTimer task5 = new NotificadorMobileTimer();
		task5.setDados(getAppProduto(5),QUANTIDADE_CHAMADAS_POR_VEZ);
		timer.schedule(task5, 0L, ms);
		
		NotificadorMobileTimer task1 = new NotificadorMobileTimer();
		task1.setDados(getAppProduto(1),QUANTIDADE_CHAMADAS_POR_VEZ);
		timer.schedule(task1, 0L, ms);
	}
	
	private AppProduto getAppProduto(int idApp) throws DaoException {
		AppProdutoRegraColecao appSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		AppProduto app = appSrv.obtemPorChave(idApp);
		return app;
	}

}
