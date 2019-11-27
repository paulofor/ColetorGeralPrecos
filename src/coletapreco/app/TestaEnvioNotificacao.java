package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.regracolecao.FabricaRegra;

public class TestaEnvioNotificacao {

	
	static int ID_DISPOSITIVO_USUARIO = 135;
	static int ID_APP = 1;
	
	public static void main(String[] args) {
		DispositivoUsuarioRegraColecao dispositivoSrv = FabricaRegra.getInstancia().getDispositivoUsuarioRegraColecao();
		AppProdutoRegraColecao appProdutoSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		
		try {
			DispositivoUsuario dispositivo = dispositivoSrv.obtemPorChave(ID_DISPOSITIVO_USUARIO);
			AppProduto app = appProdutoSrv.obtemPorChave(ID_APP);
			dispositivo.setAppProdutoUsa(app);
			
			dispositivoSrv.getFiltro().setAppMonitorameneto(app);
			dispositivoSrv.getFiltro().setItemComApp(dispositivo);
			dispositivoSrv.ChamaMobileRecuperacaoInteresse();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
