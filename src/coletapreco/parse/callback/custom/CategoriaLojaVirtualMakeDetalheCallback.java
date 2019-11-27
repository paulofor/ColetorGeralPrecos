package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaVirtualMakeDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	String dataImagem = null;
	boolean passouRowTitulo = false;
	boolean insert = false;
	
	
	
	public CategoriaLojaVirtualMakeDetalheCallback() {
		//this.setDebug();
	}
	
	
	
	

	
	@Override
	protected void elementoSimples(Tag t, String nomeId, String nomeClasse, String conteudo) {
		super.elementoSimples(t, nomeId, nomeClasse, conteudo);
		if (t == HTML.Tag.A && ">".equals(conteudo)) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}
	}






	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (this.ligaColeta) {
			String texto = String.copyValueOf(data);
			String classe = this.getUltClasse();
			if ("prod-name".equals(classe) && this.nomeProduto==null) {
				this.nomeProduto = texto;
				this.imagemProduto = this.getUltImagem2();
				this.urlProduto = this.getUtlUrl();
				System.out.println("Produto:" + nomeProduto);
				System.out.println("Imagem:" + this.imagemProduto);
				System.out.println("URL:" + this.urlProduto);
			}
			if ("price".equals(this.getUltClasse())) {
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
		

	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.DIV && classeNome.indexOf("product-list-item") != -1) {
			this.inicializaProduto();
		}

	}
}
