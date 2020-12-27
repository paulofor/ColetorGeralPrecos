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
	public void limparTabelaNuvem(DaoConexao connNuvem, long idNaturezaProdutoPa) throws DaoException {
		String sql = " delete from Cosmetic_PrecoDiario where idNaturezaProduto = " + idNaturezaProdutoPa;
		this.executaSql(sql, connNuvem);
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
	public void enviaListaNuvem(List<PrecoDiario> lista, OportunidadeDia oportunidade, DaoConexao conexao) throws DaoException {
		//DataFonte ds = new DataSourceNuvem();
		//this.setDataSource(ds);
		//DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		for (PrecoDiario item : lista) {
			item.setIdOportunidadeDia(oportunidade.getIdObj());
			item.setIdNaturezaProduto(oportunidade.getIdNaturezaProdutoPa());
			this.insereItemIdOportunidade(item);
		}
		//ds = new DataSourceAplicacao();
		//this.setDataSource(ds);
		this.setConexao(null);
	}
	private void insereItemIdOportunidade(PrecoDiario item) throws DaoException {
		String sql;
        sql = "insert into Cosmetic_PrecoDiario " +
            camposInsertIdOportunidade() + " values " + valoresInsertIdOportunidade(item);
        this.executaSql(sql);
	}
	private String valoresInsertIdOportunidade(PrecoDiario item) {
		return " ( '" + item.getIdPrecoDiario() + "'  " 
		//+ " ,'" +  DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		//+ " ,'" + item.getQuantidadeParcela() + "'  "
		//+ " ,'" +  DCConvert.ToDataBase(item.getPrecoParcela()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		//+ " ,'" +  DCConvert.ToDataBase(item.getPrecoRegular()) + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " , " + item.getIdOportunidadeDia() + " "
		+ " , " + item.getIdNaturezaProduto() + " "
		+ " ) ";
	}
	protected String camposInsertIdOportunidade() 
	{
		return " ( id " 
		//+ " ,preco_boleto " 
		+ " ,data " 
		//+ " ,quantidade_parcela " 
		//+ " ,preco_parcela " 
		+ " ,precoVenda " 
		//+ " ,preco_regular " 
		+ " ,posicaoProduto " 
		+ " ,idProduto " 
		+ " ,idOportunidadeDia "
		+ " ,idNaturezaProduto "
		+ " ) ";
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

	@Override
	public void insereSimples(PrecoDiario item) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsertSimples() + " values " + valoresInsertSimples(item);
        this.executaSql(sql);
	}
	private String valoresInsertSimples(PrecoDiario item) {
		return " ( " 
		+ " " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " ) ";
	}
	private String camposInsertSimples() 
	{
		return " ( " 
		+ " data_hora " 
		+ " ,preco_venda " 
		+ " ,posicao_produto " 
		+ " ,id_produto_pa " 
		 + " ) ";
	}

	

	

	
	
	
}
