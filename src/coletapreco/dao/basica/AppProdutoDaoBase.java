package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.AppProduto;
import coletapreco.regracolecao.filtro.AppProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class AppProdutoDaoBase extends DaoAplicacao implements AppProdutoDaoBaseI {
	
	
	public AppProdutoDaoBase() {
		super();
	}
	public AppProdutoDaoBase(DataFonte dataSource) {
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
		return new AppProdutoMontador();
	}
	public static String tabelaSelect() {
		return " app_produto" ;
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
		return " app_produto.id_app_produto " 
		+ " ,app_produto.nome " 
		+ " ,app_produto.url_instalacao " 
		+ " ,app_produto.possui_vitrine " 
		+ " ,app_produto.ativo " 
		+ " ,app_produto.status " 
		+ " ,app_produto.limite_posicionador " 
		+ " ,app_produto.possui_palavra_chave " 
		+ " ,app_produto.codigo_hash " 
		+ " ,app_produto.api_key " 
		+ " ,app_produto.dias_preco_vitrine " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_app_produto " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".url_instalacao " 
		+ " , " + nomeTabela + ".possui_vitrine " 
		+ " , " + nomeTabela + ".ativo " 
		+ " , " + nomeTabela + ".status " 
		+ " , " + nomeTabela + ".limite_posicionador " 
		+ " , " + nomeTabela + ".possui_palavra_chave " 
		+ " , " + nomeTabela + ".codigo_hash " 
		+ " , " + nomeTabela + ".api_key " 
		+ " , " + nomeTabela + ".dias_preco_vitrine " 
		;
	}
	
	
	@Override
	public void insereItem(AppProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(AppProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(AppProduto item) throws DaoException {
		AppProduto teste = this.obtemPorChave(item.getIdAppProduto());
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
	public void insereItemLoad(AppProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_app_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdAppProduto(id);	
	}
	@Override
	public void alteraItem(AppProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_app_produto = " + item.getIdAppProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(AppProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_app_produto = " + item.getIdAppProduto();
		executaSql(query);
	}
	@Override
	public AppProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_app_produto = " + id;
        return (AppProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(AppProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( AppProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(AppProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(AppProduto item) {
		return " ( '" + item.getIdAppProduto() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getUrlInstalacao() + "'  "
		+ " ,'" + (item.getPossuiVitrine()?"S":"N") + "'  "
		+ " ,'" + (item.getAtivo()?"S":"N") + "'  "
		+ " ,'" + item.getStatus() + "'  "
		+ " ,'" + item.getLimitePosicionador() + "'  "
		+ " ,'" + (item.getPossuiPalavraChave()?"S":"N") + "'  "
		+ " ,'" + item.getCodigoHash() + "'  "
		+ " ,'" + item.getApiKey() + "'  "
		+ " ,'" + item.getDiasPrecoVitrine() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_app_produto " 
		+ " ,nome " 
		+ " ,url_instalacao " 
		+ " ,possui_vitrine " 
		+ " ,ativo " 
		+ " ,status " 
		+ " ,limite_posicionador " 
		+ " ,possui_palavra_chave " 
		+ " ,codigo_hash " 
		+ " ,api_key " 
		+ " ,dias_preco_vitrine " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(AppProduto item) {
		return " id_app_produto = '" + item.getIdAppProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , url_instalacao = '" + item.getUrlInstalacao() + "'  "
		+ " , possui_vitrine = '" + (item.getPossuiVitrine()?"S":"N") + "'  "
		+ " , ativo = '" + (item.getAtivo()?"S":"N") + "'  "
		+ " , status = '" + item.getStatus() + "'  "
		+ " , limite_posicionador = '" + item.getLimitePosicionador() + "'  "
		+ " , possui_palavra_chave = '" + (item.getPossuiPalavraChave()?"S":"N") + "'  "
		+ " , codigo_hash = '" + item.getCodigoHash() + "'  "
		+ " , api_key = '" + item.getApiKey() + "'  "
		+ " , dias_preco_vitrine = '" + item.getDiasPrecoVitrine() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(AppProduto item) {
		return " id_app_produto = '" + item.getIdAppProduto() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , url_instalacao = '" + item.getUrlInstalacao() + "'  " 
		+ " , possui_vitrine = '" + (item.getPossuiVitrine()?"S":"N") + "'  " 
		+ " , ativo = '" + (item.getAtivo()?"S":"N") + "'  " 
		+ " , status = '" + item.getStatus() + "'  " 
		+ " , limite_posicionador = '" + item.getLimitePosicionador() + "'  " 
		+ " , possui_palavra_chave = '" + (item.getPossuiPalavraChave()?"S":"N") + "'  " 
		+ " , codigo_hash = '" + item.getCodigoHash() + "'  " 
		+ " , api_key = '" + item.getApiKey() + "'  " 
		+ " , dias_preco_vitrine = '" + item.getDiasPrecoVitrine() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public AppProduto obtemPorFacebookFanpageDivulgadoPor(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookFanpage_DivulgadoPor() + 
			" where id_facebook_fanpage = " + id;
		return (AppProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookFanpage_DivulgadoPor() {
		return " inner join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_app_produto_d = " + tabelaSelect() + ".id_app_produto ";  
	}
	public static String outerJoinFacebookFanpage_DivulgadoPor() {
		return " left outer join " + FacebookFanpageDaoBase.tabelaSelect() + " on " + FacebookFanpageDaoBase.tabelaSelect() + ".id_app_produto_d = " + tabelaSelect() + ".id_app_produto ";  
	}
 	
	/*
	public AppProduto obtemPorNaturezaProdutoAtende(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinNaturezaProduto_Atende() + 
			" where id_natureza_produto = " + id;
		return (AppProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinNaturezaProduto_Atende() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_app_produto_ap = " + tabelaSelect() + ".id_app_produto ";  
	}
	public static String outerJoinNaturezaProduto_Atende() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_app_produto_ap = " + tabelaSelect() + ".id_app_produto ";  
	}
 	
	/*
	public AppProduto obtemPorDispositivoUsuarioUsadoPor(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinDispositivoUsuario_UsadoPor() + 
			" where id_dispositivo_usuario = " + id;
		return (AppProduto) getObjeto(sql);
	}
	*/
	public static String innerJoinDispositivoUsuario_UsadoPor() {
		return " inner join " + DispositivoUsuarioDaoBase.tabelaSelect() + " on " + DispositivoUsuarioDaoBase.tabelaSelect() + ".id_app_produto_u = " + tabelaSelect() + ".id_app_produto ";  
	}
	public static String outerJoinDispositivoUsuario_UsadoPor() {
		return " left outer join " + DispositivoUsuarioDaoBase.tabelaSelect() + " on " + DispositivoUsuarioDaoBase.tabelaSelect() + ".id_app_produto_u = " + tabelaSelect() + ".id_app_produto ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
        return saida;
    }
    
    public void limpaObtem()
    {
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new AppProdutoMontador(), null);
         return montador;
    }
	
	
}
