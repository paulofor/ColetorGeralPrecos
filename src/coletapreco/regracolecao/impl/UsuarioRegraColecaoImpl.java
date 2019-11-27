package coletapreco.regracolecao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MySqlDataSource;
import coletapreco.dao.UsuarioDao;
import coletapreco.dao.basica.DataSourceAplicacao;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.AppProduto;
import coletapreco.modelo.DispositivoUsuario;
import coletapreco.modelo.InteresseProduto;
import coletapreco.modelo.PrecoDiario;
import coletapreco.modelo.Usuario;
import coletapreco.regracolecao.DispositivoUsuarioRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.InteresseProdutoRegraColecao;
import coletapreco.regracolecao.PrecoDiarioClienteRegraColecao;
import coletapreco.regracolecao.PrecoDiarioRegraColecao;
import coletapreco.regracolecao.ProdutoRegraColecao;
import coletapreco.regracolecao.UsuarioRegraColecao;
import coletapreco.util.UtilData;

public class UsuarioRegraColecaoImpl extends UsuarioRegraColecao {

	private InteresseProdutoRegraColecao interesseSrv = FabricaRegra.getInstancia().getInteresseProdutoRegraColecao();
	private ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
	private PrecoDiarioRegraColecao precoDiarioSrv = FabricaRegra.getInstancia().getPrecoDiarioRegraColecao();
	private PrecoDiarioClienteRegraColecao precoDiarioClienteSrv = FabricaRegra.getInstancia().getPrecoDiarioClienteRegraColecao();

	private DispositivoUsuarioRegraColecao dispositivoSrv = FabricaRegra.getInstancia()
			.getDispositivoUsuarioRegraColecao();
	// private ProdutoRegraColecao precoDiarioSrv =
	// FabricaRegra.getInstancia().getProdutoRegraColecao();
	// private ProdutoRegraColecao produtoSrv =
	// FabricaRegra.getInstancia().getProdutoRegraColecao();
	// private ProdutoRegraColecao produtoSrv =
	// FabricaRegra.getInstancia().getProdutoRegraColecao();

	@Override
	public Usuario ObtemProximoParaColetaComDispositivo(DaoConexao conexao) throws DaoException {
		long intervaloMinimo = this.getFiltro().validaIntervaloMinimoProcessamento();
		AppProduto app = this.getFiltro().validaAppMonitorameneto();
		UsuarioDao dao = getDao(conexao);
		//Usuario usuario = dao.ObtemPrimeiroSemDiaAtual(app.getIdObj());
		Usuario usuario = dao.ObtemPrimeiroProcessamentoMaisAntigo(app.getIdObj(),intervaloMinimo);
		return usuario;
	}

	@Override
	public Usuario TrataMonitoramento(DaoConexao conexaoNuvem) throws DaoException {
		// conexao e de nuvem -> porque lista interesse esta na nuvem.
		DataSourceAplicacao dsLocal = new DataSourceAplicacao();
		DaoConexao conexaoLocal = dsLocal.criaConexao();

		Usuario usuario = this.getFiltro().validaClienteMonitoramento();
		

		List<PrecoDiario> listaPreco = new ArrayList<PrecoDiario>();
		List<InteresseProduto> listaInteresse = this.interesseSrv.getPorSincronizaUsuario(usuario.getIdObj(), conexaoNuvem);
		for (InteresseProduto interesse : listaInteresse) {
			// Poderia ser feito no banco mas deixei aqui para outro tipo de
			// processamento no futuro.
			// Lista todos que precisam ser monitorados.
			if (interesse.getMonitora()) {
				obtemInformacaoProduto(interesse); // Acesso a página individual do produto para reforçar o preço.
				List<PrecoDiario> listaPrecoCliente = obtemListaPreco1mes(interesse.getIdProdutoClienteRa(), conexaoLocal);
				
				interesseSrv.getFiltro().setListaPrecoDiarioOrdenado(listaPrecoCliente);
				interesseSrv.getFiltro().setItem(interesse);
				interesseSrv.getFiltro().setUsuario(usuario);
				interesseSrv.AtualizaComListaPrecoDiario(conexaoNuvem);
				
				listaPreco.addAll(listaPrecoCliente);
			}
		}
		precoDiarioClienteSrv.setListaEntradaGenerica(listaPreco);
		precoDiarioClienteSrv.getFiltro().setUsuario(usuario);
		precoDiarioClienteSrv.ConverteEnviaListaParaCliente(conexaoNuvem);

		
		return usuario;
	}

