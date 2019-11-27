package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ModeloProdutoProduto extends DCIObjetoDominio , ModeloProdutoProdutoAgregadoI , ModeloProdutoProdutoDerivadaI
{

	
	public long getIdModeloProdutoProduto();
	public void setIdModeloProdutoProduto(long valor);
	
	
	public long getIdModeloProdutoRa();
	public void setIdModeloProdutoRa(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

