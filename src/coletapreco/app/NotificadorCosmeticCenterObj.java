package coletapreco.app;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.modelo.DispositivoUsuario;
import br.com.digicom.modelo.NotificacaoApp;
import br.com.digicom.modelo.repositorio.RepositorioBase;

public class NotificadorCosmeticCenterObj {

	final String SUCESSO = "sucesso";
	final String FALHA = "falha";
	
	
	RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21040/api");
	//RestAdapter adapter = new RestAdapter("http://localhost:21040/api");
	
	
	RepositorioBase.DispositivoUsuarioRepository dispositivoUsuarioRep = adapter
			.createRepository(RepositorioBase.DispositivoUsuarioRepository.class);
	RepositorioBase.NotificacaoAppRepository notificacaoAppRep = adapter
			.createRepository(RepositorioBase.NotificacaoAppRepository.class);

	public void executa(final NotificacaoApp dado) {
		dispositivoUsuarioRep.cosmeticCenterNotificacao(new ListCallback<DispositivoUsuario>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<DispositivoUsuario> objects) {
				System.out.println("Total Dispositivo: " + objects.size());
				for (DispositivoUsuario item : objects) {
					System.out.println("Token:" + item.getTokenFcm());
					enviaNotificacao(item, dado);
				}
			}
		});
	}
	
	public void enviaNotificacao(final DispositivoUsuario item, NotificacaoApp dado) {
		dado.setTokenFcm(item.getTokenFcm());
		notificacaoAppRep.preparaEnvio(dado, new ObjectCallback<NotificacaoApp>() {
			@Override
			public void onSuccess(NotificacaoApp object)  {
				NotificadorSender notificador = new NotificadorSender();
				JSONObject result = notificador.envia(object);
				atualizaResposta(result,object);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}
	
	public void atualizaResposta(final JSONObject resposta,final NotificacaoApp notificacao) {
		try {
			String resultado = null;
			int sucesso = resposta.getInt("success");
			if (sucesso==1) {
				resultado = SUCESSO;
			} else {
				resultado = FALHA;
			}
			notificacaoAppRep.resultadoEnvio(resultado, notificacao.getTokenNotificacao() , new VoidCallback() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
				
			});
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
