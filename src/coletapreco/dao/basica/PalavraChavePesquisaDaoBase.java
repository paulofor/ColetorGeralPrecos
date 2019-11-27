package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.PalavraChavePesquisa;
import coletapreco.regracolecao.filtro.PalavraChavePesquisaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PalavraChavePesquisaDaoBase extends DaoAplicacao implements PalavraChavePesquisaDaoBaseI {
	
	
	public PalavraChavePesquisaDaoBase() {
		super();
	}
	public PalavraChavePesquisaDaoBase(DataFonte dataSource) {
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
		return new PalavraChavePesquisaMontador();
	}
	public static String tabelaSelect() {
		return " palavra_chave_pesquisa" ;
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
		return " order by " + tabelaSelect() + ".texto_busca " ;
	}
	
	
	public static String camposOrdenados() {
		return " palavra_chave_pesquisa.id_palavra_chave_pesquisa " 
		+ " ,palavra_chave_pesquisa.texto_busca " 
		+ " , DATE_FORMAT(palavra_chave_pesquisa.data,'%d-%m-%Y') " 
		+ " ,palavra_chave_pesquisa.id_usuario_s " 
		+ " ,palavra_chave_pesquisa.id_natureza_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_palavra_chave_pesquisa " 
		+ " , " + nomeTabela + ".texto_busca " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_usuario_s " 
		+ " , " + nomeTabela + ".id_natureza_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(PalavraChavePesquisa item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PalavraChavePesquisa item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PalavraChavePesquisa item) throws DaoException {
		PalavraChavePesquisa teste = this.obtemPorChave(item.getIdPalavraChavePesquisa());
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
	public void insereItemLoad(PalavraChavePesquisa item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_palavra_chave_pesquisa) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPalavraChavePesquisa(id);	
	}
	@Override
	public void alteraItem(PalavraChavePesquisa item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_palavra_chave_pesquisa = " + item.getIdPalavraChavePesquisa();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PalavraChavePesquisa item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_palavra_chave_pesquisa = " + item.getIdPalavraChavePesquisa();
		executaSql(query);
	}
	@Override
	public PalavraChavePesquisa obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_palavra_chave_pesquisa = " + id;
        return (PalavraChavePesquisa) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PalavraChavePesquisaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PalavraChavePesquisaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoNaturezaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_ra = " + filtro.getCodigoNaturezaProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PalavraChavePesquisaFiltro filtro)
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
	
	
	protected String valoresInsert(PalavraChavePesquisa item) {
		return " ( '" + item.getIdPalavraChavePesquisa() + "'  " 
		+ " ,'" + item.getTextoBusca() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ," + item.getIdUsuarioS() + "  "
		+ " ," + item.getIdNaturezaProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_palavra_chave_pesquisa " 
		+ " ,texto_busca " 
		+ " ,data " 
		+ " ,id_usuario_s " 
		+ " ,id_natureza_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PalavraChavePesquisa item) {
		return " id_palavra_chave_pesquisa = '" + item.getIdPalavraChavePesquisa() + "'  " 
		+ " , texto_busca = '" + item.getTextoBusca() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  "
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PalavraChavePesquisa item) {
		return " id_palavra_chave_pesquisa = '" + item.getIdPalavraChavePesquisa() + "'  " 
		+ " , texto_busca = '" + item.getTextoBusca() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  " 
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public PalavraChavePesquisa obtemPorProdutoClienteGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProdutoCliente_Gerou() + 
			" where id_produto_cliente = " + id;
		return (PalavraChavePesquisa) getObjeto(sql);
	}
	*/
	public static String innerJoinProdutoCliente_Gerou() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa_ra = " + tabelaSelect() + ".id_palavra_chave_pesquisa ";  
	}
	public static String outerJoinProdutoCliente_Gerou() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa_ra = " + tabelaSelect() + ".id_palavra_chave_pesquisa ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_usuario_s = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorUsuarioSincroniza(long id) throws DaoException {
		return getPorSincronizaUsuario(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_usuario_s = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinUsuario_Sincroniza() {
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa_p = " + tabelaSelect() + ".id_palavra_chave_pesquisa ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteANaturezaProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_natureza_produto_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorNaturezaProdutoReferenteA(long id) throws DaoException {
		return getPorReferenteANaturezaProduto(id);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_natureza_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinNaturezaProduto_ReferenteA() {
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa_pp = " + tabelaSelect() + ".id_palavra_chave_pesquisa ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemUsuario_Sincroniza = false;
	public void setObtemUsuario_Sincroniza() {
		_obtemUsuario_Sincroniza = true;
	}
	protected String outterJoinUsuario_Sincroniza() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	public boolean atualizaSincronizaUsuario(long idPalavraChavePesquisa, long idUsuarioS) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_s  = " + idUsuarioS +
        " where id_palavra_chave_pesquisa = " +  idPalavraChavePesquisa;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_Sincroniza() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	
 	
	private boolean _obtemNaturezaProduto_ReferenteA = false;
	public void setObtemNaturezaProduto_ReferenteA() {
		_obtemNaturezaProduto_ReferenteA = true;
	}
	protected String outterJoinNaturezaProduto_ReferenteA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	public boolean atualizaReferenteANaturezaProduto(long idPalavraChavePesquisa, long idNaturezaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_ra  = " + idNaturezaProdutoRa +
        " where id_palavra_chave_pesquisa = " +  idPalavraChavePesquisa;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_ReferenteA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemNaturezaProduto_ReferenteA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemNaturezaProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemNaturezaProduto_ReferenteA? outterJoinNaturezaProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PalavraChavePesquisaMontador(), null);
		if (this._obtemNaturezaProduto_ReferenteA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_ReferenteA");
         return montador;
    }
	
	
}
