package coletapreco.dao.montador;

import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.ResultadoLista;
import coletapreco.modelo.PrecoProduto;

public class PrecoProdutoParaOportunidadeMontador extends PrecoProdutoMontador{

	
	public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, DCIObjetoDominio entrada, int pos)
			throws DaoException {
		PrecoProduto objeto = (PrecoProduto) super.extraiRegistro(resultadoLista, entrada, pos);
		pos = super.quantidadeCampos() + 1;
		objeto.setPrecoSugestao(resultadoLista.getFloat(pos++));
		return objeto;
	}

	public int quantidadeCampos() {
		return super.quantidadeCampos() + 1;
	}
}
