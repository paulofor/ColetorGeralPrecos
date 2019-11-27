package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface DispositivoUsuarioDaoBaseI
 extends DaoI { 
	public void insereItem( DispositivoUsuario item )  throws  DaoException;
	public void insereItemCompleto( DispositivoUsuario item )  throws  DaoException;
	public boolean insereSeNaoExiste( DispositivoUsuario item )  throws  DaoException;
	public void insereItemLoad( DispositivoUsuario item )  throws  DaoException;
	public void alteraItem( DispositivoUsuario item )  throws  DaoException;
	public void excluiItem( DispositivoUsuario item )  throws  DaoException;
	public DispositivoUsuario obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( DispositivoUsuarioFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( DispositivoUsuarioFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorUsuarioReferenteA( long idItem )  throws  DaoException;
	public List ListaPorAppProdutoUsa( long idItem )  throws  DaoException;



}
