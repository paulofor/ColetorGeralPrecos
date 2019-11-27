package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaLojaProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public CategoriaLoja getCategoriaLojaReferenteA(boolean lazyLoader);
	public void setCategoriaLojaReferenteA(CategoriaLoja item);
	//public void setCategoriaLojaReferenteAComReversao(CategoriaLoja item);
	
	// Montador alternativo
	
	public void addListaCategoriaLoja_ReferenteA(CategoriaLoja item); 
	public CategoriaLoja getCorrenteCategoriaLoja_ReferenteA();
	
		
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
