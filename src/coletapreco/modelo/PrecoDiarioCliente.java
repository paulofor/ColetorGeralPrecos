package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoDiarioCliente extends DCIObjetoDominio , PrecoDiarioClienteAgregadoI , PrecoDiarioClienteDerivadaI
{

	
	public long getIdPrecoDiarioClientte();
	public void setIdPrecoDiarioClientte(long valor);
	
	
	public String getDataHora();
	public void setDataHora(String valor);
	
	
	public float getPrecoVenda();
	public void setPrecoVenda(float valor);
	
	public String getPrecoVendaFormatada();
	
	
	public long getIdProdutoClientePa();
	public void setIdProdutoClientePa(long valor);
	
	
	public long getIdUsuarioS();
	public void setIdUsuarioS(long valor);
	
	
}

