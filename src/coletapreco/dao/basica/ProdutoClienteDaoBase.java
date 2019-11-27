package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.ProdutoCliente;
import coletapreco.regracolecao.filtro.ProdutoClienteFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ProdutoClienteDaoBase extends DaoAplicacao implements ProdutoClienteDaoBaseI {
	
	
	public ProdutoClienteDaoBase() {
		super();
	}
	public ProdutoClienteDaoBase(DataFonte dataSource) {
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
		return new ProdutoClienteMontador();
	}
	public static String tabelaSelect() {
		return " produto_cliente" ;
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
		return " produto_cliente.id_produto_cliente " 
		+ " ,produto_cliente.nome " 
		+ " ,produto_cliente.posicao_produto " 
		+ " ,produto_cliente.imagem " 
		+ " ,produto_cliente.preco_atual " 
		+ " ,produto_cliente.marca " 
		+ " ,produto_cliente.loja " 
		+ " , DATE_FORMAT(produto_cliente.data,'%d-%m-%Y') " 
		+ " ,produto_cliente.url " 
		+ " ,produto_cliente.detalhe " 
		+ " ,produto_cliente.id_natureza_produto_ra " 
		+ " ,produto_cliente.id_usuario_s " 
		+ " ,produto_cliente.id_palavra_chave_pesquisa_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_produto_cliente " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".imagem " 
		+ " , " + nomeTabela + ".preco_atual " 
		+ " , " + nomeTabela + ".marca " 
		+ " , " + nomeTabela + ".loja " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".url " 
		+ " , " + nomeTabela + ".detalhe " 
		+ " , " + nomeTabela + ".id_natureza_produto_ra " 
		+ " , " + nomeTabela + ".id_usuario_s " 
		+ " , " + nomeTabela + ".id_palavra_chave_pesquisa_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ProdutoCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ProdutoCliente item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ProdutoCliente item) throws DaoException {
		ProdutoCliente teste = this.obtemPorChave(item.getIdProdutoCliente());
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
	public void insereItemLoad(ProdutoCliente item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_produto_cliente) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdProdutoCliente(id);	
	}
	@Override
	public void alteraItem(ProdutoCliente item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_produto_cliente = " + item.getIdProdutoCliente();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ProdutoCliente item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_produto_cliente = " + item.getIdProdutoCliente();
		executaSql(query);
	}
	@Override
	public ProdutoCliente obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_produto_cliente = " + id;
        return (ProdutoCliente) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ProdutoClienteFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ProdutoClienteFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoNaturezaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_ra = " + filtro.getCodigoNaturezaProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoPalavraChavePesquisaReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_palavra_chave_pesquisa_ra = " + filtro.getCodigoPalavraChavePesquisaReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ProdutoClienteFiltro filtro)
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
	
	
	protected String valoresInsert(ProdutoCliente item) {
		return " ( '" + item.getIdProdutoCliente() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ,'" + item.getImagem() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  "
		+ " ,'" + item.getMarca() + "'  "
		+ " ,'" + item.getLoja() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ,'" + item.getDetalhe() + "'  "
		+ " ," + item.getIdNaturezaProdutoRa() + "  "
		+ " ," + item.getIdUsuarioS() + "  "
		+ " ," + item.getIdPalavraChavePesquisaRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_produto_cliente " 
		+ " ,nome " 
		+ " ,posicao_produto " 
		+ " ,imagem " 
		+ " ,preco_atual " 
		+ " ,marca " 
		+ " ,loja " 
		+ " ,data " 
		+ " ,url " 
		+ " ,detalhe " 
		+ " ,id_natureza_produto_ra " 
		+ " ,id_usuario_s " 
		+ " ,id_palavra_chave_pesquisa_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ProdutoCliente item) {
		return " id_produto_cliente = '" + item.getIdProdutoCliente() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , imagem = '" + item.getImagem() + "'  "
		+ " , preco_atual = '" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  "
		+ " , marca = '" + item.getMarca() + "'  "
		+ " , loja = '" + item.getLoja() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , url = '" + item.getUrl() + "'  "
		+ " , detalhe = '" + item.getDetalhe() + "'  "
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  "
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  "
		+ " , id_palavra_chave_pesquisa_ra = " + item.getIdPalavraChavePesquisaRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ProdutoCliente item) {
		return " id_produto_cliente = '" + item.getIdProdutoCliente() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , imagem = '" + item.getImagem() + "'  " 
		+ " , preco_atual = '" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  " 
		+ " , marca = '" + item.getMarca() + "'  " 
		+ " , loja = '" + item.getLoja() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , url = '" + item.getUrl() + "'  " 
		+ " , detalhe = '" + item.getDetalhe() + "'  " 
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  " 
		+ " , id_palavra_chave_pesquisa_ra = " + item.getIdPalavraChavePesquisaRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public ProdutoCliente obtemPorInteresseProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinInteresseProduto_Possui() + 
			" where id_interesse_produto = " + id;
		return (ProdutoCliente) getObjeto(sql);
	}
	*/
	public static String innerJoinInteresseProduto_Possui() {
		return " inner join " + InteresseProdutoDaoBase.tabelaSelect() + " on " + InteresseProdutoDaoBase.tabelaSelect() + ".id_produto_cliente_ra = " + tabelaSelect() + ".id_produto_cliente ";  
	}
	public static String outerJoinInteresseProduto_Possui() {
		return " left outer join " + InteresseProdutoDaoBase.tabelaSelect() + " on " + InteresseProdutoDaoBase.tabelaSelect() + ".id_produto_cliente_ra = " + tabelaSelect() + ".id_produto_cliente ";  
	}
 	
	/*
	public ProdutoCliente obtemPorPrecoDiarioClientePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoDiarioCliente_Possui() + 
			" where id_preco_diario_clientte = " + id;
		return (ProdutoCliente) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoDiarioCliente_Possui() {
		return " inner join " + PrecoDiarioClienteDaoBase.tabelaSelect() + " on " + PrecoDiarioClienteDaoBase.tabelaSelect() + ".id_produto_cliente_pa = " + tabelaSelect() + ".id_produto_cliente ";  
	}
	public static String outerJoinPrecoDiarioCliente_Possui() {
		return " left outer join " + PrecoDiarioClienteDaoBase.tabelaSelect() + " on " + PrecoDiarioClienteDaoBase.tabelaSelect() + ".id_produto_cliente_pa = " + tabelaSelect() + ".id_produto_cliente ";  
	}
 	
	/*
	public ProdutoCliente obtemPorOportunidadeInteresseClientePossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOportunidadeInteresseCliente_Possui() + 
			" where id_oportunidade_interesse_cliente = " + id;
		return (ProdutoCliente) getObjeto(sql);
	}
	*/
	public static String innerJoinOportunidadeInteresseCliente_Possui() {
		return " inner join " + OportunidadeInteresseClienteDaoBase.tabelaSelect() + " on " + OportunidadeInteresseClienteDaoBase.tabelaSelect() + ".id_produto_cliente_pa = " + tabelaSelect() + ".id_produto_cliente ";  
	}
	public static String outerJoinOportunidadeInteresseCliente_Possui() {
		return " left outer join " + OportunidadeInteresseClienteDaoBase.tabelaSelect() + " on " + OportunidadeInteresseClienteDaoBase.tabelaSelect() + ".id_produto_cliente_pa = " + tabelaSelect() + ".id_produto_cliente ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
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
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_produto_cliente_p = " + tabelaSelect() + ".id_produto_cliente ";  
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
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_produto_cliente_s = " + tabelaSelect() + ".id_produto_cliente ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAPalavraChavePesquisa(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_palavra_chave_pesquisa_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorPalavraChavePesquisaReferenteA(long id) throws DaoException {
		return getPorReferenteAPalavraChavePesquisa(id);
	}
	public boolean excluiPorReferenteAPalavraChavePesquisa(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_palavra_chave_pesquisa_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinPalavraChavePesquisa_ReferenteA() {
	//	return " inner join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_produto_cliente_g = " + tabelaSelect() + ".id_produto_cliente ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemNaturezaProduto_ReferenteA = false;
	public void setObtemNaturezaProduto_ReferenteA() {
		_obtemNaturezaProduto_ReferenteA = true;
	}
	protected String outterJoinNaturezaProduto_ReferenteA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	public boolean atualizaReferenteANaturezaProduto(long idProdutoCliente, long idNaturezaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_ra  = " + idNaturezaProdutoRa +
        " where id_produto_cliente = " +  idProdutoCliente;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_ReferenteA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	
 	
	private boolean _obtemUsuario_Sincroniza = false;
	public void setObtemUsuario_Sincroniza() {
		_obtemUsuario_Sincroniza = true;
	}
	protected String outterJoinUsuario_Sincroniza() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	public boolean atualizaSincronizaUsuario(long idProdutoCliente, long idUsuarioS) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_s  = " + idUsuarioS +
        " where id_produto_cliente = " +  idProdutoCliente;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_Sincroniza() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	
 	
	private boolean _obtemPalavraChavePesquisa_ReferenteA = false;
	public void setObtemPalavraChavePesquisa_ReferenteA() {
		_obtemPalavraChavePesquisa_ReferenteA = true;
	}
	protected String outterJoinPalavraChavePesquisa_ReferenteA() {
		return " left outer join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa = " + tabelaSelect() + ".id_palavra_chave_pesquisa_ra ";  
	}
	public boolean atualizaReferenteAPalavraChavePesquisa(long idProdutoCliente, long idPalavraChavePesquisaRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_palavra_chave_pesquisa_ra  = " + idPalavraChavePesquisaRa +
        " where id_produto_cliente = " +  idProdutoCliente;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinPalavraChavePesquisa_ReferenteA() {
		return " inner join " + PalavraChavePesquisaDaoBase.tabelaSelect() + " on " + PalavraChavePesquisaDaoBase.tabelaSelect() + ".id_palavra_chave_pesquisa = " + tabelaSelect() + ".id_palavra_chave_pesquisa_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemNaturezaProduto_ReferenteA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemPalavraChavePesquisa_ReferenteA?" , " +PalavraChavePesquisaDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemNaturezaProduto_ReferenteA = false;
		_obtemPalavraChavePesquisa_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemNaturezaProduto_ReferenteA? outterJoinNaturezaProduto_ReferenteA() + " ":"");
		saida += (this._obtemPalavraChavePesquisa_ReferenteA? outterJoinPalavraChavePesquisa_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ProdutoClienteMontador(), null);
		if (this._obtemNaturezaProduto_ReferenteA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_ReferenteA");
		if (this._obtemPalavraChavePesquisa_ReferenteA)
            montador.adicionaMontador(new PalavraChavePesquisaMontador(), "PalavraChavePesquisa_ReferenteA");
         return montador;
    }
	
	
}
