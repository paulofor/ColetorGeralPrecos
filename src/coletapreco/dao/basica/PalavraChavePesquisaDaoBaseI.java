package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface PalavraChavePesquisaDaoBaseI
 extends DaoI { 
	public void insereItem( PalavraChavePesquisa item )  throws  DaoException;
	public void insereItemCompleto( PalavraChavePesquisa item )  throws  DaoException;
	public boolean insereSeNaoExiste( PalavraChavePesquisa item )  throws  DaoException;
	public void insereItemLoad( PalavraChavePesquisa item )  throws  DaoException;
	public void alteraItem( PalavraChavePesquisa item )  throws  DaoException;
	public void excluiItem( PalavraChavePesquisa item )  throws  DaoException;
	public PalavraChavePesquisa obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PalavraChavePesquisaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PalavraChavePesquisaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorUsuarioSincroniza( long idItem )  throws  DaoException;
	public List ListaPorNaturezaProdutoReferenteA( long idItem )  throws  DaoException;



}
