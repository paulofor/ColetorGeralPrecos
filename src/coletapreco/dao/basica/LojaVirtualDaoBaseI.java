package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface LojaVirtualDaoBaseI
 extends DaoI { 
	public void insereItem( LojaVirtual item )  throws  DaoException;
	public void insereItemCompleto( LojaVirtual item )  throws  DaoException;
	public boolean insereSeNaoExiste( LojaVirtual item )  throws  DaoException;
	public void insereItemLoad( LojaVirtual item )  throws  DaoException;
	public void alteraItem( LojaVirtual item )  throws  DaoException;
	public void excluiItem( LojaVirtual item )  throws  DaoException;
	public LojaVirtual obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( LojaVirtualFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( LojaVirtualFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmProdutoListaPossui( long idProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmCategoriaLojaListaPossui( long idCategoriaLoja )  throws  DaoException;
	public List ListaNaoRelacionadaEmLojaNaturezaListaOferece( long idNaturezaProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmContagemProdutoListaPossui( long idContagemProduto )  throws  DaoException;

}
