package coletapreco.regracolecao.impl;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.dao.PrecoDiarioDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.InteresseProduto;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.InteresseProdutoRegraColecao;
import coletapreco.regracolecao.PrecoDiarioRegraColecao;
import coletapreco.util.UtilData;


public  class PrecoDiarioRegraColecaoImpl  extends PrecoDiarioRegraColecao {
	
	private InteresseProdutoRegraColecao interesseProdutoSrv = FabricaRegra.getInstancia().getInteresseProdutoRegraColecao();

	@Override
	public PrecoDiario RegistraPreco(DaoConexao conexao) throws DaoException {
		PrecoDiario precoDia = FabricaVo.criaPrecoDiario();
		Produto pesquisa = getFiltro().getProduto();
		
		
		PrecoProduto precoProduto = pesquisa.getCorrentePrecoProduto_Possui();
		precoDia.setPrecoBoleto(precoProduto.getPrecoBoleto());
		precoDia.setPrecoParcela(precoProduto.getPrecoParcela());
		precoDia.setPrecoRegular(precoProduto.getPrecoRegular());
		precoDia.setQuantidadeParcela(precoProduto.getQuantidadeParcela());
		precoDia.setPrecoVenda(precoProduto.getPrecoVenda());
		//precoDia.setDataHora(DatasUtils.getDataDD_MM_AAAA() + " " + DatasUtils.getHora());
		precoDia.setDataHora(UtilData.getDataHora());
		precoDia.setProdutoPertenceA(pesquisa);
		precoDia.setPosicaoProduto(pesquisa.getPosicaoProduto());
		
		getFiltro().setIdProduto(pesquisa.getIdProduto());
		getFiltro().setDataPesquisa(DatasUtils.getDataDD_MM_AAAA());
		PrecoDiario existe = this.ObtemPorDataIdProduto(conexao);
		
		if (existe!=null) return existe;
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItem(precoDia);
		return precoDia;
	}

	
	//* Atualizando com o preco do momento atual para ser enviado ao cliente de forma mais imediata.
	@Override
	public PrecoDiario AtualizaPrecoDia(DaoConexao conexao) throws DaoException {
		PrecoDiario novo = this.getFiltro().validaPrecoAtual();
		getFiltro().setIdProduto(novo.getIdProdutoPa());
		getFiltro().setDataPesquisa(DatasUtils.getDataDD_MM_AAAA());
		PrecoDiario existe = this.ObtemPorDataIdProduto(conexao);
		
		if (existe==null) {
			PrecoDiarioDao dao = getDao();
			dao.setConexao(conexao);
			dao.insereItem(novo);
			return novo;
		} else {
			if (existe.getPrecoVenda() == novo.getPrecoVenda()) {
				// Nao faz nada
				return null;
			} else {
				existe.setDataHora(novo.getDataHora());
				existe.setPrecoVenda(novo.getPrecoVenda());
				existe.setPrecoParcela(0);
				existe.setQuantidadeParcela(0);
				PrecoDiarioDao dao = getDao();
				dao.setConexao(conexao);
				dao.alteraItem(existe);
				return existe;
			}
		}
	} 
	
	
	@Override
	public PrecoDiario ObtemPorDataIdProduto(DaoConexao conexao) throws DaoException {
		long idProduto = getFiltro().validaIdProduto();
		String data = getFiltro().validaDataPesquisa();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao.obtemPorDataIdProduto(dataBd,idProduto);
	}

	@Override
	public PrecoDiario ObtemMaisRecentePorIdProduto(DaoConexao conexao) throws DaoException {
		long idProduto = getFiltro().validaIdProduto();
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao.obtemMaisRecenteIdProduto(idProduto);
	}


	@Override
	public PrecoDiario EnviaListaServidorComoCliente(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PrecoDiario> ListaPorIdProduto2Mes(DaoConexao conexao) throws DaoException {
		long idProduto = this.getFiltro().validaIdProduto();
		List<PrecoDiario> listaPreco = null;
		try {
			String dataInicialBd = UtilData.deslocaMesesFormatoDabase(-2);
			PrecoDiarioDao dao = getDao(conexao);
			listaPreco = dao.ListaPorIdProdutoDataInicialSemZeros(idProduto,dataInicialBd);
		} catch (ParseException e) {
			throw new DaoException("Erro de parser");
		}
		return listaPreco;
	}


	@Override
	public List<PrecoDiario> ListaPorIdProduto1mes(DaoConexao conexao) throws DaoException {
		
		long idProduto = this.getFiltro().validaIdProduto();
		List<PrecoDiario> listaPreco = null;
		try {
			String dataInicialBd = UtilData.deslocaMesesFormatoDabase(-1);
			PrecoDiarioDao dao = getDao(conexao);
			listaPreco = dao.ListaPorIdProdutoDataInicialSemZeros(idProduto,dataInicialBd);
		} catch (ParseException e) {
			throw new DaoException("Erro de parser");
		}
		return listaPreco;
	}


//	@Override
//	public PrecoDiario EnviaServidorPorUsuarioComoCliente(DaoConexao conexao) throws DaoException {
//		Usuario usuario = getFiltro().validaUsuario();
//		List<PrecoDiario> listaPreco = new ArrayList<PrecoDiario>();
//		List<InteresseProduto> listaInteresse = this.interesseProdutoSrv.getPorSincronizaUsuario(usuario.getIdUsuario(), conexao);
//		for (InteresseProduto interesse : listaInteresse) {
//			
//		}
//	}

	
}
