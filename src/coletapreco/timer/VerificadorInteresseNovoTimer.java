package coletapreco.timer;

import java.util.List;
import java.util.TimerTask;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MySqlDataSource;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.UsuarioRegraColecao;

public class VerificadorInteresseNovoTimer extends TimerTask{

	private AppProduto appProduto = null;
	
	
	public void setDados(AppProduto valor) {
		appProduto = valor;
	}
	
	
	@Override
	public void run() {
		try {
			ArquivoLog.getInstancia().salvaServico("VerificadorInteresse - start");
			UsuarioRegraColecao usuarioSrv = FabricaRegra.getInstancia().getUsuarioRegraColecao();
			
			usuarioSrv.getFiltro().setAppMonitorameneto(appProduto);
			MySqlDataSource ds1 = new DataSourceNuvem();
			DaoConexao conNuvem = ds1.criaConexao();
			List<Usuario> lista = usuarioSrv.ListaInteresseNovo(conNuvem);
			ArquivoLog.getInstancia().salvaServico("VerificadorInteresse " + lista.size() + " itens novos:");
			for (Usuario usuario : lista) {
				System.out.println("VerificadorInteresse: ID:" + usuario.getListaDispositivoUsuario_Usa().get(0).getCodigoDispositivo());
				
				usuarioSrv.getFiltro().setClienteMonitoramento(usuario);
				usuario = usuarioSrv.TrataClienteDadosNuvem(conNuvem);
			}
			conNuvem.fechaConexao();
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaServico("Erro VerificadorInteresse " + e.toString());
			e.printStackTrace();
		}
				
	}

}
