package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ProdutoClienteAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader);
	public void setNaturezaProdutoReferenteA(NaturezaProduto item);
	//public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA();
	
		
	// Montador tradicional
	public Usuario getUsuarioSincroniza(boolean lazyLoader);
	public void setUsuarioSincroniza(Usuario item);
	//public void setUsuarioSincronizaComReversao(Usuario item);
	
	// Montador alternativo
	
	public void addListaUsuario_Sincroniza(Usuario item); 
	public Usuario getCorrenteUsuario_Sincroniza();
	
		
	// Montador tradicional
	public PalavraChavePesquisa getPalavraChavePesquisaReferenteA(boolean lazyLoader);
	public void setPalavraChavePesquisaReferenteA(PalavraChavePesquisa item);
	//public void setPalavraChavePesquisaReferenteAComReversao(PalavraChavePesquisa item);
	
	// Montador alternativo
	
	public void addListaPalavraChavePesquisa_ReferenteA(PalavraChavePesquisa item); 
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	public InteresseProduto getCorrenteInteresseProduto_Possui();
	public void addListaInteresseProduto_Possui(InteresseProduto item);
	public List<InteresseProduto> getListaInteresseProduto_Possui(); 
	public void setListaInteresseProduto_Possui(List<InteresseProduto> item); 
	public void criaVaziaListaInteresseProduto_Possui();
	public boolean existeListaInteresseProduto_Possui();
 		
	public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Possui();
	public void addListaPrecoDiarioCliente_Possui(PrecoDiarioCliente item);
	public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Possui(); 
	public void setListaPrecoDiarioCliente_Possui(List<PrecoDiarioCliente> item); 
	public void criaVaziaListaPrecoDiarioCliente_Possui();
	public boolean existeListaPrecoDiarioCliente_Possui();
 		
	public OportunidadeInteresseCliente getCorrenteOportunidadeInteresseCliente_Possui();
	public void addListaOportunidadeInteresseCliente_Possui(OportunidadeInteresseCliente item);
	public List<OportunidadeInteresseCliente> getListaOportunidadeInteresseCliente_Possui(); 
	public void setListaOportunidadeInteresseCliente_Possui(List<OportunidadeInteresseCliente> item); 
	public void criaVaziaListaOportunidadeInteresseCliente_Possui();
	public boolean existeListaOportunidadeInteresseCliente_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
