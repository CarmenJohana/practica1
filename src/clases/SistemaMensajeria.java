package clases;

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

	/***Demás getters, setters y métodos de búsqueda y eliminación de usuarios
	por aquí. También los de cambio de contraseña y alias de usuario***/


}
