package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface NaturezaProduto extends DCIObjetoDominio , NaturezaProdutoAgregadoI , NaturezaProdutoDerivadaI
{

	
	public long getIdNaturezaProduto();
	public void setIdNaturezaProduto(long valor);
	
	
	public String getNomeNaturezaProduto();
	public void setNomeNaturezaProduto(String valor);
	
	
	public String getCodigoNaturezaProduto();
	public void setCodigoNaturezaProduto(String valor);
	
	
	public long getIdAppProdutoAp();
	public void setIdAppProdutoAp(long valor);
	
	
}

