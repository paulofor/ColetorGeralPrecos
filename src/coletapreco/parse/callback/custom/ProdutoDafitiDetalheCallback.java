package coletapreco.parse.callback.custom;

import java.net.MalformedURLException;
import java.net.URL;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoDafitiDetalheCallback extends ProdutoDetalheCallbackHtml {

	private String sku;
	private String linkJSon;
	
	private boolean ligaColeta = false;
	
	public ProdutoDafitiDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			sku = texto;
			((ProdutoDadosParse)dadosParse).setSku(sku);
			linkJSon = "https://www.dafiti.com.br/product/list/?skus=" + sku;
			ligaColeta = false;
		}
		if ("SKU".equals(texto)) {
			ligaColeta = true;
		}

	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		if (linkJSon!=null)
			return new URL(linkJSon);
		else
			return null;
	}
	
	

}
