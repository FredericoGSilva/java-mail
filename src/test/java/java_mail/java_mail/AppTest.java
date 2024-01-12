package java_mail.java_mail;

import java.util.Properties;

public class AppTest {
	
	@org.junit.Test
	public void testeEmail() {
		
		//smtp: protocolo simples de transferência de email.
		Properties propriedades = new Properties();
		
		propriedades.put("mail.smtp.auth", "true");
		propriedades.put("mail.smtp.starttls", "true");
		propriedades.put("mail.smtp.host", "smtp.gmail.com");
		propriedades.put("mail.smtp.socketFactory.port", "465");
		propriedades.put("mail.smtp.socketFactory.class", 
				"javax.net.ssl.SSLSocketFactory");
		
		
	}
	
}
