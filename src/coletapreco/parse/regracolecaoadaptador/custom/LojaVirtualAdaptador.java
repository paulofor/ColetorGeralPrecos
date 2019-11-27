package coletapreco.parse.regracolecaoadaptador.custom;

import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.parse.callback.LojaVirtualDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualAmericanasDetalheCallback;
import coletapreco.parse.callback.custom.LojaVirtualCasasBahiaDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualExtraDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualLuizaDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualPontoFrioDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualRiHappyDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualRicardoDetalheCallbackHtml;
import coletapreco.parse.callback.custom.LojaVirtualSubmarinoDetalheCallback;
import coletapreco.parse.callback.custom.LojaVirtualWalmartDetalheCallbackHtml;
import coletapreco.parse.regracolecaoadaptador.LojaVirtualRegraColecaoAdaptador;

public class LojaVirtualAdaptador extends LojaVirtualRegraColecaoAdaptador {

	private LojaVirtual item = null;
	private NaturezaProduto naturezaProduto = null;
	
	public void setItem(LojaVirtual loja) {
		item = loja;
		this.callbackLista = null;
		this.callbackDetalhe = null;
	}
	public void setNaturezaProduto(NaturezaProduto natureza) {
		naturezaProduto = natureza;
	}

	@Override
	protected ICallbackParse criaDetalheCallbackHtml() {
		LojaVirtualDetalheCallbackHtml callback = null;
		if (item.getIdObj()==1) {
			callback =  new LojaVirtualAmericanasDetalheCallback();
		}
		if (item.getIdObj()==2) {
			callback =  new LojaVirtualLuizaDetalheCallbackHtml();
		}
		if (item.getIdObj()==3) {
			callback =  new LojaVirtualExtraDetalheCallbackHtml();
		}
		if (item.getIdObj()==4) {
			callback =  new LojaVirtualWalmartDetalheCallbackHtml();
		}
		if (item.getIdObj()==5) {
			callback =  new LojaVirtualSubmarinoDetalheCallback();
		}
		if (item.getIdObj()==6) {
			callback =  new LojaVirtualRicardoDetalheCallbackHtml();
		}
		if (item.getIdObj()==7) {
			callback =  new LojaVirtualPontoFrioDetalheCallbackHtml();
		}
		if (item.getIdObj()==8) {
			callback =  new LojaVirtualCasasBahiaDetalheCallbackHtml();
		}
		if (item.getIdObj()==9) {
			callback =  new LojaVirtualRiHappyDetalheCallbackHtml();
		}
		callback.setNaturezaProduto(naturezaProduto);
		return callback;
	}
	
	

}
