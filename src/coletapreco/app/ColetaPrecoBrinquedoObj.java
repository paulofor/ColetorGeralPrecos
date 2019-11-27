	package coletapreco.app;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.InteresseProdutoRegraColecao;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;
import coletapreco.thread.ProcessaContagemTh;
import coletapreco.thread.ProcessaOportunidadeTh;
import coletorboadica.app.ColetorBoaDicaObj;
import digicom.facebook.obj.FbEnviadorPageObj;

public class ColetaPrecoBrinquedoObj implements Job{

	public void executa() throws DaoException {
		
		
		
		System.out.println("Inicializando dia");
		
		
		
		
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio executaParsing1");
		executaParsing1(); // coloquei em outro metodo para deixar o srv para o GarbageCollection
		ArquivoLog.getInstancia().salvaLogEtapa("Final executaParsing1");
		
		//ArquivoLog.getInstancia().salvaLogEtapa("Inicio ColetorBoaDica");
		//this.chamaColetorBoaDica();
		//ArquivoLog.getInstancia().salvaLogEtapa("Final ColetorBoaDica");
		
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio executaParsing2");
		executaParsing2();
		ArquivoLog.getInstancia().salvaLogEtapa("Final executaParsing2");
		
		//System.gc();
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio processaOportunidades");
		processaOportunidades();
		ArquivoLog.getInstancia().salvaLogEtapa("Final processaOportunidades");
		
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio montadorVitrineProduto");
		montadorVitrineProduto();
		ArquivoLog.getInstancia().salvaLogEtapa("Final montadorVitrineProduto");
		
		
		
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio enviaFacebook");
		enviaFacebook();
		ArquivoLog.getInstancia().salvaLogEtapa("Final enviaFacebook");
		
		//ArquivoLog.getInstancia().salvaLogEtapa("Inicio chamaMobile");
		//chamaMobile();
		//ArquivoLog.getInstancia().salvaLogEtapa("Final chamaMobile");
		
		
		//ArquivoLog.getInstancia().salvaLogEtapa("Inicio chamaMobileCliente");
		//chamaMobileCliente();
		//ArquivoLog.getInstancia().salvaLogEtapa("Final chamaMobileCliente");
		
		//this.enviaNotificacaoSapato();
		
		//ArquivoLog.getInstancia().salvaLogEtapa("Inicio coletaPorCliente");
		//coletaPorCliente();
		//ArquivoLog.getInstancia().salvaLogEtapa("Final coletaPorCliente");
		
		
		//this.executaBrinqudos();
		
		
		
		ArquivoLog.getInstancia().salvaLogEtapa("Inicio processaContagem");
		processaContagem();
		ArquivoLog.getInstancia().salvaLogEtapa("Final processaContagem");
		
		//ArquivoLog.getInstancia().salvaLogEtapa("Inicio ColetorBoaDica");
		//this.chamaColetorBoaDica();
		//ArquivoLog.getInstancia().salvaLogEtapa("Final ColetorBoaDica");
		
		//processaContagem();
		//this.processaIndexacaoPalavras();
		//this.processaAgrupamentoModelo();
	}
	
	public void coletaPorCliente() throws DaoException {
		ColetaPorClienteObj obj = new ColetaPorClienteObj();
		obj.executa();
	}
	
	
	
	
	
	
	public void enviaNotificacaoSapato() throws DaoException {
		AppProdutoRegraColecao appSrv = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
		appSrv.getFiltro().setIdApp(1);
		appSrv.ChamaDispostivos();
	}
	
	
	public void enviaFacebook() throws DaoException {
		FacebookDivulgadorObj face = new FacebookDivulgadorObj();
		face.executa();
	}
	
	public void montadorVitrineProduto() throws DaoException {
		MontadorVitrineObj obj = new MontadorVitrineObj();
		obj.executa();
	}
	
	public void enviaParaFacebook() throws DaoException {
		FbEnviadorPageObj enviador = new FbEnviadorPageObj();
		enviador.executa();
	}
	
	public void chamaColetorBoaDica() throws DaoException {
		ColetorBoaDicaObj obj = new ColetorBoaDicaObj();
		obj.executa();
	}
	
	
	public void chamaMobile() throws DaoException {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		srv.ChamaMobile();
	}
	
	public void chamaMobileCliente() throws DaoException {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		srv.ChamaMobileCliente();
	}


	
	
	
	public void executaParsing1() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		
		
		//srv.CorrigeTabelas();
		srv.AtualizaNotebook();  // voltar
		//srv.AtualizaCamera();
		srv.AtualizaCelular();
		
		srv.AtualizaGeladeira(); // voltar
		//srv.AtualizaArCondicionado();
		//srv.AtualizaFogao();
		//srv.AtualizaLavaRoupa();
		//srv.AtualizaMicroOnda();
		//srv.AtualizaVentilador();
		
		//srv.AtualizaMoveisQuarto();
		//srv.AtualizaMoveisSalaEstar();
		//srv.AtualizaMoveisSalaJantar();
		srv.AtualizaTV(); // voltar
		srv.AtualizaTablet();
		
		// em 14-03-2016
		//srv.AtualizaGameNintendoWiiU();
		//srv.AtualizaGamePS3();
		srv.AtualizaGamePS4();
		//srv.AtualizaGameXbox360();
		srv.AtualizaGameXboxOne();
		//srv.AtualizaSapatoFeminino();
		
		// em 16-05-2016
		//srv.AtualizaComputador();
	}
	public void executaBrinqudos() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaBrinquedo();
	}
	public void executaParsing2() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaSapatoFeminino();
	}
	
	public void executaSaraivaNotebook() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaNotebook();	
	}
	
	public void executaSapatoFeminino() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaSapatoFeminino();	
	}
	
	public void executaNintendo() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaGameNintendoWiiU();	
	}
	
	public void executaCameras() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaCamera();
	}
	public void executaCelulares() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.AtualizaCelular();
	}
	public void corrigeTabelas() throws DaoException {
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		srv.CorrigeTabelas();
	}
	
	public void verificaOportunidade() throws DaoException {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		srv.ConfirmaOportunidadeDia();
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			executa();
		} catch (DaoException e) {
			ArquivoLog.getInstancia().salvaErro(e);
		}
	}
	
	public void processaContagem() throws DaoException {
		ProcessaContagemTh th = new ProcessaContagemTh();
		th.run();
	}
	
	public void processaOportunidades() throws DaoException {
		ProcessaOportunidadeTh th = new ProcessaOportunidadeTh();
		th.run();
	}
	
	public void processaIndexacaoPalavras() throws DaoException  {
		ProdutoRegraColecao srv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		srv.CriaListaPalavra();
	}
	
	public void processaAgrupamentoModelo() throws DaoException {
		ProdutoRegraColecao srv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		srv.CriaListaModelo();
	}

}
