package coletapreco.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.PalavraProdutoDao;
import coletapreco.modelo.Palavra;
import coletapreco.modelo.PalavraProduto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.PalavraProdutoRegraColecao;
import coletapreco.regracolecao.PalavraRegraColecao;


public  class PalavraProdutoRegraColecaoImpl  extends PalavraProdutoRegraColecao {

	@Override
	public PalavraProduto PosicionaPalavra(DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao(conexao);
		PalavraRegraColecao palavraSrv = FabricaRegra.getInstancia().getPalavraRegraColecao();
		PalavraProduto nova = this.getFiltro().validaItem();
		String descricao = nova.getCorrentePalavra_RelaciondoA().getDescricao();
		descricao = this.limpaPalavra(descricao);
		palavraSrv.getFiltro().setDescricaoPalavra(descricao);
		Palavra pesquisa = palavraSrv.ObtemPorDescricaoPalavra(conexao);
		if (pesquisa!=null) {
			// Ja existe
			nova.setPalavraRelaciondoA(pesquisa);
			dao.insereItem(nova);
		} else {
			// Nao existe
			nova.getCorrentePalavra_RelaciondoA().setDescricao(descricao);
			nova.setPalavraRelaciondoA(palavraSrv.insereItemLoad(nova.getCorrentePalavra_RelaciondoA(), conexao));
			dao.insereItem(nova);
		}
		return nova;
	} 
	
	private String limpaPalavra(String palavra) {
		// nome. -> len = 5
		// 01234
		if (palavra.indexOf(".") == palavra.length()-1) {
			palavra = palavra.substring(0,palavra.length()-1);
		}
		if (palavra.indexOf(",") == palavra.length()-1) {
			palavra = palavra.substring(0,palavra.length()-1);
		}
		int i = palavra.indexOf("...");
		if (palavra.indexOf("...")>0 && palavra.indexOf("...") == palavra.length()-3) {
			palavra = palavra.substring(0,palavra.length()-3);
		}
		return palavra;
	}
}
