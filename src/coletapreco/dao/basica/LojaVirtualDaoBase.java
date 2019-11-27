package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.LojaVirtual;
import coletapreco.regracolecao.filtro.LojaVirtualFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class LojaVirtualDaoBase extends DaoAplicacao implements LojaVirtualDaoBaseI {
	
	
	public LojaVirtualDaoBase() {
		super();
	}
	public LojaVirtualDaoBase(DataFonte dataSource) {
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
		return new LojaVirtualMontador();
	}
	public static String tabelaSelect() {
		return " loja_virtual" ;
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
		return " order by " + tabelaSelect() + ".nome_loja_virtual " ;
	}
	
	
	public static String camposOrdenados() {
		return " loja_virtual.id_loja_virtual " 
		+ " ,loja_virtual.nome_loja_virtual " 
		+ " ,loja_virtual.url_inicial_brinquedo " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_loja_virtual " 
		+ " , " + nomeTabela + ".nome_loja_virtual " 
		+ " , " + nomeTabela + ".url_inicial_brinquedo " 
		;
	}
	
	
	@Override
	public void insereItem(LojaVirtual item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(LojaVirtual item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(LojaVirtual item) throws DaoException {
		LojaVirtual teste = this.obtemPorChave(item.getIdLojaVirtual());
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
	public void insereItemLoad(LojaVirtual item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_loja_virtual) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdLojaVirtual(id);	
	}
	@Override
	public void alteraItem(LojaVirtual item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_loja_virtual = " + item.getIdLojaVirtual();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(LojaVirtual item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_loja_virtual = " + item.getIdLojaVirtual();
		executaSql(query);
	}
	@Override
	public LojaVirtual obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_loja_virtual = " + id;
        return (LojaVirtual) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(LojaVirtualFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( LojaVirtualFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(LojaVirtualFiltro filtro)
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
	
	
	protected String valoresInsert(LojaVirtual item) {
		return " ( '" + item.getIdLojaVirtual() + "'  " 
		+ " ,'" + item.getNomeLojaVirtual() + "'  "
		+ " ,'" + item.getUrlInicialBrinquedo() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_loja_virtual " 
		+ " ,nome_loja_virtual " 
		+ " ,url_inicial_brinquedo " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(LojaVirtual item) {
		return " id_loja_virtual = '" + item.getIdLojaVirtual() + "'  " 
		+ " , nome_loja_virtual = '" + item.getNomeLojaVirtual() + "'  "
		+ " , url_inicial_brinquedo = '" + item.getUrlInicialBrinquedo() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(LojaVirtual item) {
		return " id_loja_virtual = '" + item.getIdLojaVirtual() + "'  " 
		+ " , nome_loja_virtual = '" + item.getNomeLojaVirtual() + "'  " 
		+ " , url_inicial_brinquedo = '" + item.getUrlInicialBrinquedo() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public LojaVirtual obtemPorProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProduto_Possui() + 
			" where id_produto = " + id;
		return (LojaVirtual) getObjeto(sql);
	}
	*/
	public static String innerJoinProduto_Possui() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_loja_virtual_le = " + tabelaSelect() + ".id_loja_virtual ";  
	}
	public static String outerJoinProduto_Possui() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_loja_virtual_le = " + tabelaSelect() + ".id_loja_virtual ";  
	}
 	
	/*
	public LojaVirtual obtemPorCategoriaLojaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaLoja_Possui() + 
			" where id_categoria_loja = " + id;
		return (LojaVirtual) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaLoja_Possui() {
		return " inner join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_loja_virtual_pa = " + tabelaSelect() + ".id_loja_virtual ";  
	}
	public static String outerJoinCategoriaLoja_Possui() {
		return " left outer join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_loja_virtual_pa = " + tabelaSelect() + ".id_loja_virtual ";  
	}
 	
	/*
	public LojaVirtual obtemPorLojaNaturezaOferece(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinLojaNatureza_Oferece() + 
			" where id_loja_natureza = " + id;
		return (LojaVirtual) getObjeto(sql);
	}
	*/
	public static String innerJoinLojaNatureza_Oferece() {
		return " inner join " + LojaNaturezaDaoBase.tabelaSelect() + " on " + LojaNaturezaDaoBase.tabelaSelect() + ".id_loja_virtual_ra = " + tabelaSelect() + ".id_loja_virtual ";  
	}
	public static String outerJoinLojaNatureza_Oferece() {
		return " left outer join " + LojaNaturezaDaoBase.tabelaSelect() + " on " + LojaNaturezaDaoBase.tabelaSelect() + ".id_loja_virtual_ra = " + tabelaSelect() + ".id_loja_virtual ";  
	}
 	
	/*
	public LojaVirtual obtemPorContagemProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinContagemProduto_Possui() + 
			" where id_contagem_produto = " + id;
		return (LojaVirtual) getObjeto(sql);
	}
	*/
	public static String innerJoinContagemProduto_Possui() {
		return " inner join " + ContagemProdutoDaoBase.tabelaSelect() + " on " + ContagemProdutoDaoBase.tabelaSelect() + ".id_loja_virtual_ra = " + tabelaSelect() + ".id_loja_virtual ";  
	}
	public static String outerJoinContagemProduto_Possui() {
		return " left outer join " + ContagemProdutoDaoBase.tabelaSelect() + " on " + ContagemProdutoDaoBase.tabelaSelect() + ".id_loja_virtual_ra = " + tabelaSelect() + ".id_loja_virtual ";  
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
        montador.adicionaMontador(new LojaVirtualMontador(), null);
         return montador;
    }
	
	
}
