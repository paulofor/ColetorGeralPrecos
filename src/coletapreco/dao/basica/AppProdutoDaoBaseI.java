package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface AppProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( AppProduto item )  throws  DaoException;
	public void insereItemCompleto( AppProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( AppProduto item )  throws  DaoException;
	public void insereItemLoad( AppProduto item )  throws  DaoException;
	public void alteraItem( AppProduto item )  throws  DaoException;
	public void excluiItem( AppProduto item )  throws  DaoException;
	public AppProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( AppProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( AppProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmFacebookFanpageListaDivulgadoPor( long idFacebookFanpage )  throws  DaoException;
	public List ListaNaoRelacionadaEmNaturezaProdutoListaAtende( long idNaturezaProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmDispositivoUsuarioListaUsadoPor( long idDispositivoUsuario )  throws  DaoException;

}
