package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookPerfil extends DCIObjetoDominio , FacebookPerfilAgregadoI , FacebookPerfilDerivadaI
{

	
	public long getIdFacebookPerfil();
	public void setIdFacebookPerfil(long valor);
	
	
	public String getTokenAcesso();
	public void setTokenAcesso(String valor);
	
	
	public String getEmailUtilizado();
	public void setEmailUtilizado(String valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getSobrenome();
	public void setSobrenome(String valor);
	
	
}

