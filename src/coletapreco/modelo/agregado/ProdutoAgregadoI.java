package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public LojaVirtual getLojaVirtualLidoEm(boolean lazyLoader);
	public void setLojaVirtualLidoEm(LojaVirtual item);
	//public void setLojaVirtualLidoEmComReversao(LojaVirtual item);
	
	// Montador alternativo
	
	public void addListaLojaVirtual_LidoEm(LojaVirtual item); 
	public LojaVirtual getCorrenteLojaVirtual_LidoEm();
	
		
	// Montador tradicional
	public Marca getMarcaPossui(boolean lazyLoader);
	public void setMarcaPossui(Marca item);
	//public void setMarcaPossuiComReversao(Marca item);
	
	// Montador alternativo
	
	public void addListaMarca_Possui(Marca item); 
	public Marca getCorrenteMarca_Possui();
	
		
	
	// Sem Chave Estrangeira
	
	public PrecoDiario getCorrentePrecoDiario_Possui();
	public void addListaPrecoDiario_Possui(PrecoDiario item);
	public List<PrecoDiario> getListaPrecoDiario_Possui(); 
	public void setListaPrecoDiario_Possui(List<PrecoDiario> item); 
	public void criaVaziaListaPrecoDiario_Possui();
	public boolean existeListaPrecoDiario_Possui();
 		
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto_ReferenteA();
	public void addListaModeloProdutoProduto_ReferenteA(ModeloProdutoProduto item);
	public List<ModeloProdutoProduto> getListaModeloProdutoProduto_ReferenteA(); 
	public void setListaModeloProdutoProduto_ReferenteA(List<ModeloProdutoProduto> item); 
	public void criaVaziaListaModeloProdutoProduto_ReferenteA();
	public boolean existeListaModeloProdutoProduto_ReferenteA();
 		
	public PrecoProduto getCorrentePrecoProduto_Possui();
	public void addListaPrecoProduto_Possui(PrecoProduto item);
	public List<PrecoProduto> getListaPrecoProduto_Possui(); 
	public void setListaPrecoProduto_Possui(List<PrecoProduto> item); 
	public void criaVaziaListaPrecoProduto_Possui();
	public boolean existeListaPrecoProduto_Possui();
 		
	public CategoriaLojaProduto getCorrenteCategoriaLojaProduto_Possui();
	public void addListaCategoriaLojaProduto_Possui(CategoriaLojaProduto item);
	public List<CategoriaLojaProduto> getListaCategoriaLojaProduto_Possui(); 
	public void setListaCategoriaLojaProduto_Possui(List<CategoriaLojaProduto> item); 
	public void criaVaziaListaCategoriaLojaProduto_Possui();
	public boolean existeListaCategoriaLojaProduto_Possui();
 		
	public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir();
	public void addListaOportunidadeDia_PodePossuir(OportunidadeDia item);
	public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir(); 
	public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> item); 
	public void criaVaziaListaOportunidadeDia_PodePossuir();
	public boolean existeListaOportunidadeDia_PodePossuir();
 		
	public PalavraProduto getCorrentePalavraProduto_Possui();
	public void addListaPalavraProduto_Possui(PalavraProduto item);
	public List<PalavraProduto> getListaPalavraProduto_Possui(); 
	public void setListaPalavraProduto_Possui(List<PalavraProduto> item); 
	public void criaVaziaListaPalavraProduto_Possui();
	public boolean existeListaPalavraProduto_Possui();
 		
	public FacebookPost getCorrenteFacebookPost_DivulgadoPor();
	public void addListaFacebookPost_DivulgadoPor(FacebookPost item);
	public List<FacebookPost> getListaFacebookPost_DivulgadoPor(); 
	public void setListaFacebookPost_DivulgadoPor(List<FacebookPost> item); 
	public void criaVaziaListaFacebookPost_DivulgadoPor();
	public boolean existeListaFacebookPost_DivulgadoPor();
 		
	public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Gerou();
	public void addListaCompartilhamentoProduto_Gerou(CompartilhamentoProduto item);
	public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Gerou(); 
	public void setListaCompartilhamentoProduto_Gerou(List<CompartilhamentoProduto> item); 
	public void criaVaziaListaCompartilhamentoProduto_Gerou();
	public boolean existeListaCompartilhamentoProduto_Gerou();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
