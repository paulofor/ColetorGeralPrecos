package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.Marca;
import coletapreco.regracolecao.filtro.MarcaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class MarcaDaoBase extends DaoAplicacao implements MarcaDaoBaseI {
	
	
	public MarcaDaoBase() {
		super();
	}
	public MarcaDaoBase(DataFonte dataSource) {
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
		return new MarcaMontador();
	}
	public static String tabelaSelect() {
		return " marca" ;
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
		return " order by " + tabelaSelect() + ".nome_marca " ;
	}
	
	
	public static String camposOrdenados() {
		return " marca.id_marca " 
		+ " ,marca.nome_marca " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_marca " 
		+ " , " + nomeTabela + ".nome_marca " 
		;
	}
	
	
	@Override
	public void insereItem(Marca item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Marca item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Marca item) throws DaoException {
		Marca teste = this.obtemPorChave(item.getIdMarca());
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
	public void insereItemLoad(Marca item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_marca) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdMarca(id);	
	}
	@Override
	public void alteraItem(Marca item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_marca = " + item.getIdMarca();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Marca item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_marca = " + item.getIdMarca();
		executaSql(query);
	}
	@Override
	public Marca obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_marca = " + id;
        return (Marca) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(MarcaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( MarcaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(MarcaFiltro filtro)
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
	
	
	protected String valoresInsert(Marca item) {
		return " ( '" + item.getIdMarca() + "'  " 
		+ " ,'" + item.getNomeMarca() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_marca " 
		+ " ,nome_marca " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Marca item) {
		return " id_marca = '" + item.getIdMarca() + "'  " 
		+ " , nome_marca = '" + item.getNomeMarca() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(Marca item) {
		return " id_marca = '" + item.getIdMarca() + "'  " 
		+ " , nome_marca = '" + item.getNomeMarca() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Marca obtemPorProdutoReferenteA(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProduto_ReferenteA() + 
			" where id_produto = " + id;
		return (Marca) getObjeto(sql);
	}
	*/
	public static String innerJoinProduto_ReferenteA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_marca_p = " + tabelaSelect() + ".id_marca ";  
	}
	public static String outerJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_marca_p = " + tabelaSelect() + ".id_marca ";  
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
        montador.adicionaMontador(new MarcaMontador(), null);
         return montador;
    }
	
	
}
