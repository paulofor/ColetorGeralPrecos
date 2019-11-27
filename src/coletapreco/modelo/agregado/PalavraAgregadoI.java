package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PalavraAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public PalavraProduto getCorrentePalavraProduto_Possui();
	public void addListaPalavraProduto_Possui(PalavraProduto item);
	public List<PalavraProduto> getListaPalavraProduto_Possui(); 
	public void setListaPalavraProduto_Possui(List<PalavraProduto> item); 
	public void criaVaziaListaPalavraProduto_Possui();
	public boolean existeListaPalavraProduto_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
