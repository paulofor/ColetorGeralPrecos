package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PalavraProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( PalavraProduto item )  throws  DaoException;
	public void insereItemCompleto( PalavraProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( PalavraProduto item )  throws  DaoException;
	public void insereItemLoad( PalavraProduto item )  throws  DaoException;
	public void alteraItem( PalavraProduto item )  throws  DaoException;
	public void excluiItem( PalavraProduto item )  throws  DaoException;
	public PalavraProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PalavraProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PalavraProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorPalavraRelaciondoA( long idItem )  throws  DaoException;
	public List ListaPorProdutoRelaciondoA( long idItem )  throws  DaoException;
	PalavraProduto obtemPorRel(long idPalavraRa, long idProdutoRa) throws DaoException;



}
