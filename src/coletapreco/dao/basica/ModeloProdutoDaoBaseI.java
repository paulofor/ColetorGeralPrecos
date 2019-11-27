package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface ModeloProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( ModeloProduto item )  throws  DaoException;
	public void insereItemCompleto( ModeloProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( ModeloProduto item )  throws  DaoException;
	public void insereItemLoad( ModeloProduto item )  throws  DaoException;
	public void alteraItem( ModeloProduto item )  throws  DaoException;
	public void excluiItem( ModeloProduto item )  throws  DaoException;
	public ModeloProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ModeloProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ModeloProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmModeloProdutoProdutoListaReferenteA( long idProduto )  throws  DaoException;

}
