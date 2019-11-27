package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.FacebookPostPerformance;
import coletapreco.regracolecao.filtro.FacebookPostPerformanceFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookPostPerformanceDaoBase extends DaoAplicacao implements FacebookPostPerformanceDaoBaseI {
	
	
	public FacebookPostPerformanceDaoBase() {
		super();
	}
	public FacebookPostPerformanceDaoBase(DataFonte dataSource) {
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
		return new FacebookPostPerformanceMontador();
	}
	public static String tabelaSelect() {
		return " facebook_post_performance" ;
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
		return " order by " + tabelaSelect() + ".data " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_post_performance.id_facebook_post_performance " 
		+ " , DATE_FORMAT(facebook_post_performance.data,'%d-%m-%Y %H:%i:%s') " 
		+ " ,facebook_post_performance.alcance " 
		+ " ,facebook_post_performance.id_facebook_post_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_post_performance " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".alcance " 
		+ " , " + nomeTabela + ".id_facebook_post_ra " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookPostPerformance item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookPostPerformance item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookPostPerformance item) throws DaoException {
		FacebookPostPerformance teste = this.obtemPorChave(item.getIdFacebookPostPerformance());
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
	public void insereItemLoad(FacebookPostPerformance item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_post_performance) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookPostPerformance(id);	
	}
	@Override
	public void alteraItem(FacebookPostPerformance item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_post_performance = " + item.getIdFacebookPostPerformance();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookPostPerformance item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_facebook_post_performance = " + item.getIdFacebookPostPerformance();
		executaSql(query);
	}
	@Override
	public FacebookPostPerformance obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_post_performance = " + id;
        return (FacebookPostPerformance) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookPostPerformanceFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookPostPerformanceFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoFacebookPostReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_post_ra = " + filtro.getCodigoFacebookPostReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookPostPerformanceFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookPostPerformance item) {
		return " ( '" + item.getIdFacebookPostPerformance() + "'  " 
		+ " ," + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " ,'" + item.getAlcance() + "'  "
		+ " ," + item.getIdFacebookPostRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_post_performance " 
		+ " ,data " 
		+ " ,alcance " 
		+ " ,id_facebook_post_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookPostPerformance item) {
		return " id_facebook_post_performance = '" + item.getIdFacebookPostPerformance() + "'  " 
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " , alcance = '" + item.getAlcance() + "'  "
		+ " , id_facebook_post_ra = " + item.getIdFacebookPostRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookPostPerformance item) {
		return " id_facebook_post_performance = '" + item.getIdFacebookPostPerformance() + "'  " 
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  " 
		+ " , alcance = '" + item.getAlcance() + "'  " 
		+ " , id_facebook_post_ra = " + item.getIdFacebookPostRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAFacebookPost(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_post_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorFacebookPostReferenteA(long id) throws DaoException {
		return getPorReferenteAFacebookPost(id);
	}
	public boolean excluiPorReferenteAFacebookPost(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_post_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinFacebookPost_ReferenteA() {
	//	return " inner join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_facebook_post_performance_g = " + tabelaSelect() + ".id_facebook_post_performance ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemFacebookPost_ReferenteA = false;
	public void setObtemFacebookPost_ReferenteA() {
		_obtemFacebookPost_ReferenteA = true;
	}
	protected String outterJoinFacebookPost_ReferenteA() {
		return " left outer join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_facebook_post = " + tabelaSelect() + ".id_facebook_post_ra ";  
	}
	public boolean atualizaReferenteAFacebookPost(long idFacebookPostPerformance, long idFacebookPostRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_post_ra  = " + idFacebookPostRa +
        " where id_facebook_post_performance = " +  idFacebookPostPerformance;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookPost_ReferenteA() {
		return " inner join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_facebook_post = " + tabelaSelect() + ".id_facebook_post_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemFacebookPost_ReferenteA?" , " +FacebookPostDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemFacebookPost_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemFacebookPost_ReferenteA? outterJoinFacebookPost_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookPostPerformanceMontador(), null);
		if (this._obtemFacebookPost_ReferenteA)
            montador.adicionaMontador(new FacebookPostMontador(), "FacebookPost_ReferenteA");
         return montador;
    }
	
	
}
