package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface UsuarioPesquisa extends DCIObjetoDominio , UsuarioPesquisaAgregadoI , UsuarioPesquisaDerivadaI
{

	
	public long getIdUsuarioPesquisa();
	public void setIdUsuarioPesquisa(long valor);
	
	
	public long getIdUsuarioS();
	public void setIdUsuarioS(long valor);
	
	
	public long getIdNaturezaProdutoP();
	public void setIdNaturezaProdutoP(long valor);
	
	
}

