package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface InteresseProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( InteresseProduto item )  throws  DaoException;
	public void insereItemCompleto( InteresseProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( InteresseProduto item )  throws  DaoException;
	public void insereItemLoad( InteresseProduto item )  throws  DaoException;
	public void alteraItem( InteresseProduto item )  throws  DaoException;
	public void excluiItem( InteresseProduto item )  throws  DaoException;
	public InteresseProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( InteresseProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( InteresseProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	//public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;
	//public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	//LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException;

	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	public List ListaPorProdutoClienteReferenteA(long id) throws DaoException;
	

}


