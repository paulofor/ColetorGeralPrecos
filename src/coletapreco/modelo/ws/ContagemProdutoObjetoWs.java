package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ContagemProdutoObjetoWs   { 
      long _idContagemProduto;
	public long getIdContagemProduto() {
		return _idContagemProduto;
	}
	public void setIdContagemProduto( long dado ) {
		_idContagemProduto = dado;
	}
      long _quantidade;
	public long getQuantidade() {
		return _quantidade;
	}
	public void setQuantidade( long dado ) {
		_quantidade = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      float _percentualDiferenca;
	public float getPercentualDiferenca() {
		return _percentualDiferenca;
	}
	public void setPercentualDiferenca( float dado ) {
		_percentualDiferenca = dado;
	}
      boolean _possibilidadeErro;
	public boolean getPossibilidadeErro() {
		return _possibilidadeErro;
	}
	public void setPossibilidadeErro( boolean dado ) {
		_possibilidadeErro = dado;
	}
      long _idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		return _idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa( long dado ) {
		_idNaturezaProdutoRa = dado;
	}
      long _idLojaVirtualRa;
	public long getIdLojaVirtualRa() {
		return _idLojaVirtualRa;
	}
	public void setIdLojaVirtualRa( long dado ) {
		_idLojaVirtualRa = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoReferenteA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
  private LojaVirtualObjetoWs _LojaVirtualReferenteA;
	public LojaVirtualObjetoWs getLojaVirtualReferenteA() {
		return _LojaVirtualReferenteA;
	}
	public void setLojaVirtualReferenteA( LojaVirtualObjetoWs dado ) {
		_LojaVirtualReferenteA = dado;
	}
}
