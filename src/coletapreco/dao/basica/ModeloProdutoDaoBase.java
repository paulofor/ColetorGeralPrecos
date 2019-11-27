package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.ModeloProduto;
import coletapreco.regracolecao.filtro.ModeloProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ModeloProdutoDaoBase extends DaoAplicacao implements ModeloProdutoDaoBaseI {
	
	
	public ModeloProdutoDaoBase() {
		super();
	}
	public ModeloProdutoDaoBase(DataFonte dataSource) {
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
		return new ModeloProdutoMontador();
	}
	public static String tabelaSelect() {
		return " modelo_produto" ;
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
		return " order by " + tabelaSelect() + ".nome_modelo_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " modelo_produto.id_modelo_produto " 
		+ " ,modelo_produto.nome_modelo_produto " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_modelo_produto " 
		+ " , " + nomeTabela + ".nome_modelo_produto " 
		;
	}
	
	
	@Override
	public void insereItem(ModeloProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ModeloProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ModeloProduto item) throws DaoException {
		ModeloProduto teste = this.obtemPorChave(item.getIdModeloProduto());
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
	public void insereItemLoad(ModeloProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_modelo_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdModeloProduto(id);	
	}
	@Override
	public void alteraItem(ModeloProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_modelo_produto = " + item.getIdModeloProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ModeloProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_modelo_produto = " + item.getIdModeloProduto();
		executaSql(query);
	}
	@Override
	public ModeloProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_modelo_produto = " + id;
        return (ModeloProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ModeloProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ModeloProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ModeloProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(ModeloProduto item) {
		return " ( '" + item.getIdModeloProduto() + "'  " 
		+ " ,'" + item.getNomeModeloProduto() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_modelo_produto " 
		+ " ,nome_modelo_produto " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ModeloProduto item) {
		return " id_modelo_produto = '" + item.getIdModeloProduto() + "'  " 
		+ " , nome_modelo_produto = '" + item.getNomeModeloProduto() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(ModeloProduto item) {
		return " id_modelo_produto = '" + item.getIdModeloProduto() + "'  " 
		+ " , nome_modelo_produto = '" + item.getNomeModeloProduto() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public ModeloProduto obtemPorModeloProdutoProdutoReferenteA(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinModeloProdutoProduto_ReferenteA() + 
			" where id_modelo_produto_produto = " + id;
		return (ModeloProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinModeloProdutoProduto_ReferenteA() {
		return " inner join " + ModeloProdutoProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoProdutoDaoBase.tabelaSelect() + ".id_modelo_produto_ra = " + tabelaSelect() + ".id_modelo_produto ";  
	}
	public static String outerJoinModeloProdutoProduto_ReferenteA() {
		return " left outer join " + ModeloProdutoProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoProdutoDaoBase.tabelaSelect() + ".id_modelo_produto_ra = " + tabelaSelect() + ".id_modelo_produto ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
        return saida;
    }
    
    public void limpaObtem()
    {
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ModeloProdutoMontador(), null);
         return montador;
    }
	
	
}
