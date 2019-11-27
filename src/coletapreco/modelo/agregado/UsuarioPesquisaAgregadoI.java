package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface UsuarioPesquisaAgregadoI{

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
	public NaturezaProduto getNaturezaProdutoPesquisa(boolean lazyLoader);
	public void setNaturezaProdutoPesquisa(NaturezaProduto item);
	//public void setNaturezaProdutoPesquisaComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_Pesquisa(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_Pesquisa();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
