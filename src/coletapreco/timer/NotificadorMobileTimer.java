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

public class NotificadorMobileTimer extends TimerTask{

	private AppProduto appProduto = null;
	private long quantidadeChamada;
	
	public void setDados(AppProduto valor, long valor2) {
		appProduto = valor;
		quantidadeChamada = valor2;
	}
	
	
	@Override
	public void run() {
		
		ArquivoLog.getInstancia().salvaServico("NotificadorMobileTimer - start App:" + appProduto.getIdAppProduto());		
		UsuarioRegraColecao usuarioSrv = FabricaRegra.getInstancia().getUsuarioRegraColecao();
		DispositivoUsuarioRegraColecao dispositivoSrv = FabricaRegra.getInstancia().getDispositivoUsuarioRegraColecao();
		
		usuarioSrv.getFiltro().setAppMonitorameneto(appProduto);
		usuarioSrv.getFiltro().setQuantidadeNotificacao(quantidadeChamada);
		MySqlDataSource ds1 = new DataSourceNuvem();
		dispositivoSrv.getFiltro().setAppMonitorameneto(appProduto);
		
		try {
			DaoConexao conNuvem = ds1.criaConexao();
			List<Usuario> lista = usuarioSrv.ListaAtivoChamadaDistanteComDispositivo(conNuvem);
			for (Usuario usuario : lista) {
				ArquivoLog.getInstancia().salvaServico("NotificadorMobileTimer Usuario:" + usuario.getIdObj() );
				for (DispositivoUsuario dispositivo : usuario.getListaDispositivoUsuario_Usa()) {
					dispositivo.setAppProdutoUsa(appProduto);
					dispositivoSrv.getFiltro().setItemComApp(dispositivo);
					dispositivoSrv.ChamaMobileRecuperacaoInteresse(conNuvem);
				}
			}
			conNuvem.fechaConexao();
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaServico("Erro NotificadorMobileTimer " + e.getMessage());
			e.printStackTrace();
		}
				
	}

}
