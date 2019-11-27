package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.ContagemProduto;
import coletapreco.modelo.OportunidadeDia;


public  class ContagemProdutoDaoExtendida  extends ContagemProdutoDaoBase implements ContagemProdutoDao {

	
	public ContagemProdutoDaoExtendida() {
		super(new DataSourceAplicacao());
	}
	
	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}



	@Override
	public void RegistraQuantidadesDia() throws DaoException {
		String sqldel = "delete  from contagem_produto where data = curdate();";
		// TODO Auto-generated method stub
		String sql = "insert into contagem_produto (id_loja_virtual_ra, id_natureza_produto_ra, quantidade, data) " +
				" select id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra , count(*), " +
				" date(preco_produto.data_ultima_visita) from preco_produto " +
				" inner join produto on produto.id_produto = preco_produto.id_produto_pa " + 
				" inner join categoria_loja_produto on categoria_loja_produto.id_produto_ra = preco_produto.id_produto_pa " +  
				" inner join categoria_loja on categoria_loja.id_categoria_loja = categoria_loja_produto.id_categoria_loja_ra " +
				" where date(preco_produto.data_ultima_visita) = curdate() " + 
				" group by id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra";
		this.executaSql(sqldel);
		this.executaSql(sql);
	} 
	
	@Override
	public void AtualizaQuantidadesDia() throws DaoException {
		String sql1 = "delete from contagem_produto where data = curdate() ";
		this.executaSql(sql1);
		String sql2 =
				"insert into contagem_produto (id_loja_virtual_ra, id_natureza_produto_ra, quantidade, data) " +
				"select id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra , count(*) as qtde, date(preco_produto.data_ultima_visita) as data_ultima_visita " +
				"from preco_produto " +
				"inner join produto on produto.id_produto = preco_produto.id_produto_pa " + 
				"inner join categoria_loja_produto on categoria_loja_produto.id_produto_ra = preco_produto.id_produto_pa " +  
				"inner join categoria_loja on categoria_loja.id_categoria_loja = categoria_loja_produto.id_categoria_loja_ra " +
				"where date(preco_produto.data_ultima_visita) = curdate() " +
				"group by id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra,  date(preco_produto.data_ultima_visita)"; 
		this.executaSql(sql2);
	}
	
	@Override
	public void ApagaQuantidadesDia() throws DaoException {
		String sqldel = "delete  from contagem_produto where data = curdate();";
		this.executaSql(sqldel);
	}
	

	@Override
	public List<ContagemProduto> ListaDiaCorrente() throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() + " where data = curdate()";
		return this.getListaSql(sql);
	}

	@Override
	public void EnviaListaNuvem(List<ContagemProduto> lista) throws DaoException {
		DataFonte ds = new DataSourceNuvem();
		this.setDataSource(ds);
		DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		ApagaQuantidadesDia();
		for (ContagemProduto item : lista) {
			this.insereItem(item);
		}
		ds = new DataSourceAplicacao();
		this.setDataSource(ds);
		this.setConexao(null);
		
	}

	@Override
	public void CalculaDiferencaErro() throws DaoException {
		String sqlPercentual = "update " +
				" contagem_produto, " +
				" (select * from contagem_produto where data = curdate()) as hoje, " +
				" (select * from contagem_produto where data in (select max(data) from contagem_produto where data < curdate())) as ontem " +
				// Parte mais importante
				" set contagem_produto.percentual_diferenca = (cast(hoje.quantidade as signed) - cast(ontem.quantidade as signed))  / cast(ontem.quantidade as signed) " +
				// --------------------
				" where ontem.id_loja_virtual_ra = hoje.id_loja_virtual_ra and " +
				" ontem.id_natureza_produto_ra = hoje.id_natureza_produto_ra and " +
				" contagem_produto.id_natureza_produto_ra = hoje.id_natureza_produto_ra and " +
				" contagem_produto.id_loja_virtual_ra = hoje.id_loja_virtual_ra and " +
				" contagem_produto.data = hoje.data";
		this.executaSql(sqlPercentual);
		String sqlPossibilidadeErro = "update contagem_produto set possibilidade_erro = 'S' where quantidade = 0 and percentual_diferenca = -1"; 
		this.executaSql(sqlPercentual);
		
	}
}
