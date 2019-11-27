
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class ProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idLojaVirtualLidoEm = -1;
		public long getCodigoLojaVirtualLidoEm() {
			return _codigo_idLojaVirtualLidoEm;
		}
		public void setCodigoLojaVirtualLidoEm(long dado) {
			_codigo_idLojaVirtualLidoEm = dado;
		}
      	
      	private long _codigo_idMarcaPossui = -1;
		public long getCodigoMarcaPossui() {
			return _codigo_idMarcaPossui;
		}
		public void setCodigoMarcaPossui(long dado) {
			_codigo_idMarcaPossui = dado;
		}
      	

		private String _NomeProduto;
		public String getNomeProduto () {
			return _NomeProduto ;
		}
		public void setNomeProduto (String value) {
			_NomeProduto  = value;
		}
		
		public String validaNomeProduto() {
			
			if (_NomeProduto == null) {
				throw new RuntimeException("NomeProduto eh nulo");
			}
			
			return getNomeProduto ();
		}
		
		private long _CodigoLoja;
		public long getCodigoLoja () {
			return _CodigoLoja ;
		}
		public void setCodigoLoja (long value) {
			_CodigoLoja  = value;
		}
		
		public long validaCodigoLoja() {
			
			if (_CodigoLoja == 0) {
				throw new RuntimeException("CodigoLoja eh zero");
			}
			
			return getCodigoLoja ();
		}
		
		private String _UrlProduto;
		public String getUrlProduto () {
			return _UrlProduto ;
		}
		public void setUrlProduto (String value) {
			_UrlProduto  = value;
		}
		
		public String validaUrlProduto() {
			
			if (_UrlProduto == null) {
				throw new RuntimeException("UrlProduto eh nulo");
			}
			
			return getUrlProduto ();
		}
		
		private String _DataInicioOportunidade;
		public String getDataInicioOportunidade () {
			return _DataInicioOportunidade ;
		}
		public void setDataInicioOportunidade (String value) {
			_DataInicioOportunidade  = value;
		}
		
		public String validaDataInicioOportunidade() {
			
			if (_DataInicioOportunidade == null) {
				throw new RuntimeException("DataInicioOportunidade eh nulo");
			}
			
			return getDataInicioOportunidade ();
		}
		
		private float _PercentualMinimoOportunidade;
		public float getPercentualMinimoOportunidade () {
			return _PercentualMinimoOportunidade ;
		}
		public void setPercentualMinimoOportunidade (float value) {
			_PercentualMinimoOportunidade  = value;
		}
		
		public float validaPercentualMinimoOportunidade() {
			
			if (_PercentualMinimoOportunidade == 0) {
				throw new RuntimeException("PercentualMinimoOportunidade eh zero");
			}
			
			return getPercentualMinimoOportunidade ();
		}
		
		private List _ListaPalavraProduto;
		public List getListaPalavraProduto () {
			return _ListaPalavraProduto ;
		}
		public void setListaPalavraProduto (List value) {
			_ListaPalavraProduto  = value;
		}
		
		public List validaListaPalavraProduto() {
			
			if (_ListaPalavraProduto == null) {
				throw new RuntimeException("ListaPalavraProduto eh nulo");
			}
			
			return getListaPalavraProduto ();
		}
		
		private long _CodigoNatureza;
		public long getCodigoNatureza () {
			return _CodigoNatureza ;
		}
		public void setCodigoNatureza (long value) {
			_CodigoNatureza  = value;
		}
		
		public long validaCodigoNatureza() {
			
			if (_CodigoNatureza == 0) {
				throw new RuntimeException("CodigoNatureza eh zero");
			}
			
			return getCodigoNatureza ();
		}
		
		private long _LimitePosicionador;
		public long getLimitePosicionador () {
			return _LimitePosicionador ;
		}
		public void setLimitePosicionador (long value) {
			_LimitePosicionador  = value;
		}
		
		public long validaLimitePosicionador() {
			
			if (_LimitePosicionador == 0) {
				throw new RuntimeException("LimitePosicionador eh zero");
			}
			
			return getLimitePosicionador ();
		}
		
		private Produto _Item;
		public Produto getItem () {
			return _Item ;
		}
		public void setItem (Produto value) {
			_Item  = value;
		}
		
		public Produto validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private long _IdProduto;
		public long getIdProduto () {
			return _IdProduto ;
		}
		public void setIdProduto (long value) {
			_IdProduto  = value;
		}
		
		public long validaIdProduto() {
			
			if (_IdProduto == 0) {
				throw new RuntimeException("IdProduto eh zero");
			}
			
			return getIdProduto ();
		}
		
		private long _DiasPrecoVitrine;
		public long getDiasPrecoVitrine () {
			return _DiasPrecoVitrine ;
		}
		public void setDiasPrecoVitrine (long value) {
			_DiasPrecoVitrine  = value;
		}
		
		public long validaDiasPrecoVitrine() {
			
			if (_DiasPrecoVitrine == 0) {
				throw new RuntimeException("DiasPrecoVitrine eh zero");
			}
			
			return getDiasPrecoVitrine ();
		}
		


		//public String NomeProduto;
		//public long CodigoLoja;
		//public String UrlProduto;
		//public String DataInicioOportunidade;
		//public float PercentualMinimoOportunidade;
		//public List ListaPalavraProduto;
		//public long CodigoNatureza;
		//public long LimitePosicionador;
		//public long IdProduto;
		//public long DiasPrecoVitrine;

		
}