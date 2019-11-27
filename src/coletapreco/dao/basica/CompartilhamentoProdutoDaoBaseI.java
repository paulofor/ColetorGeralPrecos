package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface CompartilhamentoProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( CompartilhamentoProduto item )  throws  DaoException;
	public void insereItemCompleto( CompartilhamentoProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( CompartilhamentoProduto item )  throws  DaoException;
	public void insereItemLoad( CompartilhamentoProduto item )  throws  DaoException;
	public void alteraItem( CompartilhamentoProduto item )  throws  DaoException;
	public void excluiItem( CompartilhamentoProduto item )  throws  DaoException;
	public CompartilhamentoProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CompartilhamentoProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CompartilhamentoProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	//public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;
	//public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	//LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException;

	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	public List ListaPorUsuarioPertenceA(long id) throws DaoException;
	

}


