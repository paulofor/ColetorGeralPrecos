package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface CategoriaLojaAssembledI
 { 
	public CategoriaLoja getCategoriaLojaFilho();
	public void setCategoriaLojaFilho( CategoriaLoja dado );
	public NaturezaProduto getNaturezaProdutoReferenteA();
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado );
	public LojaVirtual getLojaVirtualPertenceA();
	public void setLojaVirtualPertenceA( LojaVirtual dado );
}
