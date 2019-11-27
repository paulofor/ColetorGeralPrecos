package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookPost extends DCIObjetoDominio , FacebookPostAgregadoI , FacebookPostDerivadaI
{

	
	public long getIdFacebookPost();
	public void setIdFacebookPost(long valor);
	
	
	public String getDataHora();
	public void setDataHora(String valor);
	
	
	public String getCodigoFacebook();
	public void setCodigoFacebook(String valor);
	
	
	public String getHorarioProgramacao();
	public void setHorarioProgramacao(String valor);
	
	
	public long getIdFacebookFanpageFe();
	public void setIdFacebookFanpageFe(long valor);
	
	
	public long getIdProdutoD();
	public void setIdProdutoD(long valor);
	
	
}

