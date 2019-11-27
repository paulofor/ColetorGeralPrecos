package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface PalavraChavePesquisaAssembledI
 { 
	public Usuario getUsuarioSincroniza();
	public void setUsuarioSincroniza( Usuario dado );
	public NaturezaProduto getNaturezaProdutoReferenteA();
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado );
}
