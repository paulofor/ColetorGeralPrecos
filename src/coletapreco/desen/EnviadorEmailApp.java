package coletapreco.desen;

import java.io.IOException;

import javax.mail.MessagingException;

public class EnviadorEmailApp {

	public static void main(String[] args) {
		System.out.println("Ola mundo");
		EnviadorEmailObj obj = new EnviadorEmailObj();
		try {
			obj.executa();
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}

}
