package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface AppProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public FacebookFanpage getCorrenteFacebookFanpage_DivulgadoPor();
	public void addListaFacebookFanpage_DivulgadoPor(FacebookFanpage item);
	public List<FacebookFanpage> getListaFacebookFanpage_DivulgadoPor(); 
	public void setListaFacebookFanpage_DivulgadoPor(List<FacebookFanpage> item); 
	public void criaVaziaListaFacebookFanpage_DivulgadoPor();
	public boolean existeListaFacebookFanpage_DivulgadoPor();
 		
	public NaturezaProduto getCorrenteNaturezaProduto_Atende();
	public void addListaNaturezaProduto_Atende(NaturezaProduto item);
	public List<NaturezaProduto> getListaNaturezaProduto_Atende(); 
	public void setListaNaturezaProduto_Atende(List<NaturezaProduto> item); 
	public void criaVaziaListaNaturezaProduto_Atende();
	public boolean existeListaNaturezaProduto_Atende();
 		
	public DispositivoUsuario getCorrenteDispositivoUsuario_UsadoPor();
	public void addListaDispositivoUsuario_UsadoPor(DispositivoUsuario item);
	public List<DispositivoUsuario> getListaDispositivoUsuario_UsadoPor(); 
	public void setListaDispositivoUsuario_UsadoPor(List<DispositivoUsuario> item); 
	public void criaVaziaListaDispositivoUsuario_UsadoPor();
	public boolean existeListaDispositivoUsuario_UsadoPor();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
