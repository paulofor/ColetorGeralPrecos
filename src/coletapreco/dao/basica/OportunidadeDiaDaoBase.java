package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.filtro.OportunidadeDiaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OportunidadeDiaDaoBase extends DaoAplicacao implements OportunidadeDiaDaoBaseI {
	
	
	public OportunidadeDiaDaoBase() {
		super();
	}
	public OportunidadeDiaDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	protected String ConsultaJoin() {
		String tabelas;
		tabelas = tabelaSelect();
		return tabelas;
	}
	protected String CamposSelectJoin() {
		String select;
		select = camposOrdenados();
		return select;
	}
	protected  MontadorDaoI criaMontadorPadrao() {
		return new OportunidadeDiaMontador();
	}
	public static String tabelaSelect() {
		return " oportunidade_dia" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public String getLimite() {
		return "";
	}
	public  String whereLista() {
		return "";
	}
	public  String whereListaConcatenado() {
		return "";
	}
	public   static String orderBy() {
		return " order by " + tabelaSelect() + ".nome_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " oportunidade_dia.id_oportunidade_dia " 
		+ " ,oportunidade_dia.url_produto " 
		+ " ,oportunidade_dia.nome_produto " 
		+ " , DATE_FORMAT(oportunidade_dia.data_inicio_preco_atual,'%d-%m-%Y') " 
		+ " ,oportunidade_dia.nome_marca " 
		+ " ,oportunidade_dia.url_afiliado " 
		+ " , DATE_FORMAT(oportunidade_dia.data_ultima_preco_anterior,'%d-%m-%Y') " 
		+ " ,oportunidade_dia.imagem_local " 
		+ " ,oportunidade_dia.url_imagem " 
		+ " ,oportunidade_dia.posicao_produto " 
		+ " ,oportunidade_dia.preco_venda_anterior " 
		+ " ,oportunidade_dia.preco_venda_atual " 
		+ " ,oportunidade_dia.preco_boleto_anterior " 
		+ " ,oportunidade_dia.preco_boleto_atual " 
		+ " ,oportunidade_dia.preco_parcela_anterior " 
		+ " ,oportunidade_dia.preco_parcela_atual " 
		+ " ,oportunidade_dia.quantidade_parcela_anterior " 
		+ " ,oportunidade_dia.quantidade_parcela_atual " 
		+ " ,oportunidade_dia.percentual_ajuste_venda " 
		+ " ,oportunidade_dia.percentual_ajuste_boleto " 
		+ " ,oportunidade_dia.nome_loja_virtual " 
		+ " ,oportunidade_dia.preco_minimo " 
		+ " ,oportunidade_dia.preco_medio " 
		+ " ,oportunidade_dia.id_produto_ra " 
		+ " ,oportunidade_dia.id_natureza_produto_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_oportunidade_dia " 
		+ " , " + nomeTabela + ".url_produto " 
		+ " , " + nomeTabela + ".nome_produto " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_preco_atual,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".nome_marca " 
		+ " , " + nomeTabela + ".url_afiliado " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_preco_anterior,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".imagem_local " 
		+ " , " + nomeTabela + ".url_imagem " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".preco_venda_anterior " 
		+ " , " + nomeTabela + ".preco_venda_atual " 
		+ " , " + nomeTabela + ".preco_boleto_anterior " 
		+ " , " + nomeTabela + ".preco_boleto_atual " 
		+ " , " + nomeTabela + ".preco_parcela_anterior " 
		+ " , " + nomeTabela + ".preco_parcela_atual " 
		+ " , " + nomeTabela + ".quantidade_parcela_anterior " 
		+ " , " + nomeTabela + ".quantidade_parcela_atual " 
		+ " , " + nomeTabela + ".percentual_ajuste_venda " 
		+ " , " + nomeTabela + ".percentual_ajuste_boleto " 
		+ " , " + nomeTabela + ".nome_loja_virtual " 
		+ " , " + nomeTabela + ".preco_minimo " 
		+ " , " + nomeTabela + ".preco_medio " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		+ " , " + nomeTabela + ".id_natureza_produto_pa " 
		;
	}
	
	
	@Override
	public void insereItem(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OportunidadeDia item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OportunidadeDia item) throws DaoException {
		OportunidadeDia teste = this.obtemPorChave(item.getIdOportunidadeDia());
      	if (teste == null)
      	{
        	insereItemCompleto(item);
          	return true;
      	}
      	else
      	{
          	return false;
      	}
	}
	@Override
	public void insereItemLoad(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_oportunidade_dia) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOportunidadeDia(id);	
	}
	@Override
	public void alteraItem(OportunidadeDia item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_oportunidade_dia = " + item.getIdOportunidadeDia();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OportunidadeDia item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_oportunidade_dia = " + item.getIdOportunidadeDia();
		executaSql(query);
	}
	@Override
	public OportunidadeDia obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_oportunidade_dia = " + id;
        return (OportunidadeDia) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OportunidadeDiaFiltro filtro) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      	String where;
      	where = WhereFiltro(filtro) + whereListaConcatenado();
      	if (where.length() > 0)
        	sql += " where " + where;
      	sql += orderByLista();
      	return getListaSql(sql);
	}
	
	protected  String WhereFiltro( OportunidadeDiaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_ra = " + filtro.getCodigoProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoNaturezaProdutoPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_pa = " + filtro.getCodigoNaturezaProdutoPertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(OportunidadeDiaFiltro filtro)
			throws DaoException {
		setMontador(null);
		String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      	String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
		if (where.length() > 0)
			sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	
	@Override
	public List ListaCorrente() throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenados() + " from " + tabelaSelect() + orderByLista();
      	return getListaSql(sql);
	}
	
	
	protected String valoresInsert(OportunidadeDia item) {
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
		+ " ) ";
	}
	protected String camposInsert() 
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
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OportunidadeDia item) {
		return " id_oportunidade_dia = '" + item.getIdOportunidadeDia() + "'  " 
		+ " , url_produto = '" + item.getUrlProduto() + "'  "
		+ " , nome_produto = '" + item.getNomeProduto() + "'  "
		+ " , data_inicio_preco_atual = " + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  "
		+ " , nome_marca = '" + item.getNomeMarca() + "'  "
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  "
		+ " , data_ultima_preco_anterior = " + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  "
		+ " , imagem_local = '" + item.getImagemLocal() + "'  "
		+ " , url_imagem = '" + item.getUrlImagem() + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , preco_venda_anterior = '" +  DCConvert.ToDataBase(item.getPrecoVendaAnterior()) + "'  "
		+ " , preco_venda_atual = '" +  DCConvert.ToDataBase(item.getPrecoVendaAtual()) + "'  "
		+ " , preco_boleto_anterior = '" +  DCConvert.ToDataBase(item.getPrecoBoletoAnterior()) + "'  "
		+ " , preco_boleto_atual = '" +  DCConvert.ToDataBase(item.getPrecoBoletoAtual()) + "'  "
		+ " , preco_parcela_anterior = '" +  DCConvert.ToDataBase(item.getPrecoParcelaAnterior()) + "'  "
		+ " , preco_parcela_atual = '" +  DCConvert.ToDataBase(item.getPrecoParcelaAtual()) + "'  "
		+ " , quantidade_parcela_anterior = '" + item.getQuantidadeParcelaAnterior() + "'  "
		+ " , quantidade_parcela_atual = '" + item.getQuantidadeParcelaAtual() + "'  "
		+ " , percentual_ajuste_venda = '" +  DCConvert.ToDataBase(item.getPercentualAjusteVenda()) + "'  "
		+ " , percentual_ajuste_boleto = '" +  DCConvert.ToDataBase(item.getPercentualAjusteBoleto()) + "'  "
		+ " , nome_loja_virtual = '" + item.getNomeLojaVirtual() + "'  "
		+ " , preco_minimo = '" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  "
		+ " , preco_medio = '" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		+ " , id_natureza_produto_pa = " + item.getIdNaturezaProdutoPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OportunidadeDia item) {
		return " id_oportunidade_dia = '" + item.getIdOportunidadeDia() + "'  " 
		+ " , url_produto = '" + item.getUrlProduto() + "'  " 
		+ " , nome_produto = '" + item.getNomeProduto() + "'  " 
		+ " , data_inicio_preco_atual = " + (item.getDataInicioPrecoAtual()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPrecoAtual()) ) + "  " 
		+ " , nome_marca = '" + item.getNomeMarca() + "'  " 
		+ " , url_afiliado = '" + item.getUrlAfiliado() + "'  " 
		+ " , data_ultima_preco_anterior = " + (item.getDataUltimaPrecoAnterior()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaPrecoAnterior()) ) + "  " 
		+ " , imagem_local = '" + item.getImagemLocal() + "'  " 
		+ " , url_imagem = '" + item.getUrlImagem() + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , preco_venda_anterior = '" +  DCConvert.ToDataBase(item.getPrecoVendaAnterior()) + "'  " 
		+ " , preco_venda_atual = '" +  DCConvert.ToDataBase(item.getPrecoVendaAtual()) + "'  " 
		+ " , preco_boleto_anterior = '" +  DCConvert.ToDataBase(item.getPrecoBoletoAnterior()) + "'  " 
		+ " , preco_boleto_atual = '" +  DCConvert.ToDataBase(item.getPrecoBoletoAtual()) + "'  " 
		+ " , preco_parcela_anterior = '" +  DCConvert.ToDataBase(item.getPrecoParcelaAnterior()) + "'  " 
		+ " , preco_parcela_atual = '" +  DCConvert.ToDataBase(item.getPrecoParcelaAtual()) + "'  " 
		+ " , quantidade_parcela_anterior = '" + item.getQuantidadeParcelaAnterior() + "'  " 
		+ " , quantidade_parcela_atual = '" + item.getQuantidadeParcelaAtual() + "'  " 
		+ " , percentual_ajuste_venda = '" +  DCConvert.ToDataBase(item.getPercentualAjusteVenda()) + "'  " 
		+ " , percentual_ajuste_boleto = '" +  DCConvert.ToDataBase(item.getPercentualAjusteBoleto()) + "'  " 
		+ " , nome_loja_virtual = '" + item.getNomeLojaVirtual() + "'  " 
		+ " , preco_minimo = '" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  " 
		+ " , preco_medio = '" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		+ " , id_natureza_produto_pa = " + item.getIdNaturezaProdutoPa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoReferenteA(long id) throws DaoException {
		return getPorReferenteAProduto(id);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProduto_ReferenteA() {
	//	return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_oportunidade_dia_pp = " + tabelaSelect() + ".id_oportunidade_dia ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceANaturezaProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_natureza_produto_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorNaturezaProdutoPertenceA(long id) throws DaoException {
		return getPorPertenceANaturezaProduto(id);
	}
	public boolean excluiPorPertenceANaturezaProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_natureza_produto_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinNaturezaProduto_PertenceA() {
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_oportunidade_dia_p = " + tabelaSelect() + ".id_oportunidade_dia ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idOportunidadeDia, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_oportunidade_dia = " +  idOportunidadeDia;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_ReferenteA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	
 	
	private boolean _obtemNaturezaProduto_PertenceA = false;
	public void setObtemNaturezaProduto_PertenceA() {
		_obtemNaturezaProduto_PertenceA = true;
	}
	protected String outterJoinNaturezaProduto_PertenceA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_pa ";  
	}
	public boolean atualizaPertenceANaturezaProduto(long idOportunidadeDia, long idNaturezaProdutoPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_pa  = " + idNaturezaProdutoPa +
        " where id_oportunidade_dia = " +  idOportunidadeDia;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_PertenceA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_pa ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemNaturezaProduto_PertenceA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProduto_ReferenteA = false;
		_obtemNaturezaProduto_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
		saida += (this._obtemNaturezaProduto_PertenceA? outterJoinNaturezaProduto_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new OportunidadeDiaMontador(), null);
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
		if (this._obtemNaturezaProduto_PertenceA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_PertenceA");
         return montador;
    }
	
	
}
