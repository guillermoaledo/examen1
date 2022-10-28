package es.iesvegademijas.anotaciones;

public class Credencial {
	private String usuario;
	private String hashPasswd;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getHashPasswd() {
		return hashPasswd;
	}
	public void setHashPasswd(String hashPasswd) {
		this.hashPasswd = hashPasswd;
	}
}
