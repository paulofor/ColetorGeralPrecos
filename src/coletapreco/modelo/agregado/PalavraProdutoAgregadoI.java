package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PalavraProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Palavra getPalavraRelaciondoA(boolean lazyLoader);
	public void setPalavraRelaciondoA(Palavra item);
	//public void setPalavraRelaciondoAComReversao(Palavra item);
	
	// Montador alternativo
	
	public void addListaPalavra_RelaciondoA(Palavra item); 
	public Palavra getCorrentePalavra_RelaciondoA();
	
		
	// Montador tradicional
	public Produto getProdutoRelaciondoA(boolean lazyLoader);
	public void setProdutoRelaciondoA(Produto item);
	//public void setProdutoRelaciondoAComReversao(Produto item);
	
	// Montador alternativo
	
	public void addListaProduto_RelaciondoA(Produto item); 
	public Produto getCorrenteProduto_RelaciondoA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
