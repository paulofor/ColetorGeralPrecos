package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoProdutoVo implements PrecoProduto {

	public long getIdObj() {
		return idPrecoProduto;
	}

	public String toWS() {
		return "" + getIdObj();
	}

	private String JsonAtributos() {
		return " \"IdPrecoProduto\" : \"" + idPrecoProduto + "\" " + ", \"PrecoBoleto\" : \"" + precoBoleto + "\" "
				+ ", \"DataVisitaInicial\" : \"" + dataVisitaInicial + "\" " + ", \"QuantidadeParcela\" : \""
				+ quantidadeParcela + "\" " + ", \"PrecoParcela\" : \"" + precoParcela + "\" " + ", \"PrecoVenda\" : \""
				+ precoVenda + "\" " + ", \"PrecoRegular\" : \"" + precoRegular + "\" " + ", \"DataUltimaVisita\" : \""
				+ dataUltimaVisita + "\" " + ", \"PercentualAjuste\" : \"" + percentualAjuste + "\" "
				+ ", \"Media2meses\" : \"" + media2meses + "\" " + ", \"Minimo3meses\" : \"" + minimo3meses + "\" "
				+ ", \"IdProdutoPa\" : \"" + idProdutoPa + "\" "

		;
	}

	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}

	private PrecoProdutoDerivada derivada = null;

	private PrecoProdutoDerivada getDerivada() {
		if (derivada == null) {
			derivada = new PrecoProdutoDerivada(this);
		}
		return derivada;
	}

	private PrecoProdutoAgregado agregado = null;

	private PrecoProdutoAgregado getAgregado() {
		if (agregado == null) {
			agregado = new PrecoProdutoAgregado(this);
		}
		return agregado;
	}

	// Com Chave Estrangeira

	// Montador Tradicional
	public Produto getProdutoPertenceA(boolean lazyLoader) {
		return getAgregado().getProdutoPertenceA(lazyLoader);
	}

	public void setProdutoPertenceA(Produto value) {
		getAgregado().setProdutoPertenceA(value);
	}
	/*
	 * public void setProdutoPertenceAComReversao(Produto value) {
	 * getAgregado().setProdutoPertenceAComReversao(value); }
	 */

	// Montador Alternativo e Tradicional
	public void addListaProduto_PertenceA(Produto value) {
		getAgregado().setProdutoPertenceA(value);
	}

	public Produto getCorrenteProduto_PertenceA() {
		return getAgregado().getProdutoPertenceA(false);
	}

	// Um pra um

	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}

	// Sem chave estrangeira

	private long idPrecoProduto;

	public long getIdPrecoProduto() {
		return idPrecoProduto;
	}

	public void setIdPrecoProduto(long value) {
		idPrecoProduto = value;
	}

	public String getPrecoBoletoFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoBoleto);
	}

	private float precoBoleto;

	public float getPrecoBoleto() {
		return precoBoleto;
	}

	public void setPrecoBoleto(float value) {
		precoBoleto = value;
	}

	private String dataVisitaInicial;

	public String getDataVisitaInicial() {
		return dataVisitaInicial;
	}

	public void setDataVisitaInicial(String value) {
		dataVisitaInicial = value;
	}

	private long quantidadeParcela;

	public long getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(long value) {
		quantidadeParcela = value;
	}

	public String getPrecoParcelaFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoParcela);
	}

	private float precoParcela;

	public float getPrecoParcela() {
		return precoParcela;
	}

	public void setPrecoParcela(float value) {
		precoParcela = value;
	}

	public String getPrecoVendaFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoVenda);
	}

	private float precoVenda;

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float value) {
		precoVenda = value;
	}

	public String getPrecoRegularFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoRegular);
	}

	private float precoRegular;

	public float getPrecoRegular() {
		return precoRegular;
	}

	public void setPrecoRegular(float value) {
		precoRegular = value;
	}

	private String dataUltimaVisita;

	public String getDataUltimaVisita() {
		return dataUltimaVisita;
	}

	public void setDataUltimaVisita(String value) {
		dataUltimaVisita = value;
	}

	private float percentualAjuste;

	public float getPercentualAjuste() {
		return percentualAjuste;
	}

	public void setPercentualAjuste(float value) {
		percentualAjuste = value;
	}

	public String getMedia2mesesFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(media2meses);
	}

	private float media2meses;

	public float getMedia2meses() {
		return media2meses;
	}

	public void setMedia2meses(float value) {
		media2meses = value;
	}

	public String getMinimo3mesesFormatada() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(minimo3meses);
	}

	private float minimo3meses;

	public float getMinimo3meses() {
		return minimo3meses;
	}

	public void setMinimo3meses(float value) {
		minimo3meses = value;
	}

	private long idProdutoPa;

	public long getIdProdutoPa() {
		// relacionamento
		if (idProdutoPa == 0 && this.getProdutoPertenceA(false) != null)
			return getProdutoPertenceA(false).getIdObj();
		else
			return idProdutoPa;
	}

	public void setIdProdutoPa(long _valor) {
		idProdutoPa = _valor;
	}

	// -------------------------------------------------------
	// DESNORMALIZACAO -- BIGDATA

	@Override
	public long getIdLojaVirtual() {
		return this.getDerivada().getIdLojaVirtual();
	}
	@Override
	public void setIdLojaVirtual(long id) {
		this.getDerivada().setIdLojaVirtual(id);
	}

	
	@Override
	public long getIdNaturezaProduto() {
		return getDerivada().getIdNaturezaProduto();
	}
	@Override
	public void setIdNaturezaProduto(long id) {
		this.getDerivada().setIdNaturezaProduto(id);
	}

	
	@Override
	public long getIdCategoraLoja() {
		return this.getDerivada().getIdCategoraLoja();
	}
	@Override
	public void setIdCategoriaLoja(long id) {
		this.getDerivada().setIdCategoriaLoja(id);
	}

	@Override
	public long getPosicao() {
		return this.getDerivada().getPosicao();
	}

	@Override
	public void setPosicao(long valor) {
		this.getDerivada().setPosicao(valor);
	}
	
	// -------------------------------------------------------
	// Posicao
	@Override
	public int getPosicao1() {
		return this.getDerivada().getPosicao1();
	}
	@Override
	public void setPosicao1(int valor) {
		this.getDerivada().setPosicao1(valor);
	}
	
	@Override
	public int getPosicao2() {
		return this.getDerivada().getPosicao2();
	}
	@Override
	public void setPosicao2(int valor) {
		this.getDerivada().setPosicao2(valor);
	}
	
	@Override
	public int getPosicao3() {
		return this.getDerivada().getPosicao3();
	}
	@Override
	public void setPosicao3(int valor) {
		this.getDerivada().setPosicao3(valor);
	}
	
	@Override
	public int getPosicao4() {
		return this.getDerivada().getPosicao4();
	}
	@Override
	public void setPosicao4(int valor) {
		this.getDerivada().setPosicao4(valor);
	}
	
	@Override
	public int getPosicao5() {
		return this.getDerivada().getPosicao5();
	}
	@Override
	public void setPosicao5(int valor) {
		this.getDerivada().setPosicao5(valor);
	}
	
	@Override
	public int getPosicao6() {
		return this.getDerivada().getPosicao6();
	}
	@Override
	public void setPosicao6(int valor) {
		this.getDerivada().setPosicao6(valor);
	}
	
	@Override
	public int getPosicao7() {
		return this.getDerivada().getPosicao7();
	}
	@Override
	public void setPosicao7(int valor) {
		this.getDerivada().setPosicao7(valor);
	}
	
	
	@Override
	public int getDiferencaPosicao7() {
		return this.getDerivada().getDiferencaPosicao7();
	}
	@Override
	public void setDiferencaPosicao7(int valor) {
		this.getDerivada().setDiferencaPosicao7(valor);
	}

	@Override
	public void descolaPosicao() {
		this.getDerivada().descolaPosicao();
		
	}

	@Override
	public void calculaDiferencaPosicao() {
		this.getDerivada().calculaDiferencaPosicao();
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
	public void calculaPrecoSugestao() {
		this.getDerivada().calculaPrecoSugestao();
	}

	@Override
	public void processaDiario(Produto produto) {
		this.getDerivada().processaDiario(produto);
	}

	@Override
	public void processaParaOportunidade(Produto produto) {
		this.getDerivada().processaParaOportunidade(produto);
	}
	
	
	
}
