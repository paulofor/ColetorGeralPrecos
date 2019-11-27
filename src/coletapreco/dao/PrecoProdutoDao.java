package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.PrecoProduto;

public interface PrecoProdutoDao
 extends PrecoProdutoDaoBaseI {

	PrecoProduto MaisRecentePorProduto(long idProduto) throws DaoException; 
	
	float ObtemMedia2Meses(long idProduto) throws DaoException;
	float ObtemMinimo3Meses(long idProduto) throws DaoException;

	int ObtemQuantidade2Meses(long idProduto) throws DaoException;

	void atualizaMediaProduto() throws DaoException;

	void atualizaMinimoProduto() throws DaoException;

	void atualizaMinimoProduto(long idProduto) throws DaoException;

	void atualizaMediaProduto(long idProduto) throws DaoException;

	void atualizaMediaProduto(String string) throws DaoException;

	void atualizaMinimoProduto(String string) throws DaoException;
	

	void insereItemComIds(PrecoProduto precoNovo) throws DaoException;

	void atualizaDiferencaPosicao7Dias() throws DaoException;

	List<PrecoProduto> obtemMelhorPosicaoDia(int idLoja, int qtdePosicao) throws DaoException;
}
