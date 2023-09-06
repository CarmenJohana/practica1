package clases;

public class Main {

    public static void main(String[] args) {
         Fecha fecha = new Fecha(1, 1, 2000);
        Direccion direccion = new Direccion("Calle", 23, "Provincia", "Laureles", "Medellín");
        Usuario usuario = new Usuario(2, "Nuevo", fecha, "Monteria", direccion, 456893 ,"direccion@unal.edu.co");
/*         Usuario usuario2 = new Usuario(1001365936, "Daniel", fecha, "Monteria", direccion, 456893 ,"lala@unal.edu.co");
        Usuario usuario3 = new Usuario(1001365937, "Andres", fecha, "Monteria", direccion, 456893 ,"andres@unal.edu.co");

          */
        
        Usuario u=new Usuario(12345, "Carmen");
		Usuario u1=new Usuario(1, "Johana");
		Usuario u3=new Usuario(9, "Cas");


        Sistema sistema = new Sistema(10); // Ajusta la capacidad según tus necesidades
/*         sistema.fromFile("registro.txt"); */
/*         sistema.registrarUsuarios(usuario);
        sistema.registrarUsuarios(usuario2);
        sistema.registrarUsuarios(usuario3);
 */
/*         sistema.toFile(); */

        sistema.fromFile("registro.txt");
        sistema.registrarUsuarios(usuario);
        sistema.toFile();

        sistema.removerUsuario(3);
        sistema.toFile();

        for (int i = 0; i < sistema.getNumUsuarios(); i++) {
            System.out.println(sistema.getRegistro()[i].getId());
        }

    }
}
