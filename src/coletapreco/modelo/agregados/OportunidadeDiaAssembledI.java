package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface OportunidadeDiaAssembledI
 { 
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA( Produto dado );
	public NaturezaProduto getNaturezaProdutoPertenceA();
	public void setNaturezaProdutoPertenceA( NaturezaProduto dado );
}
