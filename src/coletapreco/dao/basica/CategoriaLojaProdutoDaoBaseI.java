package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface CategoriaLojaProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( CategoriaLojaProduto item )  throws  DaoException;
	public void insereItemCompleto( CategoriaLojaProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( CategoriaLojaProduto item )  throws  DaoException;
	public void insereItemLoad( CategoriaLojaProduto item )  throws  DaoException;
	public void alteraItem( CategoriaLojaProduto item )  throws  DaoException;
	public void excluiItem( CategoriaLojaProduto item )  throws  DaoException;
	public CategoriaLojaProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CategoriaLojaProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CategoriaLojaProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorCategoriaLojaReferenteA( long idItem )  throws  DaoException;
	public List ListaPorProdutoReferenteA( long idItem )  throws  DaoException;
	CategoriaLojaProduto obtemPorRel(long idCategoriaLojaRa, long idProdutoRa) throws DaoException;



}
