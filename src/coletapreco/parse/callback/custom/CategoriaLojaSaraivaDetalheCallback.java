package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.log.ArquivoLog;
import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.Marca;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;


public class CategoriaLojaSaraivaDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	private boolean ligaBoleto = false;
	private String dataImagem = null;
	private int offSet = 0;
	
		
	public CategoriaLojaSaraivaDetalheCallback() {
		//this.setDebug();
	}
	
	@Override
	public void finalizaObjeto() {
		
		if (existeProduto) {
			loop = true;
			offSet = offSet+ 30;
			String urlAtual = this.getUrlOrigem();
			String urlRaiz = urlAtual.substring(0,urlAtual.lastIndexOf("/"));
			this.urlCorrente = urlRaiz + "/" + offSet;
		} else {
			loop = false;
			offSet = 0;
		}
		super.finalizaObjeto();
		existeProduto = false;
	}
	

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if ("item".equals(classeNome)) {
			ligaColeta();
		}
		if (ligaColeta && "ratings".equals(classeNome)) {
			desligaColeta();
		}
	}
	
	
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		
	}

	




	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		//dataImagem = (String) a.getAttribute("data-src");
	}


	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		super.handleSimpleTag(t, a, pos);
		
	}

	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			if (texto.trim().length() > 0) {
				if (this.nomeProduto==null) {
					this.nomeProduto = texto;
					this.urlProduto = this.getUtlUrl();
					return;
				}
				if ("price".equals(classe)) {
					this.precoVenda = texto;
					return;
				}
				if ("without_fee".equals(classe2) && this.precoParcelado==null) {
					this.precoParcelado = texto;
					return;
				}
				if ("color-yellow".equals(classe) && this.precoParcelado!=null) {
					this.precoParcelado = this.precoParcelado + " " + texto;
					return;
				}
			}
		}
		/*
		if ("Próxima".equals(texto.trim()) && getUltTag() == HTML.Tag.A) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}
		*/

	}

	
	

}
