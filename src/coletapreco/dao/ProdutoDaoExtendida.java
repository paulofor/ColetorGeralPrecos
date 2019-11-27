package coletapreco.dao;


import java.util.ArrayList;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletapreco.dao.basica.CategoriaLojaProdutoDaoBase;
import coletapreco.dao.basica.LojaVirtualDaoBase;
import coletapreco.dao.basica.MarcaDaoBase;
import coletapreco.dao.basica.PrecoProdutoDaoBase;
import coletapreco.dao.basica.ProdutoDaoBase;
import coletapreco.dao.montador.CategoriaLojaProdutoMontador;
import coletapreco.dao.montador.LojaVirtualMontador;
import coletapreco.dao.montador.MarcaMontador;
import coletapreco.dao.montador.PrecoDiarioMontador;
import coletapreco.dao.montador.PrecoProdutoMontador;
import coletapreco.dao.montador.ProdutoMontador;
import coletapreco.modelo.Produto;


public  class ProdutoDaoExtendida  extends ProdutoDaoBase implements ProdutoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public List ListaNaoRelacionadaEmModeloProdutoProdutoListaReferenteA(
			long idModeloProduto) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmPrecoProdutoListaPossui(long idPrecoProduto)
			throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmCategoriaLojaProdutoListaPossui(
			long idCategoriaLoja) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Produto ObtemPorNomeCodigoLoja(String nomeProduto, long codigoLoja) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where nome = '" + nomeProduto + "' and id_loja_virtual_le = " + codigoLoja;
		return (Produto) this.getObjeto(sql);
	}

	

	@Override
	public Produto ObtemPorUrlProduto(String urlProduto) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where url = '" + urlProduto + "'";
		this.setMontador(new ProdutoMontador());
		return (Produto) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPodePossuir(
			long idOportunidadeDia) throws DaoException {
		throw new UnsupportedOperationException();
	}
	
	
	
	
	@Override
	public List<Produto> OportunidadeDiaPrecoMinimo(String dataInicialMySql, String percentualMinimo) throws DaoException {
		String sql1 = " select id_produto " +
				" from " + tabelaSelect() +
				this.innerJoinPrecoProduto_Possui() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + 
				" where preco_produto.data_visita_inicial > '" + dataInicialMySql + "' " +
				" and preco_produto.data_ultima_visita = current_date() " +
				" and preco_produto.percentual_ajuste > " + percentualMinimo +
				" and preco_produto.preco_venda = ( " +
				" select min(preco_produto.preco_venda) from preco_produto " +
				" where id_produto_pa = produto.id_produto and preco_produto.preco_venda > 0 )";
				
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + " , " +
				MarcaDaoBase.camposOrdenados() + " , " +
				LojaVirtualDaoBase.camposOrdenados() +
				" from " + tabelaSelect() + 
				this.innerJoinPrecoProduto_Possui() +
				this.leftOuterJoinMarca_Possui() +
				this.innerJoinLojaVirtual_LidoEm() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + // PrecoProduto
				//" inner join marca on marca.id_marca = produto.id_marca_p " + // Marca
				" where id_produto in ("  + sql1 + " ) " +
				" and preco_produto.data_visita_inicial >= DATE_SUB( CURRENT_DATE, INTERVAL 6 MONTH ) " +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		
		MontadorDaoComposite composto = new MontadorDaoComposite();
		composto.adicionaMontador(new ProdutoMontador(), null);
		// Inserir Categoria e marca.
		composto.adicionaMontador(new PrecoProdutoMontador(), "ListaPrecoProduto_Possui");
		composto.adicionaMontador(new MarcaMontador(), "MarcaPossui");
		composto.adicionaMontador(new LojaVirtualMontador(), "LojaVirtualLidoEm");
		setMontador(composto);
		return this.getListaSqlListaInterna(sql);
	}

	
	@Override
	public List<Produto> OportunidadeDiaMediaMinimo(String dataInicialMySql) throws DaoException {

		String sql1 = " select id_produto " +
				" from " + tabelaSelect() +
				this.innerJoinPrecoProduto_Possui() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + 
				" where preco_produto.data_visita_inicial > '" + dataInicialMySql + "' " +
				" and preco_produto.data_ultima_visita = current_date() " +
				" and preco_produto.preco_venda > 0 " +
				" and preco_produto.percentual_ajuste > 5 " +
				// Media 2 meses abaixo de 15%	
				" and preco_produto.preco_venda <= (select (avg(preco_venda)*(1-0.15)) from preco_diario " + 
				" where id_produto_pa = produto.id_produto and preco_venda > 0 and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH )) " +
				// Proximo 12% do preco minimo de 3 meses	
				" and preco_produto.preco_venda <= (select (min(preco_venda)*(1+0.12)) from preco_diario " + 
				" where id_produto_pa = produto.id_produto and preco_venda > 0 and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )) " +
				" and 30 <= (select count(*) from preco_diario " + 
				" where id_produto_pa = produto.id_produto and preco_venda > 0 and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )) ";
				
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + " , " +
				MarcaDaoBase.camposOrdenados() + " , " +
				LojaVirtualDaoBase.camposOrdenados() +
				" from " + tabelaSelect() + 
				this.innerJoinPrecoProduto_Possui() +
				this.leftOuterJoinMarca_Possui() +
				this.innerJoinLojaVirtual_LidoEm() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + // PrecoProduto
				//" inner join marca on marca.id_marca = produto.id_marca_p " + // Marca
				" where id_produto in ("  + sql1 + " ) " +
				" and preco_produto.data_visita_inicial >= DATE_SUB( CURRENT_DATE, INTERVAL 6 MONTH ) " +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		
		MontadorDaoComposite composto = new MontadorDaoComposite();
		composto.adicionaMontador(new ProdutoMontador(), null);
		// Inserir Categoria e marca.
		composto.adicionaMontador(new PrecoProdutoMontador(), "ListaPrecoProduto_Possui");
		composto.adicionaMontador(new MarcaMontador(), "MarcaPossui");
		composto.adicionaMontador(new LojaVirtualMontador(), "LojaVirtualLidoEm");
		setMontador(composto);
		System.out.println("Antes-SQL" + sql);
		List<Produto> lista = this.getListaSqlListaInterna(sql);
		System.out.println("Depois-SQL");
		return lista;
	}
	
	
	
	@Override
	public List<Produto> OportunidadeDia(String dataInicialMySql, String percentualMinimo) throws DaoException {

		String sql1 = " select id_produto " +
				" from " + tabelaSelect() +
				this.innerJoinPrecoProduto_Possui() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + 
				" where date(preco_produto.data_visita_inicial) > '" + dataInicialMySql + "' " +
				" and date(preco_produto.data_ultima_visita) = current_date() " +
				//" and date(preco_produto.data_ultima_visita) = '2019-10-29' " +
				" and preco_produto.percentual_ajuste > " + percentualMinimo +
				" and preco_produto.preco_venda = ( " +
				" select min(preco_produto.preco_venda) from preco_produto " +
				" where id_produto_pa = produto.id_produto and preco_produto.preco_venda > 0 )";
				
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + " , " +
				MarcaDaoBase.camposOrdenados() + " , " +
				LojaVirtualDaoBase.camposOrdenados() +
				" from " + tabelaSelect() + 
				this.innerJoinPrecoProduto_Possui() +
				this.leftOuterJoinMarca_Possui() +
				this.innerJoinLojaVirtual_LidoEm() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + // PrecoProduto
				//" inner join marca on marca.id_marca = produto.id_marca_p " + // Marca
				" where id_produto in ("  + sql1 + " ) " +
				" and date(preco_produto.data_visita_inicial) >= DATE_SUB( CURRENT_DATE, INTERVAL 6 MONTH ) " +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		
		MontadorDaoComposite composto = new MontadorDaoComposite();
		composto.adicionaMontador(new ProdutoMontador(), null);
		// Inserir Categoria e marca.
		composto.adicionaMontador(new PrecoProdutoMontador(), "ListaPrecoProduto_Possui");
		composto.adicionaMontador(new MarcaMontador(), "MarcaPossui");
		composto.adicionaMontador(new LojaVirtualMontador(), "LojaVirtualLidoEm");
		setMontador(composto);
		System.out.println("Antes-SQL" + sql);
		List<Produto> lista = this.getListaSqlListaInterna(sql);
		System.out.println("Depois-SQL");
		return lista;
	}

	 
	public static String leftOuterJoinMarca_Possui() {
		return " left outer join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_marca = " + tabelaSelect() + ".id_marca_p ";  
	}

	@Override
	public List ListaNaoRelacionadaEmPalavraProdutoListaPossui(long idPalavra) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Produto> ListaSemPalavraPorNatureza(int i) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinCategoriaLojaProduto_Possui() + 
				CategoriaLojaProdutoDaoBase.innerJoinCategoriaLoja_ReferenteA() +
				" where id_natureza_produto_ra = " + i + 
				" and id_produto not in (select id_produto_ra from palavra_produto)";
		return this.getListaSql(sql);
	}

	@Override
	public Produto ObtemPrimeiroSemModeloPorNatureza(int i) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinCategoriaLojaProduto_Possui() + 
				CategoriaLojaProdutoDaoBase.innerJoinCategoriaLoja_ReferenteA() +
				" where id_natureza_produto_ra = " + i + 
				" and id_produto not in (select id_produto_ra from modelo_produto_produto) limit 1";
		return (Produto) this.getObjeto(sql);
	}

	@Override
	public List<Produto> listaMesmaPalavra(List<Long> listaId) throws DaoException {
		if (listaId.size()==0) return new ArrayList<Produto>();
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect();
		if (listaId.size()>0) {
			sql += " where (1=1) ";
			for (Long id : listaId) {
				sql += " and id_produto in (select id_produto_ra from palavra_produto where id_palavra_ra = " + id + ") ";
			}
		}
		return this.getListaSql(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmPrecoDiarioListaPossui(long idPrecoDiario) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Produto> OportunidadeDiaPrecoMinimoMesesPassado(String dataInicialMySql, String percentualMinimo, int quantidadeMeses) throws DaoException {
		String sql1 = " select id_produto " +
				" from " + tabelaSelect() +
				this.innerJoinPrecoProduto_Possui() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + 
				" where preco_produto.data_visita_inicial > '" + dataInicialMySql + "' " +
				" and preco_produto.data_ultima_visita = current_date() " +
				" and preco_produto.percentual_ajuste > " + percentualMinimo +
				" and preco_produto.preco_venda = ( " +
				" select min(preco_produto.preco_venda) from preco_produto " +
				" where id_produto_pa = produto.id_produto and preco_produto.preco_venda > 0 " +
				" and preco_produto.data_visita_inicial >= DATE_SUB( CURRENT_DATE, INTERVAL " + quantidadeMeses + " MONTH ))";
				
		String sql = "select " + camposOrdenados() + " , " +
				PrecoProdutoDaoBase.camposOrdenados() + " , " +
				MarcaDaoBase.camposOrdenados() + " , " +
				LojaVirtualDaoBase.camposOrdenados() +
				" from " + tabelaSelect() + 
				this.innerJoinPrecoProduto_Possui() +
				this.leftOuterJoinMarca_Possui() +
				this.innerJoinLojaVirtual_LidoEm() +
				//" inner join preco_produto on preco_produto.id_produto_pa = produto.id_produto "  + // PrecoProduto
				//" inner join marca on marca.id_marca = produto.id_marca_p " + // Marca
				" where id_produto in ("  + sql1 + " ) " +
				" and preco_produto.data_visita_inicial >= DATE_SUB( CURRENT_DATE, INTERVAL 6 MONTH ) " +
				" order by produto.id_produto, preco_produto.data_ultima_visita desc";
		
		MontadorDaoComposite composto = new MontadorDaoComposite();
		composto.adicionaMontador(new ProdutoMontador(), null);
		// Inserir Categoria e marca.
		composto.adicionaMontador(new PrecoProdutoMontador(), "ListaPrecoProduto_Possui");
		composto.adicionaMontador(new MarcaMontador(), "MarcaPossui");
		composto.adicionaMontador(new LojaVirtualMontador(), "LojaVirtualLidoEm");
		setMontador(composto);
		return this.getListaSqlListaInterna(sql);
	}

	@Override
	public List<Produto> ListaMelhoresPorNaturezaLimiteComImagem(long codigoNatureza, long limite, long diasPreco) throws DaoException {
		List<Produto> listaProduto = null;
		String sql = "select distinct " + camposOrdenados() + " , " 
				+ PrecoDiarioDaoExtendida.camposOrdenados() + " , " 
				+ LojaVirtualDaoExtendida.camposOrdenados() + 
				" from " + tabelaSelect() +
				this.innerJoinPrecoDiario_Possui() +
				this.innerJoinCategoriaLojaProduto_Possui() +
				CategoriaLojaProdutoDaoExtendida.innerJoinCategoriaLoja_ReferenteA() +
				this.innerJoinLojaVirtual_LidoEm() +
				" where data_hora >= curdate() and preco_diario.posicao_produto <= " + limite + " and imagem <> 'null' and imagem is not null " +
				" and preco_venda > 0  and id_natureza_produto_ra = " + codigoNatureza +
				" and (select count(*) from preco_diario pd where pd.id_produto_pa = produto.id_produto) >= " + diasPreco;
				
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new ProdutoMontador(), null);
		montador.adicionaMontador(new PrecoDiarioMontador(), "PrecoDiario_Possui");
		montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtual_LidoEm");
		this.setMontador(montador);
		listaProduto = this.getListaSqlListaInterna(sql);
		return listaProduto; 
	}

	@Override
	public List ListaNaoRelacionadaEmFacebookPostListaDivulgadoPor(long idFacebookPost) throws DaoException {
		throw new UnsupportedOperationException();
	}



	@Override
	public void alteraNome(Produto itemDetalhe) throws DaoException {
		String sql = "update " + tabelaSelect() + " set nome = '" + itemDetalhe.getNome() + "', " +
		" verificacao_nome_ok = 'S' " +
		" where id_produto = " + itemDetalhe.getIdObj();
		this.executaSql(sql);
	}



	@Override
	public void atualizaPosicao(int i, long idCategoriaLoja, long idLojaVirtual) throws DaoException {
		String sql = "update produto set posicao_produto = " + i + ",  data_alteracao = now() " +
				" where id_produto in ( " +
				" select distinct p.id_produto from  (select * from produto) as p " +
				" inner join categoria_loja_produto on categoria_loja_produto.id_produto_ra = p.id_produto " +
				" where p.id_loja_virtual_le = "  + idLojaVirtual +
				" and categoria_loja_produto.id_categoria_loja_ra = " + idCategoriaLoja +
				") ";
		this.executaSql(sql);
	}



	@Override
	public void AtualizaProdutoExistente(Produto produto) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(produto) + ",  data_alteracao = now() " +
            " where id_produto = " + produto.getIdProduto();
        this.executaSql(sql);	
	}



	@Override
	public void alteraImagem(Produto itemDetalhe) throws DaoException {
		String sql = "update " + tabelaSelect() + " set imagem = '" + itemDetalhe.getImagem() + "' " +
				" where id_produto = " + itemDetalhe.getIdObj();
		this.executaSql(sql);
		
	}

	
	
}
