package coletapreco.parse.dados;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.modelo.Marca;
import coletapreco.modelo.Produto;
import coletapreco.parse.dados.basico.CategoriaLojaDadosParseBase;
import coletapreco.regracolecao.CategoriaLojaProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.MarcaRegraColecao;
import coletapreco.regracolecao.PrecoDiarioRegraColecao;
import coletapreco.regracolecao.PrecoProdutoRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class CategoriaLojaDadosParse extends CategoriaLojaDadosParseBase{
	
	int contaItem = 0;
	
	private ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
	private MarcaRegraColecao marcaSrv = FabricaRegra.getInstancia().getMarcaRegraColecao();
	private PrecoProdutoRegraColecao precoSrv = FabricaRegra.getInstancia().getPrecoProdutoRegraColecao();
	private CategoriaLojaProdutoRegraColecao categoriaProdutoSrv = FabricaRegra.getInstancia().getCategoriaLojaProdutoRegraColecao();
	private PrecoDiarioRegraColecao precoDiarioSrv = FabricaRegra.getInstancia().getPrecoDiarioRegraColecao();
	

	@Override
	public String getUrlDetalhe() {
		String url = this.itemDetalhe.getUrl();
		ArquivoLog.getInstancia().salvaLog("URL: " + url);
		return url;
	}

	@Override
	public void finalizacaoOkDetalhe() {
		List<CategoriaLojaProduto> listaRelacioanmento = this.itemDetalhe.getListaCategoriaLojaProduto_Possui();
		this.produtoSrv.getFiltro().setCodigoLoja(this.itemDetalhe.getIdLojaVirtualPa());
		try {
			if (listaRelacioanmento != null) {
				int cont = 1;
				//System.out.println("Antes do loop");
				for (CategoriaLojaProduto relac : listaRelacioanmento) {
					relac.getCorrenteProduto_ReferenteA().setIdLojaVirtualLe(itemDetalhe.getIdLojaVirtualPa());
					relac.setCategoriaLojaReferenteA(itemDetalhe);
					Produto produto =  relac.getCorrenteProduto_ReferenteA();
					
					// *****
					produto = processaProduto(produto);
					//System.out.println((cont++) + ":" + produto.getNome());
					relac.setProdutoReferenteA(produto);
					categoriaProdutoSrv.getFiltro().setItem(relac);
					categoriaProdutoSrv.AtualizaRelacionamento(getConexao());
				}
				//System.out.println("Finalizaou loop");
			} else {
				ArquivoLog.getInstancia().salvaMonitoramento("Categoria " + itemDetalhe.getNome() + " ( " + itemDetalhe.getUrl() + " ) est� vazia");
			}
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaErro(e);
			e.printStackTrace();
		}
	}
	
	private Produto processaProduto(Produto produto) throws DaoException {
		try {
			if (produto.getNome()==null) return null;
			produto.setNome(produto.getNome().replace('\'', ' '));
			produto.setNome(produto.getNome().replace((char)92, (char)32));
			Marca marcaObj = produto.getMarcaPossui(false);
			String nomeMarca = marcaObj.getNomeMarca();
			if (nomeMarca!=null) {
				nomeMarca = nomeMarca.replace('\'', ' ');
				produto.getMarcaPossui(false).setNomeMarca(nomeMarca);
			}
		
			ArquivoLog.getInstancia().salvaLog("Produto: " + produto.getNome() + " ( " + produto.getUrl() + " )  cont: " + produto.getPosicaoProduto());
			//ArquivoLog.getInstancia().salvaLogNomeProduto(produto.getNome());
			
			//exibeDadosProduto(produto);
			produtoSrv.getFiltro().setNomeProduto(produto.getNome());
			produtoSrv.getFiltro().setUrlProduto(produto.getUrl());
			Produto pesquisaProduto = this.produtoSrv.ObtemPorUrlProduto(getConexao());
			
			
			if (pesquisaProduto==null) {
				ArquivoLog.getInstancia().salvaLog("Produto nao existe");
				Marca pesquisaMarca = this.getMarca(produto);
				if (pesquisaMarca!=null) {
					produto.setMarcaPossui(pesquisaMarca);
				} else {
					produto.setMarcaPossui(this.marcaSrv.insereItemLoad(produto.getCorrenteMarca_Possui(), this.getConexao()));
				}
				produto.setDataInclusao(DatasUtils.getDataDD_MM_AAAA());
			
				this.produtoSrv.insereItemLoad(produto, getConexao());
				ArquivoLog.getInstancia().salvaLog("Codigo Produto:" + produto.getIdObj());
			} else {
				ArquivoLog.getInstancia().salvaLog("Produto existe (id:" + pesquisaProduto.getIdProduto() + ")");
				corrigeNomeProduto(pesquisaProduto, produto.getNome());
				pesquisaProduto.setListaPrecoProduto_Possui(produto.getListaPrecoProduto_Possui());
				pesquisaProduto.setPosicao(produto.getPosicao());
				pesquisaProduto.setPosicaoProduto(produto.getPosicaoProduto());
				// Liberar Depois que as imagens estiverem ok
				
				if (produto.getImagem()!=null && produto.getImagem().compareToIgnoreCase(pesquisaProduto.getImagem())!=0) {
					ArquivoLog.getInstancia().salvaLog("Nova imagem:" + produto.getImagem());
					pesquisaProduto.setImagem(produto.getImagem());
					
				}
				// Atualizando tudo por conta de nome, imagem e posicaaoProduto
				produtoSrv.getFiltro().setItem(pesquisaProduto);
				produtoSrv.AtualizaProdutoExistente(getConexao());
				//produtoSrv.alteraItem(pesquisaProduto,getConexao());
				produto = pesquisaProduto;
	
			}
			
			// Novos (BigData)
			produto.setIdLojaVirtual(this.itemDetalhe.getIdLojaVirtualPa());
			produto.setIdCategoriaLoja(this.itemDetalhe.getIdCategoriaLoja());
			produto.setIdNaturezaProduto(this.itemDetalhe.getIdNaturezaProdutoRa());
			
			// Alterado em 06-01-2017
			precoSrv.getFiltro().setProduto(produto);
			precoSrv.getFiltro().setItem(produto.getCorrentePrecoProduto_Possui());
			precoSrv.AtualizaPreco(getConexao());
			
			
			
			precoDiarioSrv.getFiltro().setProduto(produto);
			precoDiarioSrv.RegistraPreco(getConexao());
			return produto;
		} catch (Exception e) {
			try {
				String mensagem = produto.getNome() + " ( " + produto.getUrl() + " ) ";
				e.printStackTrace();
				ArquivoLog.getInstancia().salvaErro(e, mensagem);
			} catch (Exception e2) {
				ArquivoLog.getInstancia().salvaErro(e2);
			}
			return null;
		}
	}
	
	
	private void corrigeNomeProduto(Produto pesquisaProduto, String nome) throws DaoException {
		// TODO Auto-generated method stub
		String nomeAnterior = pesquisaProduto.getNome();
		boolean testaPesquisa = this.containsIllegals(nomeAnterior);
		if (testaPesquisa) {
			pesquisaProduto.setNome(nome);
			//this.produtoSrv.alteraItem(pesquisaProduto, getConexao());
		}
	}

	
	
	private boolean containsIllegals(String toExamine) {
	    Pattern pattern = Pattern.compile("[a-zA-Z_0-9]");
	    Matcher matcher = pattern.matcher(toExamine);
	    return matcher.find();
	}
	
	private Marca getMarca(Produto produto) throws DaoException {
		this.marcaSrv.getFiltro().setNome(produto.getCorrenteMarca_Possui().getNomeMarca());
		Marca marca = this.marcaSrv.ObtemPorNome(getConexao()) ;
		return marca;
	}
	 
	
	private void exibeDadosProduto2(Produto produto) {
		System.out.println(++contaItem);
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Marca: " + produto.getMarcaPossui(false).getNomeMarca());
		System.out.println("Url: " + produto.getUrl());
		System.out.println("Url Origem: " + produto.getUrlOrigem());
		System.out.println("Pre�o Venda: " + produto.getCorrentePrecoProduto_Possui().getPrecoVenda());
		System.out.println("Pre�o Boleto: " + produto.getCorrentePrecoProduto_Possui().getPrecoBoleto());
		System.out.println("Pre�o Regular: " + produto.getCorrentePrecoProduto_Possui().getPrecoRegular());
		System.out.println("Pre�o Parcela: " + produto.getCorrentePrecoProduto_Possui().getPrecoParcela());
		System.out.println("Quantidade Parcelas: " + produto.getCorrentePrecoProduto_Possui().getQuantidadeParcela());
	}

	@Override
	public void inicializacaoDetalhe() {
		super.inicializacaoDetalhe();
		this.itemDetalhe.setListaCategoriaLojaProduto_Possui(null);
	}


	

}