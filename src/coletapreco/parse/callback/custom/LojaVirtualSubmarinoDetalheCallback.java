package coletapreco.parse.callback.custom;

import javax.swing.text.html.HTML.Tag;

import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.parse.callback.LojaVirtualDetalheCallbackHtml;

public class LojaVirtualSubmarinoDetalheCallback extends
		LojaVirtualDetalheCallbackHtml {

	private boolean ligaColetaItem = false;
	
	// Dados do Objeto
	private String nomeCategoria = null;
	private String urlCategoria = null;
	
	// Objeto Tratad
	private CategoriaLoja categoria = null;

	
	
	public LojaVirtualSubmarinoDetalheCallback() {
		//this.setDebug();
		
	}

	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		super.inicioTag(t, classeNome, idNome);
		if (("item-linha").equals(classeNome)) {
			ligaColetaItem = true;
		}
		
	}
	
	

	@Override
	public void inicializacao() {
		super.inicializacao();
		
	}

	@Override
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (ligaColetaItem) {
			String dado =  String.copyValueOf(data);
			this.nomeCategoria = dado;
			this.urlCategoria = this.getUtlUrl();
			//System.out.println("Nome Categoria: " + dado);
			//System.out.println("URL:" + this.getUtlUrl());
			ligaColetaItem = false;
			insereObjetoLista();
		}
	}

	private void insereObjetoLista() {
		categoria = FabricaVo.criaCategoriaLoja();
		categoria.setNome(nomeCategoria);
		if (urlCategoria.indexOf("http")==-1) {
			urlCategoria = "http://www.submarino.com.br" + urlCategoria;
		}
		categoria.setUrl(urlCategoria);
		//categoria.setNaturezaProdutoReferenteA(naturezaProduto);
		dadosParse.getItemDetalhe().addListaCategoriaLoja_Possui(categoria);
	}

	@Override
	protected void elementoSimples(Tag t, String nomeId, String nomeClasse,
			String conteudo) {
		
		
	}
	
	
}
