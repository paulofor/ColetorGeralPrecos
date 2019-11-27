package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface UsuarioPesquisaAssembledI
 { 
	public Usuario getUsuarioSincroniza();
	public void setUsuarioSincroniza( Usuario dado );
	public NaturezaProduto getNaturezaProdutoPesquisa();
	public void setNaturezaProdutoPesquisa( NaturezaProduto dado );
}
