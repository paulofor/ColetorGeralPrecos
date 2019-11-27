package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.PrecoDiarioCliente;
import coletapreco.regracolecao.filtro.PrecoDiarioClienteFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PrecoDiarioClienteDaoBase extends DaoAplicacao implements PrecoDiarioClienteDaoBaseI {
	
	
	public PrecoDiarioClienteDaoBase() {
		super();
	}
	public PrecoDiarioClienteDaoBase(DataFonte dataSource) {
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
		return new PrecoDiarioClienteMontador();
	}
	public static String tabelaSelect() {
		return " preco_diario_cliente" ;
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
		return " order by " + tabelaSelect() + ".preco_venda " ;
	}
	
	
	public static String camposOrdenados() {
		return " preco_diario_cliente.id_preco_diario_clientte " 
		+ " , DATE_FORMAT(preco_diario_cliente.data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " ,preco_diario_cliente.preco_venda " 
		+ " ,preco_diario_cliente.id_produto_cliente_pa " 
		+ " ,preco_diario_cliente.id_usuario_s " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_preco_diario_clientte " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".preco_venda " 
		+ " , " + nomeTabela + ".id_produto_cliente_pa " 
		+ " , " + nomeTabela + ".id_usuario_s " 
		;
	}
	
	
	@Override
	public void insereItem(PrecoDiarioCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PrecoDiarioCliente item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PrecoDiarioCliente item) throws DaoException {
		PrecoDiarioCliente teste = this.obtemPorChave(item.getIdPrecoDiarioClientte());
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
	public void insereItemLoad(PrecoDiarioCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_preco_diario_clientte) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPrecoDiarioClientte(id);	
	}
	@Override
	public void alteraItem(PrecoDiarioCliente item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_preco_diario_clientte = " + item.getIdPrecoDiarioClientte();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PrecoDiarioCliente item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_preco_diario_clientte = " + item.getIdPrecoDiarioClientte();
		executaSql(query);
	}
	@Override
	public PrecoDiarioCliente obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_preco_diario_clientte = " + id;
        return (PrecoDiarioCliente) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PrecoDiarioClienteFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PrecoDiarioClienteFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoClientePertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_cliente_pa = " + filtro.getCodigoProdutoClientePertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PrecoDiarioClienteFiltro filtro)
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
	
	
	protected String valoresInsert(PrecoDiarioCliente item) {
		return " ( '" + item.getIdPrecoDiarioClientte() + "'  " 
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " ," + item.getIdProdutoClientePa() + "  "
		+ " ," + item.getIdUsuarioS() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_preco_diario_clientte " 
		+ " ,data_hora " 
		+ " ,preco_venda " 
		+ " ,id_produto_cliente_pa " 
		+ " ,id_usuario_s " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PrecoDiarioCliente item) {
		return " id_preco_diario_clientte = '" + item.getIdPrecoDiarioClientte() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " , preco_venda = '" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  "
		+ " , id_produto_cliente_pa = " + item.getIdProdutoClientePa() + "  "
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PrecoDiarioCliente item) {
		return " id_preco_diario_clientte = '" + item.getIdPrecoDiarioClientte() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  " 
		+ " , preco_venda = '" +  DCConvert.ToDataBase(item.getPrecoVenda()) + "'  " 
		+ " , id_produto_cliente_pa = " + item.getIdProdutoClientePa() + "  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProdutoCliente(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_cliente_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoClientePertenceA(long id) throws DaoException {
		return getPorPertenceAProdutoCliente(id);
	}
	public boolean excluiPorPertenceAProdutoCliente(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_cliente_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProdutoCliente_PertenceA() {
	//	return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_preco_diario_clientte_p = " + tabelaSelect() + ".id_preco_diario_clientte ";  
	//}
	
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
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_preco_diario_clientte_s = " + tabelaSelect() + ".id_preco_diario_clientte ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProdutoCliente_PertenceA = false;
	public void setObtemProdutoCliente_PertenceA() {
		_obtemProdutoCliente_PertenceA = true;
	}
	protected String outterJoinProdutoCliente_PertenceA() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_pa ";  
	}
	public boolean atualizaPertenceAProdutoCliente(long idPrecoDiarioClientte, long idProdutoClientePa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_cliente_pa  = " + idProdutoClientePa +
        " where id_preco_diario_clientte = " +  idPrecoDiarioClientte;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProdutoCliente_PertenceA() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_pa ";  
	}
	
 	
	private boolean _obtemUsuario_Sincroniza = false;
	public void setObtemUsuario_Sincroniza() {
		_obtemUsuario_Sincroniza = true;
	}
	protected String outterJoinUsuario_Sincroniza() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	public boolean atualizaSincronizaUsuario(long idPrecoDiarioClientte, long idUsuarioS) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_s  = " + idUsuarioS +
        " where id_preco_diario_clientte = " +  idPrecoDiarioClientte;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_Sincroniza() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProdutoCliente_PertenceA?" , " +ProdutoClienteDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProdutoCliente_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProdutoCliente_PertenceA? outterJoinProdutoCliente_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PrecoDiarioClienteMontador(), null);
		if (this._obtemProdutoCliente_PertenceA)
            montador.adicionaMontador(new ProdutoClienteMontador(), "ProdutoCliente_PertenceA");
         return montador;
    }
	
	
}
