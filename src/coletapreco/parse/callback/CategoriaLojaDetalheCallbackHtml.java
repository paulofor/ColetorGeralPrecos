package coletapreco.parse.callback;

import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.Marca;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.parse.callback.basico.CategoriaLojaDetalheCallbackHtmlBase;

public class CategoriaLojaDetalheCallbackHtml extends CategoriaLojaDetalheCallbackHtmlBase{

	protected boolean ligaColeta = false;
	
	protected String nomeProduto = null;
	protected String urlProduto = null;
	protected String imagemProduto = null;
	protected String marca = null;
	
	protected String precoVenda = null;
	protected String precoParcelado = null;
	protected String precoBoleto = null;
	protected String precoRegular = null;
	
	protected int contagem = 0;
	protected boolean existeProduto = false;
	
	
	
	protected void inicializaProduto() {
		if (!ligaColeta) {
			this.inicializaDados();
		}
		ligaColeta = true;
	}
	protected void finalizaProduto() {
		ligaColeta = false;
		this.insereObjetoLista();
	}
	
	@Override
	protected void finalizaObjeto() {
		super.finalizaObjeto();
		existeProduto = false;
	}
	protected void ligaColeta() {
		ligaColeta = true;
		inicializaDados();
	}
	protected void desligaColeta() {
		ligaColeta = false;
		this.insereObjetoLista();
	}
	
	private void inicializaDados() {
		nomeProduto = null;
		urlProduto = null;
		imagemProduto = null;
		marca = null;
		
		precoParcelado = null;
		precoRegular = null;
		precoBoleto = null;
		precoVenda = null;
	}

	private void insereObjetoLista() {
	
		Marca marcaObj = FabricaVo.criaMarca();
		marcaObj.setNomeMarca(marca);
		
		Produto produto = FabricaVo.criaProduto();
		produto.setNome(nomeProduto);
		if (urlProduto!=null && urlProduto.indexOf("http")==-1)
			urlProduto = this.getUrlPrefixo() + urlProduto;
		produto.setUrl(urlProduto);
		produto.setUrlOrigem(getUrlOrigem());
		produto.setMarcaPossui(marcaObj);
		produto.setPosicaoProduto(++contagem);
		
		
		
		if (this.imagemProduto!=null) {
			if ("//".equals(imagemProduto.substring(0, 2))) {
				imagemProduto = "http:" + imagemProduto;
			}
			produto.setImagem(imagemProduto);
		}
		
		PrecoProduto preco = FabricaVo.criaPrecoProduto();
		preco.setPrecoBoleto(this.extraiValorPreco(precoBoleto));
		if (precoParcelado!=null) {
			preco.setQuantidadeParcela(this.extraiParcelas(precoParcelado));
			String valor = precoParcelado.substring(precoParcelado.indexOf("$")); // colocar no extraiValorParcelas ?
			preco.setPrecoParcela(this.extraiValorParcelas(valor));
		}
		preco.setPrecoVenda(this.extraiValorPreco(precoVenda));
		preco.setPrecoRegular(this.extraiValorPreco(precoRegular));
		produto.addListaPrecoProduto_Possui(preco);
		
		CategoriaLojaProduto relacionamento = FabricaVo.criaCategoriaLojaProduto();
		relacionamento.setProdutoReferenteA(produto);
		dadosParse.getItemDetalhe().addListaCategoriaLojaProduto_Possui(relacionamento);
		existeProduto = true;
	}
	
	protected String retiraParametro(String url) {
		int posic = url.indexOf("?");
		if (posic!=-1)
			url = url.substring(0, posic);
		return url;
	}
	
	protected String retiraParametro(String url, String limitador) {
		int posic = url.indexOf(limitador);
		if (posic!=-1)
			url = url.substring(0, posic);
		return url;
	}



}