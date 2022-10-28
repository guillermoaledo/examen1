package es.iesvegademijas.anotaciones;

import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Login login = new Login();
		login = login.cargadorDeContexto();
		
		login.login();

	}

}
