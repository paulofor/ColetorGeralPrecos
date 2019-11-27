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


public class CategoriaLojaWalmartDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	
	
	
	private String dataImagem;
	private boolean precoCompleto = false;


	@Override
	protected String getUrlPrefixo() {
		return "https://www.walmart.com.br";
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	public CategoriaLojaWalmartDetalheCallback() {
		//this.setDebug();
		//this.urlCorrente = "http://www.magazineluiza.com.br/laptop-e-tablet-infantil/brinquedos/s/br/lapt/";
	}


	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.LI && classeNome.indexOf("shelf-product-item")!=-1) {
			ligaColeta();
		}
		//if ("stickers".equals(classeNome)) {
		//	desligaColeta();
		//	precoCompleto = false;
		//	return;
		//}
	}
	
	
	
	
	@Override
	public void handleEndTag(Tag t, int pos) {
		super.handleEndTag(t, pos);
		if (ligaColeta && t == HTML.Tag.LI) {
			this.desligaColeta();
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




	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		if (a.getAttribute("data-src")!=null)
			dataImagem = (String) a.getAttribute("data-src");
	}
	
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			String textoAnterior = this.getUltConteudo2();
			if (texto.trim().length() > 0) {
				if ("product-title".equals(classe)) {
					this.nomeProduto = texto;
					this.urlProduto = getUrlPrefixo() + this.getUtlUrl();
					//this.imagemProduto = this.dataImagem;
					return;
				}
				//if ("payment-price-old".equals(classe2) && textoAnterior.indexOf("De ")!=-1) {
				//	this.precoRegular = texto;
				//	return;
				//}
				//if ("payment-currency".equals(classe)) {
				//	this.precoVenda = texto;
				//	return;
				//}
				if ("int".equals(classe)) {
					this.precoVenda = texto;
					this.imagemProduto = "http:" + this.dataImagem;
					return;
				}
				if ("dec".equals(classe)) {
					this.precoVenda += texto;
					this.desligaColeta();
					return;
				}
				//if (texto.indexOf("vista")==-1 && "payment-installment-amount".equals(classe) && !precoCompleto) {
				//	this.precoParcelado = texto;
				//	return;
				//}
				//if ("payment-installment-price".equals(classe) && !precoCompleto) {
				//	this.precoParcelado += texto;
				//	precoCompleto = true;
				//	return;
				//}
				/*
				if ("cashPrice".equals(classe2) && this.precoBoleto == null) {
					this.precoBoleto = texto;
					return;
				}
				*/
				
			}
		}
		if ("Ver mais resultados".equals(texto.trim()) && this.getUltTag() == HTML.Tag.SPAN) {
			loop = true;
			urlCorrente = getPrefixoUrl() + this.getUtlUrl();
			if (urlCorrente.indexOf("http")==-1)
				urlCorrente = this.getUrlPrefixo()+  urlCorrente;
		}

	}

	private String getPrefixoUrl() {
		String prefixo = dadosParse.getItemDetalhe().getUrl();
		//String fragmento[] = prefixo.split('?');
		int finalUrl = prefixo.indexOf('?');
		prefixo = prefixo.substring(0,finalUrl);
		return prefixo;
	}
	
	

}
