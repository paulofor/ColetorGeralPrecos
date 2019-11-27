package coletapreco.parse.regracolecaoadaptador.custom;

import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.callback.custom.ProdutoAmericanasDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoArezzoDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoCasasBahiaDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoDafitiDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoExtraDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoLuizaDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoPassarelaDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoPontoFrioDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoRicardoDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoSubmarinoDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoWalmartDetalheCallback;
import coletapreco.parse.callback.custom.ProdutoZattiniDetalheCallback;
import coletapreco.parse.regracolecaoadaptador.ProdutoRegraColecaoAdaptador;
import coletapreco.util.ConstantesLoja;

public class ProdutoAdaptador extends ProdutoRegraColecaoAdaptador{

	

	@Override
	protected ICallbackParse criaDetalheCallbackHtml() {
		ProdutoDetalheCallbackHtml callback = null;
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_DAFITI) {
			callback =  new ProdutoDafitiDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_PONTO_FRIO) {
			callback =  new ProdutoPontoFrioDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_BAHIA) {
			callback =  new ProdutoCasasBahiaDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_AMERICANAS) {
			callback =  new ProdutoAmericanasDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_EXTRA) {
			callback =  new ProdutoExtraDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_WALMART) {
			callback =  new ProdutoWalmartDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_LUIZA) {
			callback =  new ProdutoLuizaDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_SUBMARINO) {
			callback =  new ProdutoSubmarinoDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_RICARDO) {
			callback =  new ProdutoRicardoDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_PASSARELA) {
			callback =  new ProdutoPassarelaDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_AREZZO) {
			callback =  new ProdutoArezzoDetalheCallback();
		}
		if (this.getItemRaiz().getIdLojaVirtualLe()==ConstantesLoja.ID_ZATTINI) {
			callback =  new ProdutoZattiniDetalheCallback();
		}
		return callback;
	}
	
	
	
}
