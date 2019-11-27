package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface CategoriaLojaDaoBaseI
 extends DaoI { 
	public void insereItem( CategoriaLoja item )  throws  DaoException;
	public void insereItemCompleto( CategoriaLoja item )  throws  DaoException;
	public boolean insereSeNaoExiste( CategoriaLoja item )  throws  DaoException;
	public void insereItemLoad( CategoriaLoja item )  throws  DaoException;
	public void alteraItem( CategoriaLoja item )  throws  DaoException;
	public void excluiItem( CategoriaLoja item )  throws  DaoException;
	public CategoriaLoja obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CategoriaLojaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CategoriaLojaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorCategoriaLojaFilho( long idItem )  throws  DaoException;
	public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorLojaVirtualPertenceA( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmCategoriaLojaProdutoListaPossui( long idProduto )  throws  DaoException;

}
