package java_mail.java_mail;

public class AppTest {
	
	@org.junit.Test
	public void testaEmail() throws Exception {
		
		// personalização do texto com HTML.
		StringBuilder textoEmail = new StringBuilder();
		
		textoEmail.append("Olá, <br/><br/>");
		textoEmail.append("você está recebendo o acesso ao curso de Java.<br/><br/>");
		textoEmail.append("Para ter acesso clique no botão abaixo.<br/><br/>");
		textoEmail.append("<b>Login:</b> fgs2120<br/>");
		textoEmail.append("<b>Senha:</b> 123dev<br/><br/>");
		
		textoEmail.append("<a target=\"_blank\" href=\"https://projetojavaweb.com/certificado-aluno/login\""
				+ " style=\"color:#2525a7; padding:14px 25px; text-align:center; text-decoration:none; display:inline-block; "
				+ "border-radius:30px; fon-size:20px; font-family:courier; border:3px solid green; background-color:#99DA39\"> Acessar Portal do Aluno</a><br/><br/>");
		
		ObjetoEnviaEmail enviar = new ObjetoEnviaEmail("colocar a listaDestinatarios", 
				"colocar o nomeRemetente", 
				"Chegou o email enviado com Java.",
				textoEmail.toString());
		enviar.enviarEmail(true);
	}
}

