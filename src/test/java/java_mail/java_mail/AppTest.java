package java_mail.java_mail;

public class AppTest {
	
	@org.junit.Test
	public void testaEmail() throws Exception {
		ObjetoEnviaEmail enviar = new ObjetoEnviaEmail();
		enviar.enviarEmail(true);
	}
}