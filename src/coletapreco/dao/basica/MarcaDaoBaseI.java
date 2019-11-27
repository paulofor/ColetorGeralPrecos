package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface MarcaDaoBaseI
 extends DaoI { 
	public void insereItem( Marca item )  throws  DaoException;
	public void insereItemCompleto( Marca item )  throws  DaoException;
	public boolean insereSeNaoExiste( Marca item )  throws  DaoException;
	public void insereItemLoad( Marca item )  throws  DaoException;
	public void alteraItem( Marca item )  throws  DaoException;
	public void excluiItem( Marca item )  throws  DaoException;
	public Marca obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( MarcaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( MarcaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmProdutoListaReferenteA( long idProduto )  throws  DaoException;

}
