package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.CompartilhamentoProduto;
import coletapreco.regracolecao.filtro.CompartilhamentoProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CompartilhamentoProdutoDaoBase extends DaoAplicacao implements CompartilhamentoProdutoDaoBaseI {
	
	
	public CompartilhamentoProdutoDaoBase() {
		super();
	}
	public CompartilhamentoProdutoDaoBase(DataFonte dataSource) {
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
		return new CompartilhamentoProdutoMontador();
	}
	public static String tabelaSelect() {
		return " compartilhamento_produto" ;
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
		return " order by " + tabelaSelect() + ".id_compartilhamento_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " compartilhamento_produto.id_compartilhamento_produto " 
		+ " , DATE_FORMAT(compartilhamento_produto.data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " ,compartilhamento_produto.id_usuario_pa " 
		+ " ,compartilhamento_produto.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_compartilhamento_produto " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_usuario_pa " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(CompartilhamentoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CompartilhamentoProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CompartilhamentoProduto item) throws DaoException {
		CompartilhamentoProduto teste = this.obtemPorChave(item.getIdCompartilhamentoProduto());
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
	public void insereItemLoad(CompartilhamentoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_compartilhamento_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCompartilhamentoProduto(id);	
	}
	@Override
	public void alteraItem(CompartilhamentoProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_compartilhamento_produto = " + item.getIdCompartilhamentoProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CompartilhamentoProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_compartilhamento_produto = " + item.getIdCompartilhamentoProduto();
		executaSql(query);
	}
	@Override
	public CompartilhamentoProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_compartilhamento_produto = " + id;
        return (CompartilhamentoProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CompartilhamentoProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CompartilhamentoProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoUsuarioPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_usuario_pa = " + filtro.getCodigoUsuarioPertenceA();
      	}
      	
		if (filtro.getCodigoProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_ra = " + filtro.getCodigoProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CompartilhamentoProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(CompartilhamentoProduto item) {
		return " ( '" + item.getIdCompartilhamentoProduto() + "'  " 
		+ " ," + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " ," + item.getIdUsuarioPa() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_compartilhamento_produto " 
		+ " ,data_hora " 
		+ " ,id_usuario_pa " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CompartilhamentoProduto item) {
		return " id_compartilhamento_produto = '" + item.getIdCompartilhamentoProduto() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  "
		+ " , id_usuario_pa = " + item.getIdUsuarioPa() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CompartilhamentoProduto item) {
		return " id_compartilhamento_produto = '" + item.getIdCompartilhamentoProduto() + "'  " 
		+ " , data_hora = " + (item.getDataHora()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHora()) ) + "  " 
		+ " , id_usuario_pa = " + item.getIdUsuarioPa() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAUsuario(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_usuario_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorUsuarioPertenceA(long id) throws DaoException {
		return getPorPertenceAUsuario(id);
	}
	public boolean excluiPorPertenceAUsuario(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_usuario_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinUsuario_PertenceA() {
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_compartilhamento_produto_p = " + tabelaSelect() + ".id_compartilhamento_produto ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoReferenteA(long id) throws DaoException {
		return getPorReferenteAProduto(id);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProduto_ReferenteA() {
	//	return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_compartilhamento_produto_g = " + tabelaSelect() + ".id_compartilhamento_produto ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemUsuario_PertenceA = false;
	public void setObtemUsuario_PertenceA() {
		_obtemUsuario_PertenceA = true;
	}
	protected String outterJoinUsuario_PertenceA() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_pa ";  
	}
	public boolean atualizaPertenceAUsuario(long idCompartilhamentoProduto, long idUsuarioPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_pa  = " + idUsuarioPa +
        " where id_compartilhamento_produto = " +  idCompartilhamentoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_PertenceA() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_pa ";  
	}
	
 	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idCompartilhamentoProduto, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_compartilhamento_produto = " +  idCompartilhamentoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_ReferenteA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemUsuario_PertenceA?" , " +UsuarioDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemUsuario_PertenceA = false;
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemUsuario_PertenceA? outterJoinUsuario_PertenceA() + " ":"");
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CompartilhamentoProdutoMontador(), null);
		if (this._obtemUsuario_PertenceA)
            montador.adicionaMontador(new UsuarioMontador(), "Usuario_PertenceA");
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
