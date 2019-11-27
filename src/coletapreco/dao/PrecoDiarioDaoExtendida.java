package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.modelo.PrecoDiario;


public  class PrecoDiarioDaoExtendida  extends PrecoDiarioDaoBase implements PrecoDiarioDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaPorProdutoPertenceA(long idItem) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_pa = " + idItem + " order by data_hora desc limit 30";
		return this.getListaSql(sql);
	}

	@Override
	public void limparTabelaNuvem() throws DaoException {
		DataFonte ds = new DataSourceNuvem();
		this.setDataSource(ds);
		DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		String sql = " delete from " + tabelaSelect();
		this.executaSql(sql);
	}

	@Override
	public void enviaListaNuvem(List<PrecoDiario> lista) throws DaoException {
		DataFonte ds = new DataSourceNuvem();
		this.setDataSource(ds);
		DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		for (PrecoDiario item : lista) {
			this.insereItem(item);
		}
		ds = new DataSourceAplicacao();
		this.setDataSource(ds);
		this.setConexao(null);
	}

	@Override
	public PrecoDiario obtemPorDataIdProduto(String dataBd, long idProduto) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_pa = " + idProduto + " and data_hora > '" + dataBd + "' limit 1 ";
		return (PrecoDiario) this.getObjeto(sql);
	}

	@Override
	public PrecoDiario obtemMaisRecenteIdProduto(long idProduto) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_pa = " + idProduto + " order by data_hora desc limit 1";
		return (PrecoDiario) this.getObjeto(sql);
	}

	@Override
	public List<PrecoDiario> ListaPorIdProdutoDataInicial(long idProduto, String dataInicialBd) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_produto_pa = " + idProduto + " and data_hora >= '" + dataInicialBd + "' order by data_hora desc";
		return this.getListaSql(sql);
	}

	@Override
	public List<PrecoDiario> ListaPorIdProdutoDataInicialSemZeros(long idProduto, String dataInicialBd)
			throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where preco_venda > 0  and id_produto_pa = " + idProduto + " and data_hora >= '" + dataInicialBd + "' order by data_hora desc";
		return this.getListaSql(sql);
	} 
	
	
}
