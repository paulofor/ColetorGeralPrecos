package coletapreco.parse.callback.basico;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import coletapreco.parse.dados.basico.PrecoProdutoDadosParseBase;
import coletapreco.modelo.PrecoProduto;
import br.com.digicom.parse.log.ArquivoLog;

public abstract class PrecoProdutoListaCallbackHtmlBase  extends CallbackParseHtml{

	protected PrecoProdutoDadosParseBase dadosParse;
	protected boolean ligaColetaLista = false;
	protected List<PrecoProduto> lista = null;
	protected PrecoProduto corrente = null;
	protected boolean loop = false;
	
	protected String urlCorrente = null;
	
	@Override
	public URL getJsonUrl() throws MalformedURLException {
		return null;
	}
	// Se a pagina estiver com erro de acentos e precisa usar um versao de charset diferente.
	// Possibilidades: CallbackParseHtml.HTML4_CHARSET ou CallbackParseHtml.HTML5_CHARSET
	@Override
	public String getCharSet() {
		return null;
	}

	protected String getUrlPrefixo() {
		return "";
	}
	
	@Override
	public final URL getUrl() throws MalformedURLException {
		//if (urlCorrente==null)
		urlCorrente = dadosParse.getUrlLista();
		if (urlCorrente.indexOf("http")==-1)
			if (urlCorrente.indexOf(0)!='/')
				urlCorrente = getUrlPrefixo() + "/" + urlCorrente;
			else
				urlCorrente = getUrlPrefixo() + urlCorrente;
		URL url = new URL(urlCorrente);
		return url;
	}


	@Override
	public final void setDados(IDadosParse paramIDadosParse) {
		dadosParse = (PrecoProdutoDadosParseBase) paramIDadosParse;
	}

	

	@Override
	public final void finalizacaoErro() {
		// TODO Auto-generated method stub
		ArquivoLog.getInstancia().salvaLog(" *** Finalizacao com erro ***");
		//if (lista==null) throw new RuntimeException("objeto lista em PrecoProdutoDetalheCallbackHtmlBase esta null");
		dadosParse.finalizacaoOkLista();
	}

	@Override
	public final void finalizacaoOk() {
		//if (lista==null) throw new RuntimeException("objeto lista em PrecoProdutoListaCallbackHtmlBase esta null");
		dadosParse.finalizacaoOkLista();
	}

	@Override
	public final void inicializacao() {
		//if (lista!=null) 
		//	lista.clear();
		System.out.println("Parser: " + this.getClass().getSimpleName());
		inicializacaoPagina();
		dadosParse.inicializacaoLista();
	}
	protected void inicializacaoPagina() {
		
	}

	@Override
	public final boolean getLoop() {
		return loop;
	}
	@Override
	public boolean isPost() {
		return false;
	}
	@Override
	public List camposPost() {
		return null;
	}

	protected final float extraiValorPreco(String valor) {
		int ini, fimtexto;
		if (valor==null) return 0;
		if (valor.indexOf(",")==-1 && valor.indexOf(".")!=-1) {
			valor = valor.replace('.', ',');
		}
		ini = valor.indexOf("$");
		fimtexto = valor.indexOf(",") + 3;
		valor = valor.substring(ini+1,fimtexto).trim();
		valor = valor.replace(".","");
		valor = valor.replace(',', '.');
		return Float.valueOf(valor);
	}
}