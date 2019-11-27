package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface OportunidadeInteresseClienteDaoBaseI
 extends DaoI { 
	public void insereItem( OportunidadeInteresseCliente item )  throws  DaoException;
	public void insereItemCompleto( OportunidadeInteresseCliente item )  throws  DaoException;
	public boolean insereSeNaoExiste( OportunidadeInteresseCliente item )  throws  DaoException;
	public void insereItemLoad( OportunidadeInteresseCliente item )  throws  DaoException;
	public void alteraItem( OportunidadeInteresseCliente item )  throws  DaoException;
	public void excluiItem( OportunidadeInteresseCliente item )  throws  DaoException;
	public OportunidadeInteresseCliente obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OportunidadeInteresseClienteFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OportunidadeInteresseClienteFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	//public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;
	//public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	//LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException;

	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	public List ListaPorProdutoClientePertenceA(long id) throws DaoException;
	

}


