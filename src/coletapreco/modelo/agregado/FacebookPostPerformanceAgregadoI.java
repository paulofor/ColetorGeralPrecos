package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookPostPerformanceAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public FacebookPost getFacebookPostReferenteA(boolean lazyLoader);
	public void setFacebookPostReferenteA(FacebookPost item);
	//public void setFacebookPostReferenteAComReversao(FacebookPost item);
	
	// Montador alternativo
	
	public void addListaFacebookPost_ReferenteA(FacebookPost item); 
	public FacebookPost getCorrenteFacebookPost_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
