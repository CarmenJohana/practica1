package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import java.util.Date;


public class Usuario {
	private long cedula;
	private String nombre;
	private Fecha fecha_nac;
	private String cargo; // administrador o empleado...Se asigna al leer el txt de passwords 
	private String clave;
	private String ciudad_nac;
	private Direccion dir;
	private long tel;
	private String email;
	private DoubleList<Mensaje> bandejaDeEntrada= new DoubleList<Mensaje>();;
	private Queue<Mensaje> mensajesLeidos= new Queue<Mensaje>();   //Los mensajes leídos estarán en una cola
	private Stack<Mensaje> borradores= new Stack<Mensaje>();  //Los borradores estarán en una pila
	
	public Usuario(String nombre,long cedula,Fecha fecha_nac,String ciudad_nac,long tel,String email,Direccion dir) {
		
		this.cedula=cedula;
		this.nombre=nombre;
		this.fecha_nac=fecha_nac;
		this.ciudad_nac= ciudad_nac;
		this.dir=dir;
		this.tel=tel;
		this.email=email;
		
	}
	
	public Usuario(String n, long cedula) {
		
		this.cedula=cedula;
		this.nombre=n;
		
	}
	
	public String consultarBandejaDeEntrada() {
		String texto = "";
		DoubleNode<Mensaje> dNodo = this.bandejaDeEntrada.first();
		int nMensaje = 0;
		
		for(int i = 0;i < bandejaDeEntrada.size();i++) {
		
			Date fechaMensaje = ((Mensaje)dNodo.getData()).getDateHour();
			String titulo = ((Mensaje)dNodo.getData()).getTitulo();
			String remitente =((Mensaje)dNodo.getData()).getRemitente();
		
			nMensaje++;
			texto += nMensaje + "# " + fechaMensaje.toLocaleString() + " " + titulo + " " + remitente+"\n";
			
			dNodo = dNodo.getNext();	
		}
		
		return texto;
	}
	
	public String mostrarMensajeBandeja(int nMensaje) {
		DoubleNode nodo = bandejaDeEntrada.first();
		String mensaje = "";
		DoubleNode nAnterior = null;
		
		for(int i = 0;i < bandejaDeEntrada.size();i++) {
			if(i == nMensaje - 1) {
				
				if(i==0) {
					mensaje = ((Mensaje)nodo.getData()).getMensaje();
					
					mensajesLeidos.enqueue((Mensaje)nodo.getData());
					bandejaDeEntrada.removeFirst();
					
					break;
				}
				
				else if(i == bandejaDeEntrada.size()-1){
					mensaje = ((Mensaje)nodo.getData()).getMensaje();
					
					mensajesLeidos.enqueue((Mensaje)nodo.getData());
					bandejaDeEntrada.removeLast();
					
					break;
				}
				
				mensaje = ((Mensaje)nodo.getData()).getMensaje();
				
				mensajesLeidos.enqueue((Mensaje)nodo.getData());
				
				nAnterior.setNext(nodo.getNext());
		
				bandejaDeEntrada.remove(nodo);
				break;
			
			}
			nAnterior = nodo;
			nodo = nodo.getNext();
		}
		return mensaje;
	}
	
//	public String consultarMensajesLeidos() {
//		
//		String texto ="";
////		System.out.println( ((Mensaje)mensajesLeidos.first()).getCedulaDestinatario()+" aqui");
//		Mensaje m = (Mensaje)this.mensajesLeidos.first();
//		int nMensaje = 0;
//		
//		for(int i = 0;i < mensajesLeidos.size();i++) {
//		
//			Date fechaMensaje = m.getDateHour();
//			String titulo = m.getTitulo();
//			String remitente = m.getRemitente();
//		
//			nMensaje++;
//			texto += nMensaje + "# " + fechaMensaje.toLocaleString() + " " + titulo + " " + remitente+"\n";
//			
//			
//				
//		}
//		
//		return texto;
//	}
	
	public String consultarMensajeLeidos() {
		String texto = "";
		Queue<Mensaje> mensajesLeidoscopia= new Queue<Mensaje>();  
		Queue<Mensaje> mensaje = this.mensajesLeidos;
		int nMensaje = 0;
		int c = mensajesLeidos.size();
		
		for(int i = 0;i < c;i++) {
		
			Date fechaMensaje = mensaje.first().getDateHour();
			String titulo = mensaje.first().getTitulo();
			String remitente =mensaje.first().getRemitente();
		
			nMensaje++;
			texto += nMensaje + "# " + fechaMensaje.toLocaleString() + " " + titulo + " " + remitente+"\n";
			
			mensajesLeidoscopia.enqueue(mensaje.first());
			
			mensaje.dequeue();
			
		}
		this.mensajesLeidos = mensajesLeidoscopia;
		return texto;
	}






	public String mostrarMensajeLeidos(int nMensaje) {
		String texto = "";
		Queue<Mensaje> mensajesLeidoscopia= new Queue<Mensaje>();  
		Queue<Mensaje> mensaje = this.mensajesLeidos;

		int c = mensajesLeidos.size();
		
		for(int i = 0;i < c;i++) {

			if(i == nMensaje-1) {

				texto = mensaje.first().getMensaje();
			}
			
			mensajesLeidoscopia.enqueue(mensaje.first());
			
			mensaje.dequeue();
			
		}
		this.mensajesLeidos = mensajesLeidoscopia;
		return texto;
	}

	
	public String enviarMensaje(Mensaje mensaje, SistemaMensajeria sistema) {
		
		DoubleNode<Usuario> nodo = sistema.getUsers().first();
		String resultado = "Usuario no encontrado";
		
		for(int i = 0;i < sistema.getUsers().size();i++) {
			 if(((Usuario)nodo.getData()).getId()== mensaje.getCedulaDestinatario()) {
				 
				 ((Usuario)nodo.getData()).getBandejaDeEntrada().addFirst(mensaje);
				 resultado = "Mensaje enviado";
				 break;
			 }
			 
			 nodo = nodo.getNext();			
		}
		
		
		return resultado;
		//Ingresar en la bandejaDeEntrada  del destinatario
		//Actualizar el txt que conecta con la bandejaDeEntrada del destinatario
		
	}
	
	public void agregarLeidos(Mensaje mensaje) {
		
	}
	public String getCargo() {
		
		return cargo;
		
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getClave() {
		return this.clave;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public long getId() {
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

	public void setBandejaDeEntrada(DoubleList<Mensaje> bandeja) {
		this.bandejaDeEntrada = bandeja;
	}
	
	public DoubleList<Mensaje> getBandejaDeEntrada() {
		return this.bandejaDeEntrada;
	}
	
	public Queue getMensajeLeidos() {
		return this.mensajesLeidos;
	}
	
	public void setMensajeaLeidos(Queue<Mensaje> cola) {
		this.mensajesLeidos = cola;
	}
	
	@Override
	public String toString() {
		return nombre + " " + cedula + " "+ fecha_nac + " " + ciudad_nac
				+ " " + tel +" "+ email +" "+dir;
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