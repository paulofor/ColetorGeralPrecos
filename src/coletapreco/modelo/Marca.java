package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Marca extends DCIObjetoDominio , MarcaAgregadoI , MarcaDerivadaI
{

	
	public long getIdMarca();
	public void setIdMarca(long valor);
	
	
	public String getNomeMarca();
	public void setNomeMarca(String valor);
	
	
}

