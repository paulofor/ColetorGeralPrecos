package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.FacebookPerfil;
import coletapreco.regracolecao.filtro.FacebookPerfilFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class FacebookPerfilDaoBase extends DaoAplicacao implements FacebookPerfilDaoBaseI {
	
	
	public FacebookPerfilDaoBase() {
		super();
	}
	public FacebookPerfilDaoBase(DataFonte dataSource) {
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
		return new FacebookPerfilMontador();
	}
	public static String tabelaSelect() {
		return " facebook_perfil" ;
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
		return " order by " + tabelaSelect() + ".email_utilizado " ;
	}
	
	
	public static String camposOrdenados() {
		return " facebook_perfil.id_facebook_perfil " 
		+ " ,facebook_perfil.token_acesso " 
		+ " ,facebook_perfil.email_utilizado " 
		+ " ,facebook_perfil.nome " 
		+ " ,facebook_perfil.sobrenome " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_facebook_perfil " 
		+ " , " + nomeTabela + ".token_acesso " 
		+ " , " + nomeTabela + ".email_utilizado " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".sobrenome " 
		;
	}
	
	
	@Override
	public void insereItem(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(FacebookPerfil item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(FacebookPerfil item) throws DaoException {
		FacebookPerfil teste = this.obtemPorChave(item.getIdFacebookPerfil());
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
	public void insereItemLoad(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_facebook_perfil) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdFacebookPerfil(id);	
	}
	@Override
	public void alteraItem(FacebookPerfil item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_facebook_perfil = " + item.getIdFacebookPerfil();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(FacebookPerfil item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_facebook_perfil = " + item.getIdFacebookPerfil();
		executaSql(query);
	}
	@Override
	public FacebookPerfil obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_facebook_perfil = " + id;
        return (FacebookPerfil) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(FacebookPerfilFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( FacebookPerfilFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(FacebookPerfilFiltro filtro)
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
	
	
	protected String valoresInsert(FacebookPerfil item) {
		return " ( '" + item.getIdFacebookPerfil() + "'  " 
		+ " ,'" + item.getTokenAcesso() + "'  "
		+ " ,'" + item.getEmailUtilizado() + "'  "
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getSobrenome() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_facebook_perfil " 
		+ " ,token_acesso " 
		+ " ,email_utilizado " 
		+ " ,nome " 
		+ " ,sobrenome " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(FacebookPerfil item) {
		return " id_facebook_perfil = '" + item.getIdFacebookPerfil() + "'  " 
		+ " , token_acesso = '" + item.getTokenAcesso() + "'  "
		+ " , email_utilizado = '" + item.getEmailUtilizado() + "'  "
		+ " , nome = '" + item.getNome() + "'  "
		+ " , sobrenome = '" + item.getSobrenome() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(FacebookPerfil item) {
		return " id_facebook_perfil = '" + item.getIdFacebookPerfil() + "'  " 
		+ " , token_acesso = '" + item.getTokenAcesso() + "'  " 
		+ " , email_utilizado = '" + item.getEmailUtilizado() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , sobrenome = '" + item.getSobrenome() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public FacebookPerfil obtemPorFacebookFanpagePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFanpage_Possui() + 
			" where id_facebook_fanpage = " + id;
		return (FacebookPerfil) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFanpage_Possui() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_perfil_pa = " + tabelaSelect() + ".id_facebook_perfil ";  
	}
	public static String outerJoinFacebookFanpage_Possui() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_facebook_perfil_pa = " + tabelaSelect() + ".id_facebook_perfil ";  
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
        montador.adicionaMontador(new FacebookPerfilMontador(), null);
         return montador;
    }
	
	
}
