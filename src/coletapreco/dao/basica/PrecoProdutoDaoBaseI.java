package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PrecoProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( PrecoProduto item )  throws  DaoException;
	public void insereItemCompleto( PrecoProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( PrecoProduto item )  throws  DaoException;
	public void insereItemLoad( PrecoProduto item )  throws  DaoException;
	public void alteraItem( PrecoProduto item )  throws  DaoException;
	public void excluiItem( PrecoProduto item )  throws  DaoException;
	public PrecoProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PrecoProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PrecoProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoPertenceA( long idItem )  throws  DaoException;



}
