package java_mail.java_mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	private static final String CONFIG_FILE = "config.properties";
	private String email;
	private String senha;
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
		carregarConfiguracoes();
	}
	
	public void enviarEmail(boolean emailHtml) throws Exception {

		// smtp: protocolo simples de transferência de email.
		Properties propriedades = new Properties();

		propriedades.put("mail.smtp.auth", "true");
		propriedades.put("mail.smtp.starttls", "true");
		propriedades.put("mail.smtp.host", "smtp.gmail.com");
		propriedades.put("mail.smtp.socketFactory.port", "465");
		propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// conecta e obtém um objeto do servidor do gmail autorizado a enviar email.
		Session sessao = Session.getInstance(propriedades, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});
		
		Address[] paraUsuario = InternetAddress.parse(listaDestinatarios);

		Message mensagem = new MimeMessage(sessao);
		
		mensagem.setFrom(new InternetAddress(email, nomeRemetente));
		mensagem.setRecipients(Message.RecipientType.TO, paraUsuario);
		mensagem.setSubject(assuntoEmail);
		
		if (emailHtml) {
			mensagem.setContent(textoEmail, "text/html; charset=utf-8");
		}  else {
			mensagem.setText(textoEmail);
		}
		
		Transport.send(mensagem);
		
		// System.out.println(sessao);
	}

	private void carregarConfiguracoes() {
		Properties prop = new Properties();
		try (java.io.InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
			prop.load(input);
			email = prop.getProperty("email");
			senha = prop.getProperty("senha");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
