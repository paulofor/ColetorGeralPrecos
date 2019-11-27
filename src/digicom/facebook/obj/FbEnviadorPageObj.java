package digicom.facebook.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.restfb.BinaryAttachment;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.Account;
import com.restfb.types.Album;
import com.restfb.types.FacebookType;
import com.restfb.types.User;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.app.Constantes;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;

public class FbEnviadorPageObj {

	private static String tokenUsuario = "EAABwbur8GF4BALDQOZCPFBPL6CA1yzR6ZClUMxnsiZByaTsOXUrrmLgaslw0UUYQgiGDZBjaGMQzpLx07En2S6hWkbWqllh0od2lnWfPNGpaRX6ZAfVVD8vYhICkyTTruZC6CmWLXEWPZBjaQ3ARZBocjgsySgdRLGjziZBVQTDCBZBgZDZD"; 

	private OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
	
	public void executa() throws DaoException {
		System.out.println("Inicia mensagem facebook");
		List<OportunidadeDia> listaOp = oportunidadeSrv.getPorPertenceANaturezaProduto(2);
		OportunidadeDia opo1 = listaOp.get(0);
		OportunidadeDia opo2 = listaOp.get(1);
		OportunidadeDia opo3 = listaOp.get(2);
		try {
			enviaOportunidadePage(opo1,"1");
			enviaOportunidadePage(opo2,"1");
			enviaOportunidadePage(opo3,"1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void enviaFoto(OportunidadeDia opo, String tokenPagina) throws FileNotFoundException {
		
	}

	
	private void enviaOportunidadePage(OportunidadeDia oportunidade, String nomePagina) throws IOException {
		String token = obtemTokenPagina(nomePagina);
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		
		File imageFile = new File(Constantes.DIRETORIO_IMAGENS + "/" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		
		FacebookType publishMessageResponse = null;
		try {
			
			publishMessageResponse =
				facebookClient.publish("me/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getImagemLocal(), fis),
						  Parameter.with("message", oportunidade.getMensagemFacebook()),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
		} catch (FacebookOAuthException e) {
			e.printStackTrace();
		}
		System.out.println(publishMessageResponse.getId());
	}
	
	private String obtemTokenPagina(String nomePagina) {
		FacebookClient facebookClient = new DefaultFacebookClient(tokenUsuario);
		Connection<Account> paginas = facebookClient.fetchConnection("me/accounts", Account.class);
		return paginas.getData().get(0).getAccessToken().toString();
	}

}
