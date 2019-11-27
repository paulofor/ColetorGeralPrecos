package coletapreco.parse.callback.custom;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoAmericanasDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	private String fotoProduto = null;
	
	public ProdutoAmericanasDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		/*
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
		*/
	}
	
	
	

	@Override
	protected void meta(String propriedade, String conteudo) {
		if("og:image".equals(propriedade)) {
			System.out.println("Imagem:" + conteudo);
			((ProdutoDadosParse) this.dadosParse).setImagemDetalhe(conteudo);
		}
	}

	/*
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		if (fotoProduto==null) {
			fotoProduto = imagem;
			System.out.println("Imagem:" + imagem);
			((ProdutoDadosParse) this.dadosParse).setImagemDetalhe(imagem);
		}
	}
	*/

	@Override
	public void antesLoop() {
		super.antesLoop();
		this.fotoProduto = null;
	}
	
	
}
