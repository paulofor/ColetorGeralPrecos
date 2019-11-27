package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface ContagemProdutoAssembledI
 { 
	public NaturezaProduto getNaturezaProdutoReferenteA();
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado );
	public LojaVirtual getLojaVirtualReferenteA();
	public void setLojaVirtualReferenteA( LojaVirtual dado );
}
