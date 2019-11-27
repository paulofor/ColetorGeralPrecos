package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.FacebookFanpage;
import coletapreco.regracolecao.filtro.FacebookFanpageFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookFanpageDaoBase extends DaoAplicacao implements FacebookFanpageDaoBaseI {
	
	
	public FacebookFanpageDaoBase() {
		super();
	}
	public FacebookFanpageDaoBase(DataFonte dataSource) {
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
		return new FacebookFanpageMontador();
	}
	public static String tabelaSelect() {
		return " facebook_fanpage" ;
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
		return " order by " + tabelaSelect() + ".nome " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_fanpage.id_facebook_fanpage " 
		+ " ,facebook_fanpage.nome " 
		+ " ,facebook_fanpage.codigo_facebook " 
		+ " ,facebook_fanpage.nome_url " 
		+ " ,facebook_fanpage.quantidade_dia " 
		+ " ,facebook_fanpage.id_facebook_perfil_pa " 
		+ " ,facebook_fanpage.id_app_produto_d " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_fanpage " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".codigo_facebook " 
		+ " , " + nomeTabela + ".nome_url " 
		+ " , " + nomeTabela + ".quantidade_dia " 
		+ " , " + nomeTabela + ".id_facebook_perfil_pa " 
		+ " , " + nomeTabela + ".id_app_produto_d " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookFanpage item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookFanpage item) throws DaoException {
		FacebookFanpage teste = this.obtemPorChave(item.getIdFacebookFanpage());
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
	public void insereItemLoad(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_fanpage) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookFanpage(id);	
	}
	@Override
	public void alteraItem(FacebookFanpage item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_fanpage = " + item.getIdFacebookFanpage();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookFanpage item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_facebook_fanpage = " + item.getIdFacebookFanpage();
		executaSql(query);
	}
	@Override
	public FacebookFanpage obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_fanpage = " + id;
        return (FacebookFanpage) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookFanpageFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookFanpageFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoFacebookPerfilPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_facebook_perfil_pa = " + filtro.getCodigoFacebookPerfilPertenceA();
      	}
      	
		if (filtro.getCodigoAppProdutoDivulga() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_app_produto_d = " + filtro.getCodigoAppProdutoDivulga();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookFanpageFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookFanpage item) {
		return " ( '" + item.getIdFacebookFanpage() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getCodigoFacebook() + "'  "
		+ " ,'" + item.getNomeUrl() + "'  "
		+ " ,'" + item.getQuantidadeDia() + "'  "
		+ " ," + item.getIdFacebookPerfilPa() + "  "
		+ " ," + item.getIdAppProdutoD() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_fanpage " 
		+ " ,nome " 
		+ " ,codigo_facebook " 
		+ " ,nome_url " 
		+ " ,quantidade_dia " 
		+ " ,id_facebook_perfil_pa " 
		+ " ,id_app_produto_d " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookFanpage item) {
		return " id_facebook_fanpage = '" + item.getIdFacebookFanpage() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  "
		+ " , nome_url = '" + item.getNomeUrl() + "'  "
		+ " , quantidade_dia = '" + item.getQuantidadeDia() + "'  "
		+ " , id_facebook_perfil_pa = " + item.getIdFacebookPerfilPa() + "  "
		+ " , id_app_produto_d = " + item.getIdAppProdutoD() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookFanpage item) {
		return " id_facebook_fanpage = '" + item.getIdFacebookFanpage() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , codigo_facebook = '" + item.getCodigoFacebook() + "'  " 
		+ " , nome_url = '" + item.getNomeUrl() + "'  " 
		+ " , quantidade_dia = '" + item.getQuantidadeDia() + "'  " 
		+ " , id_facebook_perfil_pa = " + item.getIdFacebookPerfilPa() + "  " 
		+ " , id_app_produto_d = " + item.getIdAppProdutoD() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public FacebookFanpage obtemPorFacebookPostTem(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookPost_Tem() + 
			" where id_facebook_post = " + id;
		return (FacebookFanpage) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookPost_Tem() {
		return " inner join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_facebook_fanpage_fe = " + tabelaSelect() + ".id_facebook_fanpage ";  
	}
	public static String outerJoinFacebookPost_Tem() {
		return " left outer join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_facebook_fanpage_fe = " + tabelaSelect() + ".id_facebook_fanpage ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAFacebookPerfil(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_facebook_perfil_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorFacebookPerfilPertenceA(long id) throws DaoException {
		return getPorPertenceAFacebookPerfil(id);
	}
	public boolean excluiPorPertenceAFacebookPerfil(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_facebook_perfil_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinFacebookPerfil_PertenceA() {
	//	return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_fanpage_p = " + tabelaSelect() + ".id_facebook_fanpage ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDivulgaAppProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_app_produto_d = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorAppProdutoDivulga(long id) throws DaoException {
		return getPorDivulgaAppProduto(id);
	}
	public boolean excluiPorDivulgaAppProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_app_produto_d = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinAppProduto_Divulga() {
	//	return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_facebook_fanpage_dp = " + tabelaSelect() + ".id_facebook_fanpage ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemFacebookPerfil_PertenceA = false;
	public void setObtemFacebookPerfil_PertenceA() {
		_obtemFacebookPerfil_PertenceA = true;
	}
	protected String outterJoinFacebookPerfil_PertenceA() {
		return " left outer join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_pa ";  
	}
	public boolean atualizaPertenceAFacebookPerfil(long idFacebookFanpage, long idFacebookPerfilPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_facebook_perfil_pa  = " + idFacebookPerfilPa +
        " where id_facebook_fanpage = " +  idFacebookFanpage;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinFacebookPerfil_PertenceA() {
		return " inner join " + FacebookPerfilDaoBase.tabelaSelect() + " on " + FacebookPerfilDaoBase.tabelaSelect() + ".id_facebook_perfil = " + tabelaSelect() + ".id_facebook_perfil_pa ";  
	}
	
 	
	private boolean _obtemAppProduto_Divulga = false;
	public void setObtemAppProduto_Divulga() {
		_obtemAppProduto_Divulga = true;
	}
	protected String outterJoinAppProduto_Divulga() {
		return " left outer join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_d ";  
	}
	public boolean atualizaDivulgaAppProduto(long idFacebookFanpage, long idAppProdutoD) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_app_produto_d  = " + idAppProdutoD +
        " where id_facebook_fanpage = " +  idFacebookFanpage;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinAppProduto_Divulga() {
		return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_d ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemFacebookPerfil_PertenceA?" , " +FacebookPerfilDaoBase.camposOrdenados():"");
		saida += (this._obtemAppProduto_Divulga?" , " +AppProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemFacebookPerfil_PertenceA = false;
		_obtemAppProduto_Divulga = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemFacebookPerfil_PertenceA? outterJoinFacebookPerfil_PertenceA() + " ":"");
		saida += (this._obtemAppProduto_Divulga? outterJoinAppProduto_Divulga() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new FacebookFanpageMontador(), null);
		if (this._obtemFacebookPerfil_PertenceA)
            montador.adicionaMontador(new FacebookPerfilMontador(), "FacebookPerfil_PertenceA");
		if (this._obtemAppProduto_Divulga)
            montador.adicionaMontador(new AppProdutoMontador(), "AppProduto_Divulga");
         return montador;
    }
	
	
}
