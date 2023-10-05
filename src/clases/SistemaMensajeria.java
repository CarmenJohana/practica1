package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SistemaMensajeria{
	
	private List users;
	private int capacity=0;
	
	public SistemaMensajeria(int capacity){
		
		this.capacity=capacity;
		
	}

	/***
	 
	Aquí van los métodos que se encargan de inicializar la lista de usuarios

	***/
	public void setUsers(List users){

		//Creamos los usuarios iniciales, estos son los extraídos del archivo empleados.txt
		this.users=users;
		this.users.setSize(capacity);		

	}
	public List getUsers() {
		return this.users;	
	}
	

	/***Demás getters, setters y métodos de búsqueda y eliminación de usuarios
	por aquí. También los de cambio de contraseña y alias de usuario***/

	
	public String registrarUsuarios(Usuario usuario, String clave) {


    	String nombre = usuario.getNombre();
    	Long cedula = usuario.getId();
    	Fecha fechaNacimiento = usuario.getFecha_nac();
    	String ciudadNacimiento = usuario.getCiudad_nac();
    	Long telefono = usuario.getTel();
    	String mail = usuario.getEmail();
    	Direccion direccion = usuario.getDir();
    	
    	usuario.setClave(clave);
    	
    	Node nodo = users.First();
		String resultado = "Usuario registrado con exito\n";
		
		
		for(int i = 0; i < users.size(); i++) {
			
			if(((Usuario)nodo.getData()).getId() == cedula) {
				resultado = "Este usuario ya se encuentra en el sistema\n";
				break;
			}
			else nodo = nodo.getNext();
		}

    	
    	if(resultado=="Usuario registrado con exito\n") {
    		users.addLast(usuario);
    	}
    	
		return resultado;
	
	}
	
	
	public String cambiarContrasena(long id, String claveNueva) {
		Node nodo = users.First();
		String resultado = "Usuario no registrado\n";
		
		for(int i = 0; i < users.size(); i++) {
			
			if(((Usuario)nodo.getData()).getId() == id) {
				((Usuario)nodo.getData()).setClave(claveNueva);
				resultado = "Se cambio la contrasena\n";
				break;
			}
			else nodo = nodo.getNext();
		}
		return resultado;
	}
	
	public String eliminarUsuario(long id) {
		
		Node nodo = users.First();
		String resultado = "Usuario no registrado\n";
		
		for(int i = 0; i < users.size(); i++) {
			
			if(i == 0 && ((Usuario)nodo.getData()).getId() == id) {
				users.removeFirst();
				System.out.println("primero");

				resultado = "Se elimino el usuario\n";

				break;
			}
			
			else if (i== users.size()-1 && ((Usuario)nodo.getData()).getId() == id) {
				users.removeLast();
				resultado = "Se elimino el usuario\n";
				System.out.println("ultimo");

				break;
				
			}
		
			else if(i < users.size()-2 &&((Usuario)nodo.getNext().getData()).getId() == id) {
				Node nodoRemovido = nodo.getNext();
				Node nodoEnlazar = nodoRemovido.getNext();
				nodo.setNext(nodoEnlazar);
				users.setSize(users.size()-1);
				
				System.out.println("medio");

				resultado = "Se elimino el usuario\n";


				break;
			}
		
			else nodo = nodo.getNext();
		}
		return resultado;
		
	}
	
	
	

}
