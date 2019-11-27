package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ModeloProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto_ReferenteA();
	public void addListaModeloProdutoProduto_ReferenteA(ModeloProdutoProduto item);
	public List<ModeloProdutoProduto> getListaModeloProdutoProduto_ReferenteA(); 
	public void setListaModeloProdutoProduto_ReferenteA(List<ModeloProdutoProduto> item); 
	public void criaVaziaListaModeloProdutoProduto_ReferenteA();
	public boolean existeListaModeloProdutoProduto_ReferenteA();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
