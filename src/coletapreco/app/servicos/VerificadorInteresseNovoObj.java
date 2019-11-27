package coletapreco.app.servicos;

import java.util.Timer;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.AppProduto;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.timer.VerificadorInteresseNovoTimer;

public class VerificadorInteresseNovoObj {
	
	
	private int INTERVALO_MINUTOS = 3;
	private int ID_APP = 5;

	
	private Timer timer = new Timer();

	public void executa() throws DaoException {
		int ms = 60000 * INTERVALO_MINUTOS;
		
		VerificadorInteresseNovoTimer task1 = new VerificadorInteresseNovoTimer();
		task1.setDados(getAppProduto(1));
		timer.schedule(task1, 0L, ms);
		
		VerificadorInteresseNovoTimer task5 = new VerificadorInteresseNovoTimer();
		task5.setDados(getAppProduto(5));
		timer.schedule(task5, 0L, ms);
		
	}
	
	private AppProduto getAppProduto(int idApp) throws DaoException {
		AppProdutoRegraColecao appSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		AppProduto app = appSrv.obtemPorChave(idApp);
		return app;
	}

}
