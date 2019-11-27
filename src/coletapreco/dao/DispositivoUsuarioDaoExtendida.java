package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;


public  class DispositivoUsuarioDaoExtendida  extends DispositivoUsuarioDaoBase implements DispositivoUsuarioDao {

	public DispositivoUsuarioDaoExtendida() {
		super(new DataSourceNuvem());
	}
	
	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	

	
}
