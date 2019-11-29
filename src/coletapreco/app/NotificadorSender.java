package coletapreco.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.modelo.NotificacaoApp;

public class NotificadorSender {

	String apiKey = "AIzaSyAtjaGGiAnp-HMs15nfXz7DfVwdK0iKS4w";
	
	public JSONObject envia(NotificacaoApp notificador) {
		System.out.println("Enviador:" + notificador.getTokenFcm());
		try {
			return enviaMensagem(notificador);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private JSONObject enviaMensagem(NotificacaoApp notificador) throws JSONException, IOException {
		
		
		JSONObject jNotification = new JSONObject();
		JSONObject jData = new JSONObject();
		JSONObject jMensagem = new JSONObject();
		
		jNotification.put("title", notificador.getTitulo());
		jNotification.put("body" , notificador.getCorpo());
		if (notificador.getCor()!=null) jNotification.put("color" , "#ba5b5b");
		jNotification.put("click_action","FCM_PLUGIN_ACTIVITY");
		
		jData.put("tokenNotificacao" , notificador.getTokenNotificacao());
		
		
		jMensagem.put("to", notificador.getTokenFcm());
		jMensagem.put("collapse_key", "type_a");
		jMensagem.put("priority", "high");
		jMensagem.put("notification" , jNotification);
		jMensagem.put("data" , jData);
		
		URL url = new URL("https://fcm.googleapis.com/fcm/send");
		Authenticator authenticator = new Authenticator() {

             public PasswordAuthentication getPasswordAuthentication() {
                 return (new PasswordAuthentication("tr626987", "Mclaren1".toCharArray()));
             }
         };
         Authenticator.setDefault(authenticator);    
         //HttpURLConnection conn = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection(proxy);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         
         conn.setRequestProperty("Authorization", "key=" + apiKey);
         conn.setRequestProperty("Content-Type", "application/json");
         conn.setRequestMethod("POST");
         conn.setDoOutput(true);
         
         // Send GCM message content.
         OutputStream outputStream = conn.getOutputStream();
         System.out.println("Send: " + jMensagem.toString());
         outputStream.write(jMensagem.toString().getBytes());

         // Read GCM response.
         InputStream inputStream = conn.getInputStream();
         String resp = IOUtils.toString(inputStream);
         System.out.println("Resposta:" + resp);
         JSONObject saida = new JSONObject(resp);
         return saida;
	}

	
	
	public static void main(String[] args) {
		String token = "esoKlL3Jwcg:APA91bGO5D8ATLT5cSC_drNqwegWiOlr49rYsbciujPg62c6CDNKNxG27HlGgUdguqYKpQ_ZGhjgCudE2FFjeu35_wgnNG7NKaoR42ZnNiDna7G797tt_Jn6B4WAsfvpXik6ZPqs0Gl3";
		
		//Oi
		//token = "dNSo-99-yr8:APA91bH_P_8Q-zTZ8hM4JOrfTLIj7kLXsvvItd21oUUP3qtdO7_D2b_2ty6HaQY52r6uVbjH5FkYtN4WzwSOcyPxlkhzIEDopYrlDrCaXcGQhSUEhiKC-Mp06FXZbrQ5xo-3UYAC3sdV";
		//Casa
		token = "ehR5OHvF0Yc:APA91bG8QnkusUmEd7jilT7ACTmGGJJumF8Yx9AmAPaGMxNiaxJtNGhYpZEA8kzPsxuPvv1tt4Txq2LgociJgiKtQNGBnpd0wh-mrfiUIdPhvv7nsQRhiGvAZnMeaJV3avHf2hzKugj8";
		
		try {
			int sucesso = result.getInt("success");
			if (sucesso==0) {
				System.out.println(result.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	

}