package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface ProdutoClienteDaoBaseI
 extends DaoI { 
	public void insereItem( ProdutoCliente item )  throws  DaoException;
	public void insereItemCompleto( ProdutoCliente item )  throws  DaoException;
	public boolean insereSeNaoExiste( ProdutoCliente item )  throws  DaoException;
	public void insereItemLoad( ProdutoCliente item )  throws  DaoException;
	public void alteraItem( ProdutoCliente item )  throws  DaoException;
	public void excluiItem( ProdutoCliente item )  throws  DaoException;
	public ProdutoCliente obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProdutoClienteFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProdutoClienteFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;



}
