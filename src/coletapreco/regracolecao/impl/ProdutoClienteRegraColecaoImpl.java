package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.ProdutoClienteDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.Produto;
import coletapreco.modelo.ProdutoCliente;
import coletapreco.regracolecao.ProdutoClienteRegraColecao;


public  class ProdutoClienteRegraColecaoImpl  extends ProdutoClienteRegraColecao {

	// NAo precia desse metodo
//	@Override
//	public List<ProdutoCliente> ListaMelhoresPorNaturezaLimite(DaoConexao conexao) throws DaoException {
//		throw new UnsupportedOperationException();
//	}

	@Override
	public ProdutoCliente CriaDeOrigem(DaoConexao conexao) throws DaoException {
		Produto produto = this.getFiltro().validaOrigem();
		ProdutoCliente produtoCliente = FabricaVo.criaProdutoCliente();
		produtoCliente.setIdNaturezaProdutoRa(this.getFiltro().getCodigoNatureza());
		// No servidor Kinghost IdProdutoCliente não é auto_increment
		produtoCliente.setIdProdutoCliente(produto.getIdProduto());
		produtoCliente.setNome(produto.getNome());
		produtoCliente.setImagem(produto.getImagem());
		produtoCliente.setUrl(produto.getUrl());
		produtoCliente.setPrecoAtual(produto.getCorrentePrecoDiario_Possui().getPrecoVenda());
		if (produto.getCorrenteMarca_Possui()!=null)
			produtoCliente.setMarca(produto.getCorrenteMarca_Possui().getNomeMarca());
		if (produto.getLojaVirtualLidoEm(false)!=null) 
			produtoCliente.setLoja(produto.getLojaVirtualLidoEm(false).getNomeLojaVirtual());
		produtoCliente.setPosicaoProduto(produto.getPosicaoProduto());
		return produtoCliente;
	}

	

	@Override
	public ProdutoCliente ReinicializaNaturezaLista(DaoConexao conexao) throws DaoException {
		long codigoNatureza = this.getFiltro().validaCodigoNatureza();
		ProdutoClienteDao dao = getDao(conexao);
		dao.DeletePorNatureza(codigoNatureza);
		List<ProdutoCliente> listaProduto = this.getListaEntradaItem();
		for (ProdutoCliente produto : listaProduto) {
			dao.insereItem(produto);
		}
		return null;
	}

	@Override
	public List<ProdutoCliente> RetiraDuplicata(DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao(conexao);
		List<ProdutoCliente> listaProduto = this.getListaEntradaItem();
		return listaProduto;
	}



}
