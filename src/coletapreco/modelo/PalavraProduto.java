package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PalavraProduto extends DCIObjetoDominio , PalavraProdutoAgregadoI , PalavraProdutoDerivadaI
{

	
	public long getIdPalavraProduto();
	public void setIdPalavraProduto(long valor);
	
	
	public long getIdPalavraRa();
	public void setIdPalavraRa(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

