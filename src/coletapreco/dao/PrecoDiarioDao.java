package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.PrecoDiarioDaoBaseI;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.modelo.PrecoDiario;

public interface PrecoDiarioDao
 extends PrecoDiarioDaoBaseI {

	public void enviaListaNuvem(List<PrecoDiario> lista) throws DaoException;
	public void enviaListaNuvem(List<PrecoDiario> lista, OportunidadeDia oportunidade, DaoConexao conexao) throws DaoException;
	//public void limparTabelaNuvem() throws DaoException;
	//public void limparTabelaNuvemPorNatureza(long idNatureza) throws DaoException;
	public PrecoDiario obtemPorDataIdProduto(String dataBd, long idProduto) throws DaoException;
	public PrecoDiario obtemMaisRecenteIdProduto(long idProduto)  throws DaoException;
	public List<PrecoDiario> ListaPorIdProdutoDataInicial(long idProduto, String dataInicialBd) throws DaoException;
	public List<PrecoDiario> ListaPorIdProdutoDataInicialSemZeros(long idProduto, String dataInicialBd) throws DaoException;
	public void limparTabelaNuvem(DaoConexao connNuvem, long idNaturezaProdutoPa) throws DaoException;
}
