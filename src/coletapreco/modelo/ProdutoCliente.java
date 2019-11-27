package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ProdutoCliente extends DCIObjetoDominio , ProdutoClienteAgregadoI , ProdutoClienteDerivadaI
{

	
	public long getIdProdutoCliente();
	public void setIdProdutoCliente(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public String getImagem();
	public void setImagem(String valor);
	
	
	public float getPrecoAtual();
	public void setPrecoAtual(float valor);
	
	public String getPrecoAtualFormatada();
	
	
	public String getMarca();
	public void setMarca(String valor);
	
	
	public String getLoja();
	public void setLoja(String valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
	public String getDetalhe();
	public void setDetalhe(String valor);
	
	
	public long getIdNaturezaProdutoRa();
	public void setIdNaturezaProdutoRa(long valor);
	
	
	public long getIdUsuarioS();
	public void setIdUsuarioS(long valor);
	
	
	public long getIdPalavraChavePesquisaRa();
	public void setIdPalavraChavePesquisaRa(long valor);
	
	
}

