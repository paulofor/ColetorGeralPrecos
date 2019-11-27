package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface MarcaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public Produto getCorrenteProduto_ReferenteA();
	public void addListaProduto_ReferenteA(Produto item);
	public List<Produto> getListaProduto_ReferenteA(); 
	public void setListaProduto_ReferenteA(List<Produto> item); 
	public void criaVaziaListaProduto_ReferenteA();
	public boolean existeListaProduto_ReferenteA();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
