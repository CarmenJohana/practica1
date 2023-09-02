package clases;

public class Usuario {
	long id;
	String nombre;
	Fecha fecha_nac;
	String ciudad_nac;
	Direccion dir;
	long tel;
	String email;
	
	public Usuario(long id,String nombre,Fecha fecha_nac,String ciudad_nac,Direccion dir,long tel,String email) {
		
		
		this.id=id;
		this.nombre=nombre;
		this.fecha_nac=fecha_nac;
		this.ciudad_nac= ciudad_nac;
		this.dir=dir;
		this.tel=tel;
		this.email=email;
		
	}
	
	public Usuario(long id, String n) {
		
		
		this.id=id;
		this.nombre=n;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Fecha fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getCiudad_nac() {
		return ciudad_nac;
	}

	public void setCiudad_nac(String ciudad_nac) {
		this.ciudad_nac = ciudad_nac;
	}

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha_nac=" + fecha_nac + ", ciudad_nac=" + ciudad_nac
				+ ", dir=" + dir + ", tel=" + tel + ", email=" + email + "]";
	}
	
	

}
