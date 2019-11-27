package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookFanpageAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public FacebookPerfil getFacebookPerfilPertenceA(boolean lazyLoader);
	public void setFacebookPerfilPertenceA(FacebookPerfil item);
	//public void setFacebookPerfilPertenceAComReversao(FacebookPerfil item);
	
	// Montador alternativo
	
	public void addListaFacebookPerfil_PertenceA(FacebookPerfil item); 
	public FacebookPerfil getCorrenteFacebookPerfil_PertenceA();
	
		
	// Montador tradicional
	public AppProduto getAppProdutoDivulga(boolean lazyLoader);
	public void setAppProdutoDivulga(AppProduto item);
	//public void setAppProdutoDivulgaComReversao(AppProduto item);
	
	// Montador alternativo
	
	public void addListaAppProduto_Divulga(AppProduto item); 
	public AppProduto getCorrenteAppProduto_Divulga();
	
		
	
	// Sem Chave Estrangeira
	
	public FacebookPost getCorrenteFacebookPost_Tem();
	public void addListaFacebookPost_Tem(FacebookPost item);
	public List<FacebookPost> getListaFacebookPost_Tem(); 
	public void setListaFacebookPost_Tem(List<FacebookPost> item); 
	public void criaVaziaListaFacebookPost_Tem();
	public boolean existeListaFacebookPost_Tem();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
