package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface ModeloProdutoProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( ModeloProdutoProduto item )  throws  DaoException;
	public void insereItemCompleto( ModeloProdutoProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( ModeloProdutoProduto item )  throws  DaoException;
	public void insereItemLoad( ModeloProdutoProduto item )  throws  DaoException;
	public void alteraItem( ModeloProdutoProduto item )  throws  DaoException;
	public void excluiItem( ModeloProdutoProduto item )  throws  DaoException;
	public ModeloProdutoProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ModeloProdutoProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ModeloProdutoProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorModeloProdutoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorProdutoReferenteA( long idItem )  throws  DaoException;
	ModeloProdutoProduto obtemPorRel(long idModeloProdutoRa, long idProdutoRa) throws DaoException;



}
