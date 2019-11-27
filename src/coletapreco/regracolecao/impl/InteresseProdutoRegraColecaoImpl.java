package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.InteresseProduto;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.InteresseProdutoRegraColecao;
import coletapreco.regracolecao.PrecoProdutoRegraColecao;
import coletapreco.regracolecao.UsuarioRegraColecao;
import coletapreco.util.UtilData;


public  class InteresseProdutoRegraColecaoImpl  extends InteresseProdutoRegraColecao {


	

	@Override
	public InteresseProduto CalculaNota(DaoConexao conexao) throws DaoException {
		InteresseProduto item = this.getFiltro().validaItem();
		long notaAtual = item.getNota();
		List<PrecoDiario> listaPreco = this.getFiltro().getListaPrecoDiarioOrdenado();
		float min = 999999999;
		float max = 0;
		for (PrecoDiario preco : listaPreco) {
			if (preco.getPrecoVenda()>max) max = preco.getPrecoVenda();
			if (preco.getPrecoVenda()<min) min = preco.getPrecoVenda();
		}
		
		float perc = (max-min) / 100;
		float limite3 = min+(15*perc);
		float limite2 = min+(40*perc);
		float limite1 = min+(70*perc);
		float limite0 = min+(100*perc);
		if (item.getValor() <= limite0) item.setNota(0);
		if (item.getValor() <= limite1) item.setNota(1);
		if (item.getValor() <= limite2) item.setNota(2);
		if (item.getValor() <= limite3) item.setNota(3);
		if (max==min) {
			item.setNota(2);
		}
		if (item.getNota()!=notaAtual)  {
			item.setDataUltimaMudancaNota(UtilData.getDataHora());
			item.setDataUltimaMudancaNotaGmt(UtilData.getDataHoraGmt());
			item.setMudancaNota(true);
		}
		return item;
	}

	@Override
	public InteresseProduto AtualizaComListaPrecoDiario(DaoConexao conexaoNuvem) throws DaoException {
		InteresseProduto interesse = this.getFiltro().validaItem();
		List<PrecoDiario> listaPreco = this.getFiltro().getListaPrecoDiarioOrdenado();
		Usuario usuario = this.getFiltro().validaUsuario();
		PrecoDiario anterior = null;
		float soma = 0;
		int cont = 0;
		float minimo = listaPreco.get(0).getPrecoVenda();
		float diferenca = listaPreco.get(0).getPrecoVenda()  - listaPreco.get(1).getPrecoVenda();
		
		for (PrecoDiario atual : listaPreco) {
			cont++;
			soma += atual.getPrecoVenda();
			if (atual.getPrecoVenda() < minimo) {
				minimo = atual.getPrecoVenda();
			}
		}
		float media = soma / cont;
		interesse.setPrecoMedio(media);
		interesse.setPrecoMinimo(minimo);
		interesse.setDiferencaAnterior(diferenca);
		boolean mudanca = (listaPreco.get(0).getPrecoVenda()!=interesse.getValor()) || (interesse.getNovo());
		if (mudanca) {
			ArquivoLog.getInstancia().salvaMudanca(
					" Mudanca - Usuario: " + interesse.getIdUsuarioS() +
					" Produto: " + interesse.getIdProdutoClienteRa() + 
					" Valor Anterior: " + interesse.getValor() +
					" Valor Atual: " + listaPreco.get(0).getPrecoVenda() +
					" Novo: " + interesse.getNovo());
			interesse.setDataUltimaMudanca(UtilData.getDataHora());
			interesse.setDataUltimaMudancaGmt(UtilData.getDataHoraGmt());
			if (!interesse.getNovo())
				interesse.setPrecoAnterior(interesse.getValor());
			interesse.setPrecoAtual(listaPreco.get(0).getPrecoVenda());
		}
		interesse.setMudanca(mudanca);
		interesse.setValor(listaPreco.get(0).getPrecoVenda());
		interesse.setNovo(false);
		interesse.setDataUltimaVerificacao(UtilData.getDataHora());
			
		this.getFiltro().setItem(interesse);
		this.CalculaNota(null);
		this.alteraItem(interesse, conexaoNuvem);
		
		return interesse;
	}
}
