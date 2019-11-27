package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OportunidadeDia extends DCIObjetoDominio , OportunidadeDiaAgregadoI , OportunidadeDiaDerivadaI
{

	
	public long getIdOportunidadeDia();
	public void setIdOportunidadeDia(long valor);
	
	
	public String getUrlProduto();
	public void setUrlProduto(String valor);
	
	
	public String getNomeProduto();
	public void setNomeProduto(String valor);
	
	
	public String getDataInicioPrecoAtual();
	public void setDataInicioPrecoAtual(String valor);
	
	
	public String getNomeMarca();
	public void setNomeMarca(String valor);
	
	
	public String getUrlAfiliado();
	public void setUrlAfiliado(String valor);
	
	
	public String getDataUltimaPrecoAnterior();
	public void setDataUltimaPrecoAnterior(String valor);
	
	
	public String getImagemLocal();
	public void setImagemLocal(String valor);
	
	
	public String getUrlImagem();
	public void setUrlImagem(String valor);
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public float getPrecoVendaAnterior();
	public void setPrecoVendaAnterior(float valor);
	
	public String getPrecoVendaAnteriorFormatada();
	
	
	public float getPrecoVendaAtual();
	public void setPrecoVendaAtual(float valor);
	
	public String getPrecoVendaAtualFormatada();
	
	
	public float getPrecoBoletoAnterior();
	public void setPrecoBoletoAnterior(float valor);
	
	public String getPrecoBoletoAnteriorFormatada();
	
	
	public float getPrecoBoletoAtual();
	public void setPrecoBoletoAtual(float valor);
	
	public String getPrecoBoletoAtualFormatada();
	
	
	public float getPrecoParcelaAnterior();
	public void setPrecoParcelaAnterior(float valor);
	
	public String getPrecoParcelaAnteriorFormatada();
	
	
	public float getPrecoParcelaAtual();
	public void setPrecoParcelaAtual(float valor);
	
	public String getPrecoParcelaAtualFormatada();
	
	
	public long getQuantidadeParcelaAnterior();
	public void setQuantidadeParcelaAnterior(long valor);
	
	
	public long getQuantidadeParcelaAtual();
	public void setQuantidadeParcelaAtual(long valor);
	
	
	public float getPercentualAjusteVenda();
	public void setPercentualAjusteVenda(float valor);
	
	
	public float getPercentualAjusteBoleto();
	public void setPercentualAjusteBoleto(float valor);
	
	public String getPercentualAjusteBoletoFormatada();
	
	
	public String getNomeLojaVirtual();
	public void setNomeLojaVirtual(String valor);
	
	
	public float getPrecoMinimo();
	public void setPrecoMinimo(float valor);
	
	public String getPrecoMinimoFormatada();
	
	
	public float getPrecoMedio();
	public void setPrecoMedio(float valor);
	
	public String getPrecoMedioFormatada();
	
	
	public long getIdProdutoRa();
	public void setIdProdutoRa(long valor);
	
	
	public long getIdNaturezaProdutoPa();
	public void setIdNaturezaProdutoPa(long valor);
	
	
}

