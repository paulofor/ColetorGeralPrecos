package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoPassarelaDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	
	public ProdutoPassarelaDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		
		if (nome==null) {
			nome = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(nome);
		}
		
		if (preco==null && this.getUltClasse3().indexOf("preco-promocional")!=-1) {
			preco = texto.substring(texto.indexOf("R$"));
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(preco);
		}
		
		
		
	}
}
