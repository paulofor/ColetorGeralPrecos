package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.Produto;

public interface ProdutoDao
 extends ProdutoDaoBaseI {

	Produto ObtemPorNomeCodigoLoja(String nomeProduto, long codigoLoja) throws DaoException;

	Produto ObtemPorUrlProduto(String urlProduto) throws DaoException;

	List<Produto> OportunidadeDia(String dataInicioOportunidade, String string) throws DaoException;
	
	List<Produto> OportunidadeDiaPrecoMinimo(String dataInicialMySql, String percentualMinimo) throws DaoException;
	
	List<Produto> OportunidadeDiaPrecoMinimoMesesPassado(String dataInicialMySql, String percentualMinimo, int quantidadeMeses) throws DaoException;

	List<Produto> ListaSemPalavraPorNatureza(int i) throws DaoException;

	Produto ObtemPrimeiroSemModeloPorNatureza(int i) throws DaoException;

	List<Produto> listaMesmaPalavra(List<Long> listaId)  throws DaoException;;
	
	List<Produto> OportunidadeDiaMediaMinimo(String dataInicialMySql) throws DaoException ;

	List<Produto> ListaMelhoresPorNaturezaLimiteComImagem(long codigoNatureza, long limite, long diasPreco) throws DaoException ;

	void alteraNome(Produto itemDetalhe) throws DaoException ;

	void atualizaPosicao(int i, long idCategoriaLoja, long idLojaVirtual) throws DaoException ;

	void AtualizaProdutoExistente(Produto produto) throws DaoException ;

	void alteraImagem(Produto itemDetalhe) throws DaoException ;
}
