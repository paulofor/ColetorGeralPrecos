package coletapreco.dao;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import coletapreco.dao.basica.PrecoProdutoDaoBase;
import coletapreco.dao.basica.ProdutoDaoBase;
import coletapreco.dao.montador.PrecoProdutoParaOportunidadeMontador;
import coletapreco.dao.montador.PrecoProdutoPosicaoMontador;
import coletapreco.dao.montador.ProdutoMontador;
import coletapreco.modelo.PrecoProduto;

public class PrecoProdutoDaoExtendida extends PrecoProdutoDaoBase implements PrecoProdutoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	private String camposOrdenadosComPosicao() {
		return " preco_produto.id_preco_produto " + " ,preco_produto.preco_boleto "
				+ " , DATE_FORMAT(preco_produto.data_visita_inicial,'%d-%m-%Y %H:%i:%s') "
				+ " ,preco_produto.quantidade_parcela " + " ,preco_produto.preco_parcela "
				+ " ,preco_produto.preco_venda " + " ,preco_produto.preco_regular "
				+ " , DATE_FORMAT(preco_produto.data_ultima_visita,'%d-%m-%Y %H:%i:%s') "
				+ " ,preco_produto.percentual_ajuste " + " ,preco_produto.media_2meses "
				+ " ,preco_produto.minimo_3meses " + " ,preco_produto.id_produto_pa " + " ,preco_produto.posicao "
				+ " ,preco_produto.posicao1 " + " ,preco_produto.posicao2 " + " ,preco_produto.posicao3 "
				+ " ,preco_produto.posicao4 " + " ,preco_produto.posicao5 " + " ,preco_produto.posicao6 "
				+ " ,preco_produto.posicao7 " + " ,preco_produto.diferenca_posicao7 ";

	}

	@Override
	public PrecoProduto MaisRecentePorProduto(long idProduto) throws DaoException {
		String sql = "select " + camposOrdenadosComPosicao() + " from " + tabelaSelect() + " where data_ultima_visita = ("
				+ " select max(data_ultima_visita) " + " from preco_produto " + " where id_produto_pa = " + idProduto
				+ " ) and id_produto_pa = " + idProduto;
		this.setMontador(new PrecoProdutoPosicaoMontador());
		return (PrecoProduto) this.getObjeto(sql);
	}

	@Override
	public float ObtemMedia2Meses(long idProduto) throws DaoException {
		String sql = "select (avg(preco_venda)) from preco_diario " + " where id_produto_pa = " + idProduto
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH )";
		String valor = this.getValorString(sql);
		return Float.parseFloat(valor);
	}

	@Override
	public float ObtemMinimo3Meses(long idProduto) throws DaoException {
		String sql = "select (min(preco_venda)) from preco_diario " + " where id_produto_pa = " + idProduto
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )";
		String valor = this.getValorString(sql);
		return Float.parseFloat(valor);
	}

	@Override
	public int ObtemQuantidade2Meses(long idProduto) throws DaoException {
		String sql = "select count(*) from preco_diario " + " where id_produto_pa = " + idProduto
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH )";
		String valor = this.getValorString(sql);
		return Integer.parseInt(valor);
	}

	@Override
	public void atualizaMediaProduto(long idProduto) throws DaoException {
		String sql = "update preco_produto set media_2meses = ( "
				+ " select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) "
				+ " where preco_produto.id_produto_pa in (" + idProduto
				+ ") and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}

	@Override
	public void atualizaMinimoProduto(long idProduto) throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( "
				+ " select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH ) and preco_venda > 0) "
				+ " where preco_produto.id_produto_pa in (" + idProduto
				+ ") and preco_produto.data_ultima_visita = current_date()";

		this.executaSql(sql);
	}

	@Override
	public void atualizaMediaProduto() throws DaoException {
		String sql = "update preco_produto set media_2meses = ( "
				+ " select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) "
				+ " where preco_produto.percentual_ajuste > 0 and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}

	@Override
	public void atualizaMinimoProduto() throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( "
				+ " select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )  and preco_venda > 0) "
				+ " where preco_produto.percentual_ajuste  > 0 and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);
	}

	@Override
	public void atualizaMediaProduto(String lista) throws DaoException {
		String sql = "update preco_produto set media_2meses = ( "
				+ " select (avg(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 2 MONTH ) and preco_venda > 0) "
				+ " where preco_produto.id_produto_pa in " + lista
				+ " and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);

	}

	@Override
	public void atualizaMinimoProduto(String lista) throws DaoException {
		String sql = "update preco_produto set minimo_3meses = ( "
				+ " select (min(preco_venda)) from preco_diario where preco_diario.id_produto_pa = preco_produto.id_produto_pa "
				+ " and data_hora >= DATE_SUB( CURRENT_DATE, INTERVAL 3 MONTH )  and preco_venda > 0) "
				+ " where preco_produto.id_produto_pa in " + lista
				+ " and preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);

	}

	@Override
	public void insereItemComIds(PrecoProduto item) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
		sql = "insert into " + tabelaSelect() + camposInsertComIds() + " values " + valoresInsertComIds(item);
		this.executaSql(sql);
	}

	protected String camposInsertComIds() {
		return " ( id_preco_produto " + " ,preco_boleto " + " ,data_visita_inicial " + " ,quantidade_parcela "
				+ " ,preco_parcela " + " ,preco_venda " + " ,preco_regular " + " ,data_ultima_visita "
				+ " ,percentual_ajuste " + " ,media_2meses " + " ,minimo_3meses " + " ,id_produto_pa "
				+ " ,id_loja_virtual " + " ,id_natureza_produto " + " ,id_categoria_loja " + " ,posicao " + " ) ";
	}

	protected String valoresInsertComIds(PrecoProduto item) {
		return " ( '" + item.getIdPrecoProduto() + "'  " + " ,'" + DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
				+ " ,"
				+ (item.getDataVisitaInicial() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()))
				+ "  " + " ,'" + item.getQuantidadeParcela() + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoParcela()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoVenda()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoRegular()) + "'  " + " ,"
				+ (item.getDataUltimaVisita() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()))
				+ "  " + " ,'" + DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getMedia2meses()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getMinimo3meses()) + "'  " + " ," + item.getIdProdutoPa() + "  " + " ,"
				+ item.getIdLojaVirtual() + "  " + " ," + item.getIdNaturezaProduto() + "  " + " ,"
				+ item.getIdCategoraLoja() + "  " + " ," + item.getPosicao() + "  " + " ) ";
	}

	@Override
	public void atualizaDiferencaPosicao7Dias() throws DaoException {

		String sql2 = "update preco_produto " + "set diferenca_posicao7 = (posicao7 - posicao) "
				+ "where preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql2);

		String sql = "update preco_produto " + "set posicao7 = posicao6, " + "posicao6 = posicao5, "
				+ "posicao5 = posicao4, " + "posicao4 = posicao3, " + "posicao3 = posicao2, " + "posicao2 = posicao1, "
				+ "posicao1 = posicao  " + "where preco_produto.data_ultima_visita = current_date()";
		this.executaSql(sql);

	}

	@Override
	public void insereItem(PrecoProduto item) throws DaoException {
		String sql;
		sql = "insert into " + tabelaSelect() + camposInsertPlus() + " values " + valoresInsertPlus(item);
		this.executaSql(sql);
	}

	private String camposInsertPlus() {
		return " ( id_preco_produto " + " ,preco_boleto " + " ,data_visita_inicial " + " ,quantidade_parcela "
				+ " ,preco_parcela " + " ,preco_venda " + " ,preco_regular " + " ,data_ultima_visita "
				+ " ,percentual_ajuste " + " ,media_2meses " + " ,minimo_3meses " + " ,id_produto_pa " + " ,posicao "
				+ " ,posicao1, posicao2, posicao3, posicao4, posicao5, posicao6, posicao7, preco_sugestao "
				+ " ) ";
	}

	private String valoresInsertPlus(PrecoProduto item) {
		return " ( '" + item.getIdPrecoProduto() + "'  " + " ,'" + DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
				+ " ,"
				+ (item.getDataVisitaInicial() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()))
				+ "  " + " ,'" + item.getQuantidadeParcela() + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoParcela()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoVenda()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getPrecoRegular()) + "'  " + " ,"
				+ (item.getDataUltimaVisita() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()))
				+ "  " + " ,'" + DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getMedia2meses()) + "'  " + " ,'"
				+ DCConvert.ToDataBase(item.getMinimo3meses()) + "'  " + " ," + item.getIdProdutoPa() + "  " + " ,"
				+ item.getPosicao() + " , 0, 0, 0, 0, 0, 0, 0 , " + DCConvert.ToDataBase(item.getPrecoSugestao()) + " ) ";
	}

	@Override
	public void alteraItem(PrecoProduto item) throws DaoException {
		String sql;
		sql = "update " + tabelaSelect() + " set " + camposValoresUpdateEdicaoPlus(item) + " where id_preco_produto = "
				+ item.getIdPrecoProduto();
		this.executaSql(sql);
	}

	protected String camposValoresUpdateEdicaoPlus(PrecoProduto item) {
		return " id_preco_produto = '" + item.getIdPrecoProduto() + "'  " + " , preco_boleto = '"
				+ DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  " + " , data_visita_inicial = "
				+ (item.getDataVisitaInicial() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataVisitaInicial()))
				+ "  " + " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  " + " , preco_parcela = '"
				+ DCConvert.ToDataBase(item.getPrecoParcela()) + "'  " + " , preco_venda = '"
				+ DCConvert.ToDataBase(item.getPrecoVenda()) + "'  " + " , preco_regular = '"
				+ DCConvert.ToDataBase(item.getPrecoRegular()) + "'  " + " , data_ultima_visita = "
				+ (item.getDataUltimaVisita() == null ? "null"
						: DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVisita()))
				+ "  " + " , percentual_ajuste = '" + DCConvert.ToDataBase(item.getPercentualAjuste()) + "'  "
				+ " , media_2meses = '" + DCConvert.ToDataBase(item.getMedia2meses()) + "'  " + " , minimo_3meses = '"
				+ DCConvert.ToDataBase(item.getMinimo3meses()) + "'  " + " , id_produto_pa = " + item.getIdProdutoPa()
				+ "  " + " , posicao = " + item.getPosicao() + "  "
				+ "  " + " , posicao1 = " + item.getPosicao1() + "  "
				+ "  " + " , posicao2 = " + item.getPosicao2() + "  "
				+ "  " + " , posicao3 = " + item.getPosicao3() + "  "
				+ "  " + " , posicao4 = " + item.getPosicao4() + "  "
				+ "  " + " , posicao5 = " + item.getPosicao5() + "  "
				+ "  " + " , posicao6 = " + item.getPosicao6() + "  "
				+ "  " + " , posicao7 = " + item.getPosicao7() + "  "
		        + "  " + " , diferenca_posicao7 = " + item.getDiferencaPosicao7() + "  "
		        + "  " + " , preco_sugestao = " + DCConvert.ToDataBase(item.getPrecoSugestao())  + "  "
		        ;
				
				
	}

	
	protected String camposOrdenadosJoinPlus()
    {
        String saida = camposOrdenados();
        saida += " , preco_produto.preco_sugestao ";
        saida += (this._obtemProduto_PertenceA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
	@Override
	public List<PrecoProduto> obtemMelhorPosicaoDia(int idLoja, int qtdePosicao) throws DaoException {
		super.setObtemProduto_PertenceA();
		String sql = "select " + camposOrdenadosJoinPlus() + 
				" from " + tabelaSelect() +
				this.innerJoinProduto_PertenceA() +
				" where id_loja_virtual = " + idLoja + " and " +
				" date(data_ultima_visita) = current_date()  " +
				//" date(data_ultima_visita) = '2019-09-03'  " +
				" and posicao <> 0 " +
				" order by diferenca_posicao7 desc " +
				" limit " + qtdePosicao;
		this.setMontador(getMontadorAgrupadoOportunidade());
		return super.getListaSql(sql);
	}
	private MontadorDaoI getMontadorAgrupadoOportunidade()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PrecoProdutoParaOportunidadeMontador(), null);
		if (this._obtemProduto_PertenceA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_PertenceA");
         return montador;
    }

}
