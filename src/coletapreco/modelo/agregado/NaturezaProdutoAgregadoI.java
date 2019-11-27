package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface NaturezaProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public AppProduto getAppProdutoAtendidoPor(boolean lazyLoader);
	public void setAppProdutoAtendidoPor(AppProduto item);
	//public void setAppProdutoAtendidoPorComReversao(AppProduto item);
	
	// Montador alternativo
	
	public void addListaAppProduto_AtendidoPor(AppProduto item); 
	public AppProduto getCorrenteAppProduto_AtendidoPor();
	
		
	
	// Sem Chave Estrangeira
	
	public CategoriaLoja getCorrenteCategoriaLoja_Possui();
	public void addListaCategoriaLoja_Possui(CategoriaLoja item);
	public List<CategoriaLoja> getListaCategoriaLoja_Possui(); 
	public void setListaCategoriaLoja_Possui(List<CategoriaLoja> item); 
	public void criaVaziaListaCategoriaLoja_Possui();
	public boolean existeListaCategoriaLoja_Possui();
 		
	public LojaNatureza getCorrenteLojaNatureza_Encontrada();
	public void addListaLojaNatureza_Encontrada(LojaNatureza item);
	public List<LojaNatureza> getListaLojaNatureza_Encontrada(); 
	public void setListaLojaNatureza_Encontrada(List<LojaNatureza> item); 
	public void criaVaziaListaLojaNatureza_Encontrada();
	public boolean existeListaLojaNatureza_Encontrada();
 		
	public OportunidadeDia getCorrenteOportunidadeDia_Possui();
	public void addListaOportunidadeDia_Possui(OportunidadeDia item);
	public List<OportunidadeDia> getListaOportunidadeDia_Possui(); 
	public void setListaOportunidadeDia_Possui(List<OportunidadeDia> item); 
	public void criaVaziaListaOportunidadeDia_Possui();
	public boolean existeListaOportunidadeDia_Possui();
 		
	public UsuarioPesquisa getCorrenteUsuarioPesquisa_PesquisadoPor();
	public void addListaUsuarioPesquisa_PesquisadoPor(UsuarioPesquisa item);
	public List<UsuarioPesquisa> getListaUsuarioPesquisa_PesquisadoPor(); 
	public void setListaUsuarioPesquisa_PesquisadoPor(List<UsuarioPesquisa> item); 
	public void criaVaziaListaUsuarioPesquisa_PesquisadoPor();
	public boolean existeListaUsuarioPesquisa_PesquisadoPor();
 		
	public ContagemProduto getCorrenteContagemProduto_Possui();
	public void addListaContagemProduto_Possui(ContagemProduto item);
	public List<ContagemProduto> getListaContagemProduto_Possui(); 
	public void setListaContagemProduto_Possui(List<ContagemProduto> item); 
	public void criaVaziaListaContagemProduto_Possui();
	public boolean existeListaContagemProduto_Possui();
 		
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_PodePesquisar();
	public void addListaPalavraChavePesquisa_PodePesquisar(PalavraChavePesquisa item);
	public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_PodePesquisar(); 
	public void setListaPalavraChavePesquisa_PodePesquisar(List<PalavraChavePesquisa> item); 
	public void criaVaziaListaPalavraChavePesquisa_PodePesquisar();
	public boolean existeListaPalavraChavePesquisa_PodePesquisar();
 		
	public ProdutoCliente getCorrenteProdutoCliente_Possui();
	public void addListaProdutoCliente_Possui(ProdutoCliente item);
	public List<ProdutoCliente> getListaProdutoCliente_Possui(); 
	public void setListaProdutoCliente_Possui(List<ProdutoCliente> item); 
	public void criaVaziaListaProdutoCliente_Possui();
	public boolean existeListaProdutoCliente_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
