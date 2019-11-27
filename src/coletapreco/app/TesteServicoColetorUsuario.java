package coletapreco.app;

import coletapreco.thread.LoopProcessamentoUsuarioTh;

public class TesteServicoColetorUsuario {

	private static int MINUTOS_SLEEP = 1;
	// private static long ID_APP = 5;
	private static int INTERVALO_MINIMO = 1;

	public static void main(String[] args) {

		// Extraido de ColetorGrupoUsuarioObj

		try {
			LoopProcessamentoUsuarioTh obj1 = new LoopProcessamentoUsuarioTh(MINUTOS_SLEEP, 1, INTERVALO_MINIMO);
			obj1.start();
		} catch (Exception e) {

		}
	}
}