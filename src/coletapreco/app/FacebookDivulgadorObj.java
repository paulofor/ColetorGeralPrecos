package coletapreco.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.FacebookFanpage;
import coletapreco.modelo.FacebookPerfil;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.modelo.Produto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.FacebookFanpageRegraColecao;
import coletapreco.regracolecao.FacebookPerfilRegraColecao;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class FacebookDivulgadorObj {

	private FacebookFanpageRegraColecao fbFanpageSrv = FabricaRegra.getInstancia().getFacebookFanpageRegraColecao();
	private OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
	private FacebookPerfilRegraColecao fbPerfilSrv = FabricaRegra.getInstancia().getFacebookPerfilRegraColecao();
	private ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
	
	
	public void verificaPerformance() throws DaoException {
		System.out.println("Ola Mundo ! - Verificando performance");
	}
	
	
	// Passou para FacebookPost.CriaPostsDia()
	public void executa() throws DaoException {
		System.out.println("Ola Mundo ! - Iniciando FacebookDivulgador de HOJE");
		List<FacebookFanpage> listaFanpage = fbFanpageSrv.ListaParaDivulgarOportunidade();
		for (FacebookFanpage page : listaFanpage) {
			this.oportunidadeSrv.getFiltro().setFbPage(page);
			List<OportunidadeDia> listaOportunidade = this.oportunidadeSrv.ListaPorFanpage();
			FacebookPerfil perfil = page.getCorrenteFacebookPerfil_PertenceA();
			for (OportunidadeDia oportunidade : listaOportunidade) {
				obtemImagem(oportunidade);
				enviadorOportunidade(oportunidade, perfil, page);
			}
		}
	}
	
	private void obtemImagem(OportunidadeDia oportunidade) throws DaoException {
		Produto produto = produtoSrv.obtemPorChave(oportunidade.getIdProdutoRa());
		produtoSrv.getFiltro().setItem(produto);
		produtoSrv.SalvaImagemLocal();
	}
	
	private void complementaOportunidade(OportunidadeDia oportunidade) {
		
	}
	
	
	private void enviadorOportunidade(OportunidadeDia oportunidade, FacebookPerfil perfil, FacebookFanpage page) throws DaoException {
		fbFanpageSrv.getFiltro().setFbEnviadorFanpage(page);
		fbFanpageSrv.getFiltro().setFbEnviadorOportunidade(oportunidade);
		fbFanpageSrv.getFiltro().setFbEnviadorPerfil(perfil);
		fbFanpageSrv.EnviaOportunidade();
	}
}
