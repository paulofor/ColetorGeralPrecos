package coletapreco.regracolecao.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.util.UtilData;


public  class DispositivoUsuarioRegraColecaoImpl  extends DispositivoUsuarioRegraColecao {

	
	private static final String CHAVE_TIPO_SINC = "tipoSinc";
 	private static final String ENVIO_ESCOLHA  = "enviaEscolha";
    private static final String NOVOS_ITENS_ESCOLHA = "novoItemEscolha";
    private static final String ATUALIZA_DADO_ESCOLHA = "atualizaDadoEscolha"; 
	
    /*
	@Override
	public DispositivoUsuario ChamaMobile(DaoConexao conexao) throws DaoException {
		DispositivoUsuario item = getFiltro().validaItemComApp();
		chamaMobileNovo(item.getAppProdutoUsa(true).getApiKey(),item.getTokenGcm());
		return item;
	}
	*/
	
	@Override
	public DispositivoUsuario ChamaMobileRecuperacaoInteresse(DaoConexao conexao) throws DaoException {
		return EnviaDadosCliente(conexao,ENVIO_ESCOLHA);
	}

	@Override
	public DispositivoUsuario ChamaMobileNovosProdutos(DaoConexao conexao) throws DaoException {
		return EnviaDadosCliente(conexao,NOVOS_ITENS_ESCOLHA);
	}

	@Override
	public DispositivoUsuario ChamaMobileAtualizaMonitorados(DaoConexao conexao) throws DaoException {
		return EnviaDadosCliente(conexao,ATUALIZA_DADO_ESCOLHA);
	}
	
	
	
	private JSONObject chamaMobileNovo(String apiKey, String mobileKey, String tipoSinc) {
		//final String API_KEY = "AIzaSyAak1l-hsYbZ2ZrOLe94xoQzuhEmZJ1Jyo";
		
		try {
			
			
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jGcmData.put("to", mobileKey);
            // What to send in GCM message.
            jData.put("tipoSinc", tipoSinc);
            jGcmData.put("data", jData);

            // Create connection to send GCM Message request.
            //URL url = new URL("https://android.googleapis.com/gcm/send");
            
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             
            
            conn.setRequestProperty("Authorization", "key=" + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

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

	
	private DispositivoUsuario EnviaDadosCliente(DaoConexao conexao, String tipoSinc) throws DaoException {
		// Precisa receber co nuvem
		DispositivoUsuario device = this.getFiltro().validaItemComApp();
		if (!"BLACKLISTED".equals(device.getTokenGcm())) {
			AppProduto aplicacao = device.getAppProdutoUsa(true);
			if (aplicacao==null) {
				aplicacao = this.getFiltro().validaAppMonitorameneto();
			}
			System.out.println("Id:" + device.getIdDispositivoUsuario() + "(" + device.getCodigoDispositivo() + ")");
			JSONObject saida = chamaMobileNovo(aplicacao.getApiKey(),device.getTokenGcm(), tipoSinc);
			try {
				int sucesso = saida.getInt("success");
				if (sucesso==0) {
					ArquivoLog.getInstancia().salvaServico("Desliga usuario:" + device.getIdDispositivoUsuario());
					ArquivoLog.getInstancia().salvaServico(saida.toString());
					ArquivoLog.getInstancia().salvaServico("Aplicacao:" + aplicacao.getIdAppProduto());
					device.setAtivo(false);
				}
			} catch (JSONException e) {
				throw new DaoException(e,"Erro no Json");
			}
			device.setDataChamada(UtilData.getDataHora());
		} else {
			device.setAtivo(false);
		}
		alteraItem(device, conexao);
		return device;
		
	}

	
	
}
