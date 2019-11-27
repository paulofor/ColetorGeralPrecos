package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CompartilhamentoProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Usuario getUsuarioPertenceA(boolean lazyLoader);
	public void setUsuarioPertenceA(Usuario item);
	//public void setUsuarioPertenceAComReversao(Usuario item);
	
	// Montador alternativo
	
	public void addListaUsuario_PertenceA(Usuario item); 
	public Usuario getCorrenteUsuario_PertenceA();
	
		
	// Montador tradicional
	public Produto getProdutoReferenteA(boolean lazyLoader);
	public void setProdutoReferenteA(Produto item);
	//public void setProdutoReferenteAComReversao(Produto item);
	
	// Montador alternativo
	
	public void addListaProduto_ReferenteA(Produto item); 
	public Produto getCorrenteProduto_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
