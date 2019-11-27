package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ProdutoClienteVo implements ProdutoCliente
{
		
	public long getIdObj()
    {
       return idProdutoCliente;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdProdutoCliente\" : \"" + idProdutoCliente + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"Imagem\" : \"" + imagem + "\" "
		+ ", \"PrecoAtual\" : \"" + precoAtual + "\" "
		+ ", \"Marca\" : \"" + marca + "\" "
		+ ", \"Loja\" : \"" + loja + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Url\" : \"" + url + "\" "
		+ ", \"Detalhe\" : \"" + detalhe + "\" "
		+ ", \"IdNaturezaProdutoRa\" : \"" + idNaturezaProdutoRa + "\" "
		+ ", \"IdUsuarioS\" : \"" + idUsuarioS + "\" "
		+ ", \"IdPalavraChavePesquisaRa\" : \"" + idPalavraChavePesquisaRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ProdutoClienteDerivada derivada = null;
	private ProdutoClienteDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ProdutoClienteDerivada(this);
		}
		return derivada;
	}

	private ProdutoClienteAgregado agregado = null;
	private ProdutoClienteAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ProdutoClienteAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getNaturezaProdutoReferenteA(lazyLoader); 
	} 
	public void setNaturezaProdutoReferenteA(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	/*
	public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto value)
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA()
	{
		return getAgregado().getNaturezaProdutoReferenteA(false); 
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
	
	
	// Montador Tradicional
	public PalavraChavePesquisa getPalavraChavePesquisaReferenteA(boolean lazyLoader)
	{
		return getAgregado().getPalavraChavePesquisaReferenteA(lazyLoader); 
	} 
	public void setPalavraChavePesquisaReferenteA(PalavraChavePesquisa value) 
	{
		getAgregado().setPalavraChavePesquisaReferenteA(value); 
	} 
	/*
	public void setPalavraChavePesquisaReferenteAComReversao(PalavraChavePesquisa value) 
	{
		getAgregado().setPalavraChavePesquisaReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaPalavraChavePesquisa_ReferenteA(PalavraChavePesquisa value)
	{
		getAgregado().setPalavraChavePesquisaReferenteA(value); 
	} 
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_ReferenteA()
	{
		return getAgregado().getPalavraChavePesquisaReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaInteresseProduto_Possui() {
		return getAgregado().existeListaInteresseProduto_Possui();
	}
	public void criaVaziaListaInteresseProduto_Possui() {
		getAgregado().criaVaziaListaInteresseProduto_Possui();
	}
	public List<InteresseProduto> getListaInteresseProduto_Possui() 
	{
		return getAgregado().getListaInteresseProduto_Possui(); 
	} 
	public void setListaInteresseProduto_Possui(List<InteresseProduto> value) 
	{
		getAgregado().setListaInteresseProduto_Possui(value); 
	} 
	public void addListaInteresseProduto_Possui(InteresseProduto value) 
	{
		getAgregado().addListaInteresseProduto_Possui(value); 
	} 
	public InteresseProduto getCorrenteInteresseProduto_Possui()
	{
		return getAgregado().getCorrenteInteresseProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPrecoDiarioCliente_Possui() {
		return getAgregado().existeListaPrecoDiarioCliente_Possui();
	}
	public void criaVaziaListaPrecoDiarioCliente_Possui() {
		getAgregado().criaVaziaListaPrecoDiarioCliente_Possui();
	}
	public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Possui() 
	{
		return getAgregado().getListaPrecoDiarioCliente_Possui(); 
	} 
	public void setListaPrecoDiarioCliente_Possui(List<PrecoDiarioCliente> value) 
	{
		getAgregado().setListaPrecoDiarioCliente_Possui(value); 
	} 
	public void addListaPrecoDiarioCliente_Possui(PrecoDiarioCliente value) 
	{
		getAgregado().addListaPrecoDiarioCliente_Possui(value); 
	} 
	public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Possui()
	{
		return getAgregado().getCorrentePrecoDiarioCliente_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOportunidadeInteresseCliente_Possui() {
		return getAgregado().existeListaOportunidadeInteresseCliente_Possui();
	}
	public void criaVaziaListaOportunidadeInteresseCliente_Possui() {
		getAgregado().criaVaziaListaOportunidadeInteresseCliente_Possui();
	}
	public List<OportunidadeInteresseCliente> getListaOportunidadeInteresseCliente_Possui() 
	{
		return getAgregado().getListaOportunidadeInteresseCliente_Possui(); 
	} 
	public void setListaOportunidadeInteresseCliente_Possui(List<OportunidadeInteresseCliente> value) 
	{
		getAgregado().setListaOportunidadeInteresseCliente_Possui(value); 
	} 
	public void addListaOportunidadeInteresseCliente_Possui(OportunidadeInteresseCliente value) 
	{
		getAgregado().addListaOportunidadeInteresseCliente_Possui(value); 
	} 
	public OportunidadeInteresseCliente getCorrenteOportunidadeInteresseCliente_Possui()
	{
		return getAgregado().getCorrenteOportunidadeInteresseCliente_Possui(); 
	} 
	

	
	
	
	
	
	private long idProdutoCliente;
	public long getIdProdutoCliente()
	{
		return idProdutoCliente;
	}
	public  void setIdProdutoCliente(long value)
	{
		idProdutoCliente = value; 
	}
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
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
	
	
	
	
	
	private String imagem;
	public String getImagem()
	{
		return imagem;
	}
	public  void setImagem(String value)
	{
		imagem = value; 
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
	
	
	
	
	
	private String marca;
	public String getMarca()
	{
		return marca;
	}
	public  void setMarca(String value)
	{
		marca = value; 
	}
	
	
	
	
	
	private String loja;
	public String getLoja()
	{
		return loja;
	}
	public  void setLoja(String value)
	{
		loja = value; 
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
	
	
	
	
	
	private String url;
	public String getUrl()
	{
		return url;
	}
	public  void setUrl(String value)
	{
		url = value; 
	}
	
	
	
	
	
	private String detalhe;
	public String getDetalhe()
	{
		return detalhe;
	}
	public  void setDetalhe(String value)
	{
		detalhe = value; 
	}
	
	
	
	
		
	private long idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		// relacionamento
		if (idNaturezaProdutoRa==0 && this.getNaturezaProdutoReferenteA(false)!=null) 
			return getNaturezaProdutoReferenteA(false).getIdObj();
		else
			return idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa(long _valor) {
		idNaturezaProdutoRa = _valor;
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
	
	
	
	
		
	private long idPalavraChavePesquisaRa;
	public long getIdPalavraChavePesquisaRa() {
		// relacionamento
		if (idPalavraChavePesquisaRa==0 && this.getPalavraChavePesquisaReferenteA(false)!=null) 
			return getPalavraChavePesquisaReferenteA(false).getIdObj();
		else
			return idPalavraChavePesquisaRa;
	}
	public void setIdPalavraChavePesquisaRa(long _valor) {
		idPalavraChavePesquisaRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
