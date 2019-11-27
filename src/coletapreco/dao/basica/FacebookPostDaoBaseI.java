package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface FacebookPostDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookPost item )  throws  DaoException;
	public void insereItemCompleto( FacebookPost item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookPost item )  throws  DaoException;
	public void insereItemLoad( FacebookPost item )  throws  DaoException;
	public void alteraItem( FacebookPost item )  throws  DaoException;
	public void excluiItem( FacebookPost item )  throws  DaoException;
	public FacebookPost obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookPostFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookPostFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorFacebookFanpageFeitoEm( long idItem )  throws  DaoException;
	public List ListaPorProdutoDivulgando( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmFacebookPostPerformanceListaGera( long idFacebookPostPerformance )  throws  DaoException;

}
