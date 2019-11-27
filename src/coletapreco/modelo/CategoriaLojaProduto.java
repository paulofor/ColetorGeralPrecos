package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CategoriaLojaProduto extends DCIObjetoDominio , CategoriaLojaProdutoAgregadoI , CategoriaLojaProdutoDerivadaI
{

	
	public long getIdCategoriaLojaProduto();
	public void setIdCategoriaLojaProduto(long valor);
	
	
	public String getDataUltimaVisita();
	public void setDataUltimaVisita(String valor);
	
	
	public long getIdCategoriaLojaRa();
	public void setIdCategoriaLojaRa(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

