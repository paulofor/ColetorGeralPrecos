package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface ProdutoDerivadaI
 { 
	public long getPosicao();
	public void setPosicao( long dado );

	public String getCodigoImagemLocal();
	public void setCodigoImagemLocal( String dado );
	
	
	// ***  DESNORMALIZACAO *** BIG DATA
	
	public long getIdLojaVirtual();
	public void setIdLojaVirtual(long id);
	
	public long getIdNaturezaProduto();
	public void setIdNaturezaProduto(long id);
	
	public long getIdCategoraLoja();
	public void setIdCategoriaLoja(long id);
	
	

}
