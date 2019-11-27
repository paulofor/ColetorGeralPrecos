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


public class CategoriaLojaSubmarinoDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	
	private boolean ligaBoleto = false;
	private String dataImagem = null;
	
	private String urlMatriz = "http://www.submarino.com.br";
	
	private int limite = 24;
	private int offset = 0;
	
	private int TOTAL = 200;
	
		
	public CategoriaLojaSubmarinoDetalheCallback() {
		//this.setDebug();
	}
	

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("product-grid-item")!=-1) {
			ligaColeta();
		}
		
	}
	
	
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		
	}

	




	


	@Override
	protected void finalizaObjeto() {
		// TODO Auto-generated method stub
		super.finalizaObjeto();
		if (offset< TOTAL) {
			offset+= 24;
			loop = true;
			urlCorrente = dadosParse.getUrlDetalhe() + "?limite=" + limite + "&offset=" + offset;
		} else {
			loop = false;
		}
		
	}


	@Override
	public void inicializacao() {
		super.inicializacao();
	}


	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		
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
			String ultTexto = this.getUltConteudo2();
			if (texto.trim().length() > 0) {
				
				if ("card-product-name".equals(classe)) {
					nomeProduto = texto;
					this.urlProduto = urlMatriz  + this.getUtlUrl();
					int posic = urlProduto.indexOf("?");
					if (posic!=-1)
						urlProduto = urlProduto.substring(0, posic);
					this.imagemProduto = this.getUltImagem();
					return;
				}
				if ("value".equals(classe) && "value".equals(classe2)) {
					this.precoVenda = texto;
					this.desligaColeta();
					return;
				}

			}
		}
		

	}

	
	
	/*
	private boolean ligaBoleto = false;
	private String dataImagem = null;
	
		
	public CategoriaLojaSubmarinoDetalheCallback() {
		this.setDebug();
	}
	

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("productInfo")!=-1) {
			ligaColeta();
		}
	}
	
	
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		
	}

	




	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		dataImagem = (String) a.getAttribute("data-src");
	}


	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		super.handleSimpleTag(t, a, pos);
		if (ligaColeta){
			String tag = "" + t;
			if ("article".equals(tag)) {
				desligaColeta();
			}
		}
	}

	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			if (texto.trim().length() > 0) {
				if (ligaBoleto) {
					this.precoBoleto = texto;
					this.ligaBoleto = false;
				}
				if ("prodTitle".equals(classe2)) {
					nomeProduto = texto;
					this.urlProduto = this.getUtlUrl();
					this.imagemProduto = this.dataImagem;
				}
				if ("regular price".equals(classe)) {
					this.precoRegular = texto;
				}
				
				if ("invoice-price".equals(classe)) {
					this.ligaBoleto = true;
				}
				if ("product-price-concurrency".equals(classe2)) {
					String valor = texto.replace(".", "");
					this.precoVenda = valor + ",00";
				}
				if ("parcel".equals(classe)) {
					this.precoParcelado = texto;
					
				}
				if ("see-more".equals(classe2)) {
					this.marca = texto;
				}
			}
		}
		if ("Próxima".equals(texto.trim()) && getUltTag() == HTML.Tag.A) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}

	}

	
	*/

}
