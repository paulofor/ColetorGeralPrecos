package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.ContagemProdutoDao;
import coletapreco.dao.OportunidadeDiaDao;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.ContagemProduto;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;


public  class ContagemProdutoRegraColecaoImpl  extends ContagemProdutoRegraColecao { 
	public ContagemProduto RegistraQuantidadesDia( DaoConexao conexao )  throws  DaoException{
		ContagemProdutoDao dao = getDao(conexao);
		//dao.RegistraQuantidadesDia();
		dao.AtualizaQuantidadesDia();
		return null;
	}

	@Override
	public ContagemProduto EnviaParaServidor(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao(conexao);
		List<ContagemProduto> listaOportunidade = dao.ListaDiaCorrente();
		dao.EnviaListaNuvem(listaOportunidade);
		ArquivoLog.getInstancia().salvaMonitoramento("Envando para nuvem " + listaOportunidade.size() + " itens.");
		return null;
	}

	@Override
	public ContagemProduto CalculaDiferencaErro(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao(conexao);
		dao.CalculaDiferencaErro();
		return null;
	}
}
