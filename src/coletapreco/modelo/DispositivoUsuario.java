package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface DispositivoUsuario extends DCIObjetoDominio , DispositivoUsuarioAgregadoI , DispositivoUsuarioDerivadaI
{

	
	public long getIdDispositivoUsuario();
	public void setIdDispositivoUsuario(long valor);
	
	
	public String getNumeroCelular();
	public void setNumeroCelular(String valor);
	
	
	public String getCodigoDispositivo();
	public void setCodigoDispositivo(String valor);
	
	
	public String getTipoAcesso();
	public void setTipoAcesso(String valor);
	
	
	public String getMelhorPath();
	public void setMelhorPath(String valor);
	
	
	public String getTokenGcm();
	public void setTokenGcm(String valor);
	
	
	public String getTokenGcmMonitor();
	public void setTokenGcmMonitor(String valor);
	
	
	public long getMicroSd();
	public void setMicroSd(long valor);
	
	
	public String getDataChamada();
	public void setDataChamada(String valor);
	
	
	public String getDataUltimoAcesso();
	public void setDataUltimoAcesso(String valor);
	
	
	public String getDataCriacao();
	public void setDataCriacao(String valor);
	
	
	public boolean getTemMudanca();
	public void setTemMudanca(boolean valor);
	
	
	public boolean getAtivo();
	public void setAtivo(boolean valor);
	
	
	public long getIdUsuarioRa();
	public void setIdUsuarioRa(long valor);
	
	
	public long getIdAppProdutoU();
	public void setIdAppProdutoU(long valor);
	
	
}

