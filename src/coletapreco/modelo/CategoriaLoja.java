package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CategoriaLoja extends DCIObjetoDominio , CategoriaLojaAgregadoI , CategoriaLojaDerivadaI
{

	
	public long getIdCategoriaLoja();
	public void setIdCategoriaLoja(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
	public long getIdCategoriaLojaF();
	public void setIdCategoriaLojaF(long valor);
	
	
	public long getIdNaturezaProdutoRa();
	public void setIdNaturezaProdutoRa(long valor);
	
	
	public long getIdLojaVirtualPa();
	public void setIdLojaVirtualPa(long valor);
	
	
}

