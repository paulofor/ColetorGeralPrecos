package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface LojaVirtual extends DCIObjetoDominio , LojaVirtualAgregadoI , LojaVirtualDerivadaI
{

	
	public long getIdLojaVirtual();
	public void setIdLojaVirtual(long valor);
	
	
	public String getNomeLojaVirtual();
	public void setNomeLojaVirtual(String valor);
	
	
	public String getUrlInicialBrinquedo();
	public void setUrlInicialBrinquedo(String valor);
	
	
}

