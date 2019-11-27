package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.FacebookPost;
import coletapreco.regracolecao.filtro.FacebookPostFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookPostDaoBase extends DaoAplicacao implements FacebookPostDaoBaseI {
	
	
	public FacebookPostDaoBase() {
		super();
	}
	public FacebookPostDaoBase(DataFonte dataSource) {
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
		return new FacebookPostMontador();
	}
	public static String tabelaSelect() {
		return " facebook_post" ;
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
		return " order by " + tabelaSelect() + ".data_hora " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_post.id_facebook_post " 
		+ " , DATE_FORMAT(facebook_post.data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " ,facebook_post.codigo_facebook " 
		+ " , DATE_FORMAT(facebook_post.horario_programacao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,facebook_post.id_facebook_fanpage_fe " 
		+ " ,facebook_post.id_produto_d " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_post " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".codigo_facebook " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".horario_programacao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_facebook_fanpage_fe " 
		+ " , " + nomeTabela + ".id_produto_d " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookPost item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookPost item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookPost item) throws DaoException {
		FacebookPost teste = this.obtemPorChave(item.getIdFacebookPost());
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
	public void insereItemLoad(FacebookPost item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_post) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookPost(id);	
	}
	@Override
	public void alteraItem(FacebookPost item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_post = " + item.getIdFacebookPost();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookPost item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_facebook_post = " + item.getIdFacebookPost();
		executaSql(query);
	}
	@Override
	public FacebookPost obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_post = " + id;
        return (FacebookPost) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookPostFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookPostFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoFacebookFanpageFeitoEm() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_fanpage_fe = " + filtro.getCodigoFacebookFanpageFeitoEm();
      	}
      	
		if (filtro.getCodigoProdutoDivulgando() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_d = " + filtro.getCodigoProdutoDivulgando();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookPostFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookPost item) {
		return " ( '" + item.getIdFacebookPost() + "'  " 
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ,'" + item.getCodigoFacebook() + "'  "
		+ " ," + (item.getHorarioProgramacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getHorarioProgramacao()) ) + "  "
		+ " ," + item.getIdFacebookFanpageFe() + "  "
		+ " ," + item.getIdProdutoD() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_post " 
		+ " ,data_hora " 
		+ " ,codigo_facebook " 
		+ " ,horario_programacao " 
		+ " ,id_facebook_fanpage_fe " 
		+ " ,id_produto_d " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookPost item) {
		return " id_facebook_post = '" + item.getIdFacebookPost() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  "
		+ " , horario_programacao = " + (item.getHorarioProgramacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getHorarioProgramacao()) ) + "  "
		+ " , id_facebook_fanpage_fe = " + item.getIdFacebookFanpageFe() + "  "
		+ " , id_produto_d = " + item.getIdProdutoD() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookPost item) {
		return " id_facebook_post = '" + item.getIdFacebookPost() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  " 
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  " 
		+ " , horario_programacao = " + (item.getHorarioProgramacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getHorarioProgramacao()) ) + "  " 
		+ " , id_facebook_fanpage_fe = " + item.getIdFacebookFanpageFe() + "  " 
		+ " , id_produto_d = " + item.getIdProdutoD() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public FacebookPost obtemPorFacebookPostPerformanceGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookPostPerformance_Gera() + 
			" where id_facebook_post_performance = " + id;
		return (FacebookPost) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookPostPerformance_Gera() {
		return " inner join " + FacebookPostPerformanceDaoBase.tabelaSelect() + " on " + FacebookPostPerformanceDaoBase.tabelaSelect() + ".id_facebook_post_ra = " + tabelaSelect() + ".id_facebook_post ";  
	}
	public static String outerJoinFacebookPostPerformance_Gera() {
		return " left outer join " + FacebookPostPerformanceDaoBase.tabelaSelect() + " on " + FacebookPostPerformanceDaoBase.tabelaSelect() + ".id_facebook_post_ra = " + tabelaSelect() + ".id_facebook_post ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorFeitoEmFacebookFanpage(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_fanpage_fe = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorFacebookFanpageFeitoEm(long id) throws DaoException {
		return getPorFeitoEmFacebookFanpage(id);
	}
	public boolean excluiPorFeitoEmFacebookFanpage(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_fanpage_fe = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinFacebookFanpage_FeitoEm() {
	//	return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_post_t = " + tabelaSelect() + ".id_facebook_post ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDivulgandoProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_d = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoDivulgando(long id) throws DaoException {
		return getPorDivulgandoProduto(id);
	}
	public boolean excluiPorDivulgandoProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_d = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProduto_Divulgando() {
	//	return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_facebook_post_dp = " + tabelaSelect() + ".id_facebook_post ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemFacebookFanpage_FeitoEm = false;
	public void setObtemFacebookFanpage_FeitoEm() {
		_obtemFacebookFanpage_FeitoEm = true;
	}
	protected String outterJoinFacebookFanpage_FeitoEm() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_fanpage = " + tabelaSelect() + ".id_facebook_fanpage_fe ";  
	}
	public boolean atualizaFeitoEmFacebookFanpage(long idFacebookPost, long idFacebookFanpageFe) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_fanpage_fe  = " + idFacebookFanpageFe +
        " where id_facebook_post = " +  idFacebookPost;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookFanpage_FeitoEm() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_fanpage = " + tabelaSelect() + ".id_facebook_fanpage_fe ";  
	}
	
 	
	private boolean _obtemProduto_Divulgando = false;
	public void setObtemProduto_Divulgando() {
		_obtemProduto_Divulgando = true;
	}
	protected String outterJoinProduto_Divulgando() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_d ";  
	}
	public boolean atualizaDivulgandoProduto(long idFacebookPost, long idProdutoD) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_d  = " + idProdutoD +
        " where id_facebook_post = " +  idFacebookPost;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_Divulgando() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_d ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemFacebookFanpage_FeitoEm?" , " +FacebookFanpageDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_Divulgando?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemFacebookFanpage_FeitoEm = false;
		_obtemProduto_Divulgando = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemFacebookFanpage_FeitoEm? outterJoinFacebookFanpage_FeitoEm() + " ":"");
		saida += (this._obtemProduto_Divulgando? outterJoinProduto_Divulgando() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookPostMontador(), null);
		if (this._obtemFacebookFanpage_FeitoEm)
            montador.adicionaMontador(new FacebookFanpageMontador(), "FacebookFanpage_FeitoEm");
		if (this._obtemProduto_Divulgando)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_Divulgando");
         return montador;
    }
	
	
}
