package coletapreco.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.modelo.*;
import coletapreco.dao.*;
import coletapreco.regracolecao.filtro.*;

public interface ProdutoDaoBaseI
 extends DaoI { 
	public void insereItem( Produto item )  throws  DaoException;
	public void insereItemCompleto( Produto item )  throws  DaoException;
	public boolean insereSeNaoExiste( Produto item )  throws  DaoException;
	public void insereItemLoad( Produto item )  throws  DaoException;
	public void alteraItem( Produto item )  throws  DaoException;
	public void excluiItem( Produto item )  throws  DaoException;
	public Produto obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProdutoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProdutoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorLojaVirtualLidoEm( long idItem )  throws  DaoException;
	public List ListaPorMarcaPossui( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmPrecoDiarioListaPossui( long idPrecoDiario )  throws  DaoException;
	public List ListaNaoRelacionadaEmModeloProdutoProdutoListaReferenteA( long idModeloProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmPrecoProdutoListaPossui( long idPrecoProduto )  throws  DaoException;
	public List ListaNaoRelacionadaEmCategoriaLojaProdutoListaPossui( long idCategoriaLoja )  throws  DaoException;
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPodePossuir( long idOportunidadeDia )  throws  DaoException;
	public List ListaNaoRelacionadaEmPalavraProdutoListaPossui( long idPalavra )  throws  DaoException;
	public List ListaNaoRelacionadaEmFacebookPostListaDivulgadoPor( long idFacebookPost )  throws  DaoException;

}
