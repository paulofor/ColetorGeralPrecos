package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OportunidadeDiaVo implements OportunidadeDia
{
		
	public long getIdObj()
    {
       return idOportunidadeDia;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOportunidadeDia\" : \"" + idOportunidadeDia + "\" "
		+ ", \"UrlProduto\" : \"" + urlProduto + "\" "
		+ ", \"NomeProduto\" : \"" + nomeProduto + "\" "
		+ ", \"DataInicioPrecoAtual\" : \"" + dataInicioPrecoAtual + "\" "
		+ ", \"NomeMarca\" : \"" + nomeMarca + "\" "
		+ ", \"UrlAfiliado\" : \"" + urlAfiliado + "\" "
		+ ", \"DataUltimaPrecoAnterior\" : \"" + dataUltimaPrecoAnterior + "\" "
		+ ", \"ImagemLocal\" : \"" + imagemLocal + "\" "
		+ ", \"UrlImagem\" : \"" + urlImagem + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"PrecoVendaAnterior\" : \"" + precoVendaAnterior + "\" "
		+ ", \"PrecoVendaAtual\" : \"" + precoVendaAtual + "\" "
		+ ", \"PrecoBoletoAnterior\" : \"" + precoBoletoAnterior + "\" "
		+ ", \"PrecoBoletoAtual\" : \"" + precoBoletoAtual + "\" "
		+ ", \"PrecoParcelaAnterior\" : \"" + precoParcelaAnterior + "\" "
		+ ", \"PrecoParcelaAtual\" : \"" + precoParcelaAtual + "\" "
		+ ", \"QuantidadeParcelaAnterior\" : \"" + quantidadeParcelaAnterior + "\" "
		+ ", \"QuantidadeParcelaAtual\" : \"" + quantidadeParcelaAtual + "\" "
		+ ", \"PercentualAjusteVenda\" : \"" + percentualAjusteVenda + "\" "
		+ ", \"PercentualAjusteBoleto\" : \"" + percentualAjusteBoleto + "\" "
		+ ", \"NomeLojaVirtual\" : \"" + nomeLojaVirtual + "\" "
		+ ", \"PrecoMinimo\" : \"" + precoMinimo + "\" "
		+ ", \"PrecoMedio\" : \"" + precoMedio + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
		+ ", \"IdNaturezaProdutoPa\" : \"" + idNaturezaProdutoPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OportunidadeDiaDerivada derivada = null;
	private OportunidadeDiaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OportunidadeDiaDerivada(this);
		}
		return derivada;
	}

	private OportunidadeDiaAgregado agregado = null;
	private OportunidadeDiaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OportunidadeDiaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Produto getProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getProdutoReferenteA(lazyLoader); 
	} 
	public void setProdutoReferenteA(Produto value) 
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	/*
	public void setProdutoReferenteAComReversao(Produto value) 
	{
		getAgregado().setProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_ReferenteA(Produto value)
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getProdutoReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public NaturezaProduto getNaturezaProdutoPertenceA(boolean lazyLoader)
	{
		return getAgregado().getNaturezaProdutoPertenceA(lazyLoader); 
	} 
	public void setNaturezaProdutoPertenceA(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoPertenceA(value); 
	} 
	/*
	public void setNaturezaProdutoPertenceAComReversao(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoPertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaNaturezaProduto_PertenceA(NaturezaProduto value)
	{
		getAgregado().setNaturezaProdutoPertenceA(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_PertenceA()
	{
		return getAgregado().getNaturezaProdutoPertenceA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	public String getCodigoImagemLocal()
	{
		return getDerivada().getCodigoImagemLocal(); 
	} 
	public void setCodigoImagemLocal(String value)
	{
		getDerivada().setCodigoImagemLocal(value); 
	} 
	
	public String getMensagemFacebook()
	{
		return getDerivada().getMensagemFacebook(); 
	} 
	public void setMensagemFacebook(String value)
	{
		getDerivada().setMensagemFacebook(value); 
	} 
	
	public String getLinkAplicativo()
	{
		return getDerivada().getLinkAplicativo(); 
	} 
	public void setLinkAplicativo(String value)
	{
		getDerivada().setLinkAplicativo(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idOportunidadeDia;
	public long getIdOportunidadeDia()
	{
		return idOportunidadeDia;
	}
	public  void setIdOportunidadeDia(long value)
	{
		idOportunidadeDia = value; 
	}
	
	
	
	
	
	private String urlProduto;
	public String getUrlProduto()
	{
		return urlProduto;
	}
	public  void setUrlProduto(String value)
	{
		urlProduto = value; 
	}
	
	
	
	
	
	private String nomeProduto;
	public String getNomeProduto()
	{
		return nomeProduto;
	}
	public  void setNomeProduto(String value)
	{
		nomeProduto = value; 
	}
	
	
	
	
	
	private String dataInicioPrecoAtual;
	public String getDataInicioPrecoAtual()
	{
		return dataInicioPrecoAtual;
	}
	public  void setDataInicioPrecoAtual(String value)
	{
		dataInicioPrecoAtual = value; 
	}
	
	
	
	
	
	private String nomeMarca;
	public String getNomeMarca()
	{
		return nomeMarca;
	}
	public  void setNomeMarca(String value)
	{
		nomeMarca = value; 
	}
	
	
	
	
	
	private String urlAfiliado;
	public String getUrlAfiliado()
	{
		return urlAfiliado;
	}
	public  void setUrlAfiliado(String value)
	{
		urlAfiliado = value; 
	}
	
	
	
	
	
	private String dataUltimaPrecoAnterior;
	public String getDataUltimaPrecoAnterior()
	{
		return dataUltimaPrecoAnterior;
	}
	public  void setDataUltimaPrecoAnterior(String value)
	{
		dataUltimaPrecoAnterior = value; 
	}
	
	
	
	
	
	private String imagemLocal;
	public String getImagemLocal()
	{
		return imagemLocal;
	}
	public  void setImagemLocal(String value)
	{
		imagemLocal = value; 
	}
	
	
	
	
	
	private String urlImagem;
	public String getUrlImagem()
	{
		return urlImagem;
	}
	public  void setUrlImagem(String value)
	{
		urlImagem = value; 
	}
	
	
	
	
	
	private long posicaoProduto;
	public long getPosicaoProduto()
	{
		return posicaoProduto;
	}
	public  void setPosicaoProduto(long value)
	{
		posicaoProduto = value; 
	}
	
	
	
	public String getPrecoVendaAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoVendaAnterior);
	}
	
	
	
	private float precoVendaAnterior;
	public float getPrecoVendaAnterior()
	{
		return precoVendaAnterior;
	}
	public  void setPrecoVendaAnterior(float value)
	{
		precoVendaAnterior = value; 
	}
	
	
	
	public String getPrecoVendaAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoVendaAtual);
	}
	
	
	
	private float precoVendaAtual;
	public float getPrecoVendaAtual()
	{
		return precoVendaAtual;
	}
	public  void setPrecoVendaAtual(float value)
	{
		precoVendaAtual = value; 
	}
	
	
	
	public String getPrecoBoletoAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoBoletoAnterior);
	}
	
	
	
	private float precoBoletoAnterior;
	public float getPrecoBoletoAnterior()
	{
		return precoBoletoAnterior;
	}
	public  void setPrecoBoletoAnterior(float value)
	{
		precoBoletoAnterior = value; 
	}
	
	
	
	public String getPrecoBoletoAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoBoletoAtual);
	}
	
	
	
	private float precoBoletoAtual;
	public float getPrecoBoletoAtual()
	{
		return precoBoletoAtual;
	}
	public  void setPrecoBoletoAtual(float value)
	{
		precoBoletoAtual = value; 
	}
	
	
	
	public String getPrecoParcelaAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoParcelaAnterior);
	}
	
	
	
	private float precoParcelaAnterior;
	public float getPrecoParcelaAnterior()
	{
		return precoParcelaAnterior;
	}
	public  void setPrecoParcelaAnterior(float value)
	{
		precoParcelaAnterior = value; 
	}
	
	
	
	public String getPrecoParcelaAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoParcelaAtual);
	}
	
	
	
	private float precoParcelaAtual;
	public float getPrecoParcelaAtual()
	{
		return precoParcelaAtual;
	}
	public  void setPrecoParcelaAtual(float value)
	{
		precoParcelaAtual = value; 
	}
	
	
	
	
	
	private long quantidadeParcelaAnterior;
	public long getQuantidadeParcelaAnterior()
	{
		return quantidadeParcelaAnterior;
	}
	public  void setQuantidadeParcelaAnterior(long value)
	{
		quantidadeParcelaAnterior = value; 
	}
	
	
	
	
	
	private long quantidadeParcelaAtual;
	public long getQuantidadeParcelaAtual()
	{
		return quantidadeParcelaAtual;
	}
	public  void setQuantidadeParcelaAtual(long value)
	{
		quantidadeParcelaAtual = value; 
	}
	
	
	
	
	
	private float percentualAjusteVenda;
	public float getPercentualAjusteVenda()
	{
		return percentualAjusteVenda;
	}
	public  void setPercentualAjusteVenda(float value)
	{
		percentualAjusteVenda = value; 
	}
	
	
	
	public String getPercentualAjusteBoletoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(percentualAjusteBoleto);
	}
	
	
	
	private float percentualAjusteBoleto;
	public float getPercentualAjusteBoleto()
	{
		return percentualAjusteBoleto;
	}
	public  void setPercentualAjusteBoleto(float value)
	{
		percentualAjusteBoleto = value; 
	}
	
	
	
	
	
	private String nomeLojaVirtual;
	public String getNomeLojaVirtual()
	{
		return nomeLojaVirtual;
	}
	public  void setNomeLojaVirtual(String value)
	{
		nomeLojaVirtual = value; 
	}
	
	
	
	public String getPrecoMinimoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoMinimo);
	}
	
	
	
	private float precoMinimo;
	public float getPrecoMinimo()
	{
		return precoMinimo;
	}
	public  void setPrecoMinimo(float value)
	{
		precoMinimo = value; 
	}
	
	
	
	public String getPrecoMedioFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoMedio);
	}
	
	
	
	private float precoMedio;
	public float getPrecoMedio()
	{
		return precoMedio;
	}
	public  void setPrecoMedio(float value)
	{
		precoMedio = value; 
	}
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoReferenteA(false)!=null) 
			return getProdutoReferenteA(false).getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
		
	private long idNaturezaProdutoPa;
	public long getIdNaturezaProdutoPa() {
		// relacionamento
		if (idNaturezaProdutoPa==0 && this.getNaturezaProdutoPertenceA(false)!=null) 
			return getNaturezaProdutoPertenceA(false).getIdObj();
		else
			return idNaturezaProdutoPa;
	}
	public void setIdNaturezaProdutoPa(long _valor) {
		idNaturezaProdutoPa = _valor;
	}

	@Override
	public float getPrecoSugestao() {
		return this.getDerivada().getPrecoSugestao();
	}

	@Override
	public void setPrecoSugestao(float preco) {
		this.getDerivada().setPrecoSugestao(preco);
	}

	@Override
	public void calculaSugestaoPreco() {
		this.getDerivada().calculaSugestaoPreco();
	}
	
	@Override
	public boolean aprovadaEnvio() {
		return this.getDerivada().aprovadaEnvio();
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
