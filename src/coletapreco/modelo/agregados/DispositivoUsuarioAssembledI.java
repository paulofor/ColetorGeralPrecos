package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface DispositivoUsuarioAssembledI
 { 
	public Usuario getUsuarioReferenteA();
	public void setUsuarioReferenteA( Usuario dado );
	public AppProduto getAppProdutoUsa();
	public void setAppProdutoUsa( AppProduto dado );
}
