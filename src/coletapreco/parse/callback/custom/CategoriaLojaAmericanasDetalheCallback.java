package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.modelo.CategoriaLoja;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;

public class CategoriaLojaAmericanasDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	private int LIMITE_PAGINA = 350;
	private int contaPagina = 1;
	private String pedacos[] = null;

	public CategoriaLojaAmericanasDetalheCallback() {
		//this.setDebug();
	}
	
	private boolean ehCosmetico() {
		CategoriaLoja cateLoja = this.dadosParse.getItemDetalhe();
		return (cateLoja.getIdNaturezaProdutoRa()==26);
	}
	

	@Override
	public void inicializacao() {
		super.inicializacao();
		if (ehCosmetico()) {
			loopCosmetico();
		} else {
			loopOutros();
		}
		
	}
	
	private void loopOutros() {
		
	}
	
	private void loopCosmetico() {
		contaPagina++;
		if (pedacos==null) {
			pedacos = this.getUrlOrigem().split("\\?");
		}
		if (contaPagina<=LIMITE_PAGINA) {
			this.loop = true;
			this.urlCorrente = pedacos[0] + "/pagina-" + contaPagina +"?" + pedacos[1];
		} else {
			this.loop = false;
		}
	}




	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("product-grid-item") != -1) {
			this.inicializaProduto();
		}
	}
	

	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		super.handleStartTag(t, a, pos);
		if (this.ehCosmetico()) return;
		if (t==HTML.Tag.SPAN && a.getAttribute("aria-label")!=null ) {
			String valor = (String) a.getAttribute("aria-label");
			if ("Next".equals(valor)) {
				this.urlCorrente = "https://www.americanas.com.br" + this.getUtlUrl();
				this.loop = true;
			}
		}
	}

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			if (this.getUltClasse().indexOf("TitleUI") != -1) {
				this.nomeProduto = texto;
				this.urlProduto = "https://www.americanas.com.br" + this.getUtlUrl();
				//System.out.println("Produto: " + this.nomeProduto);
				//System.out.println("Url: " + this.urlProduto);
			}
			if (this.getUltClasse().indexOf("PriceUI") != -1 && texto.indexOf("$") == -1) {
				this.precoVenda = texto;
				//System.out.println("Preço: " + this.precoRegular);
				this.finalizaProduto();
			}
		}

	}

}
