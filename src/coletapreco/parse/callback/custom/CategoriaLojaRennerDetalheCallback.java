package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;

import br.com.digicom.parse.ExecutadorParse;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;
import coletapreco.parse.callback.custom.lazy.CategoriaLojaRennerDetalheCallbackLazy;


public class CategoriaLojaRennerDetalheCallback extends CategoriaLojaDetalheCallbackHtml {


	//http://www.conceitofashion.com.br/categoria-produto/juju-salimeni/page/2/
	

	
	private int contaLoop = 0;
	
	private String skuProduto = "";
	private String urlLazy = "";

	public CategoriaLojaRennerDetalheCallback() {
		this.setDebug();
	}

	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		// TODO Auto-generated method stub
		super.handleUrl(url, classe, titulo, id);
		/*if (classe!=null && "pagination-link is-next".equals(classe.trim())) {
			loop = true;
			urlCorrente = "http://www.zattini.com.br" + url;
			if (contaLoop>=Constantes.PAGINAS_SAPATOS_ZATTINI) loop = false;
		}*/

	}

	@Override
	public void inicializacao() {
		if (contaLoop==0) {
			contaLoop++;
			loop = true;
			
		} else {
			loop = false;
		}
	}

	@Override
	public void inicioTag(HTML.Tag t, String nomeClasse, String nomeId) {
		super.inicioTag(t, nomeClasse, nomeId);
		if (nomeClasse.indexOf("itemProduct")!=-1) {
			ligaColeta();
			skuProduto = nomeId.substring(2);
			urlLazy = "http://www.lojasrenner.com.br/global/productBox.jsp?productId=" + skuProduto;
		}
	}
	
	private ExecutadorParse exec = null;
	private CategoriaLojaRennerDetalheCallbackLazy callback = null;
	
	private void chamaAjax(String url) {
		
	}
	

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			if ("shelfWrap".equals(this.getUltClasse3())) {
				nomeProduto = texto;
				urlProduto = this.getUtlUrl();
				urlProduto = this.retiraParametro(urlProduto,";");
			}
			
		}
	}

	

	

	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);
		if (ligaColeta) {
			System.out.println("Imagem:");
		}
		

	}

	private void insereObjetoListaNovo() {
	
	}

	private void inicializaObjetoLista() {
		
	}

	private void insereObjetoLista() {
		/*produto = FabricaVo.criaProduto();
		String marca1 = marca.replaceAll("’", " ");
		String marca2 = marca.replaceAll("'", " ");
		Marca marca = FabricaVo.criaMarca();
		marca.setNomeMarca(marca2);
		produto.setMarcaPertenceA(marca);
		String nomeProduto1 = nomeProduto.replaceAll("'", " ");
		produto.setNome(nomeProduto1);
		produto.setUrl(url);

		// String img = URLDecoder.decode(imagem);
		produto.setImagem(imagem);
		int x = precoParcelado.indexOf("x");
		String parcela = precoParcelado.substring(0, x).trim();
		String valorParcela = precoParcelado.substring(x + 1).trim();
		PrecoProduto preco = FabricaVo.criaPrecoProduto();
		preco.setValorPrecoAvista(extraiValorPreco(precoAvista));
		preco.setQuantidadeParcela(Long.parseLong(parcela));
		preco.setValorParcela(extraiValorPreco(valorParcela));
		if (this.valorPromocional != null) {
			preco.setPrecoPromocional(extraiValorPreco(this.valorPromocional));
			preco.setValorConsumidor(preco.getPrecoPromocional());
		} else {
			preco.setValorConsumidor(preco.getValorPrecoAvista());
		}
		produto.setUrlOrigem(getUrlOrigem());
		produto.addListaPrecoProduto_Possui(preco);

		CategoriaProdutoProduto relac = FabricaVo.criaCategoriaProdutoProduto();
		dadosParse.getItemDetalhe().addListaCategoriaProdutoProduto_Possui(relac);
*/
		

	}

}
