package entidades;

public class Ciudadano {

	private int dgu;
	private String nombre;
	private String apellido;
	private String user;
	private String password;
	private int rol;
	private String email;
	private Raza raza;
	
	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dgu;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Ciudadano other=(Ciudadano)obj;
		if(this.getDgu()==other.getDgu())
		{
			if(this.getEmail().equals(other.getEmail()))
			{
				if(this.getUser().equals(other.getUser()))
				{
					return false;
				}else {return true;}
			}else return false;			
		}else {return false;}
	}

	public Ciudadano(int dgu, String nombre, String apellido, String user, String password, String email,Raza raza) {
		super();
		this.dgu = dgu;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.password = password;
		this.email = email;
		this.raza=raza;
	}

	@Override
	public String toString() {
		return "Ciudadano [dgu=" + dgu + ", nombre=" + nombre + ", apellido=" + apellido + ", user=" + user + ", rol="
				+ rol + ", email=" + email + "]";
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}	
}
