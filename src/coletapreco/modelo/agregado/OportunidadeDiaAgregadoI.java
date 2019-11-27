package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface OportunidadeDiaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Produto getProdutoReferenteA(boolean lazyLoader);
	public void setProdutoReferenteA(Produto item);
	//public void setProdutoReferenteAComReversao(Produto item);
	
	// Montador alternativo
	
	public void addListaProduto_ReferenteA(Produto item); 
	public Produto getCorrenteProduto_ReferenteA();
	
		
	// Montador tradicional
	public NaturezaProduto getNaturezaProdutoPertenceA(boolean lazyLoader);
	public void setNaturezaProdutoPertenceA(NaturezaProduto item);
	//public void setNaturezaProdutoPertenceAComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_PertenceA(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
