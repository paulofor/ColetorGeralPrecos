package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface OportunidadeDiaDaoBaseI
 extends DaoI { 
	public void insereItem( OportunidadeDia item )  throws  DaoException;
	public void insereItemCompleto( OportunidadeDia item )  throws  DaoException;
	public boolean insereSeNaoExiste( OportunidadeDia item )  throws  DaoException;
	public void insereItemLoad( OportunidadeDia item )  throws  DaoException;
	public void alteraItem( OportunidadeDia item )  throws  DaoException;
	public void excluiItem( OportunidadeDia item )  throws  DaoException;
	public OportunidadeDia obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OportunidadeDiaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OportunidadeDiaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorNaturezaProdutoPertenceA( long idItem )  throws  DaoException;



}
