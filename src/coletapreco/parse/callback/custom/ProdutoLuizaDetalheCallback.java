package coletapreco.parse.callback.custom;

import java.net.MalformedURLException;
import java.net.URL;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoLuizaDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String sku;
	private String linkJSon;
	private String itensUrl[] ; 
	
	private boolean ligaColeta = false;
	
	
	public ProdutoLuizaDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		
		//http://www.magazineluiza.com.br/produto/215983700/preco.json	
	}
	
	
	
	
	@Override
	public void inicializacao() {
		try {
			String url = this.getUrl().toString();
			String itensUrl[] = url.split("/");
			System.out.println(itensUrl[5]);
			linkJSon = "http://www.magazineluiza.com.br/produto/" + itensUrl[5] + "00/preco.json";
		} catch (MalformedURLException e) {
			e.printStackTrace();
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
