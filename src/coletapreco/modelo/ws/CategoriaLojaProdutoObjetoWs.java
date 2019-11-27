package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CategoriaLojaProdutoObjetoWs   { 
      long _idCategoriaLojaProduto;
	public long getIdCategoriaLojaProduto() {
		return _idCategoriaLojaProduto;
	}
	public void setIdCategoriaLojaProduto( long dado ) {
		_idCategoriaLojaProduto = dado;
	}
      String _dataUltimaVisita;
	public String getDataUltimaVisita() {
		return _dataUltimaVisita;
	}
	public void setDataUltimaVisita( String dado ) {
		_dataUltimaVisita = dado;
	}
      long _idCategoriaLojaRa;
	public long getIdCategoriaLojaRa() {
		return _idCategoriaLojaRa;
	}
	public void setIdCategoriaLojaRa( long dado ) {
		_idCategoriaLojaRa = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
  private CategoriaLojaObjetoWs _CategoriaLojaReferenteA;
	public CategoriaLojaObjetoWs getCategoriaLojaReferenteA() {
		return _CategoriaLojaReferenteA;
	}
	public void setCategoriaLojaReferenteA( CategoriaLojaObjetoWs dado ) {
		_CategoriaLojaReferenteA = dado;
	}
  private ProdutoObjetoWs _ProdutoReferenteA;
	public ProdutoObjetoWs getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( ProdutoObjetoWs dado ) {
		_ProdutoReferenteA = dado;
	}
}
