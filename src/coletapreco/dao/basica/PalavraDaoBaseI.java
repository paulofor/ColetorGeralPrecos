package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PalavraDaoBaseI
 extends DaoI { 
	public void insereItem( Palavra item )  throws  DaoException;
	public void insereItemCompleto( Palavra item )  throws  DaoException;
	public boolean insereSeNaoExiste( Palavra item )  throws  DaoException;
	public void insereItemLoad( Palavra item )  throws  DaoException;
	public void alteraItem( Palavra item )  throws  DaoException;
	public void excluiItem( Palavra item )  throws  DaoException;
	public Palavra obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PalavraFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PalavraFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmPalavraProdutoListaPossui( long idProduto )  throws  DaoException;

}
