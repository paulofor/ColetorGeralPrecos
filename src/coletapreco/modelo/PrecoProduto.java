package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PrecoProduto extends DCIObjetoDominio , PrecoProdutoAgregadoI , PrecoProdutoDerivadaI
{

	
	public long getIdPrecoProduto();
	public void setIdPrecoProduto(long valor);
	
	
	public float getPrecoBoleto();
	public void setPrecoBoleto(float valor);
	
	public String getPrecoBoletoFormatada();
	
	
	public String getDataVisitaInicial();
	public void setDataVisitaInicial(String valor);
	
	
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
	
	
	public String getDataUltimaVisita();
	public void setDataUltimaVisita(String valor);
	
	
	public float getPercentualAjuste();
	public void setPercentualAjuste(float valor);
	
	
	public float getMedia2meses();
	public void setMedia2meses(float valor);
	
	public String getMedia2mesesFormatada();
	
	
	public float getMinimo3meses();
	public void setMinimo3meses(float valor);
	
	public String getMinimo3mesesFormatada();
	
	
	public long getIdProdutoPa();
	public void setIdProdutoPa(long valor);
	
	public long getPosicao();
	public void setPosicao(long valor);
	
	
	
}

