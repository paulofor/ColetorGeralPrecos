package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.Palavra;
import coletapreco.regracolecao.filtro.PalavraFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PalavraDaoBase extends DaoAplicacao implements PalavraDaoBaseI {
	
	
	public PalavraDaoBase() {
		super();
	}
	public PalavraDaoBase(DataFonte dataSource) {
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
		return new PalavraMontador();
	}
	public static String tabelaSelect() {
		return " palavra" ;
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
		return " order by " + tabelaSelect() + ".descricao " ;
	}
	
	
	public static String camposOrdenados() {
		return " palavra.id_palavra " 
		+ " ,palavra.descricao " 
		+ " ,palavra.comum " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_palavra " 
		+ " , " + nomeTabela + ".descricao " 
		+ " , " + nomeTabela + ".comum " 
		;
	}
	
	
	@Override
	public void insereItem(Palavra item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Palavra item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Palavra item) throws DaoException {
		Palavra teste = this.obtemPorChave(item.getIdPalavra());
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
	public void insereItemLoad(Palavra item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_palavra) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPalavra(id);	
	}
	@Override
	public void alteraItem(Palavra item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_palavra = " + item.getIdPalavra();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Palavra item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_palavra = " + item.getIdPalavra();
		executaSql(query);
	}
	@Override
	public Palavra obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_palavra = " + id;
        return (Palavra) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PalavraFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PalavraFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PalavraFiltro filtro)
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
	
	
	protected String valoresInsert(Palavra item) {
		return " ( '" + item.getIdPalavra() + "'  " 
		+ " ,'" + item.getDescricao() + "'  "
		+ " ,'" + (item.getComum()?"S":"N") + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_palavra " 
		+ " ,descricao " 
		+ " ,comum " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Palavra item) {
		return " id_palavra = '" + item.getIdPalavra() + "'  " 
		+ " , descricao = '" + item.getDescricao() + "'  "
		+ " , comum = '" + (item.getComum()?"S":"N") + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(Palavra item) {
		return " id_palavra = '" + item.getIdPalavra() + "'  " 
		+ " , descricao = '" + item.getDescricao() + "'  " 
		+ " , comum = '" + (item.getComum()?"S":"N") + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Palavra obtemPorPalavraProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPalavraProduto_Possui() + 
			" where id_palavra_produto = " + id;
		return (Palavra) getObjeto(sql);
	}
	*/
	public static String innerJoinPalavraProduto_Possui() {
		return " inner join " + PalavraProdutoDaoBase.tabelaSelect() + " on " + PalavraProdutoDaoBase.tabelaSelect() + ".id_palavra_ra = " + tabelaSelect() + ".id_palavra ";  
	}
	public static String outerJoinPalavraProduto_Possui() {
		return " left outer join " + PalavraProdutoDaoBase.tabelaSelect() + " on " + PalavraProdutoDaoBase.tabelaSelect() + ".id_palavra_ra = " + tabelaSelect() + ".id_palavra ";  
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
        montador.adicionaMontador(new PalavraMontador(), null);
         return montador;
    }
	
	
}
