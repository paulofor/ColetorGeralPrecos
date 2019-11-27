package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.Palavra;

public interface PalavraDao
 extends PalavraDaoBaseI {

	Palavra ObtemPorDescricaoPalavra(String palavra) throws DaoException;

	void atualizaComum(int i) throws DaoException;

	void atualizaNaoComum() throws DaoException; 
}
