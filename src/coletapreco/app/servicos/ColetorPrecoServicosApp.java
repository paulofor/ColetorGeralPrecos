package coletapreco.app.servicos;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.thread.LoopProcessamentoUsuarioTh;

public class ColetorPrecoServicosApp {

	public static void main(String[] args) {
		System.out.println("Inicializando servicos(27-06-2017 [1])...");
		VerificadorInteresseNovo();
		ExecutadorNotificacao();
		LoopClientes();
	}

	public static void LoopClientes() {
		ColetorGrupoUsuarioObj obj = new ColetorGrupoUsuarioObj();
		obj.executa();
	}
	
	public static void VerificadorInteresseNovo()  {
		VerificadorInteresseNovoObj obj = new VerificadorInteresseNovoObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public static void ExecutadorNotificacao() {
		EnviadorNotificacaoObj obj = new EnviadorNotificacaoObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
