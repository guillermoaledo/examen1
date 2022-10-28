package es.iesvegademijas.anotaciones;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

@CredencialAnotado(usuario = "usuario1", hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918") 
@CredencialAnotado(usuario = "usuario2", hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270") 
public class Login {
	
	private ArrayList<Credencial> credenciales;
	
	
	public Login() {
		credenciales = new ArrayList<>();
	}
	
	public Login cargadorDeContexto() {
		Login login = new Login();
		
		CredencialAnotado[] credenciales = Login.class.getAnnotationsByType(CredencialAnotado.class);
		for(CredencialAnotado credAnot : credenciales) {
			Credencial aux = new Credencial();
			aux.setUsuario(credAnot.usuario());
			aux.setHashPasswd(credAnot.hashPasswd());
			
			login.credenciales.add(aux);
		}
		return login;
	}
	
	public void login() throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		String usuario;
		String passwd;
		
		System.out.print("usuario: ");
		usuario = sc.nextLine();
		System.out.print("passwd: ");
		passwd = sc.nextLine();
		
		passwd = Login.hashPassword(passwd);
		
		boolean coincide = false;
		for(Credencial cred : credenciales) {
			if((cred.getUsuario().equals(usuario)) && (cred.getHashPasswd().equals(passwd))) {
				coincide = true;
			}
		
		}
		if(coincide) {
			System.out.println("ACCESO CONCEDIDO");
		}else {
			System.out.println("ACCESO DENEGADO");
		}
	}
	
	/**
	 * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:          
8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
	 * @param password
	 * @return hash de encriptación de la password
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashPassword(String password ) throws NoSuchAlgorithmException {
		MessageDigest digest;
		
		digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				password.getBytes(StandardCharsets.UTF_8));
		
		return bytesToHex(encodedhash);					
		
	}
	
	private static String bytesToHex(byte[] byteHash) {
		
	    StringBuilder hexString = new StringBuilder(2 * byteHash.length);	  	
	    for (int i = 0; i < byteHash.length; i++) {
	        String hex = Integer.toHexString(0xff & byteHash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    
	    return hexString.toString();
	    
	}

}
