package digicom.facebook.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.app.Constantes;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;
import coletapreco.regracolecao.impl.ProdutoRegraColecaoImpl;

import com.restfb.BinaryAttachment;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Account;
import com.restfb.types.Album;
import com.restfb.types.FacebookType;
import com.restfb.types.User;

public class FbEnviador implements Job{
	
	//https://graph.facebook.com/oauth/authorize?client_id=364886200279300& redirect_uri=http://digicom.kinghost.net/sim4/Usuario&scope=publish_stream,create_event,user_photos,manage_pages
	
	
	private FacebookClient facebookClient;
	
	private static int idx = 0;
	private static List<Album> listaAlbum = null;

	
	private long ID_NATUREZA = 2;
	
	//Carlos
	public final static String FANPAGE_ID = "149772571824888";
	//Paulo
	//private final static String FANPAGE_ID = "130215663840453";
	//Buscador
	
	private int getIndiceAlbum() {
		idx++;
		if (idx>=listaAlbum.size())
			idx = 1;
		return idx;
	}
	
	public FbEnviador() {
		inicializaFacebook();
		//criaListaAlbum(FANPAGE_ID);
		criaListaAlbum();
	}
	
	
	public void enviaMensagem() {
	}

	public void criaListaAlbum() {
		if (listaAlbum!=null) return;
		// Obtendo as contas - Fanpages
		Connection<Album> albuns = facebookClient.fetchConnection("me/albums", Album.class);
		listaAlbum = albuns.getData();
	}
	
	
	public void criaListaAlbum(String idFanPage) {
		if (listaAlbum!=null) return;
		// Obtendo as contas - Fanpages
		Connection<Account> contas = facebookClient.fetchConnection(
				"me/accounts", Account.class);
		Iterator<Account> it = contas.getData().iterator();
		Account conta = null;
		// Obtendo a conta correta.
		while (it.hasNext()) {
			Account corrente = it.next();
			String id = corrente.getId();
			if (id.compareTo(idFanPage) == 0) {
				conta = corrente;
			}
		}
		FacebookClient facebookClient2 = new DefaultFacebookClient(
				conta.getAccessToken());
		
		

		Connection<Album> albuns = facebookClient2.fetchConnection(idFanPage
				+ "/albums", Album.class);
		listaAlbum = albuns.getData();
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		EnviaOportunidades();
	}
	
	
	public void criarAlbums(int qtde, String fanPageId) {
		for (int i = 0; i<qtde; i++) {
			
		}
	}
	
	public void inicializaFacebook() {
		// APP1 - Carlos
		//String MY_APP_ID = "123621691103326";
		//String MY_APP_SECRET = "a08c80de79d08ee5ef4459def273817e";
		
		// RobotWeb01 - Paulo
		//String MY_APP_ID = "364886200279300";
		//String MY_APP_SECRET = "3a859efdce03e46d1564b937a7808232";
		
		//AccessToken accessToken =
		//		  new DefaultFacebookClient().obtainAppAccessToken(MY_APP_ID, MY_APP_SECRET);
	
		// Paulo
		//String MY_ACCESS_TOKEN = "BAAFL3LBZA4QQBAIhZAYgn3CUBsrSPz9EAE1l8HrSBMGZAF8ss9ZBVGfwyfNFFiTfgbeEaQU0otfwTMJGVxytLsvRiAZAWRmQ2QKrGonsrD974PXuBb8idc4H6R18SQWD93bpelpHYZBZCTcamuMSNpOonVZCipJPkoFuszJJloB6aETYCZBuRQDRB7oUBGgu5xeeSJy2DsCoeAMyNZAdKSsvodZBH6u5z6ZBqaEZD";
		// Carlos
		//String MY_ACCESS_TOKEN = "AAABwbur8GF4BAElafVB5CQIBmsJvrCnQo6JS9xACKfW8L46l9KZAKjsKscMHvDizCjSYeBZC1mG717ZBViPkLVEPkeZBzyQl4TDfmpeIUAZDZD";
		//String MY_ACCESS_TOKEN = "BAAFL3LBZA4QQBADlH73RKhegqkjJ4jEtnHC9z6IY5WO3sMNK0m5TTb5ak2fCg3o0ZCElhK4jAhZAyGPYZAV2SY4ZAku5O8K5eBlovMdn8XdGAP6S5Ai525zBa3PtvW7l5F8Ok8V0jH3hMzKuBKSl50akLfaUVmAZBu4jQZBfrDlhVDgV4ek9SMbf4ZAkN8maZAbqO1boZCuTZCRb3hJQsgTKth4YrPL3vPyexoZD";
		String MY_ACCESS_TOKEN = "EAABwbur8GF4BAJPkof4AocmaOZBZBkXkGzbNUrSfTi3BPcyEUZCaFn6M6I8zlgjXStJFpF33b9z61MtA4AUel3MBBZA4O2vlsA0LF9ddFGuZBkUnBUqgDwe17W3VaRsW0AT0ZCZAgxJSiDGlxauqq9hc01FjB1OVt4IiyP7WpipUAZDZD";
		// Buscador 
		//String MY_ACCESS_TOKEN = "BAAFL3LBZA4QQBABbSSVlb4dje7JxiSApBvd2k9Ma8CZAgZCKpWTeSLC3NVPuEbdj4Qr5sMXDIzbGhjojCCbEIwyr5LZC9fzs2hPFij2FKuU3rIJ0ERfMjsBzbmZAlmPROvhfopAWitVaPP7FK0191cabRXwn4E9Fo8km5xpXsgAvCF5CvuKZBwOrZAoxheUMMH7ZA8g2ZCOkntGSv0VwKglgzvS3cT4HH8L4ZD";
		
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		User eu = facebookClient.fetchObject("me", User.class);
		Connection<Album> contas = facebookClient.fetchConnection("me/albums", Album.class);
		System.out.println("Ola");
	}
	
