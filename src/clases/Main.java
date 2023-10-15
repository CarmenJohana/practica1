package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static SistemaMensajeria sys1;
	static File archivo = null;
	static File archivo2 = null;
	static FileReader fr = null;
	static FileReader fr2 = null;
	static BufferedReader br = null;
	static BufferedReader br2 = null;
	
	public static void toMensajes() {
	    DoubleNode<Usuario> usuarioNode = sys1.getUsers().first();
	    String nombreArchivo = "Mensajes.txt";
	    String ruta = "src/Archivos/";

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(ruta, nombreArchivo)))) {
	        for (int i = 0; i < sys1.getUsers().size(); i++) {
	            Usuario usuario = usuarioNode.getData();
	            //System.out.println(usuario.getId());

	            if (usuario.getBandejaDeEntrada().size() > 0) {
	                System.out.println(usuario.getBandejaDeEntrada().size());
	                String mensajesBandeja = usuario.escribirBandejaDeEntrada();
	                writer.write("cedula: " + usuario.getId() + "\n");
	                writer.write("Bandeja de entrada:\n");
	                writer.write(mensajesBandeja + "\n");
	            }

				if (usuario.getMensajesLeidos().size() > 0) {
					String mensajesLeidos = usuario.escribirMensajesLeidos();
					writer.write("Mensajes leidos:\n");
					writer.write(mensajesLeidos + "\n");
				}

				if (usuario.getBorradores().size() > 0) {
					String mensajesBorradores = usuario.escribirMensajesBorradores();
					writer.write("Borradores:\n");
					writer.write(mensajesBorradores + "\n");
				}

	            usuarioNode = usuarioNode.getNext();
	        }

	        System.out.println("Mensajes de la bandeja de entrada han sido escritos en " + nombreArchivo);
	    } catch (IOException e) {
	        System.out.println("Error al escribir el archivo: " + e.getMessage());
	    }
}
	
	
	public static void toFile() {
	    try {
	        FileWriter empleadostxt = new FileWriter("src\\Archivos\\Empleados.txt");
	        PrintWriter informacion = new PrintWriter(empleadostxt);
	        FileWriter passwordstxt = new FileWriter("src\\Archivos\\Password.txt");
	        PrintWriter informacion2 = new PrintWriter(passwordstxt);
	        DoubleNode<Usuario> usuario = sys1.getUsers().first();

	        for (int i = 0; i < sys1.getUsers().size(); i++) {
	            informacion.println(usuario.getData());
	            informacion2.println(usuario.getData().getId() + " " + usuario.getData().getClave() + " " + usuario.getData().getCargo());
	            usuario=usuario.getNext();
	        }
	        informacion.close();
	        informacion2.close();
	        empleadostxt.close(); // Cerrar FileWriter
	        passwordstxt.close(); // Cerrar FileWriter
	        System.out.println("Se ha actualizado el archivo Empleados.txt");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	public static void menuAdmin(Usuario user, Scanner lector) {

	    
        int opcion;
       
        
        
        
        do {
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
            
            opcion = lector.nextInt();
            
            switch (opcion) {
                case 1:
                
                    // Aquí puedes colocar la funcionalidad correspondiente a la opción 1
                	System.out.println("-----------Enviar Mensaje---------");
                	System.out.println("Ingrese cedula del destinatario: ");
                	long id = lector.nextLong();
                	
                	lector.nextLine();
                	
                	System.out.println("Ingrese titulo del mensaje: ");
                	String titulo = lector.nextLine();
                	
                	System.out.println("Ingrese mensaje: ");
                	String mensaje = lector.nextLine();
                	
                	System.out.println("seleccione: ");
                	System.out.println("1. Enviar mensaje ");
                	System.out.println("2. Descartar mensaje");
                	System.out.println("3. Guardar como borrador ");
                	String opcionMensajeStr = lector.nextLine();
                    int opcionMensaje = Integer.parseInt(opcionMensajeStr);
                	
                	
                	Mensaje mensajeObj = new Mensaje(user.getNombre(), id, titulo, mensaje);
                	
                	
                	if(opcionMensaje == 1) System.out.println(user.enviarMensaje(mensajeObj, sys1));
                	
                	else if(opcionMensaje == 2)System.out.println("Mensaje descartado");
                	
                	else if (opcionMensaje == 3) {user.guardarBorrador(mensajeObj);}
          			
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
                	opcion = lector.nextInt();
                	System.out.println("-----------Mensaje----------");
                	System.out.println(user.mostrarMensajeBandeja(opcion));
                	
                	
                	
                    break;
                case 3:
                	   // Aquí puedes colocar la funcionalidad correspondiente a la opción 3
                	System.out.println("-----Mensajes Leidos-------");
                	String m = user.consultarMensajeLeidos();
                	System.out.println(m);
                	if(m.equals("")) {
                		System.out.println("No tienes mensajes leidos");
                		break;
                	}
                	System.out.println("Selecione el mesaje:");
                	opcion = lector.nextInt();
                	System.out.println("-----------Mensaje----------");
                	System.out.println(user.mostrarMensajeLeidos(opcion));
                	
                    break;


                case 4:
                	System.out.println("Cosultar borradores:");
    				if (user.getBorradores().top() == null) {
    					System.out.println("--------------Borradores-----------------");
    					System.out.println("No tienes borradores");
    				} else {
    					System.out.println("-----------Borradores----------");
    					System.out.println(user.mostrarMensajeBorrador());

    					
    					System.out.println("seleccione: ");
    					System.out.println("1. Enviar mensaje ");
    					System.out.println("2. Descartar mensaje");
    					System.out.println("0. Salir ");
    					int opcionBorrador = lector.nextInt();

    					if(opcionBorrador == 1) {
    						System.out.println(user.enviarMensaje(user.getBorradores().top(), sys1));
    						user.getBorradores().pop();
    					}
    					
    					else if(opcionBorrador == 2) {
    						user.descartar(user.getBorradores().top());
    						System.out.println("-----------------------------------------");
    						System.out.println("Mensaje descartado");
    					}
    				}
                        break;
                case 5:
                	if(user.getCargo().equals("administrador")) {
                		System.out.println("Ingrese el id del usuario: ");
                    	long idUsuario3 = lector.nextLong();
                    	System.out.println("Ingrese el nombre: ");
                    	String nom = lector.next();
                    	System.out.println("Ingrese la ciudad de nacimiento: ");
                    	String ciudadN = lector.next();
                    	System.out.println("Ingrese el telefono: ");
                    	long telf = lector.nextLong();
                    	System.out.println("Ingrese el mail: ");
                    	String mail = lector.next();
                    	System.out.println("Ingrese el dia de nacimiento: ");
                    	int dd = lector.nextInt();
                    	System.out.println("Ingrese el mes de nacimiento: ");
                    	int mm = lector.nextInt();
                    	System.out.println("Ingrese el ano de nacimiento: ");
                    	int aa = lector.nextInt();
                    	System.out.println("Ingrese calle: ");
                    	String cll = lector.next();
                    	//System.out.println("Ingrese nomesclatura: ");
                    	//String nomesclatura = lector.next();
                    	System.out.println("Ingrese barrio: ");
                    	String bar = lector.next();
                    	//System.out.println("Ingrese ciudad donde vive: ");
                    	//String ciuV = lector.next();
                    	System.out.println("Ingrese nombre de la urbanizacion de residencia: ");
                    	String urb = lector.next();
                    	System.out.println("Ingrese el numero de apto: ");
                    	int apto = lector.nextInt();
                    	System.out.println("Ingrese la nueva contraseña: ");
                    	String clave1 = lector.next();
                    	
                    	Fecha fecha1 =new Fecha(dd, mm, aa);
                    	Direccion dir = new Direccion(cll, nom, bar, ciudadN, urb, apto);
                    	Usuario usuarioNew = new Usuario(nom, idUsuario3, fecha1, ciudadN, telf, mail, dir);
                    	
                    	System.out.println(sys1.registrarUsuarios(usuarioNew, clave1));
                	}
                	else System.out.println("Solo los administradores pueden registrar usuarios");
          
                    break;
                case 6:
//                	codicion cargo del usuario
                	System.out.println("------Cambiar contraseña------");
                	if(user.getCargo().equals("administrador")) {
                		System.out.println("Ingrese el id del usuario: ");
                    	long idUsuario = lector.nextLong();
                    	System.out.println("Ingrese la nueva contraseña: ");
                    	String clave = lector.next();
                    	System.out.print(sys1.cambiarContrasena(idUsuario, clave));
                	}
                	else System.out.println("Solo los administradores pueden cambiar contraseñas");
                	
                	break;
                case 7:
//                	codicion cargo usuario
                	System.out.println("--------Eliminar Usuario------");
                	if(user.getCargo().equals("administrador")) {
                		System.out.println("Ingrese el id del usuario: ");
                    	long idUsuario2 = lector.nextLong();
                    	System.out.println(sys1.eliminarUsuario(idUsuario2));
                    	
                	}
                	else System.out.println("Solo los administradores pueden eliminar usuarios");
                	
                	
                    break;
                case 0:
                	System.out.println("0. Salir");
                	
                    return;
               
                default:
                    System.out.println("Opción no válida. Introduce un número válido.");
            }
        } while (opcion != 0);
        mostrarMenuPrincipal(lector);
            
		
	}
	
	
	
	public static void mostrarMenuPrincipal(Scanner lector) {
	    int opcion;
	    boolean sistemaCerrado = false; // Agrega una bandera para verificar si el sistema ha sido cerrado

	    do {
	        System.out.println("\n------Bienvenido al sistema de mensajería------");
	        System.out.println("\nSeleccione una de las siguientes opciones:");
	        System.out.println("1. Iniciar sesión");
	        System.out.println("2. Cerrar sistema");
	        opcion = lector.nextInt();

	        switch (opcion) {
	            case 1:
	                iniciarSesion(lector);
	                break;
	            case 2:
	                System.out.println("Hasta luego. ¡Gracias por usar nuestro sistema!");
	                toMensajes();
	                toFile();
	                sistemaCerrado = true; // Actualiza la bandera al cerrar el sistema
	                break;
	            default:
	                System.out.println("Opción no válida. Introduce un número válido.");
	                break;
	        }
	    } while (opcion != 2 && !sistemaCerrado); // El bucle se detendrá si el usuario elige cerrar el sistema o si el sistema ya está cerrado
	}

	public static void iniciarSesion(Scanner lector) {
	    boolean logIn = false;
	    int opcion2;
	    while (!logIn) {
	        System.out.println("------ Inicio de Sesión ------");
	        System.out.println("Ingrese su ID: ");
	        Long id = lector.nextLong();
	        
	        // Consumir el salto de línea pendiente después de leer el ID
	        lector.nextLine();
	        
	        System.out.println("Ingrese su contraseña: ");
	        String contraseña = lector.nextLine(); // Leer la contraseña
	        
	        DoubleNode<Usuario> u = sys1.busquedaUsuario(id);

	        // Verificar si el usuario y la contraseña coinciden
	        if (u != null && contraseña.equals(u.getData().getClave())) {
	            logIn = true;
	            menuAdmin(u.getData(), lector);
	        } else {
	            System.out.println("Datos incorrectos");
	            do {
	                System.out.println("¿Desea intentar nuevamente? 1-(Sí) 2-(Volver al menú principal)");
	                opcion2 = lector.nextInt();

	                if (opcion2 == 2) {
	                    logIn = true;
	                    return; // Salir del método si el usuario elige volver al menú principal
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
	        	//System.out.println("hjgjh"+textoSeparado[1]);//Comprueba que lee el segundo archivo
	        	
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
	        		System.out.println();
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

        
        try{    
        	
               if( null != fr && null != fr2){   
                  fr.close();  
                  fr2.close();
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
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
		Usuario u5=new Usuario("Beltheodoro",1113, new Fecha(1,2,3), "Pompeya", 312, "lololo", new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301));
		u1.setClave("lololo");	
		u2.setClave("123");
		u3.setClave("Contraseña");
		u4.setClave("contraseñaSecreta");
		u5.setClave("ElOjoQueTodoLoVe");
		
		u1.setCargo("empleado");	
		u2.setCargo("administrador");
		u3.setCargo("empleado");
		u4.setCargo("administrador");
		u5.setCargo("empleado");
		
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

        // Llamar a mostrarMenuPrincipal con el Scanner lector
        mostrarMenuPrincipal(lector);

        // Cerrar el Scanner después de que ya no se necesite
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