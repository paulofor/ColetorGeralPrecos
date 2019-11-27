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


public class CategoriaLojaRicardoDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	
	
	
	private String dataImagem;
	private boolean precoCompleto = false;


	@Override
	protected String getUrlPrefixo() {
		return "http://www.ricardoeletro.com.br";
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	public CategoriaLojaRicardoDetalheCallback() {
		//this.setDebug();
		//this.urlCorrente = "http://www.magazineluiza.com.br/laptop-e-tablet-infantil/brinquedos/s/br/lapt/";
	}


	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.DIV && classeNome.indexOf("box-vitrine content-produto")!=-1) {
			ligaColeta();
		}
		if ("stickers".equals(classeNome)) {
			desligaColeta();
			precoCompleto = false;
			return;
		}
		
	}
	
	
	
	
	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		super.handleUrl(url, classe, titulo, id);
		if (classe!=null && classe.indexOf("avancar")!=-1) {
			if (classe.indexOf("inativo")==-1) {
				loop = true;
				urlCorrente = url;
			}
		}
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
		
	}
	
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			String textoAnterior = this.getUltConteudo2();
			if (texto.trim().length() > 0) {
				if ("nome-produto-vertical".equals(classe2)) {
					this.nomeProduto = texto;
					this.urlProduto = this.getUtlUrl();
					this.imagemProduto = this.getUltImagem();
					return;
				}
				if ("preco-de".equals(classe2) ) {
					this.precoRegular = texto;
					return;
				}
				if ("produto-por".equals(classe2)) {
					this.precoVenda = texto;
					return;
				}
				
				
			
				if ("qt-vezes".equals(classe) ) {
					this.precoParcelado = texto;
					return;
				}
				if ("valor-parcelado".equals(classe) ) {
					this.precoParcelado += texto;
					return;
				}
				if ("Comparar".equals(texto)) {
					this.desligaColeta();
				}
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
			urlCorrente = this.getUrlPrefixo()+  getPrefixoUrl() + this.getUtlUrl();
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
