package coletapreco.desen;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.modelo.UsuarioProduto;
import br.com.digicom.modelo.cosmeticCenter.OportunidadeDia;
import br.com.digicom.modelo.repositorio.RepositorioBase;
import br.com.digicom.modelo.repositorio.RepositorioCosmeticCenterBase;

public class EnviadorEmailApp {


	private static RestAdapter adapter = new RestAdapter("https://www.digicom.inf.br:21189/api");
	private static RestAdapter adapterValidador  = new RestAdapter("https://www.digicom.inf.br:21101/api"); // prod
	//private static RestAdapter adapterValidador  = new RestAdapter("https://www.digicom.inf.br:21040/api"); // desen
	
	private static RepositorioCosmeticCenterBase.OportunidadeDiaRepository oportunidadeRep = adapter
			.createRepository(RepositorioCosmeticCenterBase.OportunidadeDiaRepository.class);
	private static RepositorioBase.UsuarioProdutoRepository usuarioProdutoRep = adapterValidador
			.createRepository(RepositorioBase.UsuarioProdutoRepository.class);
	
	private static EnviadorEmailObj obj = new EnviadorEmailObj();
	
	public static void main(String[] args) {
		System.out.println("Ola mundo");
		try {
			//obj.executa();
			executa();
			//obtemEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executa() {
		
		oportunidadeRep.listaParaEmail(new ListCallback<OportunidadeDia>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<OportunidadeDia> objects) {
				System.out.println("Total Dispositivo: " + objects.size());
				try {
					obtemEmail(objects);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	
	public static void obtemEmail(final List<OportunidadeDia> listaProduto) {
		Long idProjeto = 32L;
		usuarioProdutoRep.listaEnvioEmail(idProjeto, (new ListCallback<UsuarioProduto>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<UsuarioProduto> listaEmail) {
				System.out.println("Total Email: " + listaEmail.size());
				try {
					obj.executa(listaEmail, listaProduto);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}));
	}
}
