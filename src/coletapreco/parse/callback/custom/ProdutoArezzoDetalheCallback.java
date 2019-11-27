package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoArezzoDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	
	public ProdutoArezzoDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		
		if (nome==null && this.getUltClasse2().indexOf("arz-product-title")!=-1) {
			nome = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(nome);
		}
		
		if (preco==null && this.getUltClasse().indexOf("arz-product-price")!=-1) {
			preco = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(preco);
		}
		
		
		
	}
}
