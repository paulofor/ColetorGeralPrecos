package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.PalavraProduto;
import coletapreco.regracolecao.filtro.PalavraProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PalavraProdutoDaoBase extends DaoAplicacao implements PalavraProdutoDaoBaseI {
	
	
	public PalavraProdutoDaoBase() {
		super();
	}
	public PalavraProdutoDaoBase(DataFonte dataSource) {
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
		return new PalavraProdutoMontador();
	}
	public static String tabelaSelect() {
		return " palavra_produto" ;
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
		return " order by " + tabelaSelect() + ".id_palavra_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " palavra_produto.id_palavra_produto " 
		+ " ,palavra_produto.id_palavra_ra " 
		+ " ,palavra_produto.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_palavra_produto " 
		+ " , " + nomeTabela + ".id_palavra_ra " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(PalavraProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PalavraProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PalavraProduto item) throws DaoException {
		PalavraProduto teste = this.obtemPorChave(item.getIdPalavraProduto());
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
	public void insereItemLoad(PalavraProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_palavra_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPalavraProduto(id);	
	}
	@Override
	public void alteraItem(PalavraProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_palavra_produto = " + item.getIdPalavraProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PalavraProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_palavra_produto = " + item.getIdPalavraProduto();
		executaSql(query);
	}
	@Override
	public PalavraProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_palavra_produto = " + id;
        return (PalavraProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PalavraProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PalavraProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoPalavraRelaciondoA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_palavra_ra = " + filtro.getCodigoPalavraRelaciondoA();
      	}
      	
		if (filtro.getCodigoProdutoRelaciondoA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_ra = " + filtro.getCodigoProdutoRelaciondoA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PalavraProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(PalavraProduto item) {
		return " ( '" + item.getIdPalavraProduto() + "'  " 
		+ " ," + item.getIdPalavraRa() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_palavra_produto " 
		+ " ,id_palavra_ra " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PalavraProduto item) {
		return " id_palavra_produto = '" + item.getIdPalavraProduto() + "'  " 
		+ " , id_palavra_ra = " + item.getIdPalavraRa() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PalavraProduto item) {
		return " id_palavra_produto = '" + item.getIdPalavraProduto() + "'  " 
		+ " , id_palavra_ra = " + item.getIdPalavraRa() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	@Override
	public PalavraProduto obtemPorRel(long idPalavraRa, long idProdutoRa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_palavra_ra = " + idPalavraRa + 
				" and id_produto_ra = " + idProdutoRa;
		return (PalavraProduto) this.getObjeto(sql);
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorRelaciondoAPalavra(long id) throws DaoException{ // Padrao
	public List ListaPorPalavraRelaciondoA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ProdutoDaoBase.tabelaSelect() +
            " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " +
            tabelaSelect() + ".id_produto_ra" +
            " where id_palavra_ra = " + id + " " +
            criterioExclusaoPalavraRelaciondoA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PalavraProdutoMontador(),null);
        montador.adicionaMontador(new ProdutoMontador(), "ProdutoRelaciondoA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorRelaciondoAPalavra(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_palavra_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoPalavraRelaciondoA() {
		return "";
	}
	
	//public List getPorRelaciondoAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoRelaciondoA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	PalavraDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + PalavraDaoBase.tabelaSelect() +
            " on " + PalavraDaoBase.tabelaSelect() + ".id_palavra = " +
            tabelaSelect() + ".id_palavra_ra" +
            " where id_produto_ra = " + id + " " +
            criterioExclusaoProdutoRelaciondoA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PalavraProdutoMontador(),null);
        montador.adicionaMontador(new PalavraMontador(), "PalavraRelaciondoA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorRelaciondoAProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoProdutoRelaciondoA() {
		return "";
	}
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemPalavra_RelaciondoA = false;
	public void setObtemPalavra_RelaciondoA() {
		_obtemPalavra_RelaciondoA = true;
	}
	protected String outterJoinPalavra_RelaciondoA() {
		return " left outer join " + PalavraDaoBase.tabelaSelect() + " on " + PalavraDaoBase.tabelaSelect() + ".id_palavra = " + tabelaSelect() + ".id_palavra_ra ";  
	}
	public boolean atualizaRelaciondoAPalavra(long idPalavraProduto, long idPalavraRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_palavra_ra  = " + idPalavraRa +
        " where id_palavra_produto = " +  idPalavraProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinPalavra_RelaciondoA() {
		return " inner join " + PalavraDaoBase.tabelaSelect() + " on " + PalavraDaoBase.tabelaSelect() + ".id_palavra = " + tabelaSelect() + ".id_palavra_ra ";  
	}
	
 	
	private boolean _obtemProduto_RelaciondoA = false;
	public void setObtemProduto_RelaciondoA() {
		_obtemProduto_RelaciondoA = true;
	}
	protected String outterJoinProduto_RelaciondoA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaRelaciondoAProduto(long idPalavraProduto, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_palavra_produto = " +  idPalavraProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProduto_RelaciondoA() {
		return " inner join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemPalavra_RelaciondoA?" , " +PalavraDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_RelaciondoA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemPalavra_RelaciondoA = false;
		_obtemProduto_RelaciondoA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemPalavra_RelaciondoA? outterJoinPalavra_RelaciondoA() + " ":"");
		saida += (this._obtemProduto_RelaciondoA? outterJoinProduto_RelaciondoA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new PalavraProdutoMontador(), null);
		if (this._obtemPalavra_RelaciondoA)
            montador.adicionaMontador(new PalavraMontador(), "Palavra_RelaciondoA");
		if (this._obtemProduto_RelaciondoA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_RelaciondoA");
         return montador;
    }
	
	
}
