package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface InteresseProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ProdutoCliente getProdutoClienteReferenteA(boolean lazyLoader);
	public void setProdutoClienteReferenteA(ProdutoCliente item);
	//public void setProdutoClienteReferenteAComReversao(ProdutoCliente item);
	
	// Montador alternativo
	
	public void addListaProdutoCliente_ReferenteA(ProdutoCliente item); 
	public ProdutoCliente getCorrenteProdutoCliente_ReferenteA();
	
		
	// Montador tradicional
	public Usuario getUsuarioSincroniza(boolean lazyLoader);
	public void setUsuarioSincroniza(Usuario item);
	//public void setUsuarioSincronizaComReversao(Usuario item);
	
	// Montador alternativo
	
	public void addListaUsuario_Sincroniza(Usuario item); 
	public Usuario getCorrenteUsuario_Sincroniza();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
