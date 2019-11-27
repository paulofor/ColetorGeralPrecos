package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.Produto;
import coletapreco.regracolecao.filtro.ProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ProdutoDaoBase extends DaoAplicacao implements ProdutoDaoBaseI {
	
	
	public ProdutoDaoBase() {
		super();
	}
	public ProdutoDaoBase(DataFonte dataSource) {
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
		return new ProdutoMontador();
	}
	public static String tabelaSelect() {
		return " produto" ;
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
		return " produto.id_produto " 
		+ " ,produto.url_origem " 
		+ " ,produto.imagem_local " 
		+ " , DATE_FORMAT(produto.data_inclusao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,produto.url " 
		+ " ,produto.nome " 
		+ " ,produto.posicao_produto " 
		+ " ,produto.imagem " 
		+ " ,produto.verificacao_nome_ok " 
		+ " ,produto.id_loja_virtual_le " 
		+ " ,produto.id_marca_p " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_produto " 
		+ " , " + nomeTabela + ".url_origem " 
		+ " , " + nomeTabela + ".imagem_local " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".url " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".posicao_produto " 
		+ " , " + nomeTabela + ".imagem " 
		+ " , " + nomeTabela + ".verificacao_nome_ok " 
		+ " , " + nomeTabela + ".id_loja_virtual_le " 
		+ " , " + nomeTabela + ".id_marca_p " 
		;
	}
	
	
	@Override
	public void insereItem(Produto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Produto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Produto item) throws DaoException {
		Produto teste = this.obtemPorChave(item.getIdProduto());
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
	public void insereItemLoad(Produto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdProduto(id);	
	}
	@Override
	public void alteraItem(Produto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_produto = " + item.getIdProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Produto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_produto = " + item.getIdProduto();
		executaSql(query);
	}
	@Override
	public Produto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_produto = " + id;
        return (Produto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoLojaVirtualLidoEm() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_loja_virtual_le = " + filtro.getCodigoLojaVirtualLidoEm();
      	}
      	
		if (filtro.getCodigoMarcaPossui() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_marca_p = " + filtro.getCodigoMarcaPossui();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(Produto item) {
		return " ( '" + item.getIdProduto() + "'  " 
		+ " ,'" + item.getUrlOrigem() + "'  "
		+ " ,'" + item.getImagemLocal() + "'  "
		+ " ," + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  "
		+ " ,'" + item.getUrl() + "'  "
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getPosicaoProduto() + "'  "
		+ " ,'" + item.getImagem() + "'  "
		+ " ,'" + (item.getVerificacaoNomeOk()?"S":"N") + "'  "
		+ " ," + item.getIdLojaVirtualLe() + "  "
		+ " ," + item.getIdMarcaP() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_produto " 
		+ " ,url_origem " 
		+ " ,imagem_local " 
		+ " ,data_inclusao " 
		+ " ,url " 
		+ " ,nome " 
		+ " ,posicao_produto " 
		+ " ,imagem " 
		+ " ,verificacao_nome_ok " 
		+ " ,id_loja_virtual_le " 
		+ " ,id_marca_p " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Produto item) {
		return " id_produto = '" + item.getIdProduto() + "'  " 
		+ " , url_origem = '" + item.getUrlOrigem() + "'  "
		+ " , imagem_local = '" + item.getImagemLocal() + "'  "
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  "
		+ " , url = '" + item.getUrl() + "'  "
		+ " , nome = '" + item.getNome() + "'  "
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  "
		+ " , imagem = '" + item.getImagem() + "'  "
		+ " , verificacao_nome_ok = '" + (item.getVerificacaoNomeOk()?"S":"N") + "'  "
		+ " , id_loja_virtual_le = " + item.getIdLojaVirtualLe() + "  "
		+ " , id_marca_p = " + item.getIdMarcaP() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Produto item) {
		return " id_produto = '" + item.getIdProduto() + "'  " 
		+ " , url_origem = '" + item.getUrlOrigem() + "'  " 
		+ " , imagem_local = '" + item.getImagemLocal() + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataInclusao()) ) + "  " 
		+ " , url = '" + item.getUrl() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , posicao_produto = '" + item.getPosicaoProduto() + "'  " 
		+ " , imagem = '" + item.getImagem() + "'  " 
		+ " , verificacao_nome_ok = '" + (item.getVerificacaoNomeOk()?"S":"N") + "'  " 
		+ " , id_loja_virtual_le = " + item.getIdLojaVirtualLe() + "  " 
		+ " , id_marca_p = " + item.getIdMarcaP() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Produto obtemPorPrecoDiarioPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoDiario_Possui() + 
			" where id_preco_diario = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoDiario_Possui() {
		return " inner join " + PrecoDiarioDaoBase.tabelaSelect() + " on " + PrecoDiarioDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinPrecoDiario_Possui() {
		return " left outer join " + PrecoDiarioDaoBase.tabelaSelect() + " on " + PrecoDiarioDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorModeloProdutoProdutoReferenteA(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinModeloProdutoProduto_ReferenteA() + 
			" where id_modelo_produto_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinModeloProdutoProduto_ReferenteA() {
		return " inner join " + ModeloProdutoProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinModeloProdutoProduto_ReferenteA() {
		return " left outer join " + ModeloProdutoProdutoDaoBase.tabelaSelect() + " on " + ModeloProdutoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorPrecoProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPrecoProduto_Possui() + 
			" where id_preco_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinPrecoProduto_Possui() {
		return " inner join " + PrecoProdutoDaoBase.tabelaSelect() + " on " + PrecoProdutoDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinPrecoProduto_Possui() {
		return " left outer join " + PrecoProdutoDaoBase.tabelaSelect() + " on " + PrecoProdutoDaoBase.tabelaSelect() + ".id_produto_pa = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorCategoriaLojaProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCategoriaLojaProduto_Possui() + 
			" where id_categoria_loja_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinCategoriaLojaProduto_Possui() {
		return " inner join " + CategoriaLojaProdutoDaoBase.tabelaSelect() + " on " + CategoriaLojaProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinCategoriaLojaProduto_Possui() {
		return " left outer join " + CategoriaLojaProdutoDaoBase.tabelaSelect() + " on " + CategoriaLojaProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorOportunidadeDiaPodePossuir(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOportunidadeDia_PodePossuir() + 
			" where id_oportunidade_dia = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinOportunidadeDia_PodePossuir() {
		return " inner join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinOportunidadeDia_PodePossuir() {
		return " left outer join " + OportunidadeDiaDaoBase.tabelaSelect() + " on " + OportunidadeDiaDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorPalavraProdutoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinPalavraProduto_Possui() + 
			" where id_palavra_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinPalavraProduto_Possui() {
		return " inner join " + PalavraProdutoDaoBase.tabelaSelect() + " on " + PalavraProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinPalavraProduto_Possui() {
		return " left outer join " + PalavraProdutoDaoBase.tabelaSelect() + " on " + PalavraProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorFacebookPostDivulgadoPor(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinFacebookPost_DivulgadoPor() + 
			" where id_facebook_post = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinFacebookPost_DivulgadoPor() {
		return " inner join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_produto_d = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinFacebookPost_DivulgadoPor() {
		return " left outer join " + FacebookPostDaoBase.tabelaSelect() + " on " + FacebookPostDaoBase.tabelaSelect() + ".id_produto_d = " + tabelaSelect() + ".id_produto ";  
	}
 	
	/*
	public Produto obtemPorCompartilhamentoProdutoGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCompartilhamentoProduto_Gerou() + 
			" where id_compartilhamento_produto = " + id;
		return (Produto) getObjeto(sql);
	}
	*/
	public static String innerJoinCompartilhamentoProduto_Gerou() {
		return " inner join " + CompartilhamentoProdutoDaoBase.tabelaSelect() + " on " + CompartilhamentoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
	public static String outerJoinCompartilhamentoProduto_Gerou() {
		return " left outer join " + CompartilhamentoProdutoDaoBase.tabelaSelect() + " on " + CompartilhamentoProdutoDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorLidoEmLojaVirtual(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_loja_virtual_le = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorLojaVirtualLidoEm(long id) throws DaoException {
		return getPorLidoEmLojaVirtual(id);
	}
	public boolean excluiPorLidoEmLojaVirtual(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_loja_virtual_le = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinLojaVirtual_LidoEm() {
	//	return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_produto_p = " + tabelaSelect() + ".id_produto ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPossuiMarca(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_marca_p = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorMarcaPossui(long id) throws DaoException {
		return getPorPossuiMarca(id);
	}
	public boolean excluiPorPossuiMarca(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_marca_p = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinMarca_Possui() {
	//	return " inner join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_produto_ra = " + tabelaSelect() + ".id_produto ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemLojaVirtual_LidoEm = false;
	public void setObtemLojaVirtual_LidoEm() {
		_obtemLojaVirtual_LidoEm = true;
	}
	protected String outterJoinLojaVirtual_LidoEm() {
		return " left outer join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_le ";  
	}
	public boolean atualizaLidoEmLojaVirtual(long idProduto, long idLojaVirtualLe) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_loja_virtual_le  = " + idLojaVirtualLe +
        " where id_produto = " +  idProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinLojaVirtual_LidoEm() {
		return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_le ";  
	}
	
 	
	private boolean _obtemMarca_Possui = false;
	public void setObtemMarca_Possui() {
		_obtemMarca_Possui = true;
	}
	protected String outterJoinMarca_Possui() {
		return " left outer join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_marca = " + tabelaSelect() + ".id_marca_p ";  
	}
	public boolean atualizaPossuiMarca(long idProduto, long idMarcaP) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_marca_p  = " + idMarcaP +
        " where id_produto = " +  idProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinMarca_Possui() {
		return " inner join " + MarcaDaoBase.tabelaSelect() + " on " + MarcaDaoBase.tabelaSelect() + ".id_marca = " + tabelaSelect() + ".id_marca_p ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemLojaVirtual_LidoEm?" , " +LojaVirtualDaoBase.camposOrdenados():"");
		saida += (this._obtemMarca_Possui?" , " +MarcaDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemLojaVirtual_LidoEm = false;
		_obtemMarca_Possui = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemLojaVirtual_LidoEm? outterJoinLojaVirtual_LidoEm() + " ":"");
		saida += (this._obtemMarca_Possui? outterJoinMarca_Possui() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ProdutoMontador(), null);
		if (this._obtemLojaVirtual_LidoEm)
            montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtual_LidoEm");
		if (this._obtemMarca_Possui)
            montador.adicionaMontador(new MarcaMontador(), "Marca_Possui");
         return montador;
    }
	
	
}
