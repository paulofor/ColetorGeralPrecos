package coletapreco.modelo.derivadas;

import coletapreco.modelo.CompartilhamentoProduto;

public class CompartilhamentoProdutoDerivada implements CompartilhamentoProdutoDerivadaI {

	private CompartilhamentoProduto principal;
    public CompartilhamentoProdutoDerivada( CompartilhamentoProduto itemPrincipal )
    {
    principal = itemPrincipal;
	}
}
