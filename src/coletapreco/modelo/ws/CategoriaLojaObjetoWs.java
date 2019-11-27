package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CategoriaLojaObjetoWs   { 
      long _idCategoriaLoja;
	public long getIdCategoriaLoja() {
		return _idCategoriaLoja;
	}
	public void setIdCategoriaLoja( long dado ) {
		_idCategoriaLoja = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
      long _idCategoriaLojaP;
	public long getIdCategoriaLojaP() {
		return _idCategoriaLojaP;
	}
	public void setIdCategoriaLojaP( long dado ) {
		_idCategoriaLojaP = dado;
	}
      long _idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		return _idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa( long dado ) {
		_idNaturezaProdutoRa = dado;
	}
      long _idLojaVirtualPa;
	public long getIdLojaVirtualPa() {
		return _idLojaVirtualPa;
	}
	public void setIdLojaVirtualPa( long dado ) {
		_idLojaVirtualPa = dado;
	}
  private CategoriaLojaObjetoWs _CategoriaLojaFilho;
	public CategoriaLojaObjetoWs getCategoriaLojaFilho() {
		return _CategoriaLojaFilho;
	}
	public void setCategoriaLojaFilho( CategoriaLojaObjetoWs dado ) {
		_CategoriaLojaFilho = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoReferenteA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
  private LojaVirtualObjetoWs _LojaVirtualPertenceA;
	public LojaVirtualObjetoWs getLojaVirtualPertenceA() {
		return _LojaVirtualPertenceA;
	}
	public void setLojaVirtualPertenceA( LojaVirtualObjetoWs dado ) {
		_LojaVirtualPertenceA = dado;
	}
}
