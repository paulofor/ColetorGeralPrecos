package coletapreco.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MySqlDataSource;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.UsuarioRegraColecao;

public class SincronizaUsuarioUnicoApp {


	private static int ID_USUARIO_J2 = 35;
	
	private static int ID_APP = 5;
	
	public static void main(String[] args) {
		
		UsuarioRegraColecao usuarioSrv = FabricaRegra.getInstancia().getUsuarioRegraColecao();
		DispositivoUsuarioRegraColecao dispositivoSrv = FabricaRegra.getInstancia().getDispositivoUsuarioRegraColecao();
		AppProdutoRegraColecao appSrv = FabricaRegra.getInstancia().getInstancia().getAppProdutoRegraColecao();
		
		Usuario usuario;
		try {
			MySqlDataSource ds1 = new DataSourceNuvem();
			DaoConexao conNuvem = ds1.criaConexao();
			usuario = usuarioSrv.obtemPorChave(ID_USUARIO_J2,conNuvem);
			List<DispositivoUsuario> listaDisp = dispositivoSrv.getPorReferenteAUsuario(ID_USUARIO_J2, conNuvem);
			usuario.setListaDispositivoUsuario_Usa(listaDisp);
			AppProduto app = appSrv.obtemPorChave(ID_APP);
			usuarioSrv.getFiltro().setAppMonitorameneto(app);
			usuarioSrv.getFiltro().setClienteMonitoramento(usuario);
			usuario = usuarioSrv.TrataClienteDadosNuvem(conNuvem);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
