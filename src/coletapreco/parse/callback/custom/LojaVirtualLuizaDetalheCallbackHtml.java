package coletapreco.parse.callback.custom;

import javax.swing.text.html.HTML.Tag;

import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.parse.callback.LojaVirtualDetalheCallbackHtml;

public class LojaVirtualLuizaDetalheCallbackHtml extends LojaVirtualDetalheCallbackHtml {

	
	private String nomeCategoria = null;
	private String urlCategoria = null;
	
	private boolean ligaColeta = false;
	
	public LojaVirtualLuizaDetalheCallbackHtml() {
		//this.setDebug();
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("line-product")!=-1) {
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
			int xurl = -1;
			if (this.urlCategoria!=null)
				xurl = this.urlCategoria.compareToIgnoreCase(this.getUtlUrl());
			if ((texto.trim().length() > 0) && (xurl!=0)) 
			{
				this.nomeCategoria = texto;
				this.urlCategoria = "http://www.magazineluiza.com.br" + this.getUtlUrl();
				InsereObjeto();
			}
		}
		/*
		if ("Próxima".equals(texto.trim()) && getUltTag() == HTML.Tag.A) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}
		*/

	}
	
	private void InsereObjeto() {
		CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
		categoria.setNome(nomeCategoria);
		categoria.setUrl(urlCategoria);
		dadosParse.getItemDetalhe().addListaCategoriaLoja_Possui(categoria);
	}
}
