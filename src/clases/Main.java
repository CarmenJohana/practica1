package clases;

public class Main {

    public static void main(String[] args) {
        // Crear una pila con capacidad para 3 elementos
//        Queue cola = new Queue();
//        cola.enqueue(4);
//        cola.enqueue(8);
//        cola.enqueue(2);
//        cola.enqueue(3);
//        cola.enqueue(5);
//
//        // Eliminar todos los elementos de la pila
//        while (!cola.isEmpty()) {
//            System.out.println(cola.dequeue());
//        }
//
//        System.out.println(cola.first());

    	Direccion direccion = new Direccion("Colombia", "a", "laureles", "Medellin", "reigal", 301);
    	Fecha fecha = new Fecha(13,03,2);
    	Usuario usuarioPrueba = new Usuario("Gabriel", 1 , fecha, "Valencia", 350277528, "gab@gmail.com", direccion);
    	Usuario usuarioPrueba2 = new Usuario("Juan", 2 , fecha, "Valencia", 350277528, "gab@gmail.com", direccion);
    	Usuario usuarioPruebaAdmi = new Usuario("Antoino", 3, fecha, "Mededillin", 354567528, "ant@gmail.com", direccion);
    	Usuario usuarioPruebaNo = new Usuario("Carmen", 4 , fecha, "Valencia", 350277528, "gab@gmail.com", direccion);
    	usuarioPruebaAdmi.setCargo("administrador");
    	usuarioPrueba.setCargo("empleado");
    	
    	List lista = new List();	
    	lista.addFirst(usuarioPruebaAdmi);
    	lista.addFirst(usuarioPrueba2);
    	lista.addFirst(usuarioPrueba);

    	SistemaMensajeria sistema = new SistemaMensajeria(3);
    	sistema.setUsers(lista);
    	
    	Mensaje mensaje1 = new Mensaje("gabriel",3 , "titulo mensaje 1", "contenido de mensaje 1");
    	Mensaje mensaje2 = new Mensaje("Juan",3 , "titulo mensaje 2", "contenido de mensaje 2");
    	Mensaje mensaje3 = new Mensaje("Carmen",3 , "titulo mensaje 3", "contenido de mensaje 3");
    	
    	DoubleList dobleLista = new DoubleList();
    	Queue cola = new Queue();
    	usuarioPrueba.setBandejaDeEntrada(dobleLista);
    	usuarioPrueba2.setBandejaDeEntrada(dobleLista);
    	
    	dobleLista.addFirst(mensaje2);
    	dobleLista.addFirst(mensaje3);
    	dobleLista.addFirst(mensaje1);
    	

    	usuarioPruebaAdmi.setBandejaDeEntrada(dobleLista);
    	usuarioPruebaAdmi.setMensajeaLeidos(cola);
    	
	    Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenuUsuarios();
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
                	
                	
                	
                	Mensaje mensajeObj = new Mensaje(usuarioPruebaAdmi.getNombre(), id, titulo, mensaje);
                	
                	
                	if(opcionMensaje == 1) System.out.println(usuarioPruebaAdmi.enviarMensaje(mensajeObj, sistema));
                	
                	else if(opcionMensaje == 2)System.out.println("Mensaje descartado");
                	
                	else if (opcionMensaje == 3)System.out.println("borrador");
              
                    break;
                case 2:
                    // Aquí puedes colocar la funcionalidad correspondiente a la opción 2
                	System.out.println("-----------Bandeja de entrada----------");
                	System.out.println(usuarioPruebaAdmi.consultarBandejaDeEntrada());
                	if(usuarioPruebaAdmi.consultarBandejaDeEntrada().equals("")) {
                		System.out.println("No tienes mensajes en bandeja");
                		break;
                	}
                	System.out.println("Selecione el mesaje:");
                	opcion = scanner.nextInt();
                	System.out.println("-----------Mensaje----------");
                	System.out.println(usuarioPruebaAdmi.mostrarMensajeBandeja(opcion));
                	
                	
                	
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
                	
                	System.out.println(sistema.registrarUsuarios(usuarioNew, clave1));
                	
                	
                    break;
                case 6:
//                	codicion cargo del usuario
                	System.out.println("------Cambiar contraseña------");
                	System.out.println("Ingrese el id del usuario: ");
                	long idUsuario = scanner.nextLong();
                	System.out.println("Ingrese la nueva contraseña: ");
                	String clave = scanner.next();
                	System.out.print(sistema.cambiarContrasena(idUsuario, clave));
                    break;
                case 7:
//                	codicion cargo usuario
                	System.out.println("--------Eliminar Usuario------");
                	System.out.println("Ingrese el id del usuario: ");
                	long idUsuario2 = scanner.nextLong();
                	System.out.println(sistema.eliminarUsuario(idUsuario2));
                	
                    break;
                case 0:
                	System.out.println("0. Salir");
                    break;
               
                default:
                    System.out.println("Opción no válida. Introduce un número válido.");
            }
        } while (opcion != 0);
        
            // Cerrar el scanner
           scanner.close();

    }
    
    public static void mostrarMenuUsuarios() {
        System.out.println("-------- Menu de Funcionalidades --------");
        System.out.println("1. Enviar Mensaje");
        System.out.println("2. Consultar Bandeja de entrada");
        System.out.println("3. Consultar Mensajes Leidos");
        System.out.println("4. Cosultar borradores");
        System.out.println("5. Agregar Usuario");
        System.out.println("6. Cambiar contraseña");
        System.out.println("7. Eliminar Usuario");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción (0-7): ");
        }
    }



}
