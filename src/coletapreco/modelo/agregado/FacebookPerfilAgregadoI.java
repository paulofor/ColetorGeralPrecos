package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookPerfilAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public FacebookFanpage getCorrenteFacebookFanpage_Possui();
	public void addListaFacebookFanpage_Possui(FacebookFanpage item);
	public List<FacebookFanpage> getListaFacebookFanpage_Possui(); 
	public void setListaFacebookFanpage_Possui(List<FacebookFanpage> item); 
	public void criaVaziaListaFacebookFanpage_Possui();
	public boolean existeListaFacebookFanpage_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
