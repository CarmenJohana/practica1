package clases;

public class Main {

    public static void main(String[] args) {
         Fecha fecha = new Fecha(1, 1, 2000);
        Direccion direccion = new Direccion("Calle", 23, "Provincia", "Laureles", "Medellín");
        Usuario usuario = new Usuario(2, "Nuevo", fecha, "Monteria", direccion, 456893 ,"direccion@unal.edu.co");
/*         Usuario usuario2 = new Usuario(1001365936, "Daniel", fecha, "Monteria", direccion, 456893 ,"lala@unal.edu.co");
        Usuario usuario3 = new Usuario(1001365937, "Andres", fecha, "Monteria", direccion, 456893 ,"andres@unal.edu.co");

          */
        



        Sistema sistema1 = new Sistema(10); // Ajusta la capacidad según tus necesidades
/*         sistema.fromFile("registro.txt"); */
/*         sistema.registrarUsuarios(usuario);
        sistema.registrarUsuarios(usuario2);
        sistema.registrarUsuarios(usuario3);
 */
/*         sistema.toFile(); */

        sistema1.fromFile("registro.txt");
        sistema1.registrarUsuarios(usuario);
        sistema1.toFile();

        sistema1.removerUsuario(3);
        sistema1.toFile();

        for (int i = 0; i < sistema1.getNumUsuarios(); i++) {
            System.out.println(sistema1.getRegistro()[i].getId());
        }





        //******** Aquí comienza la prueba de los métodos ********


        Usuario u=new Usuario(12345, "Carmen");
		Usuario u1=new Usuario(1, "Johana");
		Usuario u3=new Usuario(9, "Cas");
		Usuario u4=new Usuario(11231,"Pepe", new Fecha(13,03,2),"Hanoi",new Direccion("Av.",80, "No.", "Robledo", "Medellin"),4337468,"pepe@gmail.com");

		Usuario u5=new Usuario(35, "Harry");
		Usuario u6=new Usuario(91, "Moon");
		Usuario u7=new Usuario(90, "Dog");
		Usuario u8=new Usuario(45, "Louise");


	    Sistema sistema = new Sistema(10);

	    Usuario[] arrayInicial=new Usuario[] {u3,u4,u1,u,u,u,u,u,u,u}; //No me permite ingresar repeticiones

	    sistema.setRegistro(arrayInicial);

	    System.out.println("Para comprobar que estén en orden ascendente " +sistema.getRegistro()[0] );

	    System.out.println("Cantidad de usuarios antes de cargar los del archivo--->"+ sistema.getNumUsuarios());

	    //Probando el import
	    sistema.importar("Usuarios");

	    System.out.println(sistema.getRegistro()[5]);
	    System.out.println("Cantidad de usuarios despues de cargar los del archivo--->"+ sistema.getNumUsuarios());

	    //Trato de agregar uno con un Id mayor al de Juan Caicedo
	    sistema.registrarUsuarios(new Usuario(999999990, "Jose"));

	    //El ultimo sigue siendo Juan Caicedo
	    System.out.println("..."+sistema.getRegistro()[5]);

	    //Trato de agregar uno con un Id menor al de Juan Caicedo
	    sistema.registrarUsuarios(new Usuario(100000000, "Jose"));

	    //El ultimo sigue siendo Juan Caicedo pero ahora está en la posición 6
	    System.out.println("--->"+sistema.getRegistro()[6]);

	    //Procedemos a llenar todas las posiciones para probar lo que ocurre al tratar de agregar un usuario
	    sistema.registrarUsuarios(u8);
	    sistema.registrarUsuarios(u7);
	    System.out.println("Cantidad de usuarios despues de cargar u8 y u7--->"+ sistema.getNumUsuarios());
	    sistema.registrarUsuarios(u5);
	    sistema.registrarUsuarios(u6);

	    System.out.println("Cantidad de usuarios--->"+ sistema.getNumUsuarios());
	    System.out.println("Este es el usuario de la ultima posicion "+ sistema.getRegistro()[9]);

	    //Tratamos de agregar un usuario con Id mayor a la del ultimo

	    Usuario u9=new Usuario(999999999, "Marshall");
	    sistema.registrarUsuarios(u9);

	    //Vemos que no se agregó
	    System.out.println("Este es el usuario de la ultima posicion "+ sistema.getRegistro()[9]);

	    //Ahora tratamos de agregar un usuario con Id menor a la del último
	    Usuario u10=new Usuario(9, "Marshall");
	    sistema.registrarUsuarios(u10);

	    //Tampoco se agregó pues no hay espacio
	    System.out.println("Este es el usuario de la ultima posicion "+ sistema.getRegistro()[9]);

	    //Probamos el método de eliminación. Sabemos que el Id de Johana es 1 (el menor)
	    sistema.removerUsuario(1);

	    //El primer usuario debería ser Cas
	    System.out.println("Este es el usuario de la primera posicion "+ sistema.getRegistro()[0]);

	    System.out.println("Cantidad de usuarios después de remover a Johana--->"+ sistema.getNumUsuarios());

	    //Agregamos un nuevo usuario con Id 0
	    sistema.registrarUsuarios(new Usuario(0,"Maria"));
	    System.out.println("Este es el usuario de la primera posicion "+ sistema.getRegistro()[0]);



	    //Probando el metodo de buscarPosicion
	    System.out.println(sistema.buscarPosicion(1));//Devuelve null pues Johana fue retirada
	    System.out.println(sistema.buscarPosicion(999999990));


	    //Probando método de buscar por Id

	    System.out.println(sistema.buscarUsuario(1));//Devuelve null pues Johana fue retirada
	    System.out.println(sistema.buscarUsuario(999999990));// Devuelve Jose
	    System.out.println(sistema.buscarUsuario(11231)); //Devuelve Pepe


    }



}
