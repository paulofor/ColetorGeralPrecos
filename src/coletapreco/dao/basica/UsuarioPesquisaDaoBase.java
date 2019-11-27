package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.UsuarioPesquisa;
import coletapreco.regracolecao.filtro.UsuarioPesquisaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class UsuarioPesquisaDaoBase extends DaoAplicacao implements UsuarioPesquisaDaoBaseI {
	
	
	public UsuarioPesquisaDaoBase() {
		super();
	}
	public UsuarioPesquisaDaoBase(DataFonte dataSource) {
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
		return new UsuarioPesquisaMontador();
	}
	public static String tabelaSelect() {
		return " usuario_pesquisa" ;
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
		return " order by " + tabelaSelect() + ".id_usuario_pesquisa " ;
	}
	
	
	public static String camposOrdenados() {
		return " usuario_pesquisa.id_usuario_pesquisa " 
		+ " ,usuario_pesquisa.id_usuario_s " 
		+ " ,usuario_pesquisa.id_natureza_produto_p " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_usuario_pesquisa " 
		+ " , " + nomeTabela + ".id_usuario_s " 
		+ " , " + nomeTabela + ".id_natureza_produto_p " 
		;
	}
	
	
	@Override
	public void insereItem(UsuarioPesquisa item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(UsuarioPesquisa item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(UsuarioPesquisa item) throws DaoException {
		UsuarioPesquisa teste = this.obtemPorChave(item.getIdUsuarioPesquisa());
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
	public void insereItemLoad(UsuarioPesquisa item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_usuario_pesquisa) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdUsuarioPesquisa(id);	
	}
	@Override
	public void alteraItem(UsuarioPesquisa item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_usuario_pesquisa = " + item.getIdUsuarioPesquisa();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(UsuarioPesquisa item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_usuario_pesquisa = " + item.getIdUsuarioPesquisa();
		executaSql(query);
	}
	@Override
	public UsuarioPesquisa obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_usuario_pesquisa = " + id;
        return (UsuarioPesquisa) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(UsuarioPesquisaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( UsuarioPesquisaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoNaturezaProdutoPesquisa() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_p = " + filtro.getCodigoNaturezaProdutoPesquisa();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(UsuarioPesquisaFiltro filtro)
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
	
	
	protected String valoresInsert(UsuarioPesquisa item) {
		return " ( '" + item.getIdUsuarioPesquisa() + "'  " 
		+ " ," + item.getIdUsuarioS() + "  "
		+ " ," + item.getIdNaturezaProdutoP() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_usuario_pesquisa " 
		+ " ,id_usuario_s " 
		+ " ,id_natureza_produto_p " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(UsuarioPesquisa item) {
		return " id_usuario_pesquisa = '" + item.getIdUsuarioPesquisa() + "'  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  "
		+ " , id_natureza_produto_p = " + item.getIdNaturezaProdutoP() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(UsuarioPesquisa item) {
		return " id_usuario_pesquisa = '" + item.getIdUsuarioPesquisa() + "'  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  " 
		+ " , id_natureza_produto_p = " + item.getIdNaturezaProdutoP() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
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
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario_pesquisa_s = " + tabelaSelect() + ".id_usuario_pesquisa ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPesquisaNaturezaProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_natureza_produto_p = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorNaturezaProdutoPesquisa(long id) throws DaoException {
		return getPorPesquisaNaturezaProduto(id);
	}
	public boolean excluiPorPesquisaNaturezaProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_natureza_produto_p = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinNaturezaProduto_Pesquisa() {
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_usuario_pesquisa_pp = " + tabelaSelect() + ".id_usuario_pesquisa ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemUsuario_Sincroniza = false;
	public void setObtemUsuario_Sincroniza() {
		_obtemUsuario_Sincroniza = true;
	}
	protected String outterJoinUsuario_Sincroniza() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	public boolean atualizaSincronizaUsuario(long idUsuarioPesquisa, long idUsuarioS) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_s  = " + idUsuarioS +
        " where id_usuario_pesquisa = " +  idUsuarioPesquisa;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_Sincroniza() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	
 	
	private boolean _obtemNaturezaProduto_Pesquisa = false;
	public void setObtemNaturezaProduto_Pesquisa() {
		_obtemNaturezaProduto_Pesquisa = true;
	}
	protected String outterJoinNaturezaProduto_Pesquisa() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_p ";  
	}
	public boolean atualizaPesquisaNaturezaProduto(long idUsuarioPesquisa, long idNaturezaProdutoP) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_p  = " + idNaturezaProdutoP +
        " where id_usuario_pesquisa = " +  idUsuarioPesquisa;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_Pesquisa() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_p ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemNaturezaProduto_Pesquisa?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemNaturezaProduto_Pesquisa = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemNaturezaProduto_Pesquisa? outterJoinNaturezaProduto_Pesquisa() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new UsuarioPesquisaMontador(), null);
		if (this._obtemNaturezaProduto_Pesquisa)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_Pesquisa");
         return montador;
    }
	
	
}
