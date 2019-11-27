package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Palavra extends DCIObjetoDominio , PalavraAgregadoI , PalavraDerivadaI
{

	
	public long getIdPalavra();
	public void setIdPalavra(long valor);
	
	
	public String getDescricao();
	public void setDescricao(String valor);
	
	
	public boolean getComum();
	public void setComum(boolean valor);
	
	
}

