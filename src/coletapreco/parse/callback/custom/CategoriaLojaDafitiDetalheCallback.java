package coletapreco.parse.callback.custom;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;

import coletapreco.app.Constantes;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;


public class CategoriaLojaDafitiDetalheCallback extends CategoriaLojaDetalheCallbackHtml {

	private String imagemTrb = null;
	private String precoParcelas = null;
	private String qtdeParcelas = null;
	
	private boolean inicioTelaProduto = false;
	
	private int contaLoop = 0;

	public CategoriaLojaDafitiDetalheCallback() {
		//this.setDebug();
	}

	@Override
	protected void handleUrl(String url, String classe, String titulo, String id) {
		// TODO Auto-generated method stub
		super.handleUrl(url, classe, titulo, id);
		if ("Próximo".equals(titulo)) {
			loop = true;
			urlCorrente = "https://www.dafiti.com.br" + url;
		}

	}

	@Override
	public void inicializacao() {
		inicioTelaProduto = false;
		loop = false;
		contaLoop++;
	}

	@Override
	public void inicioTag(HTML.Tag t, String nomeClasse, String nomeId) {
		super.inicioTag(t, nomeClasse, nomeId);
		if (nomeClasse.indexOf("main-list")!=-1) {
			inicioTelaProduto = true;
		}
			
		if ("product-box-image".equals(nomeClasse.trim()) && inicioTelaProduto) {
			if (this.nomeProduto!=null) {
				if (precoParcelas!=null && qtdeParcelas!=null) {
					this.precoParcelado = qtdeParcelas + " " + precoParcelas;
					qtdeParcelas = null;
					precoParcelas = null;
				}
				if (this.precoVenda==null && this.precoRegular!=null) {
					this.precoVenda = this.precoRegular;
				}
				desligaColeta();
			}
			ligaColeta();
		}
//		if ("product-box".equals(nomeClasse) && ligaColetaProduto) {
//			desligaColeta();
//		}
//		if ("product-box".equals(nomeClasse)) {
//			if (contaInicio == 0)
//				contaInicio++;
//			else {
//				ligaColetaProduto = true;
//				ligaColeta();
//			}
//		}

	}

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		if (ligaColeta) {
			
			String classe = this.getUltClasse();
			if (texto.trim().length() > 0) {
				if ("product-box-brand".equals(classe)) {
					marca = texto;
					this.urlProduto = this.getUtlUrl3();
					return;
				}
				if ("product-box-title hide-mobile".equals(classe)) {
					nomeProduto = texto;
					imagemProduto = imagemTrb;
					return;
				}
				if ("product-box-price-from".equals(classe)) {
					this.precoRegular = texto;
					
					return;
				}
				if (qtdeParcelas == null && "product-box-installment-parcel".equals(classe)) {
					this.qtdeParcelas = texto;
					return;
				}
				if ("product-box-installment-value".equals(classe)) {
					this.precoParcelas = texto;
					return;
				}

				if ("product-box-price-to".equals(classe)) {
					this.precoVenda = texto;
					return;
				}

			}
			
		}
		if ("Próximo".equals(texto)) {
			loop = true;
			urlCorrente = "https://www.dafiti.com.br" + this.getUtlUrl();
			if (contaLoop>=Constantes.PAGINAS_SAPATOS_DAFITI) loop = false;
		}
		

	}

	

	

	@Override
	protected void handleImagem(MutableAttributeSet a) {
		super.handleImagem(a);

		if (a.getAttribute("data-original") != null) {
			imagemTrb = a.getAttribute("data-original").toString();
		}

	}

	private void insereObjetoListaNovo() {
		/*produto = FabricaVo.criaProduto();

		if (marca != null) {
			marca = marca.replaceAll("’", " ");
			marca = marca.replaceAll("'", " ");
			Marca marcaObj = FabricaVo.criaMarca();
			marcaObj.setNomeMarca(marca);
			produto.setMarcaPertenceA(marcaObj);
		}

		nomeProduto = nomeProduto.replaceAll("'", " ");
		produto.setNome(nomeProduto);
		produto.setUrl(urlProduto);
		produto.setUrlOrigem(getUrlOrigem());
		produto.setImagem(imagem);

		PrecoProduto preco = FabricaVo.criaPrecoProduto();
		if (this.valorPromocional != null)
			preco.setValorConsumidor(extraiValorPreco(this.valorPromocional));
		else
			preco.setValorConsumidor(extraiValorPreco(this.precoFrom));

		preco.setValorParcela(extraiValorPreco(this.precoParcelas));
		int limiteQtde = this.qtdeParcelas.toLowerCase().indexOf("x");
		String valorQtde = this.qtdeParcelas.substring(0, limiteQtde);
		preco.setQuantidadeParcela(Long.parseLong(valorQtde));
		produto.addListaPrecoProduto_Possui(preco);

		CategoriaProdutoProduto relacionamento = FabricaVo.criaCategoriaProdutoProduto();
		relacionamento.setProdutoReferenteA(produto);
		dadosParse.getItemDetalhe().addListaCategoriaProdutoProduto_Possui(relacionamento);
*/
		//inicializaVariaveis();
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
