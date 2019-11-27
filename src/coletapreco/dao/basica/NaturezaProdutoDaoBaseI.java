package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface NaturezaProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( NaturezaProduto item )  throws  DaoException;
	public void insereItemCompleto( NaturezaProduto item )  throws  DaoException;
	public boolean insereSeNaoExiste( NaturezaProduto item )  throws  DaoException;
	public void insereItemLoad( NaturezaProduto item )  throws  DaoException;
	public void alteraItem( NaturezaProduto item )  throws  DaoException;
	public void excluiItem( NaturezaProduto item )  throws  DaoException;
	public NaturezaProduto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( NaturezaProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( NaturezaProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorAppProdutoAtendidoPor( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmCategoriaLojaListaPossui( long idCategoriaLoja )  throws  DaoException;
	public List ListaNaoRelacionadaEmLojaNaturezaListaEncontrada( long idLojaVirtual )  throws  DaoException;
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPossui( long idOportunidadeDia )  throws  DaoException;
	public List ListaNaoRelacionadaEmUsuarioPesquisaListaPesquisadoPor( long idUsuarioPesquisa )  throws  DaoException;
	public List ListaNaoRelacionadaEmContagemProdutoListaPossui( long idContagemProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmPalavraChavePesquisaListaPodePesquisar( long idPalavraChavePesquisa )  throws  DaoException;
	public List ListaNaoRelacionadaEmProdutoClienteListaPossui( long idProdutoCliente )  throws  DaoException;

}
