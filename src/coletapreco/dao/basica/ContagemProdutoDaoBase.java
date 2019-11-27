package coletapreco.dao.basica;

import java.util.List;

import coletapreco.dao.montador.*;
import coletapreco.modelo.ContagemProduto;
import coletapreco.regracolecao.filtro.ContagemProdutoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ContagemProdutoDaoBase extends DaoAplicacao implements ContagemProdutoDaoBaseI {
	
	
	public ContagemProdutoDaoBase() {
		super();
	}
	public ContagemProdutoDaoBase(DataFonte dataSource) {
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
		return new ContagemProdutoMontador();
	}
	public static String tabelaSelect() {
		return " contagem_produto" ;
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
		return " order by " + tabelaSelect() + ".quantidade " ;
	}
	
	
	public static String camposOrdenados() {
		return " contagem_produto.id_contagem_produto " 
		+ " ,contagem_produto.quantidade " 
		+ " , DATE_FORMAT(contagem_produto.data,'%d-%m-%Y') " 
		+ " ,contagem_produto.percentual_diferenca " 
		+ " ,contagem_produto.possibilidade_erro " 
		+ " ,contagem_produto.id_natureza_produto_ra " 
		+ " ,contagem_produto.id_loja_virtual_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_contagem_produto " 
		+ " , " + nomeTabela + ".quantidade " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".percentual_diferenca " 
		+ " , " + nomeTabela + ".possibilidade_erro " 
		+ " , " + nomeTabela + ".id_natureza_produto_ra " 
		+ " , " + nomeTabela + ".id_loja_virtual_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ContagemProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ContagemProduto item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ContagemProduto item) throws DaoException {
		ContagemProduto teste = this.obtemPorChave(item.getIdContagemProduto());
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
	public void insereItemLoad(ContagemProduto item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_contagem_produto) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdContagemProduto(id);	
	}
	@Override
	public void alteraItem(ContagemProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_contagem_produto = " + item.getIdContagemProduto();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ContagemProduto item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_contagem_produto = " + item.getIdContagemProduto();
		executaSql(query);
	}
	@Override
	public ContagemProduto obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_contagem_produto = " + id;
        return (ContagemProduto) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ContagemProdutoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ContagemProdutoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoNaturezaProdutoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_natureza_produto_ra = " + filtro.getCodigoNaturezaProdutoReferenteA();
      	}
      	
		if (filtro.getCodigoLojaVirtualReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_loja_virtual_ra = " + filtro.getCodigoLojaVirtualReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ContagemProdutoFiltro filtro)
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
	
	
	protected String valoresInsert(ContagemProduto item) {
		return " ( '" + item.getIdContagemProduto() + "'  " 
		+ " ,'" + item.getQuantidade() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualDiferenca()) + "'  "
		+ " ,'" + (item.getPossibilidadeErro()?"S":"N") + "'  "
		+ " ," + item.getIdNaturezaProdutoRa() + "  "
		+ " ," + item.getIdLojaVirtualRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_contagem_produto " 
		+ " ,quantidade " 
		+ " ,data " 
		+ " ,percentual_diferenca " 
		+ " ,possibilidade_erro " 
		+ " ,id_natureza_produto_ra " 
		+ " ,id_loja_virtual_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ContagemProduto item) {
		return " id_contagem_produto = '" + item.getIdContagemProduto() + "'  " 
		+ " , quantidade = '" + item.getQuantidade() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , percentual_diferenca = '" +  DCConvert.ToDataBase(item.getPercentualDiferenca()) + "'  "
		+ " , possibilidade_erro = '" + (item.getPossibilidadeErro()?"S":"N") + "'  "
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  "
		+ " , id_loja_virtual_ra = " + item.getIdLojaVirtualRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ContagemProduto item) {
		return " id_contagem_produto = '" + item.getIdContagemProduto() + "'  " 
		+ " , quantidade = '" + item.getQuantidade() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , percentual_diferenca = '" +  DCConvert.ToDataBase(item.getPercentualDiferenca()) + "'  " 
		+ " , possibilidade_erro = '" + (item.getPossibilidadeErro()?"S":"N") + "'  " 
		+ " , id_natureza_produto_ra = " + item.getIdNaturezaProdutoRa() + "  " 
		+ " , id_loja_virtual_ra = " + item.getIdLojaVirtualRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
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
	//	return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_contagem_produto_p = " + tabelaSelect() + ".id_contagem_produto ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteALojaVirtual(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_loja_virtual_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorLojaVirtualReferenteA(long id) throws DaoException {
		return getPorReferenteALojaVirtual(id);
	}
	public boolean excluiPorReferenteALojaVirtual(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_loja_virtual_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinLojaVirtual_ReferenteA() {
	//	return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_contagem_produto_p = " + tabelaSelect() + ".id_contagem_produto ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemNaturezaProduto_ReferenteA = false;
	public void setObtemNaturezaProduto_ReferenteA() {
		_obtemNaturezaProduto_ReferenteA = true;
	}
	protected String outterJoinNaturezaProduto_ReferenteA() {
		return " left outer join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	public boolean atualizaReferenteANaturezaProduto(long idContagemProduto, long idNaturezaProdutoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_natureza_produto_ra  = " + idNaturezaProdutoRa +
        " where id_contagem_produto = " +  idContagemProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinNaturezaProduto_ReferenteA() {
		return " inner join " + NaturezaProdutoDaoBase.tabelaSelect() + " on " + NaturezaProdutoDaoBase.tabelaSelect() + ".id_natureza_produto = " + tabelaSelect() + ".id_natureza_produto_ra ";  
	}
	
 	
	private boolean _obtemLojaVirtual_ReferenteA = false;
	public void setObtemLojaVirtual_ReferenteA() {
		_obtemLojaVirtual_ReferenteA = true;
	}
	protected String outterJoinLojaVirtual_ReferenteA() {
		return " left outer join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_ra ";  
	}
	public boolean atualizaReferenteALojaVirtual(long idContagemProduto, long idLojaVirtualRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_loja_virtual_ra  = " + idLojaVirtualRa +
        " where id_contagem_produto = " +  idContagemProduto;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinLojaVirtual_ReferenteA() {
		return " inner join " + LojaVirtualDaoBase.tabelaSelect() + " on " + LojaVirtualDaoBase.tabelaSelect() + ".id_loja_virtual = " + tabelaSelect() + ".id_loja_virtual_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemNaturezaProduto_ReferenteA?" , " +NaturezaProdutoDaoBase.camposOrdenados():"");
		saida += (this._obtemLojaVirtual_ReferenteA?" , " +LojaVirtualDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemNaturezaProduto_ReferenteA = false;
		_obtemLojaVirtual_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemNaturezaProduto_ReferenteA? outterJoinNaturezaProduto_ReferenteA() + " ":"");
		saida += (this._obtemLojaVirtual_ReferenteA? outterJoinLojaVirtual_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ContagemProdutoMontador(), null);
		if (this._obtemNaturezaProduto_ReferenteA)
            montador.adicionaMontador(new NaturezaProdutoMontador(), "NaturezaProduto_ReferenteA");
		if (this._obtemLojaVirtual_ReferenteA)
            montador.adicionaMontador(new LojaVirtualMontador(), "LojaVirtual_ReferenteA");
         return montador;
    }
	
	
}
