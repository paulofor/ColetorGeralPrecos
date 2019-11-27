package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PrecoDiarioClienteDaoBaseI
 extends DaoI { 
	public void insereItem( PrecoDiarioCliente item )  throws  DaoException;
	public void insereItemCompleto( PrecoDiarioCliente item )  throws  DaoException;
	public boolean insereSeNaoExiste( PrecoDiarioCliente item )  throws  DaoException;
	public void insereItemLoad( PrecoDiarioCliente item )  throws  DaoException;
	public void alteraItem( PrecoDiarioCliente item )  throws  DaoException;
	public void excluiItem( PrecoDiarioCliente item )  throws  DaoException;
	public PrecoDiarioCliente obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PrecoDiarioClienteFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PrecoDiarioClienteFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	//public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;
	//public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	//LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException;

	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	public List ListaPorProdutoClientePertenceA(long id) throws DaoException;
	
	public List ListaPorUsuarioPertenceA(long id) throws DaoException;
	

}


