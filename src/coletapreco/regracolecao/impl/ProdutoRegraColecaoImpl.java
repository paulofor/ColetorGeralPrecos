package coletapreco.regracolecao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.app.Constantes;
import coletapreco.dao.ProdutoDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.ModeloProduto;
import coletapreco.modelo.ModeloProdutoProduto;
import coletapreco.modelo.Palavra;
import coletapreco.modelo.PalavraProduto;
import coletapreco.modelo.Produto;
import coletapreco.parse.regracolecaoadaptador.custom.ProdutoAdaptador;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.ModeloProdutoRegraColecao;
import coletapreco.regracolecao.PalavraProdutoRegraColecao;
import coletapreco.regracolecao.PalavraRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class ProdutoRegraColecaoImpl extends ProdutoRegraColecao {

	@Override
	public Produto ObtemPorNomeLoja(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		Produto produto = null;
		if (getFiltro().getNomeProduto() == null)
			throw new RuntimeException("Sem o nome do produto para pesquisa");
		if (getFiltro().getCodigoLoja() == 0)
			throw new RuntimeException("Sem o codigo da loja para pesquisa");
		produto = dao.ObtemPorNomeCodigoLoja(getFiltro().getNomeProduto(), getFiltro().getCodigoLoja());
		return produto;
	}

	@Override
	public Produto ObtemPorUrlProduto(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		Produto produto = null;
		if (getFiltro().getUrlProduto() == null)
			throw new RuntimeException("Sem url produto para pesquisa");
		produto = dao.ObtemPorUrlProduto(getFiltro().getUrlProduto());
		return produto;
	}

	@Override
	public List<Produto> OportunidadeDia(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao(conexao);
		this.getFiltro().validaDataInicioOportunidade();
		this.getFiltro().validaPercentualMinimoOportunidade();
		List<Produto> lista =
		 dao.OportunidadeDia(getFiltro().getDataInicioOportunidade(), "" +
		 getFiltro().getPercentualMinimoOportunidade());
		//List<Produto> lista = dao.OportunidadeDiaMediaMinimo(getFiltro().getDataInicioOportunidade());
		return lista;
	}

	@Override
	public Produto CriaListaPalavra(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao(conexao);
		List<Produto> listaSemPalavra = dao.ListaSemPalavraPorNatureza(2);
		PalavraRegraColecao palavraSrv = FabricaRegra.getInstancia().getPalavraRegraColecao();
		PalavraProdutoRegraColecao palavraProdutoSrv = FabricaRegra.getInstancia().getPalavraProdutoRegraColecao();
		for (Produto produto : listaSemPalavra) {
			palavraSrv.getFiltro().setProduto(produto);
			List<Palavra> listaPalavra = palavraSrv.ListaPorNomeProduto(conexao);
			for (Palavra palavra : listaPalavra) {
				System.out.println(palavra.getDescricao());
				if (palavra.getDescricao().length() > 1) {
					PalavraProduto palavraProduto = FabricaVo.criaPalavraProduto();
					palavraProduto.setPalavraRelaciondoA(palavra);
					palavraProduto.setProdutoRelaciondoA(produto);
					palavraProdutoSrv.getFiltro().setItem(palavraProduto);
					palavraProdutoSrv.PosicionaPalavra(conexao);
				}
			}

		}
		return null;
	}

	@Override
	public Produto CriaListaModelo(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao(conexao);
		PalavraProdutoRegraColecao palavraProdutoSrv = FabricaRegra.getInstancia().getPalavraProdutoRegraColecao();
		ModeloProdutoRegraColecao modeloSrv = FabricaRegra.getInstancia().getModeloProdutoRegraColecao();
		Produto produtoSemModelo = dao.ObtemPrimeiroSemModeloPorNatureza(2);
		while (produtoSemModelo != null) {
			ModeloProduto modeloProduto = FabricaVo.criaModeloProduto();
			modeloProduto.setNomeModeloProduto(produtoSemModelo.getNome());
			// criou um modelo para esse produto
			List<PalavraProduto> listaRelPalavra = palavraProdutoSrv.ListaPorProdutoRelaciondoA(produtoSemModelo.getIdObj(), conexao);

			this.getFiltro().setListaPalavraProduto(listaRelPalavra);

			List<Produto> outrosProdutos = ListaMesmaPalavra(conexao);
			outrosProdutos.add(produtoSemModelo);
			for (Produto produtoSemelhante : outrosProdutos) {
				ModeloProdutoProduto rel = FabricaVo.criaModeloProdutoProduto();
				rel.addListaProduto_ReferenteA(produtoSemelhante);
				modeloProduto.addListaModeloProdutoProduto_ReferenteA(rel);
			}
			// SALVAR EM UM MODELO - Sem salvar n�o vai acabar nunca.
			modeloSrv.getFiltro().setModeloNovo(modeloProduto);
			modeloSrv.CriaModeloNovo(); // cria com os relacionamentos de
										// produtos.
			produtoSemModelo = dao.ObtemPrimeiroSemModeloPorNatureza(2);
		}
		return null;
	}

	@Override
	public List<Produto> ListaMesmaPalavra(DaoConexao conexao) throws DaoException {
		List<PalavraProduto> listaPalavra = this.getFiltro().validaListaPalavraProduto();
		List<Long> listaId = new ArrayList<Long>();
		for (PalavraProduto palavra : listaPalavra) {
			if (!palavra.getPalavraRelaciondoA(false).getComum()) {
				listaId.add(palavra.getIdPalavraRa());
			}
		}
		ProdutoDao dao = getDao();
		return dao.listaMesmaPalavra(listaId);
	}

	@Override
	public List<Produto> ListaMelhoresPorNaturezaLimite(DaoConexao conexao) throws DaoException {
		long codigoNatureza = this.getFiltro().validaCodigoNatureza();
		long limite = this.getFiltro().validaLimitePosicionador();
		long diasComPreco = this.getFiltro().validaDiasPrecoVitrine();
		ProdutoDao dao = getDao(conexao);
		List<Produto> saida = dao.ListaMelhoresPorNaturezaLimiteComImagem(codigoNatureza, limite,diasComPreco);
		return saida;
	}

	@Override
	public Produto SalvaImagemLocal(DaoConexao conexao) throws DaoException {
		Produto produto = this.getFiltro().getItem();
		String urlImagem = produto.getImagem();
		String arquivoLocal = produto.getCodigoImagemLocal();
		if (urlImagem!=null && arquivoLocal!=null) {
			try {
				obtemImagem(urlImagem,arquivoLocal);
				produto.setImagemLocal(arquivoLocal);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
		return produto;
	}

	private void obtemImagem(String url, String arquivoLocal) throws MalformedURLException, IOException, FileNotFoundException {

		File localFile = new File(Constantes.DIRETORIO_IMAGENS + File.separator + arquivoLocal);
		URL urlAcesso = new URL(url);
		InputStream in = urlAcesso.openStream();
		FileOutputStream out = new FileOutputStream(localFile);
		copyStream(in, out);
	}

	private void copyStream(InputStream in, OutputStream out) throws IOException {
		int BUFFER_SIZE = 4096;
		try {
			byte[] buf = new byte[BUFFER_SIZE];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}

	@Override
	public Produto AcessaInformacaoProdutoPorId(DaoConexao conexao) throws DaoException {
		long idProduto = getFiltro().validaIdProduto();
		// Banco Local
		Produto produto = this.obtemPorChave(idProduto, conexao);
		ProdutoAdaptador adaptador = new ProdutoAdaptador();
		adaptador.atualizaDetalhe(produto, conexao);
		return null;
	}

	@Override
	public Produto AjustaNomeLista(DaoConexao conexao) throws DaoException {
		List<Produto> entrada = this.getListaEntradaItem();
		ProdutoAdaptador adaptador = new ProdutoAdaptador();
		for (Produto produto : entrada) {
			if (produto.getIdLojaVirtualLe()==11 && !produto.getVerificacaoNomeOk()) {
				adaptador.atualizaDetalhe(produto, conexao);
			}
		}
		return null;
	}

	@Override
	public Produto AtualizaProdutoExistente(DaoConexao conexao) throws DaoException {
		Produto produto = this.getFiltro().validaItem();
		ProdutoDao dao = getDao(conexao);
		dao.AtualizaProdutoExistente(produto);
		return produto;
	}

	@Override
	public Produto CorrigeImagemLista(DaoConexao conexao) throws DaoException {
		List<Produto> entrada = this.getListaEntradaItem();
		ProdutoAdaptador adaptador = new ProdutoAdaptador();
		for (Produto produto : entrada) {
			if (produto.getIdLojaVirtualLe()==1) {
				adaptador.atualizaDetalhe(produto, conexao);
			}
		}
		return null;
	}

}
