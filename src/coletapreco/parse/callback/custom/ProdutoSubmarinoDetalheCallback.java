package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoSubmarinoDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	
	public ProdutoSubmarinoDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (preco==null && "sales-price".equals(this.getUltClasse())) {
			preco = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(texto);
			//System.out.println(texto);
		}
		if ("product-name".equals(this.getUltClasse())) {
			((ProdutoDadosParse)dadosParse).setNomeDetalhe(texto);
			//System.out.println(texto);
		}
		
	}
}
