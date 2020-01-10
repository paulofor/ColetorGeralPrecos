package coletapreco.regracolecao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.dao.OportunidadeDiaDao;
import coletapreco.dao.basica.DataSourceAplicacao;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.FacebookFanpage;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.Produto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;
import coletapreco.regracolecao.PrecoDiarioRegraColecao;
import coletapreco.regracolecao.PrecoProdutoRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;
import coletapreco.util.UtilData;

public class OportunidadeDiaRegraColecaoImpl extends OportunidadeDiaRegraColecao {

	private float PERCENTUAL_OPORTUNIDADE = 10.0F;
	private int QTDE_DIAS_OPORTUNIDADE = 15;

	public OportunidadeDia EnviaParaServidor(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao(conexao);
		List<OportunidadeDia> listaOportunidade = dao.ListaCorrentePlus();
		dao.enviaListaNuvem(listaOportunidade);
		ArquivoLog.getInstancia().salvaMonitoramento("Envando para nuvem " + listaOportunidade.size() + " itens.");
		/*
		PrecoDiarioDao daoPreco =  DBB.getInstancia().getPrecoDiarioDao();
		daoPreco.limparTabelaNuvem();
		for (OportunidadeDia oportunidade : listaOportunidade) {
			daoPreco.setConexao(conexao);
			List<PrecoDiario> listaPreco = daoPreco.ListaPorProdutoPertenceA(oportunidade.getIdProdutoRa());
			daoPreco.enviaListaNuvem(listaPreco);
		}
		*/
		return null;
	}

	
	private void CalculaMediaMinimo(DaoConexao conexao) throws DaoException {
		PrecoProdutoRegraColecao precoProdutoSrv = FabricaRegra.getInstancia().getPrecoProdutoRegraColecao();
		precoProdutoSrv.CalculaMedioMinimoAjustePositivo(conexao);
	}
	
	private void CalculaDiferencaPosicao(DaoConexao conexao) throws DaoException {
		PrecoProdutoRegraColecao precoProdutoSrv = FabricaRegra.getInstancia().getPrecoProdutoRegraColecao();
		precoProdutoSrv.CalculaDiferencaPosicao(conexao);
	}
	
	public OportunidadeDia CalculaOportunidadesHoje(DaoConexao conexao) throws DaoException {

		PrecoDiarioRegraColecao precoDiarioSrv = FabricaRegra.getInstancia().getPrecoDiarioRegraColecao();
		
		this.LiberaConexao(conexao);
		DataFonte dsLocal = new DataSourceAplicacao();
		conexao = dsLocal.criaConexao();
		
		// Calculando Medias e Minimos.
		this.CalculaMediaMinimo(conexao);
		// Produtos que evoluiram
		this.CalculaDiferencaPosicao(conexao);
		System.out.println("Calculando media e minimos");
		
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		NaturezaProdutoRegraColecao naturezaSrv = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
		String dataInicio = DatasUtils.getDataAAAA_MM_DD_Add(this.QTDE_DIAS_OPORTUNIDADE * -1);
		produtoSrv.getFiltro().setDataInicioOportunidade(dataInicio);
		produtoSrv.getFiltro().setPercentualMinimoOportunidade(this.PERCENTUAL_OPORTUNIDADE);
		System.out.println("Antes de obter a lista de produto");
		List<Produto> listaProduto = produtoSrv.OportunidadeDia(conexao);
		System.out.println("Depois de obter a lista de produto");
		
		produtoSrv.setListaEntradaItem(listaProduto);
		produtoSrv.CorrigeImagemLista(conexao);
		
		OportunidadeDiaDao dao = getDao(conexao);
		dao.limparTabela();
		OportunidadeDia oportunidade = FabricaVo.criaOportunidadeDia();
		int i = 1;
		int zerados = 0;
		for (Produto item : listaProduto) {
			System.out.println("Produto: " + item.getIdProduto());
			if (item.getListaPrecoProduto_Possui().size() > 1) {
				PrecoProduto precoAtual = (PrecoProduto) item.getListaPrecoProduto_Possui().get(0);
				PrecoProduto precoAnterior = (PrecoProduto) item.getListaPrecoProduto_Possui().get(1);
				
				precoAtual.processaParaOportunidade(item);

				if (precoAtual.getPrecoVenda() != 0 && precoAnterior.getPrecoVenda() != 0) {

					System.out.println((i++) + " de " + listaProduto.size());

					// Tratamento do Produto
					oportunidade.setIdProdutoRa(item.getIdProduto());
					oportunidade.setNomeProduto(item.getNome().replace((char)92, (char)32));
					oportunidade.setUrlProduto(item.getUrl());

					// oportunidade.setUrlImagem(item.getImagem());
					oportunidade.setImagemLocal(item.getImagemLocal());
					// oportunidade.setQuantidadeExibicao(0L);
					// oportunidade.setUrlAfiliado(item.getUrlAfiliado());
					oportunidade.setUrlImagem(item.getImagem());
					oportunidade.setNomeMarca(item.getMarcaPossui(false).getNomeMarca());
					oportunidade.setNomeLojaVirtual(item.getLojaVirtualLidoEm(false).getNomeLojaVirtual());
					// Natureza Produto
					naturezaSrv.getFiltro().setProduto(item);
					NaturezaProduto natureza = naturezaSrv.ObtemPorProduto(conexao);
					oportunidade.setNaturezaProdutoPertenceA(natureza);
					// Tratamento de PrecoAtual
					oportunidade.setDataInicioPrecoAtual(precoAtual.getDataUltimaVisita());
					oportunidade.setPrecoBoletoAtual(precoAtual.getPrecoBoleto());
					oportunidade.setPrecoParcelaAtual(precoAtual.getPrecoParcela());
					oportunidade.setQuantidadeParcelaAtual(precoAtual.getQuantidadeParcela());
					oportunidade.setPrecoVendaAtual(precoAtual.getPrecoVenda());
					oportunidade.setPercentualAjusteVenda(precoAtual.getPercentualAjuste());

					// Tratamento de PrecoAnterior
					oportunidade.setDataUltimaPrecoAnterior(precoAnterior.getDataUltimaVisita());
					oportunidade.setPrecoBoletoAnterior(precoAnterior.getPrecoBoleto());
					oportunidade.setPrecoParcelaAnterior(precoAnterior.getPrecoParcela());
					oportunidade.setQuantidadeParcelaAnterior(precoAnterior.getQuantidadeParcela());
					oportunidade.setPrecoVendaAnterior(precoAnterior.getPrecoVenda());
					oportunidade.setPrecoMedio(precoAtual.getMedia2meses());
					oportunidade.setPrecoMinimo(precoAtual.getMinimo3meses());
					
					// Preco Sugestao
					oportunidade.setPrecoSugestao(precoAtual.getPrecoSugestao());
					
					precoDiarioSrv.getFiltro().setIdProduto(item.getIdProduto());
					PrecoDiario preco = precoDiarioSrv.ObtemMaisRecentePorIdProduto(conexao);
					oportunidade.setPosicaoProduto(preco.getPosicaoProduto());
					
					
					
					dao.insereItem(oportunidade);
				}
			} else {
				//System.out.println("Preco zerado.");
				zerados++;
			}
		}
		System.out.println("Total zerados: " + zerados);
		
		return null;
	}

