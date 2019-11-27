package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.AppProdutoDao;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.regracolecao.AppProdutoRegraColecao;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.regracolecao.FabricaRegra;



public  class AppProdutoRegraColecaoImpl  extends AppProdutoRegraColecao {

	@Override
	public List<AppProduto> ListaAtivoComVitrine(DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao(conexao);
		List<AppProduto> listaApp = dao.ListaAtivoComVitrine();
		return listaApp;
	}

	@Override
	public AppProduto ChamaDispostivos(DaoConexao conexao) throws DaoException {
		AppProduto itemApp = this.obtemPorChave(this.getFiltro().getIdApp());
		DispositivoUsuarioRegraColecao srv = FabricaRegra.getInstancia().getDispositivoUsuarioRegraColecao();
		List<DispositivoUsuario> lista = srv.getPorUsaAppProduto(itemApp.getIdObj());
		for (DispositivoUsuario disp : lista) {
			disp.setAppProdutoUsa(itemApp);
			srv.getFiltro().setItemComApp(disp);
			srv.ChamaMobileAtualizaMonitorados();
		}
		return null;
	} 
}
