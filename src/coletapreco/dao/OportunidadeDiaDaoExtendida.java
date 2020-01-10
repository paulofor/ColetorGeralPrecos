package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.util.DCConvert;
import coletapreco.dao.basica.DataSourceAplicacao;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.dao.basica.OportunidadeDiaDaoBase;
import coletapreco.dao.montador.OportunidadeDiaMontadorPlus;
import coletapreco.modelo.OportunidadeDia;


public  class OportunidadeDiaDaoExtendida  extends OportunidadeDiaDaoBase implements OportunidadeDiaDao {

	
	
	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	private String camposInsertNuvem() 
	{
		return " ( id " 
		+ " ,precoVendaAtual " 
		+ " ,precoVendaAnterior " 
		+ " ,nomeProduto " 
		+ " ,urlProduto " 
		+ " ,nomeMarca " 
		+ " ,idProduto " 
		+ " ,nomeLojaVirtual " 
		+ " ,imagemProduto " 
		+ " ,dataInsercao "
		+ " ,precoSugestao "
		+ " ,posicaoProduto"
		+ " ,dataInicioPrecoAtual"
		+ " ,dataUltimaPrecoAnterior"
		+ " ,percentualAjusteVenda"
		+ " ) ";
	}
	
	private String valoresInsertNuvem(OportunidadeDia item) {
		return " ( '" + item.getIdOportunidadeDia() + "'  " 
				+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVendaAtual()) + "'  "
				+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVendaAnterior()) + "'  "
				+ " ,'" + item.getNomeProduto() + "'  "
				+ " ,'" + item.getUrlProduto() + "'  "
				+ " ,'" + item.getNomeMarca() + "'  "
				+ " ," + item.getIdProdutoRa() + "  "
				+ " ,'" + item.getNomeLojaVirtual() + "'  "
				+ " ,'" + item.getUrlImagem() + "'  "
				+ " ,'" + DCConvert.getDataAAAA_MM_DD_HHMMSS() + "' "
				+ " ,'" +  DCConvert.ToDataBase(item.getPrecoSugestao()) + "'  "
				+ " ," + item.getPosicaoProduto() + "  "
				+ " ," + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  "
				+ " ," + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  "
				+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjusteVenda()) + "'  "
				+ " ) ";
	}

	public void insereItemNuvem(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into Cosmetic_OportunidadeDia " +
            camposInsertNuvem() + " values " + valoresInsertNuvem(item);
        this.executaSql(sql);
	}

	@Override
	public void limparTabela() throws DaoException {
		String sql = " delete from " + tabelaSelect();
		this.executaSql(sql);
	}

	@Override
	public void enviaListaNuvem(List<OportunidadeDia> listaOportunidade) throws DaoException {
		DataFonte ds = new DataSourceNuvem();
		this.setDataSource(ds);
		DaoConexao conexao = this.criaConexao();
		this.setConexao(conexao);
		limpaTabela();
		for (OportunidadeDia item : listaOportunidade) {
			item.calculaSugestaoPreco();
			if (item.aprovadaEnvio()) {
				this.insereItemNuvem(item);
			}
		}
		ds = new DataSourceAplicacao();
		this.setDataSource(ds);
		this.setConexao(null);
	} 
	
	private void limpaTabela() throws DaoException {
		String sql = "delete from Cosmetic_OportunidadeDia";
		this.executaSql(sql);
	}

	

	@Override
	public List<OportunidadeDia> ListaPorFanpage(long idFacebookFanpage) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinNaturezaProduto_PertenceA() +
				NaturezaProdutoDaoExtendida.innerJoinAppProduto_AtendidoPor() + 
				AppProdutoDaoExtendida.innerJoinFacebookFanpage_DivulgadoPor() +
				" where id_facebook_fanpage = " + idFacebookFanpage;
		return this.getListaSql(sql);
	}

	@Override
	public List<OportunidadeDia> ListaPorFanpageData(long idFacebookFanpage, String dataLimite) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinNaturezaProduto_PertenceA() +
				NaturezaProdutoDaoExtendida.innerJoinAppProduto_AtendidoPor() + 
				AppProdutoDaoExtendida.innerJoinFacebookFanpage_DivulgadoPor() +
				" where id_facebook_fanpage = " + idFacebookFanpage +
				" and id_produto_ra not in (select id_produto_d from facebook_post where data_hora >= '" + dataLimite + "')";
		return this.getListaSql(sql);
	}
	
	@Override
	public void insereItemPlus(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
        	camposInsertPlus() + 
            " values " + 
            valoresInsertPlus(item);
        this.executaSql(sql);
	}
	protected String camposInsertPlus() 
	{
		return " ( id_oportunidade_dia " 
		+ " ,url_produto " 
		+ " ,nome_produto " 
		+ " ,data_inicio_preco_atual " 
		+ " ,nome_marca " 
		+ " ,url_afiliado " 
		+ " ,data_ultima_preco_anterior " 
		+ " ,imagem_local " 
		+ " ,url_imagem " 
		+ " ,posicao_produto " 
		+ " ,preco_venda_anterior " 
		+ " ,preco_venda_atual " 
		+ " ,preco_boleto_anterior " 
		+ " ,preco_boleto_atual " 
		+ " ,preco_parcela_anterior " 
		+ " ,preco_parcela_atual " 
		+ " ,quantidade_parcela_anterior " 
		+ " ,quantidade_parcela_atual " 
		+ " ,percentual_ajuste_venda " 
		+ " ,percentual_ajuste_boleto " 
		+ " ,nome_loja_virtual " 
		+ " ,preco_minimo " 
		+ " ,preco_medio " 
		+ " ,id_produto_ra " 
		+ " ,id_natureza_produto_pa " 
		+ " ,preco_sugestao " 
		+ " ) ";
	}
	protected String valoresInsertPlus(OportunidadeDia item) {
		return " ( '" + item.getIdOportunidadeDia() + "'  " 
		+ " ,'" + item.getUrlProduto() + "'  "
		+ " ,'" + item.getNomeProduto() + "'  "
		+ " ," + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  "
		+ " ,'" + item.getNomeMarca() + "'  "
		+ " ,'" + item.getUrlAfiliado() + "'  "
		+ " ," + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  "
		+ " ,'" + item.getImagemLocal() + "'  "
		+ " ,'" + item.getUrlImagem() + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVendaAnterior()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVendaAtual()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoBoletoAnterior()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoBoletoAtual()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoParcelaAnterior()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoParcelaAtual()) + "'  "
		+ " ,'" + item.getQuantidadeParcelaAnterior() + "'  "
		+ " ,'" + item.getQuantidadeParcelaAtual() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjusteVenda()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualAjusteBoleto()) + "'  "
		+ " ,'" + item.getNomeLojaVirtual() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ," + item.getIdNaturezaProdutoPa() + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoSugestao()) + "'  "
		+ " ) ";
	}
	

	public List ListaCorrentePlus() throws DaoException {
		setMontador(new OportunidadeDiaMontadorPlus());
		String sql;
      	sql = "select " + 
		camposOrdenados() + 
		" , oportunidade_dia.preco_sugestao " +
		" from " + tabelaSelect() + orderByLista();
      	return getListaSql(sql);
	}

	
}
