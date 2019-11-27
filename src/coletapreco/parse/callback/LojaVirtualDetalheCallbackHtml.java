package coletapreco.parse.callback;

import coletapreco.modelo.NaturezaProduto;
import coletapreco.parse.callback.basico.LojaVirtualDetalheCallbackHtmlBase;
import coletapreco.parse.dados.LojaVirtualDadosParse;

public class LojaVirtualDetalheCallbackHtml extends LojaVirtualDetalheCallbackHtmlBase{

	private NaturezaProduto natureza = null;
	public void setNaturezaProduto(NaturezaProduto valor) {
		natureza = valor;
	}
	
	@Override
	public void inicializacao() {
		super.inicializacao();
		((LojaVirtualDadosParse)dadosParse).setNaturezaProduto(natureza);
	}


}