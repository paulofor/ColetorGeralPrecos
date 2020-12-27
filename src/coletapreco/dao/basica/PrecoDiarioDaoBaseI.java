package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PrecoDiarioDaoBaseI
 extends DaoI { 
	public void insereSimples( PrecoDiario item ) throws DaoException;
	public void insereItem( PrecoDiario item )  throws  DaoException;
	public void insereItemCompleto( PrecoDiario item )  throws  DaoException;
	public boolean insereSeNaoExiste( PrecoDiario item )  throws  DaoException;
	public void insereItemLoad( PrecoDiario item )  throws  DaoException;
	public void alteraItem( PrecoDiario item )  throws  DaoException;
	public void excluiItem( PrecoDiario item )  throws  DaoException;
	public PrecoDiario obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PrecoDiarioFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PrecoDiarioFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProdutoPertenceA( long idItem )  throws  DaoException;
	public List ListaPorProdutoPertenceA(long id, DaoConexao conexao )  throws  DaoException;



}
