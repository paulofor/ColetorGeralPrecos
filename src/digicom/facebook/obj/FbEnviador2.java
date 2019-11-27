package digicom.facebook.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.app.Constantes;
import coletapreco.modelo.FacebookFanpage;
import coletapreco.modelo.FacebookPerfil;
import coletapreco.modelo.OportunidadeDia;

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

public class FbEnviador2 {

	
	private static String tokenUsuario = "EAACEdEose0cBAPYZAJQVUiH6gul4S9IDOPda2QEQaLrrQEz9qMrLjgTbidaiyVy1XtfTkANqUpobpZCmcmcNrB7tprZAJ1pnY0vdxI1utZALxZCc9dbZCMGiDz59jj7NgJRdaoSNWzqm0vw4hSRU0RjBRftZA0lZCI4SlilFNZAQ88YHZAis2nGZACu"; 
	

	private static String foto = Constantes.DIRETORIO_IMAGENS + "/img-000469217.jpg";
	private static String texto = "Teste de post";
	
	public static void main(String[] args) {
		obtemDadosPage();
		EnviaOportunidade();
		//obtemDadosUsuario();
		
	}
	
	
	

	public static void EnviaOportunidade() {
		
		String token = "";
		FacebookClient facebookClient = new DefaultFacebookClient(tokenUsuario);
		
		File imageFile = new File("D:/RobotWeb/DeOlhoNoPreco/Imagens/img-000467839.jpg");
		FacebookType publishMessageResponse = null;
		
		try {
			FileInputStream fis = new FileInputStream(imageFile);
			publishMessageResponse =
				facebookClient.publish("me/photos", 
						  FacebookType.class,
						  BinaryAttachment.with("D:/RobotWeb/DeOlhoNoPreco/Imagens/img-000467839.jpg", fis),
						  Parameter.with("message", "Ola Mundo"),
						  Parameter.with("caption", " Ola Mundo")
						  );
			System.out.println(publishMessageResponse.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 
	
	private static void enviaFoto() throws FileNotFoundException {
		FacebookClient facebookClient = new DefaultFacebookClient(tokenUsuario);
		
		File imageFile = new File(foto);
		FileInputStream fis = new FileInputStream(imageFile);
		
		Connection<Album> listaAlbum = facebookClient.fetchConnection("me/albums", Album.class);
		List<Album> lstAlbum = listaAlbum.getData();
		Album corrente = lstAlbum.get(0);
		//Album corrente = listaAlbum.getData().get(0);
		String id = corrente.getId();
		
		FacebookType publishMessageResponse = null;
		try {
			publishMessageResponse =
				facebookClient.publish("me/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(foto, fis),
						  Parameter.with("message", "Titulo"),
						  Parameter.with("caption", "Nome do Produto")
						  );
		} catch (FacebookOAuthException e) {
			e.printStackTrace();
		}
		System.out.println(publishMessageResponse.getId());
	}

	private static void obtemDadosPage() {
		FacebookClient facebookClient = new DefaultFacebookClient(tokenUsuario);
		User eu= facebookClient.fetchObject("me", User.class);
		System.out.println("Eu sou " + eu.getFirstName());
	}

	

}
