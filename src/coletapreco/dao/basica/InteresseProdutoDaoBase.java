package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.InteresseProduto;
import coletapreco.regracolecao.filtro.InteresseProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class InteresseProdutoDaoBase extends DaoAplicacao implements InteresseProdutoDaoBaseI {
	
	
	public InteresseProdutoDaoBase() {
		super();
	}
	public InteresseProdutoDaoBase(DataFonte dataSource) {
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
		return new InteresseProdutoMontador();
	}
	public static String tabelaSelect() {
		return " interesse_produto" ;
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
		return " order by " + tabelaSelect() + ".data " ;
	}
	
	
	public static String camposOrdenados() {
		return " interesse_produto.id_interesse_produto " 
		+ " ,interesse_produto.nota " 
		+ " , DATE_FORMAT(interesse_produto.data,'%d-%m-%Y %H:%i:%s') " 
		+ " ,interesse_produto.valor " 
		+ " ,interesse_produto.espera " 
		+ " ,interesse_produto.monitora " 
		+ " ,interesse_produto.visualizacao_concluida " 
		+ " ,interesse_produto.preco_medio " 
		+ " ,interesse_produto.preco_minimo " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_sincronizacao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,interesse_produto.novo " 
		+ " ,interesse_produto.mudanca " 
		+ " ,interesse_produto.diferenca_anterior " 
		+ " ,interesse_produto.minha_avaliacao " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_mudanca,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_verificacao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,interesse_produto.preco_anterior " 
		+ " ,interesse_produto.estagio_visualizacao_mudanca " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_mudanca_gmt,'%d-%m-%Y %H:%i:%s') " 
		+ " ,interesse_produto.mudanca_nota " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_mudanca_nota,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(interesse_produto.data_ultima_mudanca_nota_gmt,'%d-%m-%Y %H:%i:%s') " 
		+ " ,interesse_produto.preco_atual " 
		+ " ,interesse_produto.id_produto_cliente_ra " 
		+ " ,interesse_produto.id_usuario_s " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_interesse_produto " 
		+ " , " + nomeTabela + ".nota " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".valor " 
		+ " , " + nomeTabela + ".espera " 
		+ " , " + nomeTabela + ".monitora " 
		+ " , " + nomeTabela + ".visualizacao_concluida " 
		+ " , " + nomeTabela + ".preco_medio " 
		+ " , " + nomeTabela + ".preco_minimo " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_sincronizacao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".novo " 
		+ " , " + nomeTabela + ".mudanca " 
		+ " , " + nomeTabela + ".diferenca_anterior " 
		+ " , " + nomeTabela + ".minha_avaliacao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_mudanca,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_verificacao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".preco_anterior " 
		+ " , " + nomeTabela + ".estagio_visualizacao_mudanca " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_mudanca_gmt,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".mudanca_nota " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_mudanca_nota,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_ultima_mudanca_nota_gmt,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".preco_atual " 
		+ " , " + nomeTabela + ".id_produto_cliente_ra " 
		+ " , " + nomeTabela + ".id_usuario_s " 
		;
	}
	
	
	@Override
	public void insereItem(InteresseProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(InteresseProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(InteresseProduto item) throws DaoException {
		InteresseProduto teste = this.obtemPorChave(item.getIdInteresseProduto());
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
	public void insereItemLoad(InteresseProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_interesse_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdInteresseProduto(id);	
	}
	@Override
	public void alteraItem(InteresseProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_interesse_produto = " + item.getIdInteresseProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(InteresseProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_interesse_produto = " + item.getIdInteresseProduto();
		executaSql(query);
	}
	@Override
	public InteresseProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_interesse_produto = " + id;
        return (InteresseProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(InteresseProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( InteresseProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProdutoClienteReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_produto_cliente_ra = " + filtro.getCodigoProdutoClienteReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(InteresseProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(InteresseProduto item) {
		return " ( '" + item.getIdInteresseProduto() + "'  " 
		+ " ,'" + item.getNota() + "'  "
		+ " ," + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		+ " ,'" + (item.getEspera()?"S":"N") + "'  "
		+ " ,'" + (item.getMonitora()?"S":"N") + "'  "
		+ " ,'" + (item.getVisualizacaoConcluida()?"S":"N") + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  "
		+ " ," + (item.getDataUltimaSincronizacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaSincronizacao()) ) + "  "
		+ " ,'" + (item.getNovo()?"S":"N") + "'  "
		+ " ,'" + (item.getMudanca()?"S":"N") + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getDiferencaAnterior()) + "'  "
		+ " ,'" + item.getMinhaAvaliacao() + "'  "
		+ " ," + (item.getDataUltimaMudanca()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudanca()) ) + "  "
		+ " ," + (item.getDataUltimaVerificacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVerificacao()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoAnterior()) + "'  "
		+ " ,'" + item.getEstagioVisualizacaoMudanca() + "'  "
		+ " ," + (item.getDataUltimaMudancaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaGmt()) ) + "  "
		+ " ,'" + (item.getMudancaNota()?"S":"N") + "'  "
		+ " ," + (item.getDataUltimaMudancaNota()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNota()) ) + "  "
		+ " ," + (item.getDataUltimaMudancaNotaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNotaGmt()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  "
		+ " ," + item.getIdProdutoClienteRa() + "  "
		+ " ," + item.getIdUsuarioS() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_interesse_produto " 
		+ " ,nota " 
		+ " ,data " 
		+ " ,valor " 
		+ " ,espera " 
		+ " ,monitora " 
		+ " ,visualizacao_concluida " 
		+ " ,preco_medio " 
		+ " ,preco_minimo " 
		+ " ,data_ultima_sincronizacao " 
		+ " ,novo " 
		+ " ,mudanca " 
		+ " ,diferenca_anterior " 
		+ " ,minha_avaliacao " 
		+ " ,data_ultima_mudanca " 
		+ " ,data_ultima_verificacao " 
		+ " ,preco_anterior " 
		+ " ,estagio_visualizacao_mudanca " 
		+ " ,data_ultima_mudanca_gmt " 
		+ " ,mudanca_nota " 
		+ " ,data_ultima_mudanca_nota " 
		+ " ,data_ultima_mudanca_nota_gmt " 
		+ " ,preco_atual " 
		+ " ,id_produto_cliente_ra " 
		+ " ,id_usuario_s " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(InteresseProduto item) {
		return " id_interesse_produto = '" + item.getIdInteresseProduto() + "'  " 
		+ " , nota = '" + item.getNota() + "'  "
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  "
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		+ " , espera = '" + (item.getEspera()?"S":"N") + "'  "
		+ " , monitora = '" + (item.getMonitora()?"S":"N") + "'  "
		+ " , visualizacao_concluida = '" + (item.getVisualizacaoConcluida()?"S":"N") + "'  "
		+ " , preco_medio = '" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  "
		+ " , preco_minimo = '" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  "
		+ " , data_ultima_sincronizacao = " + (item.getDataUltimaSincronizacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaSincronizacao()) ) + "  "
		+ " , novo = '" + (item.getNovo()?"S":"N") + "'  "
		+ " , mudanca = '" + (item.getMudanca()?"S":"N") + "'  "
		+ " , diferenca_anterior = '" +  DCConvert.ToDataBase(item.getDiferencaAnterior()) + "'  "
		+ " , minha_avaliacao = '" + item.getMinhaAvaliacao() + "'  "
		+ " , data_ultima_mudanca = " + (item.getDataUltimaMudanca()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudanca()) ) + "  "
		+ " , data_ultima_verificacao = " + (item.getDataUltimaVerificacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVerificacao()) ) + "  "
		+ " , preco_anterior = '" +  DCConvert.ToDataBase(item.getPrecoAnterior()) + "'  "
		+ " , estagio_visualizacao_mudanca = '" + item.getEstagioVisualizacaoMudanca() + "'  "
		+ " , data_ultima_mudanca_gmt = " + (item.getDataUltimaMudancaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaGmt()) ) + "  "
		+ " , mudanca_nota = '" + (item.getMudancaNota()?"S":"N") + "'  "
		+ " , data_ultima_mudanca_nota = " + (item.getDataUltimaMudancaNota()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNota()) ) + "  "
		+ " , data_ultima_mudanca_nota_gmt = " + (item.getDataUltimaMudancaNotaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNotaGmt()) ) + "  "
		+ " , preco_atual = '" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  "
		+ " , id_produto_cliente_ra = " + item.getIdProdutoClienteRa() + "  "
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(InteresseProduto item) {
		return " id_interesse_produto = '" + item.getIdInteresseProduto() + "'  " 
		+ " , nota = '" + item.getNota() + "'  " 
		+ " , data = " + (item.getData()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getData()) ) + "  " 
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  " 
		+ " , espera = '" + (item.getEspera()?"S":"N") + "'  " 
		+ " , monitora = '" + (item.getMonitora()?"S":"N") + "'  " 
		+ " , visualizacao_concluida = '" + (item.getVisualizacaoConcluida()?"S":"N") + "'  " 
		+ " , preco_medio = '" +  DCConvert.ToDataBase(item.getPrecoMedio()) + "'  " 
		+ " , preco_minimo = '" +  DCConvert.ToDataBase(item.getPrecoMinimo()) + "'  " 
		+ " , data_ultima_sincronizacao = " + (item.getDataUltimaSincronizacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaSincronizacao()) ) + "  " 
		+ " , novo = '" + (item.getNovo()?"S":"N") + "'  " 
		+ " , mudanca = '" + (item.getMudanca()?"S":"N") + "'  " 
		+ " , diferenca_anterior = '" +  DCConvert.ToDataBase(item.getDiferencaAnterior()) + "'  " 
		+ " , minha_avaliacao = '" + item.getMinhaAvaliacao() + "'  " 
		+ " , data_ultima_mudanca = " + (item.getDataUltimaMudanca()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudanca()) ) + "  " 
		+ " , data_ultima_verificacao = " + (item.getDataUltimaVerificacao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaVerificacao()) ) + "  " 
		+ " , preco_anterior = '" +  DCConvert.ToDataBase(item.getPrecoAnterior()) + "'  " 
		+ " , estagio_visualizacao_mudanca = '" + item.getEstagioVisualizacaoMudanca() + "'  " 
		+ " , data_ultima_mudanca_gmt = " + (item.getDataUltimaMudancaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaGmt()) ) + "  " 
		+ " , mudanca_nota = '" + (item.getMudancaNota()?"S":"N") + "'  " 
		+ " , data_ultima_mudanca_nota = " + (item.getDataUltimaMudancaNota()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNota()) ) + "  " 
		+ " , data_ultima_mudanca_nota_gmt = " + (item.getDataUltimaMudancaNotaGmt()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataUltimaMudancaNotaGmt()) ) + "  " 
		+ " , preco_atual = '" +  DCConvert.ToDataBase(item.getPrecoAtual()) + "'  " 
		+ " , id_produto_cliente_ra = " + item.getIdProdutoClienteRa() + "  " 
		+ " , id_usuario_s = " + item.getIdUsuarioS() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProdutoCliente(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_produto_cliente_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProdutoClienteReferenteA(long id) throws DaoException {
		return getPorReferenteAProdutoCliente(id);
	}
	public boolean excluiPorReferenteAProdutoCliente(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_produto_cliente_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProdutoCliente_ReferenteA() {
	//	return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_interesse_produto_p = " + tabelaSelect() + ".id_interesse_produto ";  
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
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_interesse_produto_s = " + tabelaSelect() + ".id_interesse_produto ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProdutoCliente_ReferenteA = false;
	public void setObtemProdutoCliente_ReferenteA() {
		_obtemProdutoCliente_ReferenteA = true;
	}
	protected String outterJoinProdutoCliente_ReferenteA() {
		return " left outer join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_ra ";  
	}
	public boolean atualizaReferenteAProdutoCliente(long idInteresseProduto, long idProdutoClienteRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_produto_cliente_ra  = " + idProdutoClienteRa +
        " where id_interesse_produto = " +  idInteresseProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProdutoCliente_ReferenteA() {
		return " inner join " + ProdutoClienteDaoBase.tabelaSelect() + " on " + ProdutoClienteDaoBase.tabelaSelect() + ".id_produto_cliente = " + tabelaSelect() + ".id_produto_cliente_ra ";  
	}
	
 	
	private boolean _obtemUsuario_Sincroniza = false;
	public void setObtemUsuario_Sincroniza() {
		_obtemUsuario_Sincroniza = true;
	}
	protected String outterJoinUsuario_Sincroniza() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	public boolean atualizaSincronizaUsuario(long idInteresseProduto, long idUsuarioS) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_s  = " + idUsuarioS +
        " where id_interesse_produto = " +  idInteresseProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_Sincroniza() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_s ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProdutoCliente_ReferenteA?" , " +ProdutoClienteDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProdutoCliente_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProdutoCliente_ReferenteA? outterJoinProdutoCliente_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new InteresseProdutoMontador(), null);
		if (this._obtemProdutoCliente_ReferenteA)
            montador.adicionaMontador(new ProdutoClienteMontador(), "ProdutoCliente_ReferenteA");
         return montador;
    }
	
	
}
