package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.regracolecao.filtro.CategoriaLojaProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CategoriaLojaProdutoDaoBase extends DaoAplicacao implements CategoriaLojaProdutoDaoBaseI {
	
	
	public CategoriaLojaProdutoDaoBase() {
		super();
	}
	public CategoriaLojaProdutoDaoBase(DataFonte dataSource) {
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
		return new CategoriaLojaProdutoMontador();
	}
	public static String tabelaSelect() {
		return " categoria_loja_produto" ;
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
		return " order by " + tabelaSelect() + ".id_categoria_loja_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " categoria_loja_produto.id_categoria_loja_produto " 
		+ " , DATE_FORMAT(categoria_loja_produto.data_ultima_visita,'%d-%m-%Y') " 
		+ " ,categoria_loja_produto.id_categoria_loja_ra " 
		+ " ,categoria_loja_produto.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria_loja_produto " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_visita,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_categoria_loja_ra " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(CategoriaLojaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CategoriaLojaProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CategoriaLojaProduto item) throws DaoException {
		CategoriaLojaProduto teste = this.obtemPorChave(item.getIdCategoriaLojaProduto());
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
	public void insereItemLoad(CategoriaLojaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_categoria_loja_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCategoriaLojaProduto(id);	
	}
	@Override
	public void alteraItem(CategoriaLojaProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_categoria_loja_produto = " + item.getIdCategoriaLojaProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CategoriaLojaProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_categoria_loja_produto = " + item.getIdCategoriaLojaProduto();
		executaSql(query);
	}
	@Override
	public CategoriaLojaProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_categoria_loja_produto = " + id;
        return (CategoriaLojaProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CategoriaLojaProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CategoriaLojaProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoCategoriaLojaReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_loja_ra = " + filtro.getCodigoCategoriaLojaReferenteA();
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
	public List ListaFiltroSimples(CategoriaLojaProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(CategoriaLojaProduto item) {
		return " ( '" + item.getIdCategoriaLojaProduto() + "'  " 
		+ " ," + (item.getDataUltimaVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaVisita()) ) + "  "
		+ " ," + item.getIdCategoriaLojaRa() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria_loja_produto " 
		+ " ,data_ultima_visita " 
		+ " ,id_categoria_loja_ra " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CategoriaLojaProduto item) {
		return " id_categoria_loja_produto = '" + item.getIdCategoriaLojaProduto() + "'  " 
		+ " , data_ultima_visita = " + (item.getDataUltimaVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaVisita()) ) + "  "
		+ " , id_categoria_loja_ra = " + item.getIdCategoriaLojaRa() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CategoriaLojaProduto item) {
		return " id_categoria_loja_produto = '" + item.getIdCategoriaLojaProduto() + "'  " 
		+ " , data_ultima_visita = " + (item.getDataUltimaVisita()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataUltimaVisita()) ) + "  " 
		+ " , id_categoria_loja_ra = " + item.getIdCategoriaLojaRa() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	@Override
	public CategoriaLojaProduto obtemPorRel(long idCategoriaLojaRa, long idProdutoRa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_categoria_loja_ra = " + idCategoriaLojaRa + 
				" and id_produto_ra = " + idProdutoRa;
		return (CategoriaLojaProduto) this.getObjeto(sql);
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteACategoriaLoja(long id) throws DaoException{ // Padrao
	public List ListaPorCategoriaLojaReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ProdutoDaoBase.tabelaSelect() +
            " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " +
            tabelaSelect() + ".id_produto_ra" +
            " where id_categoria_loja_ra = " + id + " " +
            criterioExclusaoCategoriaLojaReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaLojaProdutoMontador(),null);
        montador.adicionaMontador(new ProdutoMontador(), "ProdutoReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteACategoriaLoja(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_categoria_loja_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoCategoriaLojaReferenteA() {
		return "";
	}
	
	//public List getPorReferenteAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	CategoriaLojaDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + CategoriaLojaDaoBase.tabelaSelect() +
            " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja = " +
            tabelaSelect() + ".id_categoria_loja_ra" +
            " where id_produto_ra = " + id + " " +
            criterioExclusaoProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaLojaProdutoMontador(),null);
        montador.adicionaMontador(new CategoriaLojaMontador(), "CategoriaLojaReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoProdutoReferenteA() {
		return "";
	}
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemCategoriaLoja_ReferenteA = false;
	public void setObtemCategoriaLoja_ReferenteA() {
		_obtemCategoriaLoja_ReferenteA = true;
	}
	protected String outterJoinCategoriaLoja_ReferenteA() {
		return " left outer join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja = " + tabelaSelect() + ".id_categoria_loja_ra ";  
	}
	public boolean atualizaReferenteACategoriaLoja(long idCategoriaLojaProduto, long idCategoriaLojaRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_loja_ra  = " + idCategoriaLojaRa +
        " where id_categoria_loja_produto = " +  idCategoriaLojaProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinCategoriaLoja_ReferenteA() {
		return " inner join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja = " + tabelaSelect() + ".id_categoria_loja_ra ";  
	}
	
 	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idCategoriaLojaProduto, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_categoria_loja_produto = " +  idCategoriaLojaProduto;
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
		saida += (this._obtemCategoriaLoja_ReferenteA?" , " +CategoriaLojaDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemCategoriaLoja_ReferenteA = false;
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemCategoriaLoja_ReferenteA? outterJoinCategoriaLoja_ReferenteA() + " ":"");
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaLojaProdutoMontador(), null);
		if (this._obtemCategoriaLoja_ReferenteA)
            montador.adicionaMontador(new CategoriaLojaMontador(), "CategoriaLoja_ReferenteA");
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
