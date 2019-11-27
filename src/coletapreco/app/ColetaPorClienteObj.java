package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.UsuarioRegraColecao;

public class ColetaPorClienteObj {

	private UsuarioRegraColecao usuarioSrv = FabricaRegra.getInstancia().getUsuarioRegraColecao();
	
	private Usuario usuario = null;
	
	
	
	
	public void executa() throws DaoException {
		AppProdutoRegraColecao srv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		AppProduto app = srv.obtemPorChave(5);
				
				
		usuarioSrv.getFiltro().setAppMonitorameneto(app);
		usuarioSrv.TrataLoopClientes();
	}
	
}
