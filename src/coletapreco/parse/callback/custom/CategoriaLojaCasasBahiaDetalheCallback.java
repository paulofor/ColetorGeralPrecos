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


public class CategoriaLojaCasasBahiaDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	
	
	
	private String dataImagem;
	


	@Override
	protected String getUrlPrefixo() {
		return "http://www.pontofrio.com.br";
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	public CategoriaLojaCasasBahiaDetalheCallback() {
		this.setDebug();
		//this.urlCorrente = "http://www.magazineluiza.com.br/laptop-e-tablet-infantil/brinquedos/s/br/lapt/";
	}


	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if ("hproduct".equals(classeNome)) {
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
				if ("name fn".equals(classe)) {
					this.nomeProduto = texto;
					this.urlProduto = this.getUtlUrl();
					int posic = urlProduto.indexOf("?");
					if (posic!=-1)
						urlProduto = urlProduto.substring(0, posic);
					this.imagemProduto = this.dataImagem;
					return;
				}
				if ("from price regular".equals(classe2)) {
					this.precoRegular = texto;
					return;
				}
				if (classe2.indexOf("for price sale") != -1) {
					this.precoVenda = texto;
					return;
				}
				if ("installment".equals(classe)  && this.precoParcelado == null) {
					this.precoParcelado = texto;
					return;
				}
				/*
				if ("cashPrice".equals(classe2) && this.precoBoleto == null) {
					this.precoBoleto = texto;
					return;
				}
				*/
				if (texto.indexOf("Comparar")!=-1) {
					desligaColeta();
					return;
				}
			}
		}
		if ("Pr�xima".equals(texto.trim()) && getUltTag() == HTML.Tag.A) {
			loop = true;
			urlCorrente =  getPrefixoUrl() + this.getUtlUrl();
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
