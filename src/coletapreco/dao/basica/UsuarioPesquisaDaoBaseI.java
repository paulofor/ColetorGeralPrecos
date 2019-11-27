package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface UsuarioPesquisaDaoBaseI
 extends DaoI { 
	public void insereItem( UsuarioPesquisa item )  throws  DaoException;
	public void insereItemCompleto( UsuarioPesquisa item )  throws  DaoException;
	public boolean insereSeNaoExiste( UsuarioPesquisa item )  throws  DaoException;
	public void insereItemLoad( UsuarioPesquisa item )  throws  DaoException;
	public void alteraItem( UsuarioPesquisa item )  throws  DaoException;
	public void excluiItem( UsuarioPesquisa item )  throws  DaoException;
	public UsuarioPesquisa obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( UsuarioPesquisaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( UsuarioPesquisaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorUsuarioSincroniza( long idItem )  throws  DaoException;
	public List ListaPorNaturezaProdutoPesquisa( long idItem )  throws  DaoException;



}
