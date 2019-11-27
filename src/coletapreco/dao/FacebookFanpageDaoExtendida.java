package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletapreco.dao.basica.FacebookFanpageDaoBase;
import coletapreco.dao.montador.FacebookFanpageMontador;
import coletapreco.dao.montador.FacebookPerfilMontador;
import coletapreco.modelo.FacebookFanpage;


public  class FacebookFanpageDaoExtendida  extends FacebookFanpageDaoBase implements FacebookFanpageDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public List<FacebookFanpage> ListaComAppAtiva() throws DaoException {
		String sql = "select " + camposOrdenados() + 
				" , " + FacebookPerfilDaoExtendida.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinAppProduto_Divulga() +
				this.innerJoinFacebookPerfil_PertenceA() +
				" where ativo = 'S' ";
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new FacebookFanpageMontador(), null);
		montador.adicionaMontador(new FacebookPerfilMontador(), "FacebookPerfil_PertenceA");
		this.setMontador(montador);
		return this.getListaSql(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmFacebookPostListaTem(long idFacebookPost) throws DaoException {
		throw new UnsupportedOperationException();
	}

//	@Override
//	public List<FacebookFanpage> ListaParaDivulgarOportunidade() throws DaoException {
//		String sql = "select " + camposOrdenados() + " from " + tabelaSelect();
//		List<FacebookFanpage> lista = this.getListaSql(sql);
//		return lista;
//	} 
}
