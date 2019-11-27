package coletapreco.regracolecao.impl;


import java.util.LinkedList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.PalavraDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.Palavra;
import coletapreco.regracolecao.PalavraRegraColecao;


public  class PalavraRegraColecaoImpl  extends PalavraRegraColecao { 
	public  List ListaPorNome( DaoConexao conexao )  throws  DaoException{
		return null;
	}

	@Override
	public List<Palavra> ListaPorNomeProduto(DaoConexao conexao) throws DaoException {
		String nomeProduto = this.getFiltro().validaProduto().getNome();
		String palavras[] = nomeProduto.split(" ");
		List<Palavra> listaSaida = new LinkedList<Palavra>();
		for (int cont=0;cont<palavras.length;cont++) {
			Palavra palavra = FabricaVo.criaPalavra();
			palavra.setDescricao(palavras[cont]);
			listaSaida.add(palavra);
		}
		return listaSaida;
	}

	@Override
	public Palavra ObtemPorDescricaoPalavra(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao(conexao) ;
		String palavra = this.getFiltro().validaDescricaoPalavra();
		return dao.ObtemPorDescricaoPalavra(palavra);
	}

	@Override
	public Palavra IdentificaPalavraComum(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao(conexao);
		dao.atualizaComum(50); // Quantidade minima para considerar comum
		dao.atualizaNaoComum();
		return null;
	}
}
