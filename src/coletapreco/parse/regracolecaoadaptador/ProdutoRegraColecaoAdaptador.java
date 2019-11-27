package coletapreco.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.ExecutadorParseApache;
import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.dao.DBB;
import coletapreco.dao.ProdutoDao;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.Produto;
import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.callback.ProdutoListaCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

// Instnaciar um filho desse.
public abstract class ProdutoRegraColecaoAdaptador  {


	protected ExecutadorParseApache exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected ProdutoDadosParse dadosParse = null;
	
	public ProdutoRegraColecaoAdaptador() {
		exec = new ExecutadorParseApache();
		dadosParse = new ProdutoDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		if (callbackLista==null) {
			System.out.println("Produto ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaListaCallbackHtml()");
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		if (callbackDetalhe==null) {
			String mensagem = "Produto ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaDetalheCallbackHtml()";
			System.out.println(mensagem);
			ArquivoLog.getInstancia().salvaCallback(mensagem);
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new ProdutoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new ProdutoDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(ProdutoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		ProdutoDao daoFonte = DBB.getInstancia().getProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<Produto> lista = daoFonte.ListaCorrente();
		Iterator<Produto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			Produto corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(Produto itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(ProdutoDadosParse dados) {
	}
	public Produto getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ProdutoListaCallbackHtml();
		ProdutoDadosParse dadosParse = new ProdutoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		ProdutoDao daoFonte = DBB.getInstancia().getProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<Produto> lista = daoFonte.ListaCorrente();
		Iterator<Produto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			Produto corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}