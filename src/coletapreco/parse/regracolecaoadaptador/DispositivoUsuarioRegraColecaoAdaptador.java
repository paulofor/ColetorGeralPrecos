package coletapreco.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.parse.callback.DispositivoUsuarioListaCallbackHtml;
import coletapreco.parse.callback.DispositivoUsuarioDetalheCallbackHtml;
import coletapreco.parse.dados.DispositivoUsuarioDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class DispositivoUsuarioRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected DispositivoUsuarioDadosParse dadosParse = null;
	
	public DispositivoUsuarioRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new DispositivoUsuarioDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		if (callbackLista==null) {
			System.out.println("DispositivoUsuario ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaListaCallbackHtml()");
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		if (callbackDetalhe==null) {
			System.out.println("DispositivoUsuario ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaDetalheCallbackHtml()");
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new DispositivoUsuarioListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new DispositivoUsuarioDetalheCallbackHtml();
	}

	// Atualizar uma lista de objeto em uma p?gina sem referencia de objeto pai.
	// Exemplo Categorias em uma loja Virtual
	public final void atualizaLista(DaoConexao conexao)
			throws DaoException {
		
		dadosParse.setConexao(conexao);
		preparaDadosLista(dadosParse);
		exec.setCallbackParse(getCallbackLista()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
		return;
		
		/*
		// Passo 2 - Montagem da fonte das urls
		
		return;
		*/
	}
	
	protected void preparaDadosLista(DispositivoUsuarioDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao daoFonte = DBB.getInstancia().getDispositivoUsuarioDao(); // 
		daoFonte.setConexao(conexao);
		List<DispositivoUsuario> lista = daoFonte.ListaCorrente();
		Iterator<DispositivoUsuario> itLista = lista.iterator();
		while (itLista.hasNext()) {
			DispositivoUsuario corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(DispositivoUsuario itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(DispositivoUsuarioDadosParse dados) {
	}
	public DispositivoUsuario getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new DispositivoUsuarioListaCallbackHtml();
		DispositivoUsuarioDadosParse dadosParse = new DispositivoUsuarioDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		DispositivoUsuarioDao daoFonte = DBB.getInstancia().getDispositivoUsuarioDao(); // 
		daoFonte.setConexao(conexao);
		List<DispositivoUsuario> lista = daoFonte.ListaCorrente();
		Iterator<DispositivoUsuario> itLista = lista.iterator();
		while (itLista.hasNext()) {
			DispositivoUsuario corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}