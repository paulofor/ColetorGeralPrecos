package coletapreco.parse.callback.basico;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import coletapreco.parse.dados.basico.UsuarioDadosParseBase;
import coletapreco.modelo.Usuario;
import coletapreco.log.ArquivoLog;


public abstract class UsuarioDetalheCallbackHtmlBase  extends CallbackParseHtml{

	protected UsuarioDadosParseBase dadosParse;
	protected boolean ligaColetaLista = false;
	protected String urlCorrente = null;
	protected boolean loop = false;
	private String urlOrigem = null;
	
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
		if (urlCorrente==null)
			urlCorrente = dadosParse.getUrlDetalhe();
		if (urlCorrente.indexOf("http")==-1)
			if (urlCorrente.indexOf(0)!='/')
				urlCorrente = getUrlPrefixo() + "/" + urlCorrente;
			else
				urlCorrente = getUrlPrefixo() + urlCorrente;
		urlOrigem = urlCorrente;
		URL url = new URL(urlCorrente);
		return url;
	}
	
	protected String getUrlOrigem() {
		return urlOrigem;
	}

	@Override
	public final void setDados(IDadosParse paramIDadosParse) {
		dadosParse = (UsuarioDadosParseBase) paramIDadosParse;
		ArquivoLog.getInstancia().salvaLog("Usuario(detalhe):"  + dadosParse.displayLog(dadosParse.getItemDetalhe()));
	}

	

	@Override
	public final void finalizacaoErro() {
		// TODO Auto-generated method stub
	}

	@Override
	public final void finalizacaoOk() {
		//if (lista==null) throw new RuntimeException("objeto lista em UsuarioListaCallbackHtmlBase esta null");
		finalizaObjeto();
		dadosParse.finalizacaoOkDetalhe();
		limpaListasInternas();
	}
	protected void finalizaObjeto() {
	}
	private void limpaListasInternas() {
	
	}

	@Override
	public void inicializacao() {
		System.out.println("Parser: " + this.getClass().getSimpleName());
		dadosParse.inicializacaoDetalhe();
		loop = false;
		urlCorrente = null;
	}

	@Override
	public final boolean getLoop() {
		return loop;
	}

	@Override
	public final boolean isPost() {
		return (dadosParse.camposPost()!=null);
	}
	@Override
	public final List camposPost() {
		return dadosParse.camposPost();
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
	
	protected final int extraiParcelas(String parcelamento) {
		if (parcelamento==null) return 0;
		int posicao = parcelamento.toLowerCase().indexOf("x");
		String parcelas = parcelamento.substring(0,posicao).trim();
		parcelas = this.retiraLetras(parcelas);
		int qtde = Integer.parseInt(parcelas);
		return qtde;
	}
	protected final float extraiValorParcelas(String parcelamento) {
		if (parcelamento==null) return 0;
		parcelamento = retiraLetras(parcelamento);
		return this.extraiValorPreco(parcelamento);
	}
	
	private String retiraLetras(String texto) {
		String saida = "";
		for (int i=0;i<texto.length();i++) {
			if (texto.substring(i, i+1).matches("[0-9]") || texto.charAt(i)=='.' ||  texto.charAt(i)==',')
				saida += texto.substring(i, i+1);
		}
		return saida;
	}
}