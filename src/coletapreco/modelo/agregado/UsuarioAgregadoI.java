package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface UsuarioAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public DispositivoUsuario getCorrenteDispositivoUsuario_Usa();
	public void addListaDispositivoUsuario_Usa(DispositivoUsuario item);
	public List<DispositivoUsuario> getListaDispositivoUsuario_Usa(); 
	public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> item); 
	public void criaVaziaListaDispositivoUsuario_Usa();
	public boolean existeListaDispositivoUsuario_Usa();
 		
	public UsuarioPesquisa getCorrenteUsuarioPesquisa_Sincroniza();
	public void addListaUsuarioPesquisa_Sincroniza(UsuarioPesquisa item);
	public List<UsuarioPesquisa> getListaUsuarioPesquisa_Sincroniza(); 
	public void setListaUsuarioPesquisa_Sincroniza(List<UsuarioPesquisa> item); 
	public void criaVaziaListaUsuarioPesquisa_Sincroniza();
	public boolean existeListaUsuarioPesquisa_Sincroniza();
 		
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_Possui();
	public void addListaPalavraChavePesquisa_Possui(PalavraChavePesquisa item);
	public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_Possui(); 
	public void setListaPalavraChavePesquisa_Possui(List<PalavraChavePesquisa> item); 
	public void criaVaziaListaPalavraChavePesquisa_Possui();
	public boolean existeListaPalavraChavePesquisa_Possui();
 		
	public InteresseProduto getCorrenteInteresseProduto_Sincroniza();
	public void addListaInteresseProduto_Sincroniza(InteresseProduto item);
	public List<InteresseProduto> getListaInteresseProduto_Sincroniza(); 
	public void setListaInteresseProduto_Sincroniza(List<InteresseProduto> item); 
	public void criaVaziaListaInteresseProduto_Sincroniza();
	public boolean existeListaInteresseProduto_Sincroniza();
 		
	public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Sincroniza();
	public void addListaPrecoDiarioCliente_Sincroniza(PrecoDiarioCliente item);
	public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Sincroniza(); 
	public void setListaPrecoDiarioCliente_Sincroniza(List<PrecoDiarioCliente> item); 
	public void criaVaziaListaPrecoDiarioCliente_Sincroniza();
	public boolean existeListaPrecoDiarioCliente_Sincroniza();
 		
	public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Possui();
	public void addListaCompartilhamentoProduto_Possui(CompartilhamentoProduto item);
	public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Possui(); 
	public void setListaCompartilhamentoProduto_Possui(List<CompartilhamentoProduto> item); 
	public void criaVaziaListaCompartilhamentoProduto_Possui();
	public boolean existeListaCompartilhamentoProduto_Possui();
 		
	public ProdutoCliente getCorrenteProdutoCliente_Sincroniza();
	public void addListaProdutoCliente_Sincroniza(ProdutoCliente item);
	public List<ProdutoCliente> getListaProdutoCliente_Sincroniza(); 
	public void setListaProdutoCliente_Sincroniza(List<ProdutoCliente> item); 
	public void criaVaziaListaProdutoCliente_Sincroniza();
	public boolean existeListaProdutoCliente_Sincroniza();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
