package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.dao.basica.InteresseProdutoDaoBase;
import coletapreco.modelo.InteresseProduto;


public  class InteresseProdutoDaoExtendida  extends InteresseProdutoDaoBase implements InteresseProdutoDao {

	
	public InteresseProdutoDaoExtendida() {
		super(new DataSourceNuvem());
	}
	
	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AtualizaPrecoGeralMonitorado() throws DaoException {
		
		
	}

	@Override
	public void AtualizaPrecoMonitoradoPorUsuario(long id) throws DaoException {
		
		
	}

	
	@Override
	public void alteraItem(InteresseProduto item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_interesse_produto = " + item.getIdInteresseProduto() + " and " +
            " id_usuario_s = " + item.getIdUsuarioS();
        this.executaSql(sql);
 	}

	
}
