package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.regracolecao.filtro.NaturezaProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class NaturezaProdutoDaoBase extends DaoAplicacao implements NaturezaProdutoDaoBaseI {
	
	
	public NaturezaProdutoDaoBase() {
		super();
	}
	public NaturezaProdutoDaoBase(DataFonte dataSource) {
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
		return new NaturezaProdutoMontador();
	}
	public static String tabelaSelect() {
		return " natureza_produto" ;
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
		return " order by " + tabelaSelect() + ".nome_natureza_produto " ;
	}
	
	
	public static String camposOrdenados() {
		return " natureza_produto.id_natureza_produto " 
		+ " ,natureza_produto.nome_natureza_produto " 
		+ " ,natureza_produto.codigo_natureza_produto " 
		+ " ,natureza_produto.id_app_produto_ap " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_natureza_produto " 
		+ " , " + nomeTabela + ".nome_natureza_produto " 
		+ " , " + nomeTabela + ".codigo_natureza_produto " 
		+ " , " + nomeTabela + ".id_app_produto_ap " 
		;
	}
	
	
	@Override
	public void insereItem(NaturezaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(NaturezaProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(NaturezaProduto item) throws DaoException {
		NaturezaProduto teste = this.obtemPorChave(item.getIdNaturezaProduto());
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
	public void insereItemLoad(NaturezaProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_natureza_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdNaturezaProduto(id);	
	}
	@Override
	public void alteraItem(NaturezaProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_natureza_produto = " + item.getIdNaturezaProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(NaturezaProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_natureza_produto = " + item.getIdNaturezaProduto();
		executaSql(query);
	}
	@Override
	public NaturezaProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_natureza_produto = " + id;
        return (NaturezaProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(NaturezaProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( NaturezaProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoAppProdutoAtendidoPor() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_app_produto_ap = " + filtro.getCodigoAppProdutoAtendidoPor();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(NaturezaProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(NaturezaProduto item) {
		return " ( '" + item.getIdNaturezaProduto() + "'  " 
		+ " ,'" + item.getNomeNaturezaProduto() + "'  "
		+ " ,'" + item.getCodigoNaturezaProduto() + "'  "
		+ " ," + item.getIdAppProdutoAp() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_natureza_produto " 
		+ " ,nome_natureza_produto " 
		+ " ,codigo_natureza_produto " 
		+ " ,id_app_produto_ap " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(NaturezaProduto item) {
		return " id_natureza_produto = '" + item.getIdNaturezaProduto() + "'  " 
		+ " , nome_natureza_produto = '" + item.getNomeNaturezaProduto() + "'  "
		+ " , codigo_natureza_produto = '" + item.getCodigoNaturezaProduto() + "'  "
		+ " , id_app_produto_ap = " + item.getIdAppProdutoAp() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(NaturezaProduto item) {
		return " id_natureza_produto = '" + item.getIdNaturezaProduto() + "'  " 
		+ " , nome_natureza_produto = '" + item.getNomeNaturezaProduto() + "'  " 
		+ " , codigo_natureza_produto = '" + item.getCodigoNaturezaProduto() + "'  " 
		+ " , id_app_produto_ap = " + item.getIdAppProdutoAp() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public NaturezaProduto obtemPorCategoriaLojaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaLoja_Possui() + 
			" where id_categoria_loja = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaLoja_Possui() {
		return " inner join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinCategoriaLoja_Possui() {
		return " left outer join " + CategoriaLojaDaoBase.tabelaSelect() + " on " + CategoriaLojaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorLojaNaturezaEncontrada(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinLojaNatureza_Encontrada() + 
			" where id_loja_natureza = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinLojaNatureza_Encontrada() {
		return " inner join " + LojaNaturezaDaoBase.tabelaSelect() + " on " + LojaNaturezaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinLojaNatureza_Encontrada() {
		return " left outer join " + LojaNaturezaDaoBase.tabelaSelect() + " on " + LojaNaturezaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorOportunidadeDiaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOportunidadeDia_Possui() + 
			" where id_oportunidade_dia = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinOportunidadeDia_Possui() {
		return " inner join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_natureza_produto_pa = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinOportunidadeDia_Possui() {
		return " left outer join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_natureza_produto_pa = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorUsuarioPesquisaPesquisadoPor(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinUsuarioPesquisa_PesquisadoPor() + 
			" where id_usuario_pesquisa = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinUsuarioPesquisa_PesquisadoPor() {
		return " inner join " + UsuarioPesquisaDaoBase.tabelaSelect() + " on " + UsuarioPesquisaDaoBase.tabelaSelect() + ".id_natureza_produto_p = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinUsuarioPesquisa_PesquisadoPor() {
		return " left outer join " + UsuarioPesquisaDaoBase.tabelaSelect() + " on " + UsuarioPesquisaDaoBase.tabelaSelect() + ".id_natureza_produto_p = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorContagemProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinContagemProduto_Possui() + 
			" where id_contagem_produto = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinContagemProduto_Possui() {
		return " inner join " + ContagemProdutoDaoBase.tabelaSelect() + " on " + ContagemProdutoDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinContagemProduto_Possui() {
		return " left outer join " + ContagemProdutoDaoBase.tabelaSelect() + " on " + ContagemProdutoDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorPalavraChavePesquisaPodePesquisar(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPalavraChavePesquisa_PodePesquisar() + 
			" where id_palavra_chave_pesquisa = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinPalavraChavePesquisa_PodePesquisar() {
		return " inner join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinPalavraChavePesquisa_PodePesquisar() {
		return " left outer join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	/*
	public NaturezaProduto obtemPorProdutoClientePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProdutoCliente_Possui() + 
			" where id_produto_cliente = " + id;
		return (NaturezaProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinProdutoCliente_Possui() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
	public static String outerJoinProdutoCliente_Possui() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_natureza_produto_ra = " + tabelaSelect() + ".id_natureza_produto ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorAtendidoPorAppProduto(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_app_produto_ap = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorAppProdutoAtendidoPor(long id) throws DaoException {
		return getPorAtendidoPorAppProduto(id);
	}
	public boolean excluiPorAtendidoPorAppProduto(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_app_produto_ap = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinAppProduto_AtendidoPor() {
	//	return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_natureza_produto_a = " + tabelaSelect() + ".id_natureza_produto ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemAppProduto_AtendidoPor = false;
	public void setObtemAppProduto_AtendidoPor() {
		_obtemAppProduto_AtendidoPor = true;
	}
	protected String outterJoinAppProduto_AtendidoPor() {
		return " left outer join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_ap ";  
	}
	public boolean atualizaAtendidoPorAppProduto(long idNaturezaProduto, long idAppProdutoAp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_app_produto_ap  = " + idAppProdutoAp +
        " where id_natureza_produto = " +  idNaturezaProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinAppProduto_AtendidoPor() {
		return " inner join " + AppProdutoDaoBase.tabelaSelect() + " on " + AppProdutoDaoBase.tabelaSelect() + ".id_app_produto = " + tabelaSelect() + ".id_app_produto_ap ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemAppProduto_AtendidoPor?" , " +AppProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemAppProduto_AtendidoPor = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemAppProduto_AtendidoPor? outterJoinAppProduto_AtendidoPor() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new NaturezaProdutoMontador(), null);
		if (this._obtemAppProduto_AtendidoPor)
            montador.adicionaMontador(new AppProdutoMontador(), "AppProduto_AtendidoPor");
         return montador;
    }
	
	
}
