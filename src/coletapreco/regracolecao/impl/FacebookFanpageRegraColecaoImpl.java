package coletapreco.regracolecao.impl;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.app.Constantes;
import coletapreco.dao.FacebookFanpageDao;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.FacebookFanpage;
import coletapreco.modelo.FacebookPerfil;
import coletapreco.modelo.FacebookPost;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.FacebookFanpageRegraColecao;
import coletapreco.regracolecao.FacebookPostRegraColecao;
import coletapreco.util.UtilData;

import com.restfb.BinaryAttachment;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Account;
import com.restfb.types.FacebookType;


public  class FacebookFanpageRegraColecaoImpl  extends FacebookFanpageRegraColecao {

	FacebookPostRegraColecao postSrv = FabricaRegra.getInstancia().getFacebookPostRegraColecao();
	
	@Override
	public List<FacebookFanpage> ListaParaDivulgarOportunidade(DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao(conexao);
		List<FacebookFanpage> lista = dao.ListaComAppAtiva();
		return lista;
		
	}

	@Override
	public FacebookFanpage EnviaOportunidade(DaoConexao conexao) throws DaoException {
		OportunidadeDia oportunidade = getFiltro().validaFbEnviadorOportunidade();
		FacebookFanpage page = getFiltro().validaFbEnviadorFanpage();
		FacebookPerfil perfil = getFiltro().validaFbEnviadorPerfil();
		String token = obtemTokenPagina(perfil.getTokenAcesso(),page.getCodigoFacebook());
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		
		File imageFile = new File(Constantes.DIRETORIO_IMAGENS + "/" + oportunidade.getCodigoImagemLocal());
		FacebookType publishMessageResponse = null;
		
		try {
			FileInputStream fis = new FileInputStream(imageFile);
			publishMessageResponse =
				facebookClient.publish("me/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getImagemLocal(), fis),
						  Parameter.with("message", oportunidade.getMensagemFacebook()),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
			System.out.println(publishMessageResponse.getId());
			criaRegistroPost(publishMessageResponse.getId(),oportunidade.getIdProdutoRa(),page.getIdObj(),conexao);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	} 
	
	private void criaRegistroPost(String idFcb,long idProduto, long idPage,DaoConexao conexao) throws DaoException {
		FacebookPost post = FabricaVo.criaFacebookPost();
		post.setCodigoFacebook(idFcb);
		post.setDataHora(UtilData.getDataHora());
		post.setIdFacebookFanpageFe(idPage);
		post.setIdProdutoD(idProduto);
		postSrv.insereItemLoad(post, conexao);
	}
	
	private String obtemTokenPagina(String tokenUsuario, String codigoPagina) {
		FacebookClient facebookClient = new DefaultFacebookClient(tokenUsuario);
		Connection<Account> paginas = facebookClient.fetchConnection("me/accounts", Account.class);
		List<Account> listPagina = paginas.getData();
		for (Account conta : listPagina) {
			if (conta.getId().compareTo(codigoPagina)==0) 
				return conta.getAccessToken();
		}
		return null;
	}
}
