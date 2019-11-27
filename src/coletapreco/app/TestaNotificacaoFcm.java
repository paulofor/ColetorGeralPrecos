package coletapreco.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;

public class TestaNotificacaoFcm {

	public static void main(String[] args) {
		String token = "esoKlL3Jwcg:APA91bGO5D8ATLT5cSC_drNqwegWiOlr49rYsbciujPg62c6CDNKNxG27HlGgUdguqYKpQ_ZGhjgCudE2FFjeu35_wgnNG7NKaoR42ZnNiDna7G797tt_Jn6B4WAsfvpXik6ZPqs0Gl3";
		String apiKey = "AIzaSyAtjaGGiAnp-HMs15nfXz7DfVwdK0iKS4w";
		//Oi
		//token = "dNSo-99-yr8:APA91bH_P_8Q-zTZ8hM4JOrfTLIj7kLXsvvItd21oUUP3qtdO7_D2b_2ty6HaQY52r6uVbjH5FkYtN4WzwSOcyPxlkhzIEDopYrlDrCaXcGQhSUEhiKC-Mp06FXZbrQ5xo-3UYAC3sdV";
		//Casa
		token = "ehR5OHvF0Yc:APA91bG8QnkusUmEd7jilT7ACTmGGJJumF8Yx9AmAPaGMxNiaxJtNGhYpZEA8kzPsxuPvv1tt4Txq2LgociJgiKtQNGBnpd0wh-mrfiUIdPhvv7nsQRhiGvAZnMeaJV3avHf2hzKugj8";
		JSONObject result = chamaMobileNovo(apiKey,token,"teste");
		try {
			int sucesso = result.getInt("success");
			if (sucesso==0) {
				System.out.println(result.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	
	private static JSONObject chamaMobileNovo(String apiKey, String mobileKey, String tipoSinc) {
		//final String API_KEY = "AIzaSyAak1l-hsYbZ2ZrOLe94xoQzuhEmZJ1Jyo";
		
		try {
			
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.21.7.10", 82));
			System.setProperty("http.proxyUser", "tr626987");
			System.setProperty("http.proxyPassword", "Mclaren1");
			System.setProperty("https.proxyUser", "tr626987");
			System.setProperty("https.proxyPassword", "Mclaren1");
			
			
			JSONObject jNotification = new JSONObject();
			JSONObject jData = new JSONObject();
			JSONObject jMensagem = new JSONObject();
			
			jNotification.put("title", "Cosmetic Center");
			jNotification.put("body" , "Chegaram novos produtos para voce");
			jNotification.put("color" , "#ba5b5b");
			
			jData.put("tokenNotificacao" , "12345");
			
			
			jMensagem.put("to", "/topics/novo");
			jMensagem.put("collapse_key", "type_a");
			jMensagem.put("priority", "high");
			jMensagem.put("notification" , jNotification);
			jMensagem.put("data" , jData);
			
            
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //HttpURLConnection conn = (HttpURLConnection) new URL("https://fcm.googleapis.com/fcm/send").openConnection(proxy);
            
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
            System.out.println(resp);
            JSONObject saida = new JSONObject(resp);
            System.out.println("Check your device/emulator for notification or logcat for " +
                    "confirmation of the receipt of the FCM message.");
            return saida;
		} catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " +
                    "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
        	e.printStackTrace();
			return null;
		}
	}

}
