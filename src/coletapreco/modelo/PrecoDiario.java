package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoDiario extends DCIObjetoDominio , PrecoDiarioAgregadoI , PrecoDiarioDerivadaI
{

	
	public long getIdPrecoDiario();
	public void setIdPrecoDiario(long valor);
	
	
	public float getPrecoBoleto();
	public void setPrecoBoleto(float valor);
	
	public String getPrecoBoletoFormatada();
	
	
	public String getDataHora();
	public void setDataHora(String valor);
	
	
	public long getQuantidadeParcela();
	public void setQuantidadeParcela(long valor);
	
	
	public float getPrecoParcela();
	public void setPrecoParcela(float valor);
	
	public String getPrecoParcelaFormatada();
	
	
	public float getPrecoVenda();
	public void setPrecoVenda(float valor);
	
	public String getPrecoVendaFormatada();
	
	
	public float getPrecoRegular();
	public void setPrecoRegular(float valor);
	
	public String getPrecoRegularFormatada();
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public long getIdProdutoPa();
	public void setIdProdutoPa(long valor);
	
	public long getIdOportunidadeDia();
	public void setIdOportunidadeDia(long id);
	
	public long getIdNaturezaProduto();
	public void setIdNaturezaProduto(long id);

}

