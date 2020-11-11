package coletapreco.thread;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;

public class ProcessaOportunidadeTh extends Thread {
	
	private long idNatureza;
	
	public void setIdNatureza(long id) {
		this.idNatureza = id;
	}

	@Override
	public void run() {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		try {
			System.out.println("Vai calcular oportunidades...");
			srv.CalculaOportunidadesHoje(this.idNatureza);
			System.out.println("Final de calculando oportunidades...");
			srv.EnviaParaServidor(this.idNatureza);
			System.out.println("Final de envio para o servidor...");
		} catch (DaoException e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaErro(e);
		}
	}
	
	public void enviaParaServidor() {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		try {
			System.out.println("Vai enviar natureza: " + this.idNatureza);
			srv.EnviaParaServidor(idNatureza);
			System.out.println("Finalizou");
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
