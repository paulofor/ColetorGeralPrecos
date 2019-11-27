package digicom.facebook.obj;

import java.io.FileNotFoundException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.FacebookPerfil;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.FacebookPerfilRegraColecao;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Album;
import com.restfb.types.Insight;
import com.restfb.types.Photo;
import com.restfb.types.User;



public class FbEnviadorObj implements Job{
	
	private static String tokenUsuario = "EAABwbur8GF4BALDQOZCPFBPL6CA1yzR6ZClUMxnsiZByaTsOXUrrmLgaslw0UUYQgiGDZBjaGMQzpLx07En2S6hWkbWqllh0od2lnWfPNGpaRX6ZAfVVD8vYhICkyTTruZC6CmWLXEWPZBjaQ3ARZBocjgsySgdRLGjziZBVQTDCBZBgZDZD"; 

	
	private final static int ID_ALBUM = 1;
	private final static String TOKEN = "";
	

	private static int idxAlbum = 0;
	private static List<Album> listaAlbum = null;
	
	private FacebookPerfil perfil = null;
	//private FacebookFotoPostRegraColecao postSrv = null;
	
	public FbEnviadorObj() {
		/*System.out.println("Inicializou o FbEnviadorObj");
		try {
			perfil = getPerfil();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		criaListaAlbum();*/
		//postSrv = FabricaRegra.getInstancia().getFacebookFotoPostRegraColecao();
		//postSrv.getFiltro().setAlvoPostPerfil(perfil);
	}
	
	public FacebookPerfil getPerfil() throws DaoException {
		FacebookPerfilRegraColecao perfilSrv = FabricaRegra.getInstancia().getFacebookPerfilRegraColecao();
		FacebookPerfil perfil = perfilSrv.obtemPorChave(1);
		return perfil;

	}
	
	public boolean ExluiItem(String id) {
		FacebookClient facebookClient = new DefaultFacebookClient(perfil.getTokenAcesso());
		Boolean deleted = facebookClient.deleteObject(id);
		return deleted;
	}
	private void criaListaAlbum() {
		if (listaAlbum!=null) return;
		FacebookClient facebookClient = new DefaultFacebookClient(perfil.getTokenAcesso());
		// Para testar
		User user = facebookClient.fetchObject("me", User.class);
		Connection<Album> albuns = facebookClient.fetchConnection("me/albums", Album.class);
		listaAlbum = albuns.getData();
	}
	
	public void criaListaFoto() {
		InsightWrapper wrapper = new InsightWrapper();
		//if (listaAlbum!=null) return;
		FacebookClient facebookClient = new DefaultFacebookClient("EAABwbur8GF4BADQRfC1xmfl87YVUHhFbY2oTShyRxWk0oXmQsK2ZCT4ivMXxF2T4cNd1Bx52L36gzZAH9Q8UTKAsjUObZByE6OqAZAfwdTvzqIGM3Atg5U7Te5Cc8yCfXPsC0AXUjK7TjEZABGVPtunLwPKSHQzxw9q56YWE0hgZDZD");
		// Para testar
		Photo user = facebookClient.fetchObject("794263807375758", Photo.class);
		Connection<Insight> insights = facebookClient.fetchConnection("794263807375758/insights", Insight.class);
		//listaAlbum = albuns.getData();
		
		for (Insight insight : insights.getData()) {
			wrapper.setItem(insights);
			System.out.println(insight.getName() + ":" + wrapper.qtdeImpressaoUnica());
		}
		
		Photo foto = facebookClient.fetchObject("", Photo.class);
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		enviaOportunidade(null, null);
	}
	
	public void enviaOportunidade(OportunidadeDia oportunidade, String token) {
		int ind = getIndiceAlbum();
		Album corrente = listaAlbum.get(ind);
		System.out.println("Album:" + corrente.getName());
		FacebookFotoPost fotoPost = new FacebookFotoPost();
		try {
			fotoPost.EnviaFotoPost(oportunidade, "" + ind, token);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		postSrv.getFiltro().setFacebookIdAlbum(corrente.getId());
//		try {
//			postSrv.EnviaFotoPost();
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
	}
	
	private int getIndiceAlbum() {
		idxAlbum++;
		if (idxAlbum>=listaAlbum.size())
			idxAlbum = 1;
		return idxAlbum;
	}
}
