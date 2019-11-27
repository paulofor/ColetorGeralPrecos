package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;


public  class ProdutoClienteDaoExtendida  extends ProdutoClienteDaoBase implements ProdutoClienteDao {
	
	public ProdutoClienteDaoExtendida() {
		super(new DataSourceNuvem());
	}
	
	@Override
	public void DeleteAll() throws DaoException {
		String sql = "delete from " + tabelaSelect();
		this.executaSql(sql);
	}

	

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void DeletePorNatureza(long codigoNatureza) throws DaoException {
		String sql = "delete from " + tabelaSelect() + " where id_natureza_produto_ra = " + codigoNatureza;
		this.executaSql(sql);
	}
	
}
