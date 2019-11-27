package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PalavraChavePesquisa extends DCIObjetoDominio , PalavraChavePesquisaAgregadoI , PalavraChavePesquisaDerivadaI
{

	
	public long getIdPalavraChavePesquisa();
	public void setIdPalavraChavePesquisa(long valor);
	
	
	public String getTextoBusca();
	public void setTextoBusca(String valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public long getIdUsuarioS();
	public void setIdUsuarioS(long valor);
	
	
	public long getIdNaturezaProdutoRa();
	public void setIdNaturezaProdutoRa(long valor);
	
	
}

