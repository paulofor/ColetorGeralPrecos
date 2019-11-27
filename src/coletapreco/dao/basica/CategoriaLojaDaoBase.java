package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.regracolecao.filtro.CategoriaLojaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CategoriaLojaDaoBase extends DaoAplicacao implements CategoriaLojaDaoBaseI {
	
	
	public CategoriaLojaDaoBase() {
		super();
	}
	public CategoriaLojaDaoBase(DataFonte dataSource) {
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
		return new CategoriaLojaMontador();
	}
	public static String tabelaSelect() {
		return " categoria_loja" ;
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
		return " order by " + tabelaSelect() + ".nome " ;
	}
	
	
	public static String camposOrdenados() {
		return " categoria_loja.id_categoria_loja " 
		+ " ,categoria_loja.nome " 
		+ " ,categoria_loja.url " 
		+ " , DATE_FORMAT(categoria_loja.data_inclusao,'%d-%m-%Y') " 
		+ " ,categoria_loja.id_categoria_loja_p " 
		+ " ,categoria_loja.id_natureza_produto_ra " 
		+ " ,categoria_loja.id_loja_virtual_pa " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_categoria_loja " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".url " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_categoria_loja_p " 
		+ " , " + nomeTabela + ".id_natureza_produto_ra " 
		+ " , " + nomeTabela + ".id_loja_virtual_pa " 
		;
	}
	
	
	@Override
	public void insereItem(CategoriaLoja item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CategoriaLoja item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CategoriaLoja item) throws DaoException {
		CategoriaLoja teste = this.obtemPorChave(item.getIdCategoriaLoja());
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
	public void insereItemLoad(CategoriaLoja item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_categoria_loja) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCategoriaLoja(id);	
	}
	@Override
	public void alteraItem(CategoriaLoja item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_categoria_loja = " + item.getIdCategoriaLoja();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CategoriaLoja item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_categoria_loja = " + item.getIdCategoriaLoja();
		executaSql(query);
	}
	@Override
	public CategoriaLoja obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_categoria_loja = " + id;
        return (CategoriaLoja) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CategoriaLojaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CategoriaLojaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoCategoriaLojaFilho() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_categoria_loja_p = " + filtro.getCodigoCategoriaLojaFilho();
      	}
      	
		if (filtro.getCodigoNaturezaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_ra = " + filtro.getCodigoNaturezaProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoLojaVirtualPertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_loja_virtual_pa = " + filtro.getCodigoLojaVirtualPertenceA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CategoriaLojaFiltro filtro)
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
	
	
	protected String valoresInsert(CategoriaLoja item) {
		return " ( '" + item.getIdCategoriaLoja() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ," + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " ," + item.getIdCategoriaLojaF() + "  "
		+ " ," + item.getIdNaturezaProdutoRa() + "  "
		+ " ," + item.getIdLojaVirtualPa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_categoria_loja " 
		+ " ,nome " 
		+ " ,url " 
		+ " ,data_inclusao " 
		+ " ,id_categoria_loja_p " 
		+ " ,id_natureza_produto_ra " 
		+ " ,id_loja_virtual_pa " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CategoriaLoja item) {
		return " id_categoria_loja = '" + item.getIdCategoriaLoja() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , url = '" + item.getUrl() + "'  "
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " , id_categoria_loja_p = " + item.getIdCategoriaLojaF() + "  "
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  "
		+ " , id_loja_virtual_pa = " + item.getIdLojaVirtualPa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CategoriaLoja item) {
		return " id_categoria_loja = '" + item.getIdCategoriaLoja() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , url = '" + item.getUrl() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  " 
		+ " , id_categoria_loja_p = " + item.getIdCategoriaLojaF() + "  " 
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  " 
		+ " , id_loja_virtual_pa = " + item.getIdLojaVirtualPa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public CategoriaLoja obtemPorCategoriaLojaProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaLojaProduto_Possui() + 
			" where id_categoria_loja_produto = " + id;
		return (CategoriaLoja) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaLojaProduto_Possui() {
		return " inner join " + CategoriaLojaProdutoDaoBase.tabelaSelect() + " on " + CategoriaLojaProdutoDaoBase.tabelaSelect() + ".id_categoria_loja_ra = " + tabelaSelect() + ".id_categoria_loja ";  
	}
	public static String outerJoinCategoriaLojaProduto_Possui() {
		return " left outer join " + CategoriaLojaProdutoDaoBase.tabelaSelect() + " on " + CategoriaLojaProdutoDaoBase.tabelaSelect() + ".id_categoria_loja_ra = " + tabelaSelect() + ".id_categoria_loja ";  
	}
 	
	/*
	public CategoriaLoja obtemPorCategoriaLojaFilho(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaLoja_Filho() + 
			" where id_categoria_loja = " + id;
		return (CategoriaLoja) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaLoja_Filho() {
		return " inner join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja_p = " + tabelaSelect() + ".id_categoria_loja ";  
	}
	public static String outerJoinCategoriaLoja_Filho() {
		return " left outer join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja_p = " + tabelaSelect() + ".id_categoria_loja ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorFilhoCategoriaLoja(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_categoria_loja_p = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorCategoriaLojaFilho(long id) throws DaoException {
		return getPorFilhoCategoriaLoja(id);
	}
	public boolean excluiPorFilhoCategoriaLoja(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_categoria_loja_p = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinCategoriaLoja_Filho() {
	//	return " inner join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja_p = " + tabelaSelect() + ".id_categoria_loja ";  
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
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_categoria_loja_p = " + tabelaSelect() + ".id_categoria_loja ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceALojaVirtual(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_loja_virtual_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorLojaVirtualPertenceA(long id) throws DaoException {
		return getPorPertenceALojaVirtual(id);
	}
	public boolean excluiPorPertenceALojaVirtual(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_loja_virtual_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinLojaVirtual_PertenceA() {
	//	return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_categoria_loja_p = " + tabelaSelect() + ".id_categoria_loja ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemCategoriaLoja_Filho = false;
	public void setObtemCategoriaLoja_Filho() {
		_obtemCategoriaLoja_Filho = true;
	}
	protected String outterJoinCategoriaLoja_Filho() {
		return " left outer join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_categoria_loja = " + tabelaSelect() + ".id_categoria_loja_p ";  
	}
	public boolean atualizaFilhoCategoriaLoja(long idCategoriaLoja, long idCategoriaLojaP) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_categoria_loja_p  = " + idCategoriaLojaP +
        " where id_categoria_loja = " +  idCategoriaLoja;
       	this.executaSql(sql);
       	return true;
	}
	
 	
	private boolean _obtemNaturezaProduto_ReferenteA = false;
	public void setObtemNaturezaProduto_ReferenteA() {
		_obtemNaturezaProduto_ReferenteA = true;
	}
	protected String outterJoinNaturezaProduto_ReferenteA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	public boolean atualizaReferenteANaturezaProduto(long idCategoriaLoja, long idNaturezaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_ra  = " + idNaturezaProdutoRa +
        " where id_categoria_loja = " +  idCategoriaLoja;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_ReferenteA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	
 	
	private boolean _obtemLojaVirtual_PertenceA = false;
	public void setObtemLojaVirtual_PertenceA() {
		_obtemLojaVirtual_PertenceA = true;
	}
	protected String outterJoinLojaVirtual_PertenceA() {
		return " left outer join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_pa ";  
	}
	public boolean atualizaPertenceALojaVirtual(long idCategoriaLoja, long idLojaVirtualPa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_loja_virtual_pa  = " + idLojaVirtualPa +
        " where id_categoria_loja = " +  idCategoriaLoja;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinLojaVirtual_PertenceA() {
		return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_pa ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemCategoriaLoja_Filho?" , " +CategoriaLojaDaoBase.camposOrdenados():"");
		saida += (this._obtemNaturezaProduto_ReferenteA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemLojaVirtual_PertenceA?" , " +LojaVirtualDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemCategoriaLoja_Filho = false;
		_obtemNaturezaProduto_ReferenteA = false;
		_obtemLojaVirtual_PertenceA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemCategoriaLoja_Filho? outterJoinCategoriaLoja_Filho() + " ":"");
		saida += (this._obtemNaturezaProduto_ReferenteA? outterJoinNaturezaProduto_ReferenteA() + " ":"");
		saida += (this._obtemLojaVirtual_PertenceA? outterJoinLojaVirtual_PertenceA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CategoriaLojaMontador(), null);
		if (this._obtemCategoriaLoja_Filho)
            montador.adicionaMontador(new CategoriaLojaMontador(), "CategoriaLoja_Filho");
		if (this._obtemNaturezaProduto_ReferenteA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_ReferenteA");
		if (this._obtemLojaVirtual_PertenceA)
            montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtual_PertenceA");
         return montador;
    }
	
	
}
