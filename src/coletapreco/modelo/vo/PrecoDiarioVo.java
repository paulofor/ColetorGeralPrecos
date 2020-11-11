package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoDiarioVo implements PrecoDiario
{
		
	public long getIdObj()
    {
       return idPrecoDiario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPrecoDiario\" : \"" + idPrecoDiario + "\" "
		+ ", \"PrecoBoleto\" : \"" + precoBoleto + "\" "
		+ ", \"DataHora\" : \"" + dataHora + "\" "
		+ ", \"QuantidadeParcela\" : \"" + quantidadeParcela + "\" "
		+ ", \"PrecoParcela\" : \"" + precoParcela + "\" "
		+ ", \"PrecoVenda\" : \"" + precoVenda + "\" "
		+ ", \"PrecoRegular\" : \"" + precoRegular + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"IdProdutoPa\" : \"" + idProdutoPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PrecoDiarioDerivada derivada = null;
	private PrecoDiarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PrecoDiarioDerivada(this);
		}
		return derivada;
	}

	private PrecoDiarioAgregado agregado = null;
	private PrecoDiarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PrecoDiarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Produto getProdutoPertenceA(boolean lazyLoader)
	{
		return getAgregado().getProdutoPertenceA(lazyLoader); 
	} 
	public void setProdutoPertenceA(Produto value) 
	{
		getAgregado().setProdutoPertenceA(value); 
	} 
	/*
	public void setProdutoPertenceAComReversao(Produto value) 
	{
		getAgregado().setProdutoPertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_PertenceA(Produto value)
	{
		getAgregado().setProdutoPertenceA(value); 
	} 
	public Produto getCorrenteProduto_PertenceA()
	{
		return getAgregado().getProdutoPertenceA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPrecoDiario;
	public long getIdPrecoDiario()
	{
		return idPrecoDiario;
	}
	public  void setIdPrecoDiario(long value)
	{
		idPrecoDiario = value; 
	}
	
	
	
	public String getPrecoBoletoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoBoleto);
	}
	
	
	
	private float precoBoleto;
	public float getPrecoBoleto()
	{
		return precoBoleto;
	}
	public  void setPrecoBoleto(float value)
	{
		precoBoleto = value; 
	}
	
	
	
	
	
	private String dataHora;
	public String getDataHora()
	{
		return dataHora;
	}
	public  void setDataHora(String value)
	{
		dataHora = value; 
	}
	
	
	
	
	
	private long quantidadeParcela;
	public long getQuantidadeParcela()
	{
		return quantidadeParcela;
	}
	public  void setQuantidadeParcela(long value)
	{
		quantidadeParcela = value; 
	}
	
	
	
	public String getPrecoParcelaFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoParcela);
	}
	
	
	
	private float precoParcela;
	public float getPrecoParcela()
	{
		return precoParcela;
	}
	public  void setPrecoParcela(float value)
	{
		precoParcela = value; 
	}
	
	
	
	public String getPrecoVendaFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoVenda);
	}
	
	
	
	private float precoVenda;
	public float getPrecoVenda()
	{
		return precoVenda;
	}
	public  void setPrecoVenda(float value)
	{
		precoVenda = value; 
	}
	
	
	
	public String getPrecoRegularFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoRegular);
	}
	
	
	
	private float precoRegular;
	public float getPrecoRegular()
	{
		return precoRegular;
	}
	public  void setPrecoRegular(float value)
	{
		precoRegular = value; 
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
	
	
	
	
		
	private long idProdutoPa;
	public long getIdProdutoPa() {
		// relacionamento
		if (idProdutoPa==0 && this.getProdutoPertenceA(false)!=null) 
			return getProdutoPertenceA(false).getIdObj();
		else
			return idProdutoPa;
	}
	public void setIdProdutoPa(long _valor) {
		idProdutoPa = _valor;
	}

	long idOportunidadeDia;
	@Override
	public long getIdOportunidadeDia() {
		return idOportunidadeDia;
	}

	@Override
	public void setIdOportunidadeDia(long id) {
		idOportunidadeDia = id;
	}

	long idNaturezaProduto;
	@Override
	public long getIdNaturezaProduto() {
		return idNaturezaProduto;
	}

	@Override
	public void setIdNaturezaProduto(long id) {
		idNaturezaProduto = id;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	

}
