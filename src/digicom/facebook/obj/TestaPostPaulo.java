package digicom.facebook.obj;

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

public class TestaPostPaulo {

	private static FacebookFanpageRegraColecao fbFanpageSrv = FabricaRegra.getInstancia().getFacebookFanpageRegraColecao();
	private static OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
	private static FacebookPerfilRegraColecao fbPerfilSrv = FabricaRegra.getInstancia().getFacebookPerfilRegraColecao();
	private static ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			executa();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Passou para FacebookPost.CriaPostsDia()
	public static void executa() throws DaoException {
		System.out.println("Ola Mundo ! - Iniciando FacebookDivulgador de HOJE");
		List<FacebookFanpage> listaFanpage = fbFanpageSrv.ListaParaDivulgarOportunidade();
		for (FacebookFanpage page : listaFanpage) {
			if (page.getIdFacebookPerfilPa() != 1) {
				oportunidadeSrv.getFiltro().setFbPage(page);
				List<OportunidadeDia> listaOportunidade = oportunidadeSrv.ListaPorFanpage();
				FacebookPerfil perfil = page.getCorrenteFacebookPerfil_PertenceA();
				for (OportunidadeDia oportunidade : listaOportunidade) {
					obtemImagem(oportunidade);
					enviadorOportunidade(oportunidade, perfil, page);
				}
			}
		}
	}
	
	private static void obtemImagem(OportunidadeDia oportunidade) throws DaoException {
		Produto produto = produtoSrv.obtemPorChave(oportunidade.getIdProdutoRa());
		produtoSrv.getFiltro().setItem(produto);
		produtoSrv.SalvaImagemLocal();
	}
	
	private static void enviadorOportunidade(OportunidadeDia oportunidade, FacebookPerfil perfil, FacebookFanpage page) throws DaoException {
		fbFanpageSrv.getFiltro().setFbEnviadorFanpage(page);
		fbFanpageSrv.getFiltro().setFbEnviadorOportunidade(oportunidade);
		fbFanpageSrv.getFiltro().setFbEnviadorPerfil(perfil);
		fbFanpageSrv.EnviaOportunidade();
	}

}
