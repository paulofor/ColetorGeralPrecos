package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface AppProduto extends DCIObjetoDominio , AppProdutoAgregadoI , AppProdutoDerivadaI
{

	
	public long getIdAppProduto();
	public void setIdAppProduto(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getUrlInstalacao();
	public void setUrlInstalacao(String valor);
	
	
	public boolean getPossuiVitrine();
	public void setPossuiVitrine(boolean valor);
	
	
	public boolean getAtivo();
	public void setAtivo(boolean valor);
	
	
	public String getStatus();
	public void setStatus(String valor);
	
	
	public long getLimitePosicionador();
	public void setLimitePosicionador(long valor);
	
	
	public boolean getPossuiPalavraChave();
	public void setPossuiPalavraChave(boolean valor);
	
	
	public String getCodigoHash();
	public void setCodigoHash(String valor);
	
	
	public String getApiKey();
	public void setApiKey(String valor);
	
	
	public long getDiasPrecoVitrine();
	public void setDiasPrecoVitrine(long valor);
	
	
}

