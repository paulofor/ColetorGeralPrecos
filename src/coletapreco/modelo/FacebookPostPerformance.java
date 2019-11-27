package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookPostPerformance extends DCIObjetoDominio , FacebookPostPerformanceAgregadoI , FacebookPostPerformanceDerivadaI
{

	
	public long getIdFacebookPostPerformance();
	public void setIdFacebookPostPerformance(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public long getAlcance();
	public void setAlcance(long valor);
	
	
	public long getIdFacebookPostRa();
	public void setIdFacebookPostRa(long valor);
	
	
}

