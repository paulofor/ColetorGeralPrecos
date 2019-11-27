package digicom.facebook.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import br.com.digicom.parse.log.DatasUtils;
import coletapreco.app.Constantes;
import coletapreco.modelo.OportunidadeDia;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;


public class FacebookFotoPost {

	private boolean retiraLink = false;
	
	
	
	public void EnviaFotoPost(OportunidadeDia oportunidade, String idAlbum, String token) throws FileNotFoundException {
		//FacebookFotoPost post = FabricaVo.criaFacebookFotoPost();
		if (oportunidade==null) {
			System.out.println("Oportunidade = null");
		}
		File imageFile = new File(Constantes.DIRETORIO_IMAGENS	+ "\\" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		String mensagem = this.getMensagem(oportunidade);
		
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		System.out.println("Post..." + oportunidade.getNomeProduto() + " Album:" + idAlbum + ") - [" + DatasUtils.getHora() + "] ");
		FacebookType publishMessageResponse = null;
		try {
			publishMessageResponse =
				facebookClient.publish(idAlbum + "/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
						  Parameter.with("message", mensagem),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
			retiraLink = false;
		} catch (FacebookOAuthException e) {
			System.out.println("Retirando link");
			retiraLink = true;
			e.printStackTrace();
			//mensagem = this.getMensagemSemLink(oportunidade);
			//publishMessageResponse =
			//		facebookClient.publish(id + "/photos", 
			//				  FacebookType.class,
			//				  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
			//				  Parameter.with("message", mensagem),
			//				  Parameter.with("caption", oportunidade.getNomeProduto())
			//				  );
		}
		System.out.println(publishMessageResponse.getId());
		
		return ;
	}
	
	private String getMensagem2(OportunidadeDia oportunidade) { 
		String preco = "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " + oportunidade.getQuantidadeParcelaAnterior() + 
				" x R$ " + oportunidade.getPrecoParcelaAnteriorFormatada() + " = R$ " + oportunidade.getPrecoVendaAnteriorFormatada() +
				"\nEm " + datas(oportunidade.getDataInicioPrecoAtual()) + ": " + oportunidade.getQuantidadeParcelaAtual() + 
				" x R$ " + oportunidade.getPrecoParcelaAtualFormatada() + " = R$ " + oportunidade.getPrecoVendaAtualFormatada();
		String justificativa =  "Buscador de descontos é um serviço independente que monitora lojas virtuais e oferece as melhores oportunidades de preço em calçados femininos para você.";
		String mensagem = oportunidade.getNomeMarca() + " - " + oportunidade.getNomeProduto() + "\n\n" + preco;
		String link = oportunidade.getUrlAfiliado();
		if (!retiraLink)
			mensagem = mensagem + "\n\n" + "Compre na Dafiti => " + link;
		mensagem += "\n\n" + justificativa;
		return mensagem;
	}
	private String getMensagem(OportunidadeDia oportunidade) { 
		String mensagem = "Este produto estava sendo vendido na Dafiti até o dia " + datas(oportunidade.getDataUltimaPrecoAnterior())  + 
				" por R$ " + oportunidade.getPrecoVendaAnteriorFormatada() + " ( " + oportunidade.getQuantidadeParcelaAnterior() + 
				" parcelas de R$ " + oportunidade.getPrecoParcelaAnteriorFormatada() + "). Hoje está saindo por R$ " +
				 oportunidade.getPrecoVendaAtualFormatada() + " ( " + oportunidade.getQuantidadeParcelaAtual() + 
				" parcelas de R$ " + oportunidade.getPrecoParcelaAtualFormatada() + " ) " +
				" com redução de " + decimal(oportunidade.getPercentualAjusteVenda()) + " %.";
		String link = "Para aproveitar o preço clique no link ao lado => " + oportunidade.getUrlAfiliado();
		String nomeProduto = oportunidade.getNomeMarca() + " - " + oportunidade.getNomeProduto();
		
		String saida = nomeProduto;
		saida += "\n\n" + mensagem;
		if (!retiraLink) {
			saida += "\n\n" + link; 
		}
		return saida;
	}
	
	
	private String getMensagemSemLink(OportunidadeDia oportunidade) { 
		String preco = "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " + oportunidade.getQuantidadeParcelaAnterior() + 
				" x R$ " + oportunidade.getPrecoParcelaAnteriorFormatada() + " = R$ " + oportunidade.getPrecoVendaAnteriorFormatada() +
				"\nEm " + datas(oportunidade.getDataInicioPrecoAtual()) + ": " + oportunidade.getQuantidadeParcelaAtual() + 
				" x R$ " + oportunidade.getPrecoParcelaAtualFormatada() + " = R$ " + oportunidade.getPrecoVendaAtualFormatada();
		String mensagem = oportunidade.getNomeMarca() + "\n" + oportunidade.getNomeProduto() + "\n\n" + preco;
		String link = oportunidade.getUrlAfiliado();
		return mensagem;
	}
	
	
		
	private String decimal(float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	private String datas(String dataEnt) {
		return dataEnt.replaceAll("-", "/");
	}

}
