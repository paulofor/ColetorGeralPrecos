package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface InteresseProduto extends DCIObjetoDominio , InteresseProdutoAgregadoI , InteresseProdutoDerivadaI
{

	
	public long getIdInteresseProduto();
	public void setIdInteresseProduto(long valor);
	
	
	public long getNota();
	public void setNota(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public float getValor();
	public void setValor(float valor);
	
	public String getValorFormatada();
	
	
	public boolean getEspera();
	public void setEspera(boolean valor);
	
	
	public boolean getMonitora();
	public void setMonitora(boolean valor);
	
	
	public boolean getVisualizacaoConcluida();
	public void setVisualizacaoConcluida(boolean valor);
	
	
	public float getPrecoMedio();
	public void setPrecoMedio(float valor);
	
	public String getPrecoMedioFormatada();
	
	
	public float getPrecoMinimo();
	public void setPrecoMinimo(float valor);
	
	public String getPrecoMinimoFormatada();
	
	
	public String getDataUltimaSincronizacao();
	public void setDataUltimaSincronizacao(String valor);
	
	
	public boolean getNovo();
	public void setNovo(boolean valor);
	
	
	public boolean getMudanca();
	public void setMudanca(boolean valor);
	
	
	public float getDiferencaAnterior();
	public void setDiferencaAnterior(float valor);
	
	public String getDiferencaAnteriorFormatada();
	
	
	public long getMinhaAvaliacao();
	public void setMinhaAvaliacao(long valor);
	
	
	public String getDataUltimaMudanca();
	public void setDataUltimaMudanca(String valor);
	
	
	public String getDataUltimaVerificacao();
	public void setDataUltimaVerificacao(String valor);
	
	
	public float getPrecoAnterior();
	public void setPrecoAnterior(float valor);
	
	public String getPrecoAnteriorFormatada();
	
	
	public long getEstagioVisualizacaoMudanca();
	public void setEstagioVisualizacaoMudanca(long valor);
	
	
	public String getDataUltimaMudancaGmt();
	public void setDataUltimaMudancaGmt(String valor);
	
	
	public boolean getMudancaNota();
	public void setMudancaNota(boolean valor);
	
	
	public String getDataUltimaMudancaNota();
	public void setDataUltimaMudancaNota(String valor);
	
	
	public String getDataUltimaMudancaNotaGmt();
	public void setDataUltimaMudancaNotaGmt(String valor);
	
	
	public float getPrecoAtual();
	public void setPrecoAtual(float valor);
	
	public String getPrecoAtualFormatada();
	
	
	public long getIdProdutoClienteRa();
	public void setIdProdutoClienteRa(long valor);
	
	
	public long getIdUsuarioS();
	public void setIdUsuarioS(long valor);
	
	
}

