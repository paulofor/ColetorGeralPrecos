package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.OportunidadeInteresseCliente;
import coletapreco.regracolecao.filtro.OportunidadeInteresseClienteFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OportunidadeInteresseClienteDaoBase extends DaoAplicacao implements OportunidadeInteresseClienteDaoBaseI {
	
	
	public OportunidadeInteresseClienteDaoBase() {
		super();
	}
	public OportunidadeInteresseClienteDaoBase(DataFonte dataSource) {
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
		return new OportunidadeInteresseClienteMontador();
	}
	public static String tabelaSelect() {
		return " oportunidade_interesse_cliente" ;
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
		return " order by " + tabelaSelect() + ".id_oportunidade_interesse_cliente " ;
	}
	
	
	public static String camposOrdenados() {
		return " oportunidade_interesse_cliente.id_oportunidade_interesse_cliente " 
		+ " ,oportunidade_interesse_cliente.id_produto_cliente_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_oportunidade_interesse_cliente " 
		+ " , " + nomeTabela + ".id_produto_cliente_pa " 
		;
	}
	
	
	@Override
	public void insereItem(OportunidadeInteresseCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OportunidadeInteresseCliente item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OportunidadeInteresseCliente item) throws DaoException {
		OportunidadeInteresseCliente teste = this.obtemPorChave(item.getIdOportunidadeInteresseCliente());
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
	public void insereItemLoad(OportunidadeInteresseCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_oportunidade_interesse_cliente) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOportunidadeInteresseCliente(id);	
	}
	@Override
	public void alteraItem(OportunidadeInteresseCliente item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_oportunidade_interesse_cliente = " + item.getIdOportunidadeInteresseCliente();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OportunidadeInteresseCliente item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_oportunidade_interesse_cliente = " + item.getIdOportunidadeInteresseCliente();
		executaSql(query);
	}
	@Override
	public OportunidadeInteresseCliente obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_oportunidade_interesse_cliente = " + id;
        return (OportunidadeInteresseCliente) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OportunidadeInteresseClienteFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OportunidadeInteresseClienteFiltro filtro ) {
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
	public List ListaFiltroSimples(OportunidadeInteresseClienteFiltro filtro)
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
	
	
	protected String valoresInsert(OportunidadeInteresseCliente item) {
		return " ( '" + item.getIdOportunidadeInteresseCliente() + "'  " 
		+ " ," + item.getIdProdutoClientePa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_oportunidade_interesse_cliente " 
		+ " ,id_produto_cliente_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OportunidadeInteresseCliente item) {
		return " id_oportunidade_interesse_cliente = '" + item.getIdOportunidadeInteresseCliente() + "'  " 
		+ " , id_produto_cliente_pa = " + item.getIdProdutoClientePa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OportunidadeInteresseCliente item) {
		return " id_oportunidade_interesse_cliente = '" + item.getIdOportunidadeInteresseCliente() + "'  " 
		+ " , id_produto_cliente_pa = " + item.getIdProdutoClientePa() + "  " 
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
	//	return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_oportunidade_interesse_cliente_p = " + tabelaSelect() + ".id_oportunidade_interesse_cliente ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProdutoCliente_PertenceA = false;
	public void setObtemProdutoCliente_PertenceA() {
		_obtemProdutoCliente_PertenceA = true;
	}
	protected String outterJoinProdutoCliente_PertenceA() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_pa ";  
	}
	public boolean atualizaPertenceAProdutoCliente(long idOportunidadeInteresseCliente, long idProdutoClientePa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_cliente_pa  = " + idProdutoClientePa +
        " where id_oportunidade_interesse_cliente = " +  idOportunidadeInteresseCliente;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProdutoCliente_PertenceA() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_pa ";  
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
        montador.adicionaMontador(new OportunidadeInteresseClienteMontador(), null);
		if (this._obtemProdutoCliente_PertenceA)
            montador.adicionaMontador(new ProdutoClienteMontador(), "ProdutoCliente_PertenceA");
         return montador;
    }
	
	
}
