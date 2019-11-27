package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.regracolecao.filtro.DispositivoUsuarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class DispositivoUsuarioDaoBase extends DaoAplicacao implements DispositivoUsuarioDaoBaseI {
	
	
	public DispositivoUsuarioDaoBase() {
		super();
	}
	public DispositivoUsuarioDaoBase(DataFonte dataSource) {
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
		return new DispositivoUsuarioMontador();
	}
	public static String tabelaSelect() {
		return " dispositivo_usuario" ;
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
		return " order by " + tabelaSelect() + ".numero_celular " ;
	}
	
	
	public static String camposOrdenados() {
		return " dispositivo_usuario.id_dispositivo_usuario " 
		+ " ,dispositivo_usuario.numero_celular " 
		+ " ,dispositivo_usuario.codigo_dispositivo " 
		+ " ,dispositivo_usuario.tipo_acesso " 
		+ " ,dispositivo_usuario.melhor_path " 
		+ " ,dispositivo_usuario.token_gcm " 
		+ " ,dispositivo_usuario.token_gcm_monitor " 
		+ " ,dispositivo_usuario.micro_sd " 
		+ " , DATE_FORMAT(dispositivo_usuario.data_chamada,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(dispositivo_usuario.data_ultimo_acesso,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(dispositivo_usuario.data_criacao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,dispositivo_usuario.tem_mudanca " 
		+ " ,dispositivo_usuario.ativo " 
		+ " ,dispositivo_usuario.id_usuario_ra " 
		+ " ,dispositivo_usuario.id_app_produto_u " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_dispositivo_usuario " 
		+ " , " + nomeTabela + ".numero_celular " 
		+ " , " + nomeTabela + ".codigo_dispositivo " 
		+ " , " + nomeTabela + ".tipo_acesso " 
		+ " , " + nomeTabela + ".melhor_path " 
		+ " , " + nomeTabela + ".token_gcm " 
		+ " , " + nomeTabela + ".token_gcm_monitor " 
		+ " , " + nomeTabela + ".micro_sd " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_chamada,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultimo_acesso,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_criacao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".tem_mudanca " 
		+ " , " + nomeTabela + ".ativo " 
		+ " , " + nomeTabela + ".id_usuario_ra " 
		+ " , " + nomeTabela + ".id_app_produto_u " 
		;
	}
	
	
	@Override
	public void insereItem(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(DispositivoUsuario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(DispositivoUsuario item) throws DaoException {
		DispositivoUsuario teste = this.obtemPorChave(item.getIdDispositivoUsuario());
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
	public void insereItemLoad(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_dispositivo_usuario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdDispositivoUsuario(id);	
	}
	@Override
	public void alteraItem(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_dispositivo_usuario = " + item.getIdDispositivoUsuario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(DispositivoUsuario item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_dispositivo_usuario = " + item.getIdDispositivoUsuario();
		executaSql(query);
	}
	@Override
	public DispositivoUsuario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_dispositivo_usuario = " + id;
        return (DispositivoUsuario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(DispositivoUsuarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( DispositivoUsuarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoUsuarioReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_usuario_ra = " + filtro.getCodigoUsuarioReferenteA();
      	}
      	
		if (filtro.getCodigoAppProdutoUsa() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_app_produto_u = " + filtro.getCodigoAppProdutoUsa();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(DispositivoUsuarioFiltro filtro)
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
	
	
	protected String valoresInsert(DispositivoUsuario item) {
		return " ( '" + item.getIdDispositivoUsuario() + "'  " 
		+ " ,'" + item.getNumeroCelular() + "'  "
		+ " ,'" + item.getCodigoDispositivo() + "'  "
		+ " ,'" + item.getTipoAcesso() + "'  "
		+ " ,'" + item.getMelhorPath() + "'  "
		+ " ,'" + item.getTokenGcm() + "'  "
		+ " ,'" + item.getTokenGcmMonitor() + "'  "
		+ " ,'" + item.getMicroSd() + "'  "
		+ " ," + (item.getDataChamada()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataChamada()) ) + "  "
		+ " ," + (item.getDataUltimoAcesso()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoAcesso()) ) + "  "
		+ " ," + (item.getDataCriacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataCriacao()) ) + "  "
		+ " ,'" + (item.getTemMudanca()?"S":"N") + "'  "
		+ " ,'" + (item.getAtivo()?"S":"N") + "'  "
		+ " ," + item.getIdUsuarioRa() + "  "
		+ " ," + item.getIdAppProdutoU() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_dispositivo_usuario " 
		+ " ,numero_celular " 
		+ " ,codigo_dispositivo " 
		+ " ,tipo_acesso " 
		+ " ,melhor_path " 
		+ " ,token_gcm " 
		+ " ,token_gcm_monitor " 
		+ " ,micro_sd " 
		+ " ,data_chamada " 
		+ " ,data_ultimo_acesso " 
		+ " ,data_criacao " 
		+ " ,tem_mudanca " 
		+ " ,ativo " 
		+ " ,id_usuario_ra " 
		+ " ,id_app_produto_u " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(DispositivoUsuario item) {
		return " id_dispositivo_usuario = '" + item.getIdDispositivoUsuario() + "'  " 
		+ " , numero_celular = '" + item.getNumeroCelular() + "'  "
		+ " , codigo_dispositivo = '" + item.getCodigoDispositivo() + "'  "
		+ " , tipo_acesso = '" + item.getTipoAcesso() + "'  "
		+ " , melhor_path = '" + item.getMelhorPath() + "'  "
		+ " , token_gcm = '" + item.getTokenGcm() + "'  "
		+ " , token_gcm_monitor = '" + item.getTokenGcmMonitor() + "'  "
		+ " , micro_sd = '" + item.getMicroSd() + "'  "
		+ " , data_chamada = " + (item.getDataChamada()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataChamada()) ) + "  "
		+ " , data_ultimo_acesso = " + (item.getDataUltimoAcesso()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoAcesso()) ) + "  "
		+ " , data_criacao = " + (item.getDataCriacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataCriacao()) ) + "  "
		+ " , tem_mudanca = '" + (item.getTemMudanca()?"S":"N") + "'  "
		+ " , ativo = '" + (item.getAtivo()?"S":"N") + "'  "
		+ " , id_usuario_ra = " + item.getIdUsuarioRa() + "  "
		+ " , id_app_produto_u = " + item.getIdAppProdutoU() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(DispositivoUsuario item) {
		return " id_dispositivo_usuario = '" + item.getIdDispositivoUsuario() + "'  " 
		+ " , numero_celular = '" + item.getNumeroCelular() + "'  " 
		+ " , codigo_dispositivo = '" + item.getCodigoDispositivo() + "'  " 
		+ " , tipo_acesso = '" + item.getTipoAcesso() + "'  " 
		+ " , melhor_path = '" + item.getMelhorPath() + "'  " 
		+ " , token_gcm = '" + item.getTokenGcm() + "'  " 
		+ " , token_gcm_monitor = '" + item.getTokenGcmMonitor() + "'  " 
		+ " , micro_sd = '" + item.getMicroSd() + "'  " 
		+ " , data_chamada = " + (item.getDataChamada()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataChamada()) ) + "  " 
		+ " , data_ultimo_acesso = " + (item.getDataUltimoAcesso()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoAcesso()) ) + "  " 
		+ " , data_criacao = " + (item.getDataCriacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataCriacao()) ) + "  " 
		+ " , tem_mudanca = '" + (item.getTemMudanca()?"S":"N") + "'  " 
		+ " , ativo = '" + (item.getAtivo()?"S":"N") + "'  " 
		+ " , id_usuario_ra = " + item.getIdUsuarioRa() + "  " 
		+ " , id_app_produto_u = " + item.getIdAppProdutoU() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAUsuario(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_usuario_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorUsuarioReferenteA(long id) throws DaoException {
		return getPorReferenteAUsuario(id);
	}
	public boolean excluiPorReferenteAUsuario(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_usuario_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinUsuario_ReferenteA() {
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_dispositivo_usuario_u = " + tabelaSelect() + ".id_dispositivo_usuario ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorUsaAppProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_app_produto_u = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorAppProdutoUsa(long id) throws DaoException {
		return getPorUsaAppProduto(id);
	}
	public boolean excluiPorUsaAppProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_app_produto_u = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinAppProduto_Usa() {
	//	return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_dispositivo_usuario_up = " + tabelaSelect() + ".id_dispositivo_usuario ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemUsuario_ReferenteA = false;
	public void setObtemUsuario_ReferenteA() {
		_obtemUsuario_ReferenteA = true;
	}
	protected String outterJoinUsuario_ReferenteA() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_ra ";  
	}
	public boolean atualizaReferenteAUsuario(long idDispositivoUsuario, long idUsuarioRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_ra  = " + idUsuarioRa +
        " where id_dispositivo_usuario = " +  idDispositivoUsuario;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_ReferenteA() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_ra ";  
	}
	
 	
	private boolean _obtemAppProduto_Usa = false;
	public void setObtemAppProduto_Usa() {
		_obtemAppProduto_Usa = true;
	}
	protected String outterJoinAppProduto_Usa() {
		return " left outer join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_u ";  
	}
	public boolean atualizaUsaAppProduto(long idDispositivoUsuario, long idAppProdutoU) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_app_produto_u  = " + idAppProdutoU +
        " where id_dispositivo_usuario = " +  idDispositivoUsuario;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinAppProduto_Usa() {
		return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_u ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemUsuario_ReferenteA?" , " +UsuarioDaoBase.camposOrdenados():"");
		saida += (this._obtemAppProduto_Usa?" , " +AppProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemUsuario_ReferenteA = false;
		_obtemAppProduto_Usa = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemUsuario_ReferenteA? outterJoinUsuario_ReferenteA() + " ":"");
		saida += (this._obtemAppProduto_Usa? outterJoinAppProduto_Usa() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new DispositivoUsuarioMontador(), null);
		if (this._obtemUsuario_ReferenteA)
            montador.adicionaMontador(new UsuarioMontador(), "Usuario_ReferenteA");
		if (this._obtemAppProduto_Usa)
            montador.adicionaMontador(new AppProdutoMontador(), "AppProduto_Usa");
         return montador;
    }
	
	
}
