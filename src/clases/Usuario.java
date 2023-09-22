package clases;

public class Usuario {
	private long cedula;
	private String nombre;
	private Fecha fecha_nac;
	private String cargo; // administrador o empleado...Se asigna al leer el txt de passwords 
	private String ciudad_nac;
	private Direccion dir;
	private long tel;
	private String email;
	private DoubleList bandejaDeEntrada;
	private Queue mensajesLeidos;   //Los mensajes leídos estarán en una cola
	private Stack borradores;  //Los borradores estarán en una pila
	
	public Usuario(String nombre,long cedula,Fecha fecha_nac,String ciudad_nac,long tel,String email,Direccion dir) {
		
		
		this.cedula=cedula;
		this.nombre=nombre;
		this.fecha_nac=fecha_nac;
		this.ciudad_nac= ciudad_nac;
		this.dir=dir;
		this.tel=tel;
		this.email=email;
		
	}
	
	
	public void consultarBandejaDeEntrada() {
		
		
		
	}
	
	
	public String getCargo() {
		
		return cargo;
		
	}
	
	public Usuario(String n, long cedula) {
		
		
		this.cedula=cedula;
		this.nombre=n;
		
	}

	public long getCedula() {
		return cedula;
	}

	public void setId(long cedula) {
		this.cedula = cedula;
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
		return nombre + " " + cedula + " "+ fecha_nac + " " + ciudad_nac
				+ " " + tel +" "+ email +" "+dir;
	}
	
	public void enviarMensaje(Mensaje m) {
		
		//Ingresar en la bandejaDeEntrada  del destinatario
		//Actualizar el txt que conecta con la bandejaDeEntrada del destinatario
		
	}
	
	public void descartar(Mensaje m) {
		
		//Eliminar mensaje (destroy)
		
		
	}
	
	public void guardarBorrador(Mensaje m) {
		
		//Ingresar en Borradores del remitente
		//Actulizar el txt conectado con el borrador del remitente
	}
	
	public void almacenarInformacionUsuario() {
		
		//Crear tres txt cuyos nombres sean el número de cédula del empleado seguido de 
		//BA para bandeja de entrada
		//Ml para mensajes leidos
		//B para borradores
	}

}