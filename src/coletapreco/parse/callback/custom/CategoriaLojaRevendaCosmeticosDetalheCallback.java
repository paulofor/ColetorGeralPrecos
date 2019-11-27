package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaRevendaCosmeticosDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (this.ligaColeta) {
			String texto = String.copyValueOf(data);
			String classe = this.getUltClasse2();
			if ("product-name".equals(classe)) {
				this.nomeProduto = texto;
				this.imagemProduto = this.getUltImagem2();
				this.urlProduto = this.getUtlUrl();
				System.out.println("Produto:" + nomeProduto);
				System.out.println("Imagem:" + this.imagemProduto);
				System.out.println("URL:" + this.urlProduto);
			}
			if ("regular-price".equals(classe)
					|| ("price".equals(this.getUltClasse()) && "price-box".equals(this.getUltClasse2()))
					|| ("price".equals(this.getUltClasse()) && "special-price".equals(this.getUltClasse3()))) {
				this.precoVenda = texto;
				System.out.println("Preço:" + precoVenda);
				this.desligaColeta();
			}
		}
	}

	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		// TODO Auto-generated method stub
		super.handleUrl(url, classe, titulo, id);
		if ("next i-next".equals(classe)) {
			loop = true;
			urlCorrente = url;
		}

	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.DIV && classeNome.indexOf("item-area") != -1) {
			ligaColeta();
		}

	}
}
