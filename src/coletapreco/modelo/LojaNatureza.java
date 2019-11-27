package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface LojaNatureza extends DCIObjetoDominio , LojaNaturezaAgregadoI , LojaNaturezaDerivadaI
{

	
	public long getIdLojaNatureza();
	public void setIdLojaNatureza(long valor);
	
	
	public String getUrlInicial();
	public void setUrlInicial(String valor);
	
	
	public boolean getParseCategoria();
	public void setParseCategoria(boolean valor);
	
	
	public long getIdLojaVirtualRa();
	public void setIdLojaVirtualRa(long valor);
	
	
	public long getIdNaturezaProdutoRa();
	public void setIdNaturezaProdutoRa(long valor);
	
	
}

