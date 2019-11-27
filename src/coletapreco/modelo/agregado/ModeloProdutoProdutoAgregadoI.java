package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ModeloProdutoProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ModeloProduto getModeloProdutoReferenteA(boolean lazyLoader);
	public void setModeloProdutoReferenteA(ModeloProduto item);
	//public void setModeloProdutoReferenteAComReversao(ModeloProduto item);
	
	// Montador alternativo
	
	public void addListaModeloProduto_ReferenteA(ModeloProduto item); 
	public ModeloProduto getCorrenteModeloProduto_ReferenteA();
	
		
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