	// Monitoramento - Passo 1
	private void obtemInformacaoProduto(InteresseProduto interesse) throws DaoException {
		// usar conexao local
		produtoSrv.getFiltro().setIdProduto(interesse.getIdProdutoClienteRa());
		produtoSrv.AcessaInformacaoProdutoPorId();
	}

	private List<PrecoDiario> obtemListaPreco1mes(long idProduto, DaoConexao conexao) throws DaoException {
		precoDiarioSrv.getFiltro().setIdProduto(idProduto);
		return precoDiarioSrv.ListaPorIdProduto2Mes(conexao);
	}

	// Existe no RegraColecao do Disposiitivo tambem.
	@Override
	public Usuario EnviaDadosCliente(DaoConexao conexao) throws DaoException {
		// Precisa receber co nuvem
		Usuario usuario = getFiltro().validaClienteMonitoramento();
		AppProduto aplicacao = getFiltro().validaAppMonitorameneto();
		List<DispositivoUsuario> listaDispositivo = dispositivoSrv.getPorReferenteAUsuario(usuario.getIdObj(), conexao);
		for (DispositivoUsuario device : listaDispositivo) {
			device.setAppProdutoUsa(aplicacao);
			dispositivoSrv.getFiltro().setItemComApp(device);
			dispositivoSrv.getFiltro().setAppMonitorameneto(aplicacao);
			dispositivoSrv.ChamaMobileAtualizaMonitorados(conexao);
		}
		return null;
	}

	

	@Override
	public Usuario TrataLoopClientes(DaoConexao conexao) throws DaoException {
		MySqlDataSource ds1 = new DataSourceNuvem();
		DaoConexao conNuvem = ds1.criaConexao();
		Usuario usuario = ObtemProximoParaColetaComDispositivo(conNuvem);
		while (usuario != null) {
			getFiltro().setClienteMonitoramento(usuario);
			usuario = TrataClienteDadosNuvem(conNuvem);
		}
		return usuario;
	}
	@Override
	public Usuario TrataClienteDadosNuvem(DaoConexao conNuvem) throws DaoException {
		Usuario usuario = getFiltro().validaClienteMonitoramento();
		UsuarioDao dao = getDao(conNuvem);
		dao.atualizaDataProcessamento(usuario.getIdObj());
		System.out.println("Usuario: " + usuario.getIdObj() + "  Device: " 	+ (usuario.getCorrenteDispositivoUsuario_Usa()!=null?usuario.getCorrenteDispositivoUsuario_Usa().getCodigoDispositivo():" - "));
		ArquivoLog.getInstancia().salvaServico("Coleta de Usuario: " + usuario.getIdObj() + "  Device: " 	+ (usuario.getCorrenteDispositivoUsuario_Usa()!=null?usuario.getCorrenteDispositivoUsuario_Usa().getCodigoDispositivo():" - "));
		TrataMonitoramento(conNuvem);
		//interesseSrv.getFiltro().setUsuario(usuario);
		//interesseSrv.AtualizaPrecosNotasPorUsuario(conNuvem); -> coloquei tudo dentro do Tratamonitoramento
		EnviaDadosCliente(conNuvem);
		///usuario = ObtemProximoParaColetaComDispositivo(conNuvem);
		
		return null;
	}

	
	@Override
	public List<Usuario> ListaAtivoChamadaDistanteComDispositivo(DaoConexao conexao) throws DaoException {
		AppProduto app = this.getFiltro().validaAppMonitorameneto();
		long quantidade = this.getFiltro().validaQuantidadeNotificacao();
		UsuarioDao dao = getDao(conexao);
		List<Usuario> lista = dao.ListaAtivoChamadaDistante(app.getIdObj(),quantidade);
		return lista;
	}

	@Override
	public List<Usuario> ListaInteresseNovo(DaoConexao conexao) throws DaoException {
		AppProduto app = this.getFiltro().validaAppMonitorameneto();
		
		UsuarioDao dao = getDao(conexao);
		List<Usuario> lista = dao.ListaInteresseNovo(app.getIdObj());
		return lista;
	}

	
}
