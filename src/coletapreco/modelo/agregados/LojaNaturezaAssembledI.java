package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface LojaNaturezaAssembledI
 { 
	public LojaVirtual getLojaVirtualReferenteA();
	public void setLojaVirtualReferenteA( LojaVirtual dado );
	public NaturezaProduto getNaturezaProdutoReferenteA();
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado );
}