	public void ApagaOportunidades() {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		
	}
	
	public void EnviaOportunidades()  {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		oportunidadeSrv.getFiltro().setCodigoNaturezaProdutoPertenceA(ID_NATUREZA);
		try {
			List<OportunidadeDia> lista = oportunidadeSrv.ListaPorNatureza();
			EnviaFotoPost(lista.get(0));

			//oportunidadeSrv.getFiltro().setItemComCodigoFb(corrente);
			//oportunidadeSrv.AlteraIdFacebook();
			
		} catch (DaoException e) {
			e.printStackTrace();
		} 

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

	}
	
	private String decimal(float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	private String datas(String dataEnt) {
		return dataEnt.replaceAll("-", "/");
	}
	
	private void EnviaPost(OportunidadeDia oportunidade, String idFanPage) {
		
		String mensagem = getMensagem(oportunidade);
		String nomeImagem = oportunidade.getUrlImagem().replaceAll("catalog", "zoom");
		FacebookType publishMessageResponse1 =
				facebookClient.publish(idFanPage + "/feed", 
				  FacebookType.class,
				  Parameter.with("message", mensagem),
				  Parameter.with("picture",nomeImagem)
				  );
	}
	
	
	public boolean ExluiItem(String id) {
		Boolean deleted = facebookClient.deleteObject(id);
		return deleted;
	}
	
	private String getMensagem(OportunidadeDia oportunidade) { 
		String preco = "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " + oportunidade.getQuantidadeParcelaAnterior() + 
				" x R$ " + oportunidade.getPrecoParcelaAnteriorFormatada() + " = R$ " + oportunidade.getPrecoVendaAnteriorFormatada() +
				"\nEm " + datas(oportunidade.getDataInicioPrecoAtual()) + ": " + oportunidade.getQuantidadeParcelaAtual() + 
				" x R$ " + oportunidade.getPrecoParcelaAtualFormatada() + " = R$ " + oportunidade.getPrecoVendaAtualFormatada();
		String mensagem = oportunidade.getNomeMarca() + "\n" + oportunidade.getNomeProduto() + "\n\n" + preco;
		String link = oportunidade.getUrlAfiliado();
		mensagem = mensagem + "\n\n" + "Compre na Dafiti => " + link;
		//mensagem = mensagem + "\n\n" + "Compre na Dafiti => ";
		return mensagem;
	}
	
	private String EnviaFotoPost(OportunidadeDia oportunidade) throws FileNotFoundException {
		

		String mensagem = getMensagem(oportunidade);
		File imageFile = new File(Constantes.DIRETORIO_IMAGENS
				+ "\\" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		
		int ind = getIndiceAlbum();
		Album corrente = listaAlbum.get(ind);
		String id = corrente.getId();
		/*
		Connection<Account> contas = facebookClient.fetchConnection(
				"me/accounts", Account.class);
		Iterator<Account> it = contas.getData().iterator();
		Account conta = null;
		// Obtendo a conta correta.
		while (it.hasNext()) {
			Account correnteConta = it.next();
			String idConta = correnteConta.getId();
			if (idConta.compareTo(idFanPage) == 0) {
				conta = correnteConta;
			}
		}
		FacebookClient facebookClient2 = new DefaultFacebookClient(
				conta.getAccessToken());
		*/
		System.out.println("Post..." + oportunidade.getNomeProduto() + " Album:" + ind + "(" + corrente.getName() + "," + 
				corrente.getId() + ") - [" + DatasUtils.getHora() + "] ");
		FacebookType publishMessageResponse =
				facebookClient.publish(id + "/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
						  Parameter.with("message", mensagem),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
		System.out.println(publishMessageResponse.getId());
		return publishMessageResponse.getId();
	}

	
	private String EnviaFotoPost(OportunidadeDia oportunidade, String idFanPage) throws FileNotFoundException {
		

		String mensagem = getMensagem(oportunidade);
		File imageFile = new File(Constantes.DIRETORIO_IMAGENS	+ "\\" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		
		int ind = getIndiceAlbum();
		Album corrente = listaAlbum.get(ind);
		String id = corrente.getId();
		Connection<Account> contas = facebookClient.fetchConnection(
				"me/accounts", Account.class);
		Iterator<Account> it = contas.getData().iterator();
		Account conta = null;
		// Obtendo a conta correta.
		while (it.hasNext()) {
			Account correnteConta = it.next();
			String idConta = correnteConta.getId();
			if (idConta.compareTo(idFanPage) == 0) {
				conta = correnteConta;
			}
		}
		FacebookClient facebookClient2 = new DefaultFacebookClient(
				conta.getAccessToken());
		System.out.println("Post..." + oportunidade.getNomeProduto() + " Album:" + ind + "(" + corrente.getName() + "," + 
				corrente.getId() + ") - [" + DatasUtils.getHora() + "] ");
		FacebookType publishMessageResponse =
				facebookClient2.publish(id + "/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
						  Parameter.with("message", mensagem),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
		System.out.println(publishMessageResponse.getId());
		return publishMessageResponse.getId();
	}

}
