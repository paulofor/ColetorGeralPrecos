package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaCarmosBRDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	String dataImagem = null;
	boolean passouRowTitulo = false;
	boolean insert = false;
	
	
	
	public CategoriaLojaCarmosBRDetalheCallback() {
		//this.setDebug();
	}
	
	
	public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos)  {
		super.handleSimpleTag(t, a, pos);
		//System.out.println("TAG:" + t.toString());
		if ("del".equals(t.toString())) 
			insert = false;
		if ("ins".equals(t.toString())) 
			insert = true;
	}
	
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
			if ("name product-title".equals(classe)) {
				this.nomeProduto = texto;
				this.imagemProduto = this.getUltImagem2();
				this.urlProduto = this.getUtlUrl();
				System.out.println("Produto:" + nomeProduto);
				System.out.println("Imagem:" + this.imagemProduto);
				System.out.println("URL:" + this.urlProduto);
			}
			if ("woocommerce-Price-amount amount".equals(classe) && texto.indexOf("$")==-1 && insert) {
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
		if ("next page-number".equals(classe)) {
			loop = true;
			urlCorrente = url;
		}

	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		//if (t == HTML.Tag.DIV && classeNome.indexOf("row titulo") != -1) {
		//	passouRowTitulo = true;
		//}
		if (t == HTML.Tag.DIV && classeNome.indexOf("col-inner") != -1) {
			this.inicializaProduto();
		}

	}
}
