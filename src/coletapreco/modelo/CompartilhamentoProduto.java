package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CompartilhamentoProduto extends DCIObjetoDominio , CompartilhamentoProdutoAgregadoI , CompartilhamentoProdutoDerivadaI
{

	
	public long getIdCompartilhamentoProduto();
	public void setIdCompartilhamentoProduto(long valor);
	
	
	public String getDataHora();
	public void setDataHora(String valor);
	
	
	public long getIdUsuarioPa();
	public void setIdUsuarioPa(long valor);
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
}

