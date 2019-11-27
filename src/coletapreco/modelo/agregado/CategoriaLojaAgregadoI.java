package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CategoriaLojaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public CategoriaLoja getCategoriaLojaFilho(boolean lazyLoader);
	public void setCategoriaLojaFilho(CategoriaLoja item);
	//public void setCategoriaLojaFilhoComReversao(CategoriaLoja item);
	
	// Montador alternativo
	
	/*  AutoRelacionamento
	
	public void addListaCategoriaLoja_Filho(CategoriaLoja item); 
	public CategoriaLoja getCorrenteCategoriaLoja_Filho();
	
	*/
	
		
	// Montador tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader);
	public void setNaturezaProdutoReferenteA(NaturezaProduto item);
	//public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA();
	
		
	// Montador tradicional
	public LojaVirtual getLojaVirtualPertenceA(boolean lazyLoader);
	public void setLojaVirtualPertenceA(LojaVirtual item);
	//public void setLojaVirtualPertenceAComReversao(LojaVirtual item);
	
	// Montador alternativo
	
	public void addListaLojaVirtual_PertenceA(LojaVirtual item); 
	public LojaVirtual getCorrenteLojaVirtual_PertenceA();
	
		
	
	// Sem Chave Estrangeira
	
	public CategoriaLojaProduto getCorrenteCategoriaLojaProduto_Possui();
	public void addListaCategoriaLojaProduto_Possui(CategoriaLojaProduto item);
	public List<CategoriaLojaProduto> getListaCategoriaLojaProduto_Possui(); 
	public void setListaCategoriaLojaProduto_Possui(List<CategoriaLojaProduto> item); 
	public void criaVaziaListaCategoriaLojaProduto_Possui();
	public boolean existeListaCategoriaLojaProduto_Possui();
 		
	public CategoriaLoja getCorrenteCategoriaLoja_Filho();
	public void addListaCategoriaLoja_Filho(CategoriaLoja item);
	public List<CategoriaLoja> getListaCategoriaLoja_Filho(); 
	public void setListaCategoriaLoja_Filho(List<CategoriaLoja> item); 
	public void criaVaziaListaCategoriaLoja_Filho();
	public boolean existeListaCategoriaLoja_Filho();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
