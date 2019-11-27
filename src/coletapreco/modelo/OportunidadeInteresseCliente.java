package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OportunidadeInteresseCliente extends DCIObjetoDominio , OportunidadeInteresseClienteAgregadoI , OportunidadeInteresseClienteDerivadaI
{

	
	public long getIdOportunidadeInteresseCliente();
	public void setIdOportunidadeInteresseCliente(long valor);
	
	
	public long getIdProdutoClientePa();
	public void setIdProdutoClientePa(long valor);
	
	
}

