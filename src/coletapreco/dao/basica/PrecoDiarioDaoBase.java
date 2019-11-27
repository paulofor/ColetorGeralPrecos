package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.PrecoDiario;
import coletapreco.regracolecao.filtro.PrecoDiarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PrecoDiarioDaoBase extends DaoAplicacao implements PrecoDiarioDaoBaseI {
	
	
	public PrecoDiarioDaoBase() {
		super();
	}
	public PrecoDiarioDaoBase(DataFonte dataSource) {
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
		return new PrecoDiarioMontador();
	}
	public static String tabelaSelect() {
		return " preco_diario" ;
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
		return " order by " + tabelaSelect() + ".preco_venda " ;
	}
	
	
	public static String camposOrdenados() {
		return " preco_diario.id_preco_diario " 
		+ " ,preco_diario.preco_boleto " 
		+ " , DATE_FORMAT(preco_diario.data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " ,preco_diario.quantidade_parcela " 
		+ " ,preco_diario.preco_parcela " 
		+ " ,preco_diario.preco_venda " 
		+ " ,preco_diario.preco_regular " 
		+ " ,preco_diario.posicao_produto " 
		+ " ,preco_diario.id_produto_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_preco_diario " 
		+ " , " + nomeTabela + ".preco_boleto " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".quantidade_parcela " 
		+ " , " + nomeTabela + ".preco_parcela " 
		+ " , " + nomeTabela + ".preco_venda " 
		+ " , " + nomeTabela + ".preco_regular " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".id_produto_pa " 
		;
	}
	
	
	@Override
	public void insereItem(PrecoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PrecoDiario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PrecoDiario item) throws DaoException {
		PrecoDiario teste = this.obtemPorChave(item.getIdPrecoDiario());
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
	public void insereItemLoad(PrecoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_preco_diario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPrecoDiario(id);	
	}
	@Override
	public void alteraItem(PrecoDiario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_preco_diario = " + item.getIdPrecoDiario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PrecoDiario item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_preco_diario = " + item.getIdPrecoDiario();
		executaSql(query);
	}
	@Override
	public PrecoDiario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_preco_diario = " + id;
        return (PrecoDiario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PrecoDiarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PrecoDiarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_pa = " + filtro.getCodigoProdutoPertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PrecoDiarioFiltro filtro)
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
	
	
	protected String valoresInsert(PrecoDiario item) {
		return " ( '" + item.getIdPrecoDiario() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ,'" + item.getQuantidadeParcela() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoParcela()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoRegular()) + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ," + item.getIdProdutoPa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_preco_diario " 
		+ " ,preco_boleto " 
		+ " ,data_hora " 
		+ " ,quantidade_parcela " 
		+ " ,preco_parcela " 
		+ " ,preco_venda " 
		+ " ,preco_regular " 
		+ " ,posicao_produto " 
		+ " ,id_produto_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PrecoDiario item) {
		return " id_preco_diario = '" + item.getIdPrecoDiario() + "'  " 
		+ " , preco_boleto = '" +  DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  "
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  "
		+ " , preco_parcela = '" +  DCConvert.ToDataBase(item.getPrecoParcela()) + "'  "
		+ " , preco_venda = '" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " , preco_regular = '" +  DCConvert.ToDataBase(item.getPrecoRegular()) + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , id_produto_pa = " + item.getIdProdutoPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PrecoDiario item) {
		return " id_preco_diario = '" + item.getIdPrecoDiario() + "'  " 
		+ " , preco_boleto = '" +  DCConvert.ToDataBase(item.getPrecoBoleto()) + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  " 
		+ " , quantidade_parcela = '" + item.getQuantidadeParcela() + "'  " 
		+ " , preco_parcela = '" +  DCConvert.ToDataBase(item.getPrecoParcela()) + "'  " 
		+ " , preco_venda = '" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  " 
		+ " , preco_regular = '" +  DCConvert.ToDataBase(item.getPrecoRegular()) + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , id_produto_pa = " + item.getIdProdutoPa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoPertenceA(long id) throws DaoException {
		return getPorPertenceAProduto(id);
	}
	public boolean excluiPorPertenceAProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProduto_PertenceA() {
	//	return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_preco_diario_p = " + tabelaSelect() + ".id_preco_diario ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProduto_PertenceA = false;
	public void setObtemProduto_PertenceA() {
		_obtemProduto_PertenceA = true;
	}
	protected String outterJoinProduto_PertenceA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_pa ";  
	}
	public boolean atualizaPertenceAProduto(long idPrecoDiario, long idProdutoPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_pa  = " + idProdutoPa +
        " where id_preco_diario = " +  idPrecoDiario;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_PertenceA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_pa ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProduto_PertenceA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProduto_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProduto_PertenceA? outterJoinProduto_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PrecoDiarioMontador(), null);
		if (this._obtemProduto_PertenceA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_PertenceA");
         return montador;
    }
	
	
}
