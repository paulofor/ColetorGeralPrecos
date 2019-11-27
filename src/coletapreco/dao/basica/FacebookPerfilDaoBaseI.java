package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface FacebookPerfilDaoBaseI
 extends DaoI { 
	public void insereItem( FacebookPerfil item )  throws  DaoException;
	public void insereItemCompleto( FacebookPerfil item )  throws  DaoException;
	public boolean insereSeNaoExiste( FacebookPerfil item )  throws  DaoException;
	public void insereItemLoad( FacebookPerfil item )  throws  DaoException;
	public void alteraItem( FacebookPerfil item )  throws  DaoException;
	public void excluiItem( FacebookPerfil item )  throws  DaoException;
	public FacebookPerfil obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FacebookPerfilFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FacebookPerfilFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmFacebookFanpageListaPossui( long idFacebookFanpage )  throws  DaoException;

}
