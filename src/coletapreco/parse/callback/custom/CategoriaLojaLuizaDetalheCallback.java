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


public class CategoriaLojaLuizaDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	
	
	
	@Override
	protected String getUrlPrefixo() {
		return "http://www.magazineluiza.com.br";
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	public CategoriaLojaLuizaDetalheCallback() {
		//this.setDebug();
		//this.urlCorrente = "http://www.magazineluiza.com.br/laptop-e-tablet-infantil/brinquedos/s/br/lapt/";
	}


	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if ("product".equals(classeNome)) {
			ligaColeta();
		}
	}
	
	
	
	
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		
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
				if ("productTitle".equals(classe)) {
					this.nomeProduto = texto;
					this.urlProduto = this.getUtlUrl();
					this.imagemProduto = this.getUltImagem();
					return;
				}
				if ("originalPrice".equals(classe)) {
					this.precoRegular = texto;
					return;
				}
				if ("price".equals(classe)) {
					this.precoVenda = texto;
					return;
				}
				if ("installmentPrice".equals(classe)  && this.precoParcelado == null) {
					this.precoParcelado = texto;
					return;
				}
				if ("cashPrice".equals(classe2) && this.precoBoleto == null) {
					this.precoBoleto = texto;
					return;
				}
				if (texto.indexOf("Ver com outros produtos")!=-1) {
					desligaColeta();
					return;
				}
			}
		}
		if ("próxima página".equals(texto.trim()) && getUltTag() == HTML.Tag.A) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}

	}

	
	
	

}
