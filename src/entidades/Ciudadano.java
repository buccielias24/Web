package entidades;

public class Ciudadano {

	private int dgu;
	private String nombre;
	private String apellido;
	private Raza raza;
	private String user;
	private String password;
	
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ciudadano() {}
	
	public Ciudadano(int dgu, String nombre) {
		super();
		this.dgu = dgu;
		this.nombre = nombre;
	}
	
	public int getDgu() {
		return dgu;
	}
	public void setDgu(int dgu) {
		this.dgu = dgu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
}
