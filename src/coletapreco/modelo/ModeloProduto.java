package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ModeloProduto extends DCIObjetoDominio , ModeloProdutoAgregadoI , ModeloProdutoDerivadaI
{

	
	public long getIdModeloProduto();
	public void setIdModeloProduto(long valor);
	
	
	public String getNomeModeloProduto();
	public void setNomeModeloProduto(String valor);
	
	
}

