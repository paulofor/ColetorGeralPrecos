package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface FacebookPostPerformanceDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookPostPerformance item )  throws  DaoException;
	public void insereItemCompleto( FacebookPostPerformance item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookPostPerformance item )  throws  DaoException;
	public void insereItemLoad( FacebookPostPerformance item )  throws  DaoException;
	public void alteraItem( FacebookPostPerformance item )  throws  DaoException;
	public void excluiItem( FacebookPostPerformance item )  throws  DaoException;
	public FacebookPostPerformance obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookPostPerformanceFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookPostPerformanceFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorFacebookPostReferenteA( long idItem )  throws  DaoException;



}
