package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class ProdutoAssembled   implements ProdutoAssembledI { 
  private LojaVirtual _LojaVirtualLidoEm;
	public LojaVirtual getLojaVirtualLidoEm() {
		return _LojaVirtualLidoEm;
	}
	public void setLojaVirtualLidoEm( LojaVirtual dado ) {
		_LojaVirtualLidoEm = dado;
	}
  private Marca _MarcaPossui;
	public Marca getMarcaPossui() {
		return _MarcaPossui;
	}
	public void setMarcaPossui( Marca dado ) {
		_MarcaPossui = dado;
	}
}