	@Override
	public OportunidadeDia ChamaMobile(DaoConexao conexao) throws DaoException {
		System.out.println("Inicializacao GCM Monitor");
		
		
		final String API_KEY = "AIzaSyBKcizXgFgdxxcghw8ZaO2kGZiokX-Vptk";
		   
		final String ID = "fh0x0TUpnvY:APA91bGMjDs3DaOAAgyKuUIAHfibhCacuKX7YfdToK7AAjj7qV-zi41meCJ2pVcDnczRMHC1UKd3meYVXIVbgoauOZflsWUASMra8FRJOgBum-p4Wabi_7S0xZombF7TmPC7LVb3l-lN";

        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jGcmData.put("to", "/topics/global");
            // What to send in GCM message.
            jGcmData.put("data", jData);

            // Create connection to send GCM Message request.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response.
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.out.println(resp);
            System.out.println("Check your device/emulator for notification or logcat for " +
                    "confirmation of the receipt of the GCM message.");
        } catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " +
                    "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public OportunidadeDia ChamaMobileCliente(DaoConexao conexao) throws DaoException {
		System.out.println("Inicializacao GCM Cliente");
		
		final String API_KEY = "AIzaSyCUB834-d0XXNS4f-YGBHTvpOzvtZGG6qU";
		   
		//final String ID = "fh0x0TUpnvY:APA91bGMjDs3DaOAAgyKuUIAHfibhCacuKX7YfdToK7AAjj7qV-zi41meCJ2pVcDnczRMHC1UKd3meYVXIVbgoauOZflsWUASMra8FRJOgBum-p4Wabi_7S0xZombF7TmPC7LVb3l-lN";

        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jGcmData.put("to", "/topics/global");
            // What to send in GCM message.
            jGcmData.put("data", jData);

