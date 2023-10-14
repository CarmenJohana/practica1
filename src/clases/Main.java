package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static SistemaMensajeria sys1;
	static File archivo=null;
	static File archivo2=null;
	static FileReader fr= null;
	static FileReader fr2= null;
	static BufferedReader br = null;
	static BufferedReader br2= null;
	Scanner lector = new Scanner(System.in);
	
	

	public static void toFile() {
		
		try {
			FileWriter empleadostxt = new FileWriter("Empleados.txt");
			PrintWriter informacion = new PrintWriter(empleadostxt);
			FileWriter passwordstxt = new FileWriter("Password.txt");
			PrintWriter informacion2 = new PrintWriter(passwordstxt);
			DoubleNode<Usuario> usuario= sys1.getUsers().last();
			
			for( int i = 0; i < sys1.getUsers().size(); i++) {
				
				informacion.println(usuario.getData());
				informacion2.println(usuario.getData().getId()+ " "+ usuario.getData().getClave()+ " "+usuario.getData().getCargo());
			}
			informacion.close();
			informacion2.close();
			System.out.println("Se ha actualizado el archivo Empleados.txt");
			
			
		} catch(IOException e) {
			  e.printStackTrace();
			}
		}
	
	
	
	public static void mostrarMenuPrincipal(SistemaMensajeria sys1, Scanner lector) {
	    int opcion;
	    do {
	        System.out.println("\n------Bienvenido al sistema de mensajería------");
	        System.out.println("\nSeleccione una de las siguientes opciones:");
	        System.out.println("1. Iniciar sesión");
	        System.out.println("2. Cerrar sistema");

	        opcion = lector.nextInt();

	        switch (opcion) {
	            case 1:
	                iniciarSesion(sys1, lector);
	                break;
	            case 2:
	                System.out.println("Hasta luego. ¡Gracias por usar nuestro sistema!");
	                toFile();
	                //GUARDAR CAMBIOS ANTES DE CERRAR
	                
	                
	                
	                
	                try{    
                    	
	                       if( null != fr && null != fr2){   
	                          fr.close();  
	                          fr2.close();
	                       }                  
	                    }catch (Exception e2){ 
	                       e2.printStackTrace();
	                    }
	                	break;
	            default:
	                System.out.println("Opción no válida. Introduce un número válido.");
	                break;
	        }
	    } while (opcion != 2);
	}
	
	public static void menuAdmin(Usuario user) {

	    Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("-------- Menu de Funcionalidades --------");
        System.out.println("0. Salir");
        System.out.println("1. Enviar Mensaje");
        System.out.println("2. Consultar Bandeja de entrada");
        System.out.println("3. Consultar Mensajes Leidos");
        System.out.println("4. Consultar borradores");
        System.out.println("5. Agregar Usuario");
        System.out.println("6. Cambiar contraseña");
        System.out.println("7. Eliminar Usuario");
        
        System.out.print("Selecciona una opción: ");

        
        
        
        
        
        do {
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                
                    // Aquí puedes colocar la funcionalidad correspondiente a la opción 1
                	System.out.println("-----------Enviar Mensaje---------");
                	System.out.println("Ingrese cedula del destinatario: ");
                	long id = scanner.nextLong();
                	
                	System.out.println("Ingrese titulo del mensaje: ");
                	String titulo = scanner.next();
                	
                	System.out.println("Ingrese mensaje: ");
                	String mensaje = scanner.next();
                	
                	System.out.println("seleccione: ");
                	System.out.println("1. Enviar mensaje ");
                	System.out.println("2. Descartar mensaje");
                	System.out.println("3. Guardar como borrador ");
                	int opcionMensaje = scanner.nextInt();
                	
                	
                	
                	Mensaje mensajeObj = new Mensaje(user.getNombre(), id, titulo, mensaje);
                	
                	
                	if(opcionMensaje == 1) System.out.println(user.enviarMensaje(mensajeObj, sys1));
                	
                	else if(opcionMensaje == 2)System.out.println("Mensaje descartado");
                	
                	else if (opcionMensaje == 3)System.out.println("borrador");
          			
                    break;
                case 2:
                    // Aquí puedes colocar la funcionalidad correspondiente a la opción 2
                	System.out.println("-----------Bandeja de entrada----------");
                	System.out.println(user.consultarBandejaDeEntrada());
                	if(user.consultarBandejaDeEntrada().equals("")) {
                		System.out.println("No tienes mensajes en bandeja");
                		break;
                	}
                	System.out.println("Selecione el mesaje:");
                	opcion = scanner.nextInt();
                	System.out.println("-----------Mensaje----------");
                	System.out.println(user.mostrarMensajeBandeja(opcion));
                	
                	
                	
                    break;
                case 3:
                    // Aquí puedes colocar la funcionalidad correspondiente a la opción 3
                	System.out.println("Consultar Mensajes Leidos");
                    break;
                case 4:
                	System.out.println("Cosultar borradores");
                    break;
                case 5:
                	System.out.println("--------Registrar Usuario------");
                	System.out.println("Ingrese el id del usuario: ");
                	long idUsuario3 = scanner.nextLong();
                	System.out.println("Ingrese el nombre: ");
                	String nom = scanner.next();
                	System.out.println("Ingrese la ciudad de nacimiento: ");
                	String ciudadN = scanner.next();
                	System.out.println("Ingrese el telefono: ");
                	long telf = scanner.nextLong();
                	System.out.println("Ingrese el mail: ");
                	String mail = scanner.next();
                	System.out.println("Ingrese el dia de nacimiento: ");
                	int dd = scanner.nextInt();
                	System.out.println("Ingrese el mes de nacimiento: ");
                	int mm = scanner.nextInt();
                	System.out.println("Ingrese el ano de nacimiento: ");
                	int aa = scanner.nextInt();
                	System.out.println("Ingrese calle: ");
                	String cll = scanner.next();
                	System.out.println("Ingrese nomesclatura: ");
                	String nomesclatura = scanner.next();
                	System.out.println("Ingrese barrio: ");
                	String bar = scanner.next();
                	System.out.println("Ingrese ciudad donde vive: ");
                	String ciuV = scanner.next();
                	System.out.println("Ingrese nombre de la urbanizacion de residencia: ");
                	String urb = scanner.next();
                	System.out.println("Ingrese el numero de apto: ");
                	int apto = scanner.nextInt();
                	System.out.println("Ingrese la nueva contraseña: ");
                	String clave1 = scanner.next();
                	
                	Fecha fecha1 =new Fecha(dd, mm, aa);
                	Direccion dir = new Direccion(cll, nom, bar, ciudadN, urb, apto);
                	Usuario usuarioNew = new Usuario(nom, idUsuario3, fecha1, ciudadN, telf, mail, dir);
                	
                	System.out.println(sys1.registrarUsuarios(usuarioNew, clave1));
                	
                	
                    break;
                case 6:
//                	codicion cargo del usuario
                	System.out.println("------Cambiar contraseña------");
                	System.out.println("Ingrese el id del usuario: ");
                	long idUsuario = scanner.nextLong();
                	System.out.println("Ingrese la nueva contraseña: ");
                	String clave = scanner.next();
                	System.out.print(sys1.cambiarContrasena(idUsuario, clave));
                    break;
                case 7:
//                	codicion cargo usuario
                	System.out.println("--------Eliminar Usuario------");
                	System.out.println("Ingrese el id del usuario: ");
                	long idUsuario2 = scanner.nextLong();
                	System.out.println(sys1.eliminarUsuario(idUsuario2));
                	
                    break;
                case 0:
                	System.out.println("0. Salir");
                	iniciarSesion(sys1, scanner);
                    break;
               
                default:
                    System.out.println("Opción no válida. Introduce un número válido.");
            }
        } while (opcion != 0);
        
            // Cerrar el scanner
           scanner.close();
		
	}
	
	
	
	
	public static void iniciarSesion(SistemaMensajeria sys1, Scanner lector) {
	    boolean logIn = false;

	    while (!logIn) {
	        System.out.println("------ Inicio de Sesión ------");
	        System.out.println("Ingrese su ID: ");
	        Long id = lector.nextLong();
	        System.out.println("Ingrese su contraseña: ");
	        String contraseña = lector.nextLine(); // Consumir el salto de línea pendiente
	        contraseña = lector.nextLine();

	        DoubleNode<Usuario> u = sys1.busquedaUsuario(id);
	        
	        if (u != null && u.getData().getClave().equals(contraseña)) {
	            logIn = true;
	            menuAdmin(u.getData());
	        } else {
	            System.out.println("Datos incorrectos");
	            int opcion2;
	            do {
	                System.out.println("¿Desea intentar nuevamente? 1-(Sí) 2-(Volver al menú principal)");
	                opcion2 = lector.nextInt();

	                if (opcion2 == 2) {
	                    logIn = true;
	                    break;
	                } else if (opcion2 != 1) {
	                    System.out.println("Opción no válida");
	                }
	            } while (opcion2 != 1 && opcion2 != 2);
	        }
	    }
	}


	public static void importarUsuarios() {
		
		try {
			/*
			archivo = new File("C:\\Users\\cjcho\\eclipse-workspace\\pr1\\src\\Archivos\\Empleados.txt");
			archivo2= new File("C:\\Users\\cjcho\\eclipse-workspace\\pr1\\src\\Archivos\\Password.txt");
			*/
			archivo = new File("src\\Archivos\\Empleados.txt");
			archivo2 = new File("src\\Archivos\\Password.txt");

			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			fr2 = new FileReader(archivo2);
			br2 = new BufferedReader(fr2);
			
			
			// Lectura del fichero
	        String linea;
	        String linea2;
	        
	        DoubleList<Usuario> users= new DoubleList<Usuario>();
	        
	        
	        while((linea2=br2.readLine())!=null && (linea=br.readLine())!=null) {
	        	
	        	
	        	
	        	String[] textoSeparado = linea.split(", "); //Texto empleados.txt
	        	String[] textoSeparado2 = linea2.split(" ");//Texto password.txt
	        	//System.out.println("hjgjh"+textoSeparado2[1]);//Comprueba que lee el segundo archivo
	        	
	        	Usuario u1=new Usuario(textoSeparado[0], Long.parseLong(textoSeparado[1]));
	        	
	        	if (textoSeparado.length >= 7 && textoSeparado2.length >= 3) {
	        		
	        		String[]direccion = textoSeparado[6].split(" ");
	        		String[] fecha = textoSeparado[2].split("-");
	        		
	        		
	        		
	        		
	        		Fecha fechaNacimiento=new Fecha(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]));
	        		
	        		
	        		
	        		// Verifica si direccion[5] es "null" o tiene un valor numérico
	        		int valorEntero;
	        		if (direccion[5].equals("null")) {
	        		    valorEntero = 0; // O cualquier otro valor predeterminado que desee asignar cuando direccion[5] es "null"
	        		} else {
	        		    valorEntero = Integer.parseInt(direccion[5]);
	        		}
	        		
	        		

	        		// Crea la instancia de Direccion con el valorEntero obtenido
	        		Direccion dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], direccion[4], valorEntero);
	        		
	        		
	        		
	        		
	        		u1.setEmail(textoSeparado[5]);
	        		u1.setTel(Long.parseLong(textoSeparado[4]));
	        		u1.setCiudad_nac(textoSeparado[3]);
	        		u1.setFecha_nac(fechaNacimiento);
	        		u1.setDir(dir);
	        		u1.setCargo(textoSeparado2[2]);
	        	
	        		//System.out.println("NULLL PARA "+sys1.busquedaUsuario(u1.getId())+ u1);
	        			
	        		System.out.println(sys1.registrarUsuarios(u1,textoSeparado2[1]));
	        		
	        		
	        		
	        		/*
	        		DoubleNode<Usuario> nodo= sistema.getUsers().first();
	        		for (int i=0;i<sistema.getUsers().size();i++) {
	        			System.out.println("Antes de ordenar");
	        			System.out.println(nodo.getData().getId());
	        			nodo= nodo.getNext();
	        		}
	        		*/
	        	}
	        	
	        	//System.out.println(linea);
	        
	        }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static DoubleNode<Usuario> busquedaUsuario(Long id) {
	    DoubleNode<Usuario> start = sys1.getUsers().first();
	    DoubleNode<Usuario> end = sys1.getUsers().last();

	    // Caso especial: ID a buscar es menor que el mínimo ID en la lista
	    if (id < start.getData().getId()) {
	        return null;
	    }

	    // Búsqueda binaria
	    while (start != null && end != null && start != end) {
	        DoubleNode<Usuario> mid = sys1.getUsers().Middle(start, end);

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

	

	public static void main(String[] args) {
		
		DoubleList<Usuario> users= new DoubleList<Usuario>(); //Se inicializa con un head y tail nulos y un size de cero
		
		
		
		Usuario u1=new Usuario("Johana",234, new Fecha(1,2,3), "Pompeya", 312, "jacalderonc", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		Usuario u2=new Usuario( "Harry",2234, new Fecha(1,2,3), "Pompeya", 312, "harriest", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		Usuario u3=new Usuario("Louise",2134, new Fecha(1,2,3), "Pompeya", 312, "lololo", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		Usuario u4=new Usuario("Ronald",1111, new Fecha(1,2,3), "Pompeya", 312, "lololo", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		Usuario u5=new Usuario("LUIS",1113, new Fecha(1,2,3), "Pompeya", 312, "lololo", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		
		DoubleList<Usuario> u = new DoubleList<Usuario>();
		u.addFirst(u3);
		u.addFirst(u2);
		u.addFirst(u1);
		u.addFirst(u4);
		u.sort(); //El problema no está en el sort
		
		
		
		
		sys1= new SistemaMensajeria(15);
		sys1.setUsers(u);
		/*
		//Los enlaces están bien
		DoubleNode<Usuario> uno3= sys1.getUsers().first();
				
		for (int i=0; i<sys1.getUsers().size();i++) {
				
				System.out.println("LA LISTA ESTÁ EXACTAMENTE ORGANIZADA "+uno3.getData());
				uno3 = uno3.getNext();
					
		}
				
		
		
		
		
		/*
		//Los enlaces están bien
		DoubleNode<Usuario> uno= sys1.getUsers().last();
		
		for (int i=0; i<sys1.getUsers().size();i++) {
			System.out.println("CANTIDAD DE USUARIOS EN EL SISTEMA--->"+sys1.getUsers().size());
			System.out.println("LA LISTA ESTÁ EXACTAMENTE ORGANIZADA "+uno.getData());
			uno = uno.getPrev();
			
		}
		
		System.out.println(sys1.getUsers().last().getNext());
		//u.addLast(u5); Aquí modificaría también la de sys1
		System.out.println(busquedaUsuario(234L).getData());
		
		
		System.out.println(sys1.busquedaUsuario(1111L).getData());
		*/
		
		importarUsuarios();
		Scanner lector = new Scanner(System.in);
        
        mostrarMenuPrincipal(sys1, lector);
        lector.close();
		
		/*
		System.out.println("Cantidad de usuarios--->"+sys1.getUsers().size());
		DoubleNode<Usuario> uno2= sys1.getUsers().last();
		
		for (int i=0; i<sys1.getUsers().size();i++) {
			
			System.out.println("LA LISTA ESTÁ EXACTAMENTE ORGANIZADA "+uno2.getData());
			uno2 = uno2.getPrev();
			
		}
		
		//  JOHANA - HARRY - LOUISE
		/*
		DoubleNode<Usuario> nodo= u.first();
		for (int i=0;i<u.size();i++) {
			System.out.println("Antes de ordenar");
			System.out.println(nodo.getData().getEmail());
			nodo= nodo.getNext();
		}
		
		
		
		DoubleNode<Usuario> nodo2=u.first();
		for (int i=0;i<u.size();i++) {
			System.out.println("Después de ordenar");
			System.out.println(nodo2.getData().getEmail());
			nodo2= nodo2.getNext();
		}
		*/
		
		
	}
}