package coletapreco.dao;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.PrecoDiarioClienteDaoBase;
import coletapreco.modelo.PrecoDiarioCliente;
import coletapreco.regracolecao.filtro.PrecoDiarioClienteFiltro;

public class PrecoDiarioClienteDaoExtendida extends PrecoDiarioClienteDaoBase implements PrecoDiarioClienteDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluiTodosUsuario(long idUsuario) throws DaoException {
		String sql = "delete from " + tabelaSelect() + " where id_usuario_s = " + idUsuario;
		this.executaSql(sql);
	}

	@Override
	public List ListaPorUsuarioPertenceA(long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
