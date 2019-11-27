package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.filtro.UsuarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class UsuarioDaoBase extends DaoAplicacao implements UsuarioDaoBaseI {
	
	
	public UsuarioDaoBase() {
		super();
	}
	public UsuarioDaoBase(DataFonte dataSource) {
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
		return new UsuarioMontador();
	}
	public static String tabelaSelect() {
		return " usuario" ;
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
		return " order by " + tabelaSelect() + ".nome_usuario " ;
	}
	
	
	public static String camposOrdenados() {
		return " usuario.id_usuario " 
		+ " ,usuario.nome_usuario " 
		+ " ,usuario.plano01 " 
		+ " ,usuario.plano02 " 
		+ " ,usuario.plano03 " 
		+ " ,usuario.plano04 " 
		+ " ,usuario.plano05 " 
		+ " , DATE_FORMAT(usuario.data_ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,usuario.permite_sincronizar " 
		+ " ,usuario.codigo_externo " 
		+ " , DATE_FORMAT(usuario.data_ultimo_processamento,'%d-%m-%Y %H:%i:%s') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_usuario " 
		+ " , " + nomeTabela + ".nome_usuario " 
		+ " , " + nomeTabela + ".plano01 " 
		+ " , " + nomeTabela + ".plano02 " 
		+ " , " + nomeTabela + ".plano03 " 
		+ " , " + nomeTabela + ".plano04 " 
		+ " , " + nomeTabela + ".plano05 " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".permite_sincronizar " 
		+ " , " + nomeTabela + ".codigo_externo " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultimo_processamento,'%d-%m-%Y %H:%i:%s') " 
		;
	}
	
	
	@Override
	public void insereItem(Usuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Usuario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Usuario item) throws DaoException {
		Usuario teste = this.obtemPorChave(item.getIdUsuario());
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
	public void insereItemLoad(Usuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_usuario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdUsuario(id);	
	}
	@Override
	public void alteraItem(Usuario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_usuario = " + item.getIdUsuario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Usuario item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_usuario = " + item.getIdUsuario();
		executaSql(query);
	}
	@Override
	public Usuario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_usuario = " + id;
        return (Usuario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(UsuarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( UsuarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(UsuarioFiltro filtro)
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
	
	
	protected String valoresInsert(Usuario item) {
		return " ( '" + item.getIdUsuario() + "'  " 
		+ " ,'" + item.getNomeUsuario() + "'  "
		+ " ,'" + (item.getPlano01()?"S":"N") + "'  "
		+ " ,'" + (item.getPlano02()?"S":"N") + "'  "
		+ " ,'" + (item.getPlano03()?"S":"N") + "'  "
		+ " ,'" + (item.getPlano04()?"S":"N") + "'  "
		+ " ,'" + (item.getPlano05()?"S":"N") + "'  "
		+ " ," + (item.getDataUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaAlteracao()) ) + "  "
		+ " ,'" + (item.getPermiteSincronizar()?"S":"N") + "'  "
		+ " ,'" + item.getCodigoExterno() + "'  "
		+ " ," + (item.getDataUltimoProcessamento()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoProcessamento()) ) + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_usuario " 
		+ " ,nome_usuario " 
		+ " ,plano01 " 
		+ " ,plano02 " 
		+ " ,plano03 " 
		+ " ,plano04 " 
		+ " ,plano05 " 
		+ " ,data_ultima_alteracao " 
		+ " ,permite_sincronizar " 
		+ " ,codigo_externo " 
		+ " ,data_ultimo_processamento " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Usuario item) {
		return " id_usuario = '" + item.getIdUsuario() + "'  " 
		+ " , nome_usuario = '" + item.getNomeUsuario() + "'  "
		+ " , plano01 = '" + (item.getPlano01()?"S":"N") + "'  "
		+ " , plano02 = '" + (item.getPlano02()?"S":"N") + "'  "
		+ " , plano03 = '" + (item.getPlano03()?"S":"N") + "'  "
		+ " , plano04 = '" + (item.getPlano04()?"S":"N") + "'  "
		+ " , plano05 = '" + (item.getPlano05()?"S":"N") + "'  "
		+ " , data_ultima_alteracao = " + (item.getDataUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaAlteracao()) ) + "  "
		+ " , permite_sincronizar = '" + (item.getPermiteSincronizar()?"S":"N") + "'  "
		+ " , codigo_externo = '" + item.getCodigoExterno() + "'  "
		+ " , data_ultimo_processamento = " + (item.getDataUltimoProcessamento()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoProcessamento()) ) + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Usuario item) {
		return " id_usuario = '" + item.getIdUsuario() + "'  " 
		+ " , nome_usuario = '" + item.getNomeUsuario() + "'  " 
		+ " , plano01 = '" + (item.getPlano01()?"S":"N") + "'  " 
		+ " , plano02 = '" + (item.getPlano02()?"S":"N") + "'  " 
		+ " , plano03 = '" + (item.getPlano03()?"S":"N") + "'  " 
		+ " , plano04 = '" + (item.getPlano04()?"S":"N") + "'  " 
		+ " , plano05 = '" + (item.getPlano05()?"S":"N") + "'  " 
		+ " , data_ultima_alteracao = " + (item.getDataUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaAlteracao()) ) + "  " 
		+ " , permite_sincronizar = '" + (item.getPermiteSincronizar()?"S":"N") + "'  " 
		+ " , codigo_externo = '" + item.getCodigoExterno() + "'  " 
		+ " , data_ultimo_processamento = " + (item.getDataUltimoProcessamento()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimoProcessamento()) ) + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Usuario obtemPorDispositivoUsuarioUsa(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinDispositivoUsuario_Usa() + 
			" where id_dispositivo_usuario = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinDispositivoUsuario_Usa() {
		return " inner join " + DispositivoUsuarioDaoBase.tabelaSelect() + " on " + DispositivoUsuarioDaoBase.tabelaSelect() + ".id_usuario_ra = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinDispositivoUsuario_Usa() {
		return " left outer join " + DispositivoUsuarioDaoBase.tabelaSelect() + " on " + DispositivoUsuarioDaoBase.tabelaSelect() + ".id_usuario_ra = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorUsuarioPesquisaSincroniza(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinUsuarioPesquisa_Sincroniza() + 
			" where id_usuario_pesquisa = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinUsuarioPesquisa_Sincroniza() {
		return " inner join " + UsuarioPesquisaDaoBase.tabelaSelect() + " on " + UsuarioPesquisaDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinUsuarioPesquisa_Sincroniza() {
		return " left outer join " + UsuarioPesquisaDaoBase.tabelaSelect() + " on " + UsuarioPesquisaDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorPalavraChavePesquisaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPalavraChavePesquisa_Possui() + 
			" where id_palavra_chave_pesquisa = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinPalavraChavePesquisa_Possui() {
		return " inner join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinPalavraChavePesquisa_Possui() {
		return " left outer join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorInteresseProdutoSincroniza(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinInteresseProduto_Sincroniza() + 
			" where id_interesse_produto = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinInteresseProduto_Sincroniza() {
		return " inner join " + InteresseProdutoDaoBase.tabelaSelect() + " on " + InteresseProdutoDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinInteresseProduto_Sincroniza() {
		return " left outer join " + InteresseProdutoDaoBase.tabelaSelect() + " on " + InteresseProdutoDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorPrecoDiarioClienteSincroniza(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoDiarioCliente_Sincroniza() + 
			" where id_preco_diario_clientte = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoDiarioCliente_Sincroniza() {
		return " inner join " + PrecoDiarioClienteDaoBase.tabelaSelect() + " on " + PrecoDiarioClienteDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinPrecoDiarioCliente_Sincroniza() {
		return " left outer join " + PrecoDiarioClienteDaoBase.tabelaSelect() + " on " + PrecoDiarioClienteDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorCompartilhamentoProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCompartilhamentoProduto_Possui() + 
			" where id_compartilhamento_produto = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinCompartilhamentoProduto_Possui() {
		return " inner join " + CompartilhamentoProdutoDaoBase.tabelaSelect() + " on " + CompartilhamentoProdutoDaoBase.tabelaSelect() + ".id_usuario_pa = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinCompartilhamentoProduto_Possui() {
		return " left outer join " + CompartilhamentoProdutoDaoBase.tabelaSelect() + " on " + CompartilhamentoProdutoDaoBase.tabelaSelect() + ".id_usuario_pa = " + tabelaSelect() + ".id_usuario ";  
	}
 	
	/*
	public Usuario obtemPorProdutoClienteSincroniza(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProdutoCliente_Sincroniza() + 
			" where id_produto_cliente = " + id;
		return (Usuario) getObjeto(sql);
	}
	*/
	public static String innerJoinProdutoCliente_Sincroniza() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
	}
	public static String outerJoinProdutoCliente_Sincroniza() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_usuario_s = " + tabelaSelect() + ".id_usuario ";  
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
        montador.adicionaMontador(new UsuarioMontador(), null);
         return montador;
    }
	
	
}
