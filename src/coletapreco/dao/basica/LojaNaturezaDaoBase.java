package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.LojaNatureza;
import coletapreco.regracolecao.filtro.LojaNaturezaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class LojaNaturezaDaoBase extends DaoAplicacao implements LojaNaturezaDaoBaseI {
	
	
	public LojaNaturezaDaoBase() {
		super();
	}
	public LojaNaturezaDaoBase(DataFonte dataSource) {
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
		return new LojaNaturezaMontador();
	}
	public static String tabelaSelect() {
		return " loja_natureza" ;
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
		return " order by " + tabelaSelect() + ".id_loja_virtual_ra " ;
	}
	
	
	public static String camposOrdenados() {
		return " loja_natureza.id_loja_natureza " 
		+ " ,loja_natureza.url_inicial " 
		+ " ,loja_natureza.parse_categoria " 
		+ " ,loja_natureza.id_loja_virtual_ra " 
		+ " ,loja_natureza.id_natureza_produto_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_loja_natureza " 
		+ " , " + nomeTabela + ".url_inicial " 
		+ " , " + nomeTabela + ".parse_categoria " 
		+ " , " + nomeTabela + ".id_loja_virtual_ra " 
		+ " , " + nomeTabela + ".id_natureza_produto_ra " 
		;
	}
	
	
	@Override
	public void insereItem(LojaNatureza item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(LojaNatureza item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(LojaNatureza item) throws DaoException {
		LojaNatureza teste = this.obtemPorChave(item.getIdLojaNatureza());
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
	public void insereItemLoad(LojaNatureza item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_loja_natureza) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdLojaNatureza(id);	
	}
	@Override
	public void alteraItem(LojaNatureza item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_loja_natureza = " + item.getIdLojaNatureza();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(LojaNatureza item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_loja_natureza = " + item.getIdLojaNatureza();
		executaSql(query);
	}
	@Override
	public LojaNatureza obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_loja_natureza = " + id;
        return (LojaNatureza) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(LojaNaturezaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( LojaNaturezaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoLojaVirtualReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_loja_virtual_ra = " + filtro.getCodigoLojaVirtualReferenteA();
      	}
      	
		if (filtro.getCodigoNaturezaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_ra = " + filtro.getCodigoNaturezaProdutoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(LojaNaturezaFiltro filtro)
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
	
	
	protected String valoresInsert(LojaNatureza item) {
		return " ( '" + item.getIdLojaNatureza() + "'  " 
		+ " ,'" + item.getUrlInicial() + "'  "
		+ " ,'" + (item.getParseCategoria()?"S":"N") + "'  "
		+ " ," + item.getIdLojaVirtualRa() + "  "
		+ " ," + item.getIdNaturezaProdutoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_loja_natureza " 
		+ " ,url_inicial " 
		+ " ,parse_categoria " 
		+ " ,id_loja_virtual_ra " 
		+ " ,id_natureza_produto_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(LojaNatureza item) {
		return " id_loja_natureza = '" + item.getIdLojaNatureza() + "'  " 
		+ " , url_inicial = '" + item.getUrlInicial() + "'  "
		+ " , parse_categoria = '" + (item.getParseCategoria()?"S":"N") + "'  "
		+ " , id_loja_virtual_ra = " + item.getIdLojaVirtualRa() + "  "
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(LojaNatureza item) {
		return " id_loja_natureza = '" + item.getIdLojaNatureza() + "'  " 
		+ " , url_inicial = '" + item.getUrlInicial() + "'  " 
		+ " , parse_categoria = '" + (item.getParseCategoria()?"S":"N") + "'  " 
		+ " , id_loja_virtual_ra = " + item.getIdLojaVirtualRa() + "  " 
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	@Override
	public LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_loja_virtual_ra = " + idLojaVirtualRa + 
				" and id_natureza_produto_ra = " + idNaturezaProdutoRa;
		return (LojaNatureza) this.getObjeto(sql);
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteALojaVirtual(long id) throws DaoException{ // Padrao
	public List ListaPorLojaVirtualReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	NaturezaProdutoDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + NaturezaProdutoDaoBase.tabelaSelect() +
            " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " +
            tabelaSelect() + ".id_natureza_produto_ra" +
            " where id_loja_virtual_ra = " + id + " " +
            criterioExclusaoLojaVirtualReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new LojaNaturezaMontador(),null);
        montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProdutoReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteALojaVirtual(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_loja_virtual_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoLojaVirtualReferenteA() {
		return "";
	}
	
	//public List getPorReferenteANaturezaProduto(long id) throws DaoException{ // Padrao
	public List ListaPorNaturezaProdutoReferenteA(long id) throws DaoException{ // Combinar com Interface
		String sql;
        sql = "select " + camposOrdenados() + " , " +
        	LojaVirtualDaoBase.camposOrdenados() +
        	" from " + tabelaSelect() +
        	" inner join " + LojaVirtualDaoBase.tabelaSelect() +
            " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " +
            tabelaSelect() + ".id_loja_virtual_ra" +
            " where id_natureza_produto_ra = " + id + " " +
            // apagar depois 29-09-2020
            " and id_loja_virtual = 8 " +
            criterioExclusaoNaturezaProdutoReferenteA() + " " +
            orderByLista();
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new LojaNaturezaMontador(),null);
        montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtualReferenteA");
        setMontador(montador);
        return getListaSqlListaInterna(sql);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		String sql;
      	sql = "delete from " + tabelaSelect() + 
        " where id_natureza_produto_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	protected String criterioExclusaoNaturezaProdutoReferenteA() {
		return "";
	}
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemLojaVirtual_ReferenteA = false;
	public void setObtemLojaVirtual_ReferenteA() {
		_obtemLojaVirtual_ReferenteA = true;
	}
	protected String outterJoinLojaVirtual_ReferenteA() {
		return " left outer join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_ra ";  
	}
	public boolean atualizaReferenteALojaVirtual(long idLojaNatureza, long idLojaVirtualRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_loja_virtual_ra  = " + idLojaVirtualRa +
        " where id_loja_natureza = " +  idLojaNatureza;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinLojaVirtual_ReferenteA() {
		return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_ra ";  
	}
	
 	
	private boolean _obtemNaturezaProduto_ReferenteA = false;
	public void setObtemNaturezaProduto_ReferenteA() {
		_obtemNaturezaProduto_ReferenteA = true;
	}
	protected String outterJoinNaturezaProduto_ReferenteA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	public boolean atualizaReferenteANaturezaProduto(long idLojaNatureza, long idNaturezaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_ra  = " + idNaturezaProdutoRa +
        " where id_loja_natureza = " +  idLojaNatureza;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_ReferenteA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemLojaVirtual_ReferenteA?" , " +LojaVirtualDaoBase.camposOrdenados():"");
		saida += (this._obtemNaturezaProduto_ReferenteA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemLojaVirtual_ReferenteA = false;
		_obtemNaturezaProduto_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemLojaVirtual_ReferenteA? outterJoinLojaVirtual_ReferenteA() + " ":"");
		saida += (this._obtemNaturezaProduto_ReferenteA? outterJoinNaturezaProduto_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new LojaNaturezaMontador(), null);
		if (this._obtemLojaVirtual_ReferenteA)
            montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtual_ReferenteA");
		if (this._obtemNaturezaProduto_ReferenteA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_ReferenteA");
         return montador;
    }
	
	
}
