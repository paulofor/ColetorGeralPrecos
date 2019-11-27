package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface LojaVirtualAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public Produto getCorrenteProduto_Possui();
	public void addListaProduto_Possui(Produto item);
	public List<Produto> getListaProduto_Possui(); 
	public void setListaProduto_Possui(List<Produto> item); 
	public void criaVaziaListaProduto_Possui();
	public boolean existeListaProduto_Possui();
 		
	public CategoriaLoja getCorrenteCategoriaLoja_Possui();
	public void addListaCategoriaLoja_Possui(CategoriaLoja item);
	public List<CategoriaLoja> getListaCategoriaLoja_Possui(); 
	public void setListaCategoriaLoja_Possui(List<CategoriaLoja> item); 
	public void criaVaziaListaCategoriaLoja_Possui();
	public boolean existeListaCategoriaLoja_Possui();
 		
	public LojaNatureza getCorrenteLojaNatureza_Oferece();
	public void addListaLojaNatureza_Oferece(LojaNatureza item);
	public List<LojaNatureza> getListaLojaNatureza_Oferece(); 
	public void setListaLojaNatureza_Oferece(List<LojaNatureza> item); 
	public void criaVaziaListaLojaNatureza_Oferece();
	public boolean existeListaLojaNatureza_Oferece();
 		
	public ContagemProduto getCorrenteContagemProduto_Possui();
	public void addListaContagemProduto_Possui(ContagemProduto item);
	public List<ContagemProduto> getListaContagemProduto_Possui(); 
	public void setListaContagemProduto_Possui(List<ContagemProduto> item); 
	public void criaVaziaListaContagemProduto_Possui();
	public boolean existeListaContagemProduto_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
