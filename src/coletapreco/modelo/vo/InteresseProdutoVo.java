package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class InteresseProdutoVo implements InteresseProduto
{
		
	public long getIdObj()
    {
       return idInteresseProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdInteresseProduto\" : \"" + idInteresseProduto + "\" "
		+ ", \"Nota\" : \"" + nota + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Valor\" : \"" + valor + "\" "
		+ ", \"Espera\" : \"" + espera + "\" "
		+ ", \"Monitora\" : \"" + monitora + "\" "
		+ ", \"VisualizacaoConcluida\" : \"" + visualizacaoConcluida + "\" "
		+ ", \"PrecoMedio\" : \"" + precoMedio + "\" "
		+ ", \"PrecoMinimo\" : \"" + precoMinimo + "\" "
		+ ", \"DataUltimaSincronizacao\" : \"" + dataUltimaSincronizacao + "\" "
		+ ", \"Novo\" : \"" + novo + "\" "
		+ ", \"Mudanca\" : \"" + mudanca + "\" "
		+ ", \"DiferencaAnterior\" : \"" + diferencaAnterior + "\" "
		+ ", \"MinhaAvaliacao\" : \"" + minhaAvaliacao + "\" "
		+ ", \"DataUltimaMudanca\" : \"" + dataUltimaMudanca + "\" "
		+ ", \"DataUltimaVerificacao\" : \"" + dataUltimaVerificacao + "\" "
		+ ", \"PrecoAnterior\" : \"" + precoAnterior + "\" "
		+ ", \"EstagioVisualizacaoMudanca\" : \"" + estagioVisualizacaoMudanca + "\" "
		+ ", \"DataUltimaMudancaGmt\" : \"" + dataUltimaMudancaGmt + "\" "
		+ ", \"MudancaNota\" : \"" + mudancaNota + "\" "
		+ ", \"DataUltimaMudancaNota\" : \"" + dataUltimaMudancaNota + "\" "
		+ ", \"DataUltimaMudancaNotaGmt\" : \"" + dataUltimaMudancaNotaGmt + "\" "
		+ ", \"PrecoAtual\" : \"" + precoAtual + "\" "
		+ ", \"IdProdutoClienteRa\" : \"" + idProdutoClienteRa + "\" "
		+ ", \"IdUsuarioS\" : \"" + idUsuarioS + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private InteresseProdutoDerivada derivada = null;
	private InteresseProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new InteresseProdutoDerivada(this);
		}
		return derivada;
	}

	private InteresseProdutoAgregado agregado = null;
	private InteresseProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new InteresseProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ProdutoCliente getProdutoClienteReferenteA(boolean lazyLoader)
	{
		return getAgregado().getProdutoClienteReferenteA(lazyLoader); 
	} 
	public void setProdutoClienteReferenteA(ProdutoCliente value) 
	{
		getAgregado().setProdutoClienteReferenteA(value); 
	} 
	/*
	public void setProdutoClienteReferenteAComReversao(ProdutoCliente value) 
	{
		getAgregado().setProdutoClienteReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProdutoCliente_ReferenteA(ProdutoCliente value)
	{
		getAgregado().setProdutoClienteReferenteA(value); 
	} 
	public ProdutoCliente getCorrenteProdutoCliente_ReferenteA()
	{
		return getAgregado().getProdutoClienteReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public Usuario getUsuarioSincroniza(boolean lazyLoader)
	{
		return getAgregado().getUsuarioSincroniza(lazyLoader); 
	} 
	public void setUsuarioSincroniza(Usuario value) 
	{
		getAgregado().setUsuarioSincroniza(value); 
	} 
	/*
	public void setUsuarioSincronizaComReversao(Usuario value) 
	{
		getAgregado().setUsuarioSincronizaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaUsuario_Sincroniza(Usuario value)
	{
		getAgregado().setUsuarioSincroniza(value); 
	} 
	public Usuario getCorrenteUsuario_Sincroniza()
	{
		return getAgregado().getUsuarioSincroniza(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idInteresseProduto;
	public long getIdInteresseProduto()
	{
		return idInteresseProduto;
	}
	public  void setIdInteresseProduto(long value)
	{
		idInteresseProduto = value; 
	}
	
	
	
	
	
	private long nota;
	public long getNota()
	{
		return nota;
	}
	public  void setNota(long value)
	{
		nota = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
	}
	
	
	
	public String getValorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	
	
	
	private float valor;
	public float getValor()
	{
		return valor;
	}
	public  void setValor(float value)
	{
		valor = value; 
	}
	
	
	
	
	
	private boolean espera;
	public boolean getEspera()
	{
		return espera;
	}
	public  void setEspera(boolean value)
	{
		espera = value; 
	}
	
	
	
	
	
	private boolean monitora;
	public boolean getMonitora()
	{
		return monitora;
	}
	public  void setMonitora(boolean value)
	{
		monitora = value; 
	}
	
	
	
	
	
	private boolean visualizacaoConcluida;
	public boolean getVisualizacaoConcluida()
	{
		return visualizacaoConcluida;
	}
	public  void setVisualizacaoConcluida(boolean value)
	{
		visualizacaoConcluida = value; 
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
	
	
	
	
	
	private String dataUltimaSincronizacao;
	public String getDataUltimaSincronizacao()
	{
		return dataUltimaSincronizacao;
	}
	public  void setDataUltimaSincronizacao(String value)
	{
		dataUltimaSincronizacao = value; 
	}
	
	
	
	
	
	private boolean novo;
	public boolean getNovo()
	{
		return novo;
	}
	public  void setNovo(boolean value)
	{
		novo = value; 
	}
	
	
	
	
	
	private boolean mudanca;
	public boolean getMudanca()
	{
		return mudanca;
	}
	public  void setMudanca(boolean value)
	{
		mudanca = value; 
	}
	
	
	
	public String getDiferencaAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(diferencaAnterior);
	}
	
	
	
	private float diferencaAnterior;
	public float getDiferencaAnterior()
	{
		return diferencaAnterior;
	}
	public  void setDiferencaAnterior(float value)
	{
		diferencaAnterior = value; 
	}
	
	
	
	
	
	private long minhaAvaliacao;
	public long getMinhaAvaliacao()
	{
		return minhaAvaliacao;
	}
	public  void setMinhaAvaliacao(long value)
	{
		minhaAvaliacao = value; 
	}
	
	
	
	
	
	private String dataUltimaMudanca;
	public String getDataUltimaMudanca()
	{
		return dataUltimaMudanca;
	}
	public  void setDataUltimaMudanca(String value)
	{
		dataUltimaMudanca = value; 
	}
	
	
	
	
	
	private String dataUltimaVerificacao;
	public String getDataUltimaVerificacao()
	{
		return dataUltimaVerificacao;
	}
	public  void setDataUltimaVerificacao(String value)
	{
		dataUltimaVerificacao = value; 
	}
	
	
	
	public String getPrecoAnteriorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoAnterior);
	}
	
	
	
	private float precoAnterior;
	public float getPrecoAnterior()
	{
		return precoAnterior;
	}
	public  void setPrecoAnterior(float value)
	{
		precoAnterior = value; 
	}
	
	
	
	
	
	private long estagioVisualizacaoMudanca;
	public long getEstagioVisualizacaoMudanca()
	{
		return estagioVisualizacaoMudanca;
	}
	public  void setEstagioVisualizacaoMudanca(long value)
	{
		estagioVisualizacaoMudanca = value; 
	}
	
	
	
	
	
	private String dataUltimaMudancaGmt;
	public String getDataUltimaMudancaGmt()
	{
		return dataUltimaMudancaGmt;
	}
	public  void setDataUltimaMudancaGmt(String value)
	{
		dataUltimaMudancaGmt = value; 
	}
	
	
	
	
	
	private boolean mudancaNota;
	public boolean getMudancaNota()
	{
		return mudancaNota;
	}
	public  void setMudancaNota(boolean value)
	{
		mudancaNota = value; 
	}
	
	
	
	
	
	private String dataUltimaMudancaNota;
	public String getDataUltimaMudancaNota()
	{
		return dataUltimaMudancaNota;
	}
	public  void setDataUltimaMudancaNota(String value)
	{
		dataUltimaMudancaNota = value; 
	}
	
	
	
	
	
	private String dataUltimaMudancaNotaGmt;
	public String getDataUltimaMudancaNotaGmt()
	{
		return dataUltimaMudancaNotaGmt;
	}
	public  void setDataUltimaMudancaNotaGmt(String value)
	{
		dataUltimaMudancaNotaGmt = value; 
	}
	
	
	
	public String getPrecoAtualFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoAtual);
	}
	
	
	
	private float precoAtual;
	public float getPrecoAtual()
	{
		return precoAtual;
	}
	public  void setPrecoAtual(float value)
	{
		precoAtual = value; 
	}
	
	
	
	
		
	private long idProdutoClienteRa;
	public long getIdProdutoClienteRa() {
		// relacionamento
		if (idProdutoClienteRa==0 && this.getProdutoClienteReferenteA(false)!=null) 
			return getProdutoClienteReferenteA(false).getIdObj();
		else
			return idProdutoClienteRa;
	}
	public void setIdProdutoClienteRa(long _valor) {
		idProdutoClienteRa = _valor;
	}
	
	
	
	
		
	private long idUsuarioS;
	public long getIdUsuarioS() {
		// relacionamento
		if (idUsuarioS==0 && this.getUsuarioSincroniza(false)!=null) 
			return getUsuarioSincroniza(false).getIdObj();
		else
			return idUsuarioS;
	}
	public void setIdUsuarioS(long _valor) {
		idUsuarioS = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
