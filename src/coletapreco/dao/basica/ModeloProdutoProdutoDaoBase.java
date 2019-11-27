package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.ModeloProdutoProduto;
import coletapreco.regracolecao.filtro.ModeloProdutoProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ModeloProdutoProdutoDaoBase extends DaoAplicacao implements ModeloProdutoProdutoDaoBaseI {
	
	
	public ModeloProdutoProdutoDaoBase() {
		super();
	}
	public ModeloProdutoProdutoDaoBase(DataFonte dataSource) {
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
		return new ModeloProdutoProdutoMontador();
	}
	public static String tabelaSelect() {
		return " modelo_produto_produto" ;
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
		return " order by " + tabelaSelect() + ".id_modelo_produto_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " modelo_produto_produto.id_modelo_produto_produto " 
		+ " ,modelo_produto_produto.id_modelo_produto_ra " 
		+ " ,modelo_produto_produto.id_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_modelo_produto_produto " 
		+ " , " + nomeTabela + ".id_modelo_produto_ra " 
		+ " , " + nomeTabela + ".id_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ModeloProdutoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ModeloProdutoProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ModeloProdutoProduto item) throws DaoException {
		ModeloProdutoProduto teste = this.obtemPorChave(item.getIdModeloProdutoProduto());
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
	public void insereItemLoad(ModeloProdutoProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_modelo_produto_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdModeloProdutoProduto(id);	
	}
	@Override
	public void alteraItem(ModeloProdutoProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_modelo_produto_produto = " + item.getIdModeloProdutoProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ModeloProdutoProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_modelo_produto_produto = " + item.getIdModeloProdutoProduto();
		executaSql(query);
	}
	@Override
	public ModeloProdutoProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_modelo_produto_produto = " + id;
        return (ModeloProdutoProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ModeloProdutoProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ModeloProdutoProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoModeloProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_modelo_produto_ra = " + filtro.getCodigoModeloProdutoReferenteA();
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
	public List ListaFiltroSimples(ModeloProdutoProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(ModeloProdutoProduto item) {
		return " ( '" + item.getIdModeloProdutoProduto() + "'  " 
		+ " ," + item.getIdModeloProdutoRa() + "  "
		+ " ," + item.getIdProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_modelo_produto_produto " 
		+ " ,id_modelo_produto_ra " 
		+ " ,id_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ModeloProdutoProduto item) {
		return " id_modelo_produto_produto = '" + item.getIdModeloProdutoProduto() + "'  " 
		+ " , id_modelo_produto_ra = " + item.getIdModeloProdutoRa() + "  "
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ModeloProdutoProduto item) {
		return " id_modelo_produto_produto = '" + item.getIdModeloProdutoProduto() + "'  " 
		+ " , id_modelo_produto_ra = " + item.getIdModeloProdutoRa() + "  " 
		+ " , id_produto_ra = " + item.getIdProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	@Override
	public ModeloProdutoProduto obtemPorRel(long idModeloProdutoRa, long idProdutoRa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_modelo_produto_ra = " + idModeloProdutoRa + 
				" and id_produto_ra = " + idProdutoRa;
		return (ModeloProdutoProduto) this.getObjeto(sql);
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteAModeloProduto(long id) throws DaoException{ // Padrao
	public List ListaPorModeloProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ProdutoDaoBase.tabelaSelect() +
            " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " +
            tabelaSelect() + ".id_produto_ra" +
            " where id_modelo_produto_ra = " + id + " " +
            criterioExclusaoModeloProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ModeloProdutoProdutoMontador(),null);
        montador.adicionaMontador(new ProdutoMontador(), "ProdutoReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteAModeloProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_modelo_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoModeloProdutoReferenteA() {
		return "";
	}
	
	//public List getPorReferenteAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	ModeloProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + ModeloProdutoDaoBase.tabelaSelect() +
            " on " + ModeloProdutoDaoBase.tabelaSelect() + ".id_modelo_produto = " +
            tabelaSelect() + ".id_modelo_produto_ra" +
            " where id_produto_ra = " + id + " " +
            criterioExclusaoProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ModeloProdutoProdutoMontador(),null);
        montador.adicionaMontador(new ModeloProdutoMontador(), "ModeloProdutoReferenteA");
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
	
	private boolean _obtemModeloProduto_ReferenteA = false;
	public void setObtemModeloProduto_ReferenteA() {
		_obtemModeloProduto_ReferenteA = true;
	}
	protected String outterJoinModeloProduto_ReferenteA() {
		return " left outer join " + ModeloProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoDaoBase.tabelaSelect() + ".id_modelo_produto = " + tabelaSelect() + ".id_modelo_produto_ra ";  
	}
	public boolean atualizaReferenteAModeloProduto(long idModeloProdutoProduto, long idModeloProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_modelo_produto_ra  = " + idModeloProdutoRa +
        " where id_modelo_produto_produto = " +  idModeloProdutoProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinModeloProduto_ReferenteA() {
		return " inner join " + ModeloProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoDaoBase.tabelaSelect() + ".id_modelo_produto = " + tabelaSelect() + ".id_modelo_produto_ra ";  
	}
	
 	
	private boolean _obtemProduto_ReferenteA = false;
	public void setObtemProduto_ReferenteA() {
		_obtemProduto_ReferenteA = true;
	}
	protected String outterJoinProduto_ReferenteA() {
		return " left outer join " + ProdutoDaoBase.tabelaSelect() + " on " + ProdutoDaoBase.tabelaSelect() + ".id_produto = " + tabelaSelect() + ".id_produto_ra ";  
	}
	public boolean atualizaReferenteAProduto(long idModeloProdutoProduto, long idProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_ra  = " + idProdutoRa +
        " where id_modelo_produto_produto = " +  idModeloProdutoProduto;
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
		saida += (this._obtemModeloProduto_ReferenteA?" , " +ModeloProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemProduto_ReferenteA?" , " +ProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemModeloProduto_ReferenteA = false;
		_obtemProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemModeloProduto_ReferenteA? outterJoinModeloProduto_ReferenteA() + " ":"");
		saida += (this._obtemProduto_ReferenteA? outterJoinProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ModeloProdutoProdutoMontador(), null);
		if (this._obtemModeloProduto_ReferenteA)
            montador.adicionaMontador(new ModeloProdutoMontador(), "ModeloProduto_ReferenteA");
		if (this._obtemProduto_ReferenteA)
            montador.adicionaMontador(new ProdutoMontador(), "Produto_ReferenteA");
         return montador;
    }
	
	
}
