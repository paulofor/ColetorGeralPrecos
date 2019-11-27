package coletapreco.parse.regracolecaoadaptador.custom;

import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;
import coletapreco.parse.callback.custom.CategoriaLojaAmericanasDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaArezzoDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaAtacadoMaquiagemDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaCarmosBRDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaCasasBahiaDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaConceitoFashionDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaCristalCosmeticDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaDafitiDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaExtraDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaLuizaDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaPassarelaDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaPontoFrioDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaRennerDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaRevendaCosmeticosDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaRiHappyDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaRicardoDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaSaraivaDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaSubmarinoDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaVirtualMakeDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaWalmartDetalheCallback;
import coletapreco.parse.callback.custom.CategoriaLojaZattiniDetalheCallback;
import coletapreco.parse.regracolecaoadaptador.CategoriaLojaRegraColecaoAdaptador;

public class CategoriaLojaAdaptador extends CategoriaLojaRegraColecaoAdaptador {

	
	
	private LojaVirtual item = null;
	private NaturezaProduto naturezaProduto = null;
	
	public void setItem(LojaVirtual loja) {
		item = loja;
		this.callbackDetalhe = null;
		this.callbackLista = null;
	}
	public void setNaturezaProduto(NaturezaProduto natureza) {
		naturezaProduto = natureza;
	}
	
	@Override
	protected ICallbackParse criaDetalheCallbackHtml() {
		CategoriaLojaDetalheCallbackHtml callback = null;
		if (item.getIdObj()==1) {
			callback =  new CategoriaLojaAmericanasDetalheCallback();
		}
		if (item.getIdObj()==2) {
			callback =  new CategoriaLojaLuizaDetalheCallback();
		}
		if (item.getIdObj()==3) {
			callback =  new CategoriaLojaExtraDetalheCallback();
		}
		if (item.getIdObj()==4) {
			callback =  new CategoriaLojaWalmartDetalheCallback();
		}
		if (item.getIdObj()==5) {
			callback =  new CategoriaLojaSubmarinoDetalheCallback();
		}
		if (item.getIdObj()==6) {
			callback =  new CategoriaLojaRicardoDetalheCallback();
		}
		if (item.getIdObj()==7) {
			callback =  new CategoriaLojaPontoFrioDetalheCallback();
		}
		if (item.getIdObj()==8) {
			callback =  new CategoriaLojaCasasBahiaDetalheCallback();
		}
		if (item.getIdObj()==9) {
			callback =  new CategoriaLojaRiHappyDetalheCallback();
		}
		if (item.getIdObj()==10) {
			callback =  new CategoriaLojaSaraivaDetalheCallback();
		}
		if (item.getIdObj()==11) {
			callback =  new CategoriaLojaDafitiDetalheCallback();
		}
		if (item.getIdObj()==12) {
			callback =  new CategoriaLojaZattiniDetalheCallback();
		}
		if (item.getIdObj()==13) {
			callback =  new CategoriaLojaConceitoFashionDetalheCallback();
		}
		if (item.getIdObj()==14) {
			callback =  new CategoriaLojaPassarelaDetalheCallback();
		}
		if (item.getIdObj()==15) {
			callback =  new CategoriaLojaRennerDetalheCallback();
		}
		if (item.getIdObj()==16) {
			callback =  new CategoriaLojaArezzoDetalheCallback();
		}
		if (item.getIdObj()==26) {
			callback =  new CategoriaLojaRevendaCosmeticosDetalheCallback();
		}
		if (item.getIdObj()==27) {
			callback =  new CategoriaLojaAtacadoMaquiagemDetalheCallback();
		}
		if (item.getIdObj()==28) {
			callback =  new CategoriaLojaCarmosBRDetalheCallback();
		}
		if (item.getIdObj()==29) {
			callback =  new CategoriaLojaCristalCosmeticDetalheCallback();
		}
		if (item.getIdObj()==30) {
			callback =  new CategoriaLojaVirtualMakeDetalheCallback();
		}
		//callback.setNaturezaProduto(naturezaProduto);
		return callback;

	}
	
	
}
