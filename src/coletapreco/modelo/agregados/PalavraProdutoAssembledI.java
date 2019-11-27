package coletapreco.modelo.agregados;


import coletapreco.modelo.*;

public interface PalavraProdutoAssembledI
 { 
	public Palavra getPalavraRelaciondoA();
	public void setPalavraRelaciondoA( Palavra dado );
	public Produto getProdutoRelaciondoA();
	public void setProdutoRelaciondoA( Produto dado );
}
