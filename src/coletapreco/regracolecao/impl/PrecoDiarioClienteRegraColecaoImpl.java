package coletapreco.regracolecao.impl;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.PrecoDiarioClienteDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.PrecoDiarioCliente;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.PrecoDiarioClienteRegraColecao;

public class PrecoDiarioClienteRegraColecaoImpl extends PrecoDiarioClienteRegraColecao {

	@Override
	public List<PrecoDiarioCliente> ConverteEnviaListaParaCliente(DaoConexao conexao) throws DaoException {
		List<PrecoDiario> listaPreco = this.getListaEntradaGenerica();
		Usuario usuario = this.getFiltro().getUsuario();
		//List<PrecoDiarioCliente> listaSaida = new ArrayList<PrecoDiarioCliente>();
		PrecoDiarioClienteDao dao = getDao(conexao);
		getFiltro().setUsuario(usuario);
		LimpaPrecoNuvemUsuario(conexao);
		for (PrecoDiario preco : listaPreco) {
			PrecoDiarioCliente saida = FabricaVo.criaPrecoDiarioCliente();
			saida.setIdUsuarioS(usuario.getIdUsuario());
			saida.setPrecoVenda(preco.getPrecoVenda());
			saida.setDataHora(preco.getDataHora());
			saida.setIdProdutoClientePa(preco.getIdProdutoPa());
			saida.setIdPrecoDiarioClientte(preco.getIdPrecoDiario());
			dao.insereItem(saida);
			System.out.println("Preço:" + saida.getDataHora() + ":" + saida.getPrecoVendaFormatada());
		}
		return null;
	}

	


	private PrecoDiarioCliente LimpaPrecoNuvemUsuario(DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao(conexao);
		Usuario usuario = this.getFiltro().validaUsuario();
		dao.excluiTodosUsuario(usuario.getIdUsuario());
		return null;
	}

}
