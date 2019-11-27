package coletapreco.app.servicos;

import coletapreco.thread.LoopProcessamentoUsuarioTh;

public class ColetorGrupoUsuarioObj {

	
	//private static int MINUTOS_SLEEP = 10;
	
	private static int MINUTOS_SLEEP = 10;
	//private static long ID_APP = 5;
	private static int INTERVALO_MINIMO = 60;
	
	public void executa() {
		
		LoopProcessamentoUsuarioTh obj5 = new LoopProcessamentoUsuarioTh(MINUTOS_SLEEP, 5,INTERVALO_MINIMO);
		obj5.start();
		
		LoopProcessamentoUsuarioTh obj1 = new LoopProcessamentoUsuarioTh(MINUTOS_SLEEP, 1,INTERVALO_MINIMO);
		obj1.start();
	}

}
