package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.ContagemProduto;

public interface ContagemProdutoDao
 extends ContagemProdutoDaoBaseI {

	void RegistraQuantidadesDia() throws DaoException;

	void AtualizaQuantidadesDia() throws DaoException;

	void ApagaQuantidadesDia() throws DaoException;

	List<ContagemProduto> ListaDiaCorrente() throws DaoException;

	void EnviaListaNuvem(List<ContagemProduto> listaOportunidade) throws DaoException;

	void CalculaDiferencaErro() throws DaoException;
}
