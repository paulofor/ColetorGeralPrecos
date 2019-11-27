package coletapreco.thread;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MySqlDataSource;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.UsuarioRegraColecao;

public class LoopProcessamentoUsuarioTh extends Thread{
	
	private int tempoEspera = 0;
	private long idApp = 0;
	private long intervaloMinimo = 0;
	
	private UsuarioRegraColecao usuarioSrv = FabricaRegra.getInstancia().getUsuarioRegraColecao();
	
	private AppProduto app = null;
	
	private DaoConexao conNuvem = null;
	private DaoConexao conLocal = null;
	
	public LoopProcessamentoUsuarioTh(int minutos, long valor2, long valor3) {
		tempoEspera = minutos * 1000 * 60;
		idApp = valor2;
		intervaloMinimo = valor3;
		
		AppProdutoRegraColecao appSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		try {
			app = appSrv.obtemPorChave(idApp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	private DaoConexao getConexaoLocal() {
		return null;
	}
	private DaoConexao getConexaoNuvem() throws DaoException {
		if (conNuvem==null || conNuvem.conexaoInativa()) {
			MySqlDataSource ds1 = new DataSourceNuvem();
			conNuvem = ds1.criaConexao();
		}
		return conNuvem;
	}

	@Override
	public void run() {
		usuarioSrv.getFiltro().setAppMonitorameneto(app);
		usuarioSrv.getFiltro().setIntervaloMinimoProcessamento(intervaloMinimo);
		while (true) {
			try {
				Usuario corrente = usuarioSrv.ObtemProximoParaColetaComDispositivo(getConexaoNuvem());
				ArquivoLog.getInstancia().salvaServico("Loop ProximoParaColeta:" + (corrente==null?corrente:corrente.getIdUsuario()));
				if (corrente==null) {
					System.out.println("Ninguem encontrado, pausa de " + tempoEspera + " ms");
					conNuvem.fechaConexao();
					conNuvem = null;
					sleep(tempoEspera);
				} else {
					usuarioSrv.getFiltro().setClienteMonitoramento(corrente);
					usuarioSrv.TrataClienteDadosNuvem(getConexaoNuvem());
				}
			} catch (DaoException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
