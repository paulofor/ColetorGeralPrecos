package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface FacebookPostAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public FacebookFanpage getFacebookFanpageFeitoEm(boolean lazyLoader);
	public void setFacebookFanpageFeitoEm(FacebookFanpage item);
	//public void setFacebookFanpageFeitoEmComReversao(FacebookFanpage item);
	
	// Montador alternativo
	
	public void addListaFacebookFanpage_FeitoEm(FacebookFanpage item); 
	public FacebookFanpage getCorrenteFacebookFanpage_FeitoEm();
	
		
	// Montador tradicional
	public Produto getProdutoDivulgando(boolean lazyLoader);
	public void setProdutoDivulgando(Produto item);
	//public void setProdutoDivulgandoComReversao(Produto item);
	
	// Montador alternativo
	
	public void addListaProduto_Divulgando(Produto item); 
	public Produto getCorrenteProduto_Divulgando();
	
		
	
	// Sem Chave Estrangeira
	
	public FacebookPostPerformance getCorrenteFacebookPostPerformance_Gera();
	public void addListaFacebookPostPerformance_Gera(FacebookPostPerformance item);
	public List<FacebookPostPerformance> getListaFacebookPostPerformance_Gera(); 
	public void setListaFacebookPostPerformance_Gera(List<FacebookPostPerformance> item); 
	public void criaVaziaListaFacebookPostPerformance_Gera();
	public boolean existeListaFacebookPostPerformance_Gera();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
