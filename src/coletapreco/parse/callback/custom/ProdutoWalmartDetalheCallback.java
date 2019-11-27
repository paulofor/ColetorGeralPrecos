package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoWalmartDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	
	public ProdutoWalmartDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if ("int".equals(this.getUltClasse()) && "product-price-value".equals(this.getUltClasse2())) {
			preco = texto;
		}
		if (preco!=null && "dec".equals(this.getUltClasse())) {
			preco += texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(preco);
			preco = null;
		}
		if (nome==null && "product-name".equals(this.getUltClasse())) {
			nome = texto;
			((ProdutoDadosParse)dadosParse).setNomeDetalhe(nome);
		}
		
	}
}
