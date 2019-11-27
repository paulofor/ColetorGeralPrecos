package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface OportunidadeInteresseClienteAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ProdutoCliente getProdutoClientePertenceA(boolean lazyLoader);
	public void setProdutoClientePertenceA(ProdutoCliente item);
	//public void setProdutoClientePertenceAComReversao(ProdutoCliente item);
	
	// Montador alternativo
	
	public void addListaProdutoCliente_PertenceA(ProdutoCliente item); 
	public ProdutoCliente getCorrenteProdutoCliente_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
