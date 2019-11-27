package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface FacebookFanpage extends DCIObjetoDominio , FacebookFanpageAgregadoI , FacebookFanpageDerivadaI
{

	
	public long getIdFacebookFanpage();
	public void setIdFacebookFanpage(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getCodigoFacebook();
	public void setCodigoFacebook(String valor);
	
	
	public String getNomeUrl();
	public void setNomeUrl(String valor);
	
	
	public long getQuantidadeDia();
	public void setQuantidadeDia(long valor);
	
	
	public long getIdFacebookPerfilPa();
	public void setIdFacebookPerfilPa(long valor);
	
	
	public long getIdAppProdutoD();
	public void setIdAppProdutoD(long valor);
	
	
}