            // Create connection to send GCM Message request.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response.
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.out.println(resp);
            System.out.println("Check your device/emulator for notification or logcat for " +
                    "confirmation of the receipt of the GCM message.");
        } catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " +
                    "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}


	@Override
	public OportunidadeDia ConfirmaOportunidadeDia(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao(conexao);
		List<OportunidadeDia> lista = dao.ListaCorrente();
		for (OportunidadeDia item : lista) {
			System.out.println(item.getNomeLojaVirtual());
			if ("Americanas".equals(item.getNomeLojaVirtual())) {
				//Callback cbk = new Amer
			}
		}
		return null;
	}


	@Override
	public List<OportunidadeDia> ListaPorNatureza(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao(conexao);
		long id = this.getFiltro().getCodigoNaturezaProdutoPertenceA();
		return this.getPorPertenceANaturezaProduto(id);
	}


	@Override
	public List<OportunidadeDia> ListaPorFanpage(DaoConexao conexao) throws DaoException {
		DataFonte dsLocal = new DataSourceAplicacao();
		conexao = dsLocal.criaConexao();
		
		FacebookFanpage fanpage = getFiltro().validaFbPage();
		OportunidadeDiaDao dao = getDao(conexao);
		//List<OportunidadeDia> lista = dao.ListaPorFanpage(fanpage.getIdFacebookFanpage());
		String dataBd;
		try {
			dataBd = UtilData.deslocaDiasFormatoDabase(-7);
		} catch (ParseException e) {
			throw new DaoException("Erro: " + e.getMessage());
		}
		List<OportunidadeDia> lista = dao.ListaPorFanpageData(fanpage.getIdFacebookFanpage(),dataBd);
		//* Tratar as duplicadas **
		if (lista.size()>=fanpage.getQuantidadeDia())
			return lista.subList(0,(int) fanpage.getQuantidadeDia()-1);
		else
			return lista;
	}


	@Override
	public OportunidadeDia CalculaOportunidadesPosicaoHoje(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao(conexao);
		dao.limparTabela();
		
		PrecoProdutoRegraColecao precoDiarioSrv = FabricaRegra.getInstancia().getPrecoProdutoRegraColecao();
		LojaVirtualRegraColecao lojaSrv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		LojaVirtual loja = null;
		
		precoDiarioSrv.getFiltro().setIdLoja(1);
		precoDiarioSrv.getFiltro().setQtdePosicao(30);
		loja = lojaSrv.obtemPorChave(1, conexao);
		List<PrecoProduto> listaProduto4 = precoDiarioSrv.ObtemMelhorPosicaoDia(conexao);
		System.out.println(loja.getNomeLojaVirtual() + " : " + listaProduto4.size());
		List<Produto> listaProdutoPuro = new ArrayList<Produto>();
		for (PrecoProduto precoProduto : listaProduto4) {
			listaProdutoPuro.add(precoProduto.getCorrenteProduto_PertenceA());
		}
		produtoSrv.setListaEntradaItem(listaProdutoPuro);
		produtoSrv.CorrigeImagemLista(conexao);
		listaProduto4 = precoDiarioSrv.ObtemMelhorPosicaoDia(conexao);
		this.geraOportunidadeDia(loja, listaProduto4, conexao);
		
		
		
		precoDiarioSrv.getFiltro().setIdLoja(26);
		precoDiarioSrv.getFiltro().setQtdePosicao(30);
		loja = lojaSrv.obtemPorChave(26, conexao);
		List<PrecoProduto> listaProduto1 = precoDiarioSrv.ObtemMelhorPosicaoDia(conexao);
		System.out.println(loja.getNomeLojaVirtual() + " : " + listaProduto1.size());
		this.geraOportunidadeDia(loja, listaProduto1, conexao);
		
		precoDiarioSrv.getFiltro().setIdLoja(27);
		precoDiarioSrv.getFiltro().setQtdePosicao(30);
		loja = lojaSrv.obtemPorChave(27, conexao);
		List<PrecoProduto> listaProduto2 = precoDiarioSrv.ObtemMelhorPosicaoDia(conexao);
		System.out.println(loja.getNomeLojaVirtual() + " : " + listaProduto2.size());
		this.geraOportunidadeDia(loja, listaProduto2, conexao);
		
		precoDiarioSrv.getFiltro().setIdLoja(28);
		precoDiarioSrv.getFiltro().setQtdePosicao(30);
		loja = lojaSrv.obtemPorChave(28, conexao);
		List<PrecoProduto> listaProduto3 = precoDiarioSrv.ObtemMelhorPosicaoDia(conexao);
		System.out.println(loja.getNomeLojaVirtual() + " : " + listaProduto3.size());
		this.geraOportunidadeDia(loja, listaProduto3, conexao);
		
		/*
		
		*/
		
		return null;
	}
	
	private void geraOportunidadeDia(LojaVirtual loja, List<PrecoProduto> listaPrecoProduto, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao(conexao);
		OportunidadeDia oportunidade = FabricaVo.criaOportunidadeDia();
		for (PrecoProduto precoProduto : listaPrecoProduto) {
			Produto produto = precoProduto.getProdutoPertenceA(false);
			precoProduto.processaParaOportunidade(produto);
			
			oportunidade.setIdProdutoRa(precoProduto.getIdProdutoPa());
			oportunidade.setIdNaturezaProdutoPa(precoProduto.getIdNaturezaProduto());
			oportunidade.setPrecoVendaAtual(precoProduto.getPrecoVenda());
			oportunidade.setNomeProduto(produto.getNome().replaceAll("\\?","-"));
			oportunidade.setUrlImagem(produto.getImagem());
			oportunidade.setUrlProduto(produto.getUrl());
			oportunidade.setNomeLojaVirtual(loja.getNomeLojaVirtual());
			oportunidade.setPrecoSugestao(precoProduto.getPrecoSugestao());
			oportunidade.setPosicaoProduto(produto.getPosicaoProduto());

			
			if ("null".equals(oportunidade.getUrlImagem())) {
				
			}
			
			dao.insereItemPlus(oportunidade);
		}
	}


	

}
