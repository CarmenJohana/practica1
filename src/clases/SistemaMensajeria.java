package clases;



public class SistemaMensajeria{
	
	private DoubleList<Usuario> users;
	private int capacity=0;
	
	public SistemaMensajeria(int capacity){
		
		this.capacity=capacity;
		
	}

	/***
	 
	Aquí van los métodos que se encargan de inicializar la lista de usuarios

	***/
	
	
	
	
	public void setUsers(DoubleList<Usuario> users){

		//Creamos los usuarios iniciales, estos son los extraídos del archivo empleados.txt
		users.sort();
		this.users=users;
		

	}
	public DoubleList<Usuario> getUsers() {
		return this.users;	
	}
	

	/***Demás getters, setters y métodos de búsqueda y eliminación de usuarios
	por aquí. También los de cambio de contraseña y alias de usuario***/

	
	public DoubleNode<Usuario> busquedaUsuario(Long id) {
	    DoubleNode<Usuario> start = users.first();
	    DoubleNode<Usuario> end = users.last();

	    // Caso especial: ID a buscar es menor que el mínimo ID en la lista
	    if (id < start.getData().getId()) {
	        return null;
	    }

	    // Búsqueda binaria
	    while (start != null && end != null && start != end) {
	        DoubleNode<Usuario> mid = users.Middle(start, end);

	        if (mid.getData().getId() == id) {
	            return mid;
	        } else if (mid.getData().getId() < id) {
	            start = mid.getNext();
	        } else {
	            end = mid.getPrev();
	        }
	    }

	    // Verificar el último nodo si es el nodo buscado
	    if (start != null && start.getData().getId() == id) {
	        return start;
	    }

	    return null;
	}

	
	

	
	
	public String registrarUsuarios(Usuario usuario, String clave) {

		/*
    	String nombre = usuario.getNombre();
    	Long cedula = usuario.getId();
    	Fecha fechaNacimiento = usuario.getFecha_nac();
    	String ciudadNacimiento = usuario.getCiudad_nac();
    	Long telefono = usuario.getTel();
    	String mail = usuario.getEmail();
    	Direccion direccion = usuario.getDir();
    	*/
		
    	usuario.setClave(clave);
    	
    	//DoubleNode<Usuario> nodo = users.first();
    	
    	int numUsers= users.size();
		//String resultado = "Usuario registrado con exito\n";
		
		
		
		
		if(numUsers<capacity && (busquedaUsuario(usuario.getId()))==null) {
			
			users.addLast(usuario);
			numUsers++;
			//System.out.println(users.last().getData());

		
		if (numUsers>1){

			
			
			DoubleNode<Usuario> previo= users.last().getPrev();
			
			while(previo!=null && previo.getData().getId()>previo.getNext().getData().getId()) {
				
				//Insertion Sort
				Usuario temp = previo.getData();
				previo.setData(previo.getNext().getData());
				previo.getNext().setData(temp);
				previo=previo.getPrev();
				
			}
		
			
		}
			return "El usuario "+ usuario.getEmail() +" fue registrado";

		}
		if(numUsers>=capacity) {
		return "Capacidad maxima alcanzada. No es posible agregar a este usuario.";
		}
		return "El Id registrado ya se encuentra en el sistema";
		
	}
	
	

	
	public String cambiarContrasena(long id, String claveNueva) {
		DoubleNode<Usuario> nodo = users.first();
		String resultado = "Usuario no registrado\n";
		
		for(int i = 0; i < users.size(); i++) {
			
			if(nodo.getData().getId() == id) {
				nodo.getData().setClave(claveNueva);
				resultado = "Se cambio la contrasena\n";
				break;
			}
			else nodo = nodo.getNext();
		}
		return resultado;
	}
	
	
	
	
	public String eliminarUsuario(long id) {
		
		DoubleNode<Usuario> nodo = users.first();
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
				DoubleNode<Usuario> nodoRemovido = nodo.getNext();
				DoubleNode<Usuario> nodoEnlazar = nodoRemovido.getNext();
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
