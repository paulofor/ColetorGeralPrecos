package coletapreco.dao.montador;

import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.ResultadoLista;
import coletapreco.modelo.PrecoProduto;

public class PrecoProdutoPosicaoMontador extends PrecoProdutoMontador {

	public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, DCIObjetoDominio entrada, int pos)
			throws DaoException {
		PrecoProduto objeto;
		objeto = (PrecoProduto) entrada;

		objeto.setIdPrecoProduto(resultadoLista.getInt(pos++));
		objeto.setPrecoBoleto(resultadoLista.getFloat(pos++));
		objeto.setDataVisitaInicial(resultadoLista.getString(pos++));
		objeto.setQuantidadeParcela(resultadoLista.getInt(pos++));
		objeto.setPrecoParcela(resultadoLista.getFloat(pos++));
		objeto.setPrecoVenda(resultadoLista.getFloat(pos++));
		objeto.setPrecoRegular(resultadoLista.getFloat(pos++));
		objeto.setDataUltimaVisita(resultadoLista.getString(pos++));
		objeto.setPercentualAjuste(resultadoLista.getFloat(pos++));
		objeto.setMedia2meses(resultadoLista.getFloat(pos++));
		objeto.setMinimo3meses(resultadoLista.getFloat(pos++));
		objeto.setIdProdutoPa(resultadoLista.getInt(pos++));

		objeto.setPosicao(resultadoLista.getInt(pos++));
		objeto.setPosicao1(resultadoLista.getInt(pos++));
		objeto.setPosicao2(resultadoLista.getInt(pos++));
		objeto.setPosicao3(resultadoLista.getInt(pos++));
		objeto.setPosicao4(resultadoLista.getInt(pos++));
		objeto.setPosicao5(resultadoLista.getInt(pos++));
		objeto.setPosicao6(resultadoLista.getInt(pos++));
		objeto.setPosicao7(resultadoLista.getInt(pos++));
		objeto.setDiferencaPosicao7(resultadoLista.getInt(pos++));

		return objeto;
	}

	public int quantidadeCampos() {
		return 21;
	}
}
