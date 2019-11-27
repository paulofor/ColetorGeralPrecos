package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.OportunidadeDia;

public interface OportunidadeDiaDao
 extends OportunidadeDiaDaoBaseI {

	void limparTabela() throws DaoException;

	

	void enviaListaNuvem(List<OportunidadeDia> listaOportunidade) throws DaoException;



	List<OportunidadeDia> ListaPorFanpage(long idFacebookFanpage) throws DaoException;



	List<OportunidadeDia> ListaPorFanpageData(long idFacebookFanpage, String data)  throws DaoException;


	void insereItemPlus( OportunidadeDia item )  throws  DaoException;
	List ListaCorrentePlus() throws DaoException;

}
