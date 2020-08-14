package coletapreco.desen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import coletapreco.email.EmailVo;
import coletapreco.modelo.vo.OportunidadeDiaVo;

public class EnviadorEmailObj {

	private String MAILHOST = "smtp.lojadigicom.com.br";
	private int PORTA = 587;
	private String PASS = "center777";

	public void executa() throws AddressException, MessagingException, IOException {
		EmailVo email = new EmailVo();
		email.setFromName("Cosmetic Center");
		email.setFrom("cosmetic.center@lojadigicom.com.br");
		email.setTo("paulofore@gmail.com");
		// email.setTo("paforestieri@stefanini.com");
		email.setTitulo("Confira as oportunidades");
		email.setMensagem("muito bem chegou");

		envia(email, getOportunidade());
	}
	
	private List<OportunidadeDiaVo> getOportunidade() {
		List<OportunidadeDiaVo> lista = new ArrayList<OportunidadeDiaVo>();
		OportunidadeDiaVo item = new OportunidadeDiaVo();
		item.setNomeProduto("Notebook Inspiron I15-3583-A20P Intel Core i5 8GB (AMD Radeon 520 com 2GB) 2TB 15,6   W10 Preto - Dell");
		item.setPrecoVendaAtual(3999.99f);
		item.setPrecoVendaAnterior(3999.99f);
		item.setUrlImagem("https://images-americanas.b2w.io/produtos/01/00/img/134388/6/134388611_1SZ.jpg");
		item.setNomeLojaVirtual("Americanas");
		lista.add(item);
		return lista;
	}
	
	

	private void envia(final EmailVo msgVo, List<OportunidadeDiaVo> oportunidades) throws AddressException, MessagingException, IOException {
		String mailer = "sendhtml";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Properties props = System.getProperties();
		props.put("mail.smtp.host", MAILHOST);
		props.put("mail.smtp.port", PORTA);
		props.put("mail.smtp.auth", "true"); // enable authentication

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(msgVo.getFrom(), PASS);
			}
		};
		Session session = Session.getInstance(props, auth);
		session.setDebug(true);

		Message msg = new MimeMessage(session);
		msg.setHeader("Content-Type", "text/html; charset=UTF-8");
		msg.setHeader("Content-Transfer-Encoding", "quoted-printable");

		msg.setFrom(new InternetAddress(msgVo.getFrom(), msgVo.getFromName()));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(msgVo.getTo(), false));
		msg.setSubject(msgVo.getTitulo());

		// msg.setText(msgVo.getMensagem());
		String arquivo = "/home/usuario/FontesJavaRec/ProjetosJava2/ColetorGeralPrecos/pages/estudoEmail.html";
		//msg.setContent(this.getMensagem(msgVo), "text/html; charset=UTF-8");

		String textoEmail = this.leArquivo(arquivo);
		textoEmail = substituiItens(textoEmail,oportunidades);
		msg.setContent(textoEmail,"text/html; charset=UTF-8");
		
		Transport.send(msg);
	}
	
	private String substituiItens(String arquivo, List<OportunidadeDiaVo> listaOportunidade) {
		arquivo = arquivo.replaceFirst("nomeProduto1", listaOportunidade.get(0).getNomeProduto());
		arquivo = arquivo.replaceFirst("imagemProduto1", listaOportunidade.get(0).getUrlImagem());
		arquivo = arquivo.replaceFirst("precoProduto1", listaOportunidade.get(0).getPrecoVendaAtualFormatada());
		return arquivo;
	}
	

	public void collect(BufferedReader in, Message msg) throws MessagingException, IOException {
		String line;
		String subject = msg.getSubject();
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<HEAD>\n");
		sb.append("<TITLE>\n");
		sb.append(subject + "\n");
		sb.append("</TITLE>\n");
		sb.append("</HEAD>\n");

		sb.append("<BODY>\n");
		sb.append("<H1>" + subject + "</H1>" + "\n");

		while ((line = in.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}

		sb.append("</BODY>\n");
		sb.append("</HTML>\n");

		msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
	}

	private String getMensagem(EmailVo msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<style>");
		sb.append("h1, caption {");
		sb.append("	color : #77bf52 !important;");
		sb.append("}");
		sb.append(" .texto-produto {");
		sb.append("        color: rgb(48,48,48);");
		sb.append("font-size: 18px;");
		sb.append("font-weight: 600;");
		sb.append("}");
		sb.append("    .texto-preco {");
		sb.append("        color:#03c998;");
		sb.append("        font-size: 20px;");
		sb.append("        font-weight: 600;");
		sb.append("        width: 100%;");
		sb.append("        text-align:right;");
		sb.append("    }");
		sb.append("    .texto-loja {");
		sb.append("        color: blue;");
		sb.append("	        font-size: 16px;");
		sb.append("        font-weight: 300;");
		sb.append("       width: 100%;");
		sb.append("        text-align:left;");
		sb.append("        height: 100%");
		;
		sb.append("    }");
		sb.append("</style>");
		
		
		sb.append("<BODY>\n");
		sb.append("<ion-card class=\"card card-md\">");
		sb.append("<ion-card-content text-wrap=\"\" class=\"card-content card-content-md\">");
		sb.append("<h2 class=\"texto-produto\" style=\"word-wrap: normal\">Paleta de Sombras Matte 12 Cores Belle Angel B021 - Display com 12 unidades</h2>");
		sb.append("<img src=\"./Ionic App_files/paleta-de-sombra-bella-angel-b021-01.jpg\">");
		sb.append("<h3 class=\"texto-preco\">Preço até 27/02/2020: R$ 70,32</h3>");
		sb.append("<h3 class=\"texto-preco\">Preço atual: R$ 35,16</h3>");
		sb.append("<h3 class=\"texto-loja\">Loja: Revenda de Cosméticos</h3>");
		//sb.append("<span class="button-inner">Ir para loja</span><div class="button-effect"></div></a>
        sb.append("</ion-card-content>");
        sb.append("</ion-card>");
		sb.append("</BODY>\n");
		sb.append("</HTML>\n");
		return sb.toString();
	}
	
	private String leArquivo(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

}
