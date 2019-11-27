package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface FacebookFanpageDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookFanpage item )  throws  DaoException;
	public void insereItemCompleto( FacebookFanpage item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookFanpage item )  throws  DaoException;
	public void insereItemLoad( FacebookFanpage item )  throws  DaoException;
	public void alteraItem( FacebookFanpage item )  throws  DaoException;
	public void excluiItem( FacebookFanpage item )  throws  DaoException;
	public FacebookFanpage obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookFanpageFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookFanpageFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorFacebookPerfilPertenceA( long idItem )  throws  DaoException;
	public List ListaPorAppProdutoDivulga( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmFacebookPostListaTem( long idFacebookPost )  throws  DaoException;

}
