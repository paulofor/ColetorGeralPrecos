package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface ContagemProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( ContagemProduto item )  throws  DaoException;
	public void insereItemCompleto( ContagemProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( ContagemProduto item )  throws  DaoException;
	public void insereItemLoad( ContagemProduto item )  throws  DaoException;
	public void alteraItem( ContagemProduto item )  throws  DaoException;
	public void excluiItem( ContagemProduto item )  throws  DaoException;
	public ContagemProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ContagemProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ContagemProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;



}
