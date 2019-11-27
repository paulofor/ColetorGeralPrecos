package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface LojaNaturezaDaoBaseI
 extends DaoI { 
	public void insereItem( LojaNatureza item )  throws  DaoException;
	public void insereItemCompleto( LojaNatureza item )  throws  DaoException;
	public boolean insereSeNaoExiste( LojaNatureza item )  throws  DaoException;
	public void insereItemLoad( LojaNatureza item )  throws  DaoException;
	public void alteraItem( LojaNatureza item )  throws  DaoException;
	public void excluiItem( LojaNatureza item )  throws  DaoException;
	public LojaNatureza obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( LojaNaturezaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( LojaNaturezaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorLojaVirtualReferenteA( long idItem )  throws  DaoException;
	public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;
	LojaNatureza obtemPorRel(long idLojaVirtualRa, long idNaturezaProdutoRa) throws DaoException;



}
