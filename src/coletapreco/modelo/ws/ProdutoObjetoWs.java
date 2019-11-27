package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ProdutoObjetoWs   { 
      long _idProduto;
	public long getIdProduto() {
		return _idProduto;
	}
	public void setIdProduto( long dado ) {
		_idProduto = dado;
	}
      String _urlOrigem;
	public String getUrlOrigem() {
		return _urlOrigem;
	}
	public void setUrlOrigem( String dado ) {
		_urlOrigem = dado;
	}
      String _imagemLocal;
	public String getImagemLocal() {
		return _imagemLocal;
	}
	public void setImagemLocal( String dado ) {
		_imagemLocal = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      long _posicaoProduto;
	public long getPosicaoProduto() {
		return _posicaoProduto;
	}
	public void setPosicaoProduto( long dado ) {
		_posicaoProduto = dado;
	}
      String _imagem;
	public String getImagem() {
		return _imagem;
	}
	public void setImagem( String dado ) {
		_imagem = dado;
	}
      long _idLojaVirtualLe;
	public long getIdLojaVirtualLe() {
		return _idLojaVirtualLe;
	}
	public void setIdLojaVirtualLe( long dado ) {
		_idLojaVirtualLe = dado;
	}
      long _idMarcaP;
	public long getIdMarcaP() {
		return _idMarcaP;
	}
	public void setIdMarcaP( long dado ) {
		_idMarcaP = dado;
	}
  private LojaVirtualObjetoWs _LojaVirtualLidoEm;
	public LojaVirtualObjetoWs getLojaVirtualLidoEm() {
		return _LojaVirtualLidoEm;
	}
	public void setLojaVirtualLidoEm( LojaVirtualObjetoWs dado ) {
		_LojaVirtualLidoEm = dado;
	}
  private MarcaObjetoWs _MarcaPossui;
	public MarcaObjetoWs getMarcaPossui() {
		return _MarcaPossui;
	}
	public void setMarcaPossui( MarcaObjetoWs dado ) {
		_MarcaPossui = dado;
	}
      long _posicao;
	public long getPosicao() {
		return _posicao;
	}
	public void setPosicao( long dado ) {
		_posicao = dado;
	}
      String _codigoImagemLocal;
	public String getCodigoImagemLocal() {
		return _codigoImagemLocal;
	}
	public void setCodigoImagemLocal( String dado ) {
		_codigoImagemLocal = dado;
	}
}
