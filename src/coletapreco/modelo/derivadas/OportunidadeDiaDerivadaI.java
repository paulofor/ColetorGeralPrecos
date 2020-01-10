package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface OportunidadeDiaDerivadaI
 { 
	public String getCodigoImagemLocal();
	public void setCodigoImagemLocal( String dado );

	public String getMensagemFacebook();
	public void setMensagemFacebook( String dado );

	public String getLinkAplicativo();
	public void setLinkAplicativo( String dado );
	
	public float getPrecoSugestao();
	public void setPrecoSugestao( float preco );
	
	public void calculaSugestaoPreco();
	public boolean aprovadaEnvio();

}
