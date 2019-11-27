package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface PalavraChavePesquisaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Usuario getUsuarioSincroniza(boolean lazyLoader);
	public void setUsuarioSincroniza(Usuario item);
	//public void setUsuarioSincronizaComReversao(Usuario item);
	
	// Montador alternativo
	
	public void addListaUsuario_Sincroniza(Usuario item); 
	public Usuario getCorrenteUsuario_Sincroniza();
	
		
	// Montador tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader);
	public void setNaturezaProdutoReferenteA(NaturezaProduto item);
	//public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	public ProdutoCliente getCorrenteProdutoCliente_Gerou();
	public void addListaProdutoCliente_Gerou(ProdutoCliente item);
	public List<ProdutoCliente> getListaProdutoCliente_Gerou(); 
	public void setListaProdutoCliente_Gerou(List<ProdutoCliente> item); 
	public void criaVaziaListaProdutoCliente_Gerou();
	public boolean existeListaProdutoCliente_Gerou();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
