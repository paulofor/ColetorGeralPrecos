package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaAtacadoMaquiagemDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	String dataImagem = null;
	boolean passouRowTitulo = false;
	
	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		if (a.getAttribute("data-original")!=null)
			dataImagem = (String) a.getAttribute("data-original");
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (this.ligaColeta) {
			String texto = String.copyValueOf(data);
			String classe = this.getUltClasse2();
			if ("catalogo-item-titulo".equals(classe)) {
				this.nomeProduto = texto;
				this.imagemProduto = dataImagem;
				this.urlProduto = "https://www.atacadodemaquiagem.com.br" + this.getUtlUrl();
				System.out.println("Produto:" + nomeProduto);
				System.out.println("Imagem:" + this.imagemProduto);
				System.out.println("URL:" + this.urlProduto);
			}
			if ("catalogo-item-preco-por".equals(this.getUltClasse())) {
				this.precoVenda = texto;
				System.out.println("Preço:" + precoVenda);
				this.finalizaProduto();
				System.out.println();
			}
		}
	}

	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		// TODO Auto-generated method stub
		super.handleUrl(url, classe, titulo, id);
		if ("next_page".equals(classe)) {
			loop = true;
			urlCorrente = "https://www.atacadodemaquiagem.com.br" + url;
		}

	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.DIV && classeNome.indexOf("row titulo") != -1) {
			passouRowTitulo = true;
		}
		if (passouRowTitulo && t == HTML.Tag.DIV && classeNome.indexOf("catalogo-item") != -1) {
			this.inicializaProduto();
		}

	}
}
