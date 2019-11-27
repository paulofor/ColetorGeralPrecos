package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface ProdutoAssembledI
 { 
	public LojaVirtual getLojaVirtualLidoEm();
	public void setLojaVirtualLidoEm( LojaVirtual dado );
	public Marca getMarcaPossui();
	public void setMarcaPossui( Marca dado );
}
