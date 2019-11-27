package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PrecoDiarioAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Produto getProdutoPertenceA(boolean lazyLoader);
	public void setProdutoPertenceA(Produto item);
	//public void setProdutoPertenceAComReversao(Produto item);
	
	// Montador alternativo
	
	public void addListaProduto_PertenceA(Produto item); 
	public Produto getCorrenteProduto_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
