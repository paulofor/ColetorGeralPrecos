package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.PrecoDiario;

public interface PrecoDiarioDao
 extends PrecoDiarioDaoBaseI {

	public void enviaListaNuvem(List<PrecoDiario> lista) throws DaoException;
	public void limparTabelaNuvem() throws DaoException;
	public PrecoDiario obtemPorDataIdProduto(String dataBd, long idProduto) throws DaoException;
	public PrecoDiario obtemMaisRecenteIdProduto(long idProduto)  throws DaoException;
	public List<PrecoDiario> ListaPorIdProdutoDataInicial(long idProduto, String dataInicialBd) throws DaoException;
	public List<PrecoDiario> ListaPorIdProdutoDataInicialSemZeros(long idProduto, String dataInicialBd) throws DaoException;
}
