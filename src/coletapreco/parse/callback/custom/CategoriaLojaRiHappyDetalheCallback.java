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


public class CategoriaLojaRiHappyDetalheCallback  extends CategoriaLojaDetalheCallbackHtml {

	private boolean ligaBoleto = false;
	private String dataImagem = null;
	
	private int paginaAtual = 1;
	private boolean existeProduto = false;
	
	private String urlPaginacao = null;
		
	
	
	
	@Override
	protected String getUrlPrefixo() {
		return "http://www.rihappy.com.br/";
	}


	@Override
	public void finalizaObjeto() {
		super.finalizaObjeto();
		if (existeProduto) {
			loop = true;
			paginaAtual++;
			this.urlCorrente = urlPaginacao + paginaAtual;
		} else {
			loop = false;
			paginaAtual = 1;
		}
		existeProduto = false;
	}


	public CategoriaLojaRiHappyDetalheCallback() {
		//this.setDebug();
	}
	@Override
	public void handleComment(char[] data, int pos) {
		super.handleComment(data, pos);
		String texto = String.copyValueOf(data);
		String dado = null;
		if (texto.indexOf("buscapagina?")!=-1) {
			int ini = texto.indexOf("buscapagina?");
			dado = texto.substring(ini);
			int termino = dado.indexOf("+");
			urlPaginacao = dado.substring(0,termino-2);
		}
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (classeNome.indexOf("brinquedos")!=-1 && t == HTML.Tag.LI) {
			ligaColeta();
		}
		if ("selos".equals(classeNome)) {
			this.desligaColeta();
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
		
	}

	
	@SuppressWarnings("unused")
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		HTML.Tag t = this.getUltTag();
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			String valorTag = t.toString();
			if (texto.trim().length() > 0) {
				if (this.nomeProduto == null && "productIdInRel".equals(classe)) {
					this.nomeProduto = texto;
					this.imagemProduto = this.getUltImagem();
					this.urlProduto = this.getUtlUrl();
					existeProduto = true;
					return;
				}
				if ("s".equals(valorTag) && "precos".equals(classe2)) {
					this.precoRegular = texto;
					return;
				}
				if ("productIdInRel".equals(classe) && this.getUltTag2() == HTML.Tag.H2)  {
					this.precoVenda = texto;
					return;
				}
				if ("productIdInRel".equals(classe) && this.getUltTag2() == HTML.Tag.H3)  {
					this.precoParcelado = texto;
					return;
				}
				
			}
		}
		
		if ("próximo".equals(texto.trim())) {
			loop = true;
			urlCorrente = this.getUtlUrl();
		}

	}


	
	
	

}
