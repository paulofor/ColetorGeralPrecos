package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface CategoriaLojaProdutoAssembledI
 { 
	public CategoriaLoja getCategoriaLojaReferenteA();
	public void setCategoriaLojaReferenteA( CategoriaLoja dado );
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA( Produto dado );
}
