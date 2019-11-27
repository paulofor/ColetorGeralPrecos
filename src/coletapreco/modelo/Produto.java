package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Produto extends DCIObjetoDominio , ProdutoAgregadoI , ProdutoDerivadaI
{

	
	public long getIdProduto();
	public void setIdProduto(long valor);
	
	
	public String getUrlOrigem();
	public void setUrlOrigem(String valor);
	
	
	public String getImagemLocal();
	public void setImagemLocal(String valor);
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
	public String getUrl();
	public void setUrl(String valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public long getPosicaoProduto();
	public void setPosicaoProduto(long valor);
	
	
	public String getImagem();
	public void setImagem(String valor);
	
	
	public boolean getVerificacaoNomeOk();
	public void setVerificacaoNomeOk(boolean valor);
	
	
	public long getIdLojaVirtualLe();
	public void setIdLojaVirtualLe(long valor);
	
	
	public long getIdMarcaP();
	public void setIdMarcaP(long valor);
	
	
}

