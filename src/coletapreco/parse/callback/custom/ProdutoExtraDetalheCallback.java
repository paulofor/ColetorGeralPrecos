package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoExtraDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	
	public ProdutoExtraDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (preco==null && "sale price".equals(this.getUltClasse()) && "".equals(this.getUltClasse3())) {
			preco = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(texto);
			//System.out.println(texto);
		}
		if ("produtoNome".equals(this.getUltClasse3())) {
			((ProdutoDadosParse)dadosParse).setNomeDetalhe(texto);
			//System.out.println(texto);
		}
		
	}
}
