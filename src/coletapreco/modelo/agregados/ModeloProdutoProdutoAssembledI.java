package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface ModeloProdutoProdutoAssembledI
 { 
	public ModeloProduto getModeloProdutoReferenteA();
	public void setModeloProdutoReferenteA( ModeloProduto dado );
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA( Produto dado );
}
