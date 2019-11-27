package coletapreco.parse.callback.custom;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.parse.callback.LojaVirtualDetalheCallbackHtml;

public class LojaVirtualWalmartDetalheCallbackHtml extends LojaVirtualDetalheCallbackHtml {

	
	private String nomeCategoria = null;
	private String urlCategoria = null;
	
	private boolean ligaColeta = false;
	
	public LojaVirtualWalmartDetalheCallbackHtml() {
		//this.setDebug();
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.SPAN && "menu-name".equals(classeNome)) {
			ligaColeta = true;
		}
		if ("description closed".equals(classeNome)) {
			ligaColeta = false;
		}
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			String url = this.getUtlUrl();
			if (!"sub-menu-link".equals(classe2)) {
				if (this.nomeCategoria==null && "menu-name".equals(classe)) {
					this.nomeCategoria = texto;
					this.urlCategoria = this.getUtlUrl();
					return;
				}
				if ("menu-count".equals(classe) && this.nomeCategoria!=null) {
					InsereObjeto();
					return;
				}
			}
			
		}
		

	}
	
	private void InsereObjeto() {
		CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
		categoria.setNome(nomeCategoria);
		categoria.setUrl(urlCategoria);
		dadosParse.getItemDetalhe().addListaCategoriaLoja_Possui(categoria);
		this.nomeCategoria = null;
		this.urlCategoria = null;
	}
}
