package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.Usuario;

public interface UsuarioDao
 extends UsuarioDaoBaseI {

	Usuario ObtemPrimeiroSemDiaAtual(long idApp)  throws DaoException;
	
	Usuario ObtemPrimeiroProcessamentoMaisAntigo(long idApp, long minutos) throws DaoException;

	List<Usuario> ListaAtivoChamadaDistante(long idApp, long quantidade) throws DaoException;

	List<Usuario> ListaInteresseNovo(long idApp) throws DaoException;

	void atualizaDataProcessamento(long idObj) throws DaoException;
}
