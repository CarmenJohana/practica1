package clases;

public class Main {

    public static void main(String[] args) {
        Direccion direccion1 = new Direccion("Calle A", 123, "Norte", "Barrio X", "Ciudad Y");
        Fecha fechaNacimiento = new Fecha(15, 8, 1990);
        Usuario usuario1 = new Usuario(1, "Juan", fechaNacimiento, "Ciudad X", direccion1, 1234567890, "juan@example.com");
        Usuario usuario2 = new Usuario(2, "Carmen", fechaNacimiento, "Ciudad Y", direccion1, 1234567890, "juan@example.com");
        Usuario usuario3 = new Usuario(3, "Gabriel", fechaNacimiento, "Ciudad Z", direccion1, 1234567890, "juan@example.com");
        Usuario usuario4 = new Usuario(4, "Nicolas", fechaNacimiento, "Ciudad W", direccion1, 1234567890, "juan@example.com");
        Usuario usuario5 = new Usuario(5, "Andres", fechaNacimiento, "Ciudad X", direccion1, 1234567890, "juan@example.com");
        Usuario usuario6 = new Usuario(6, "Felipe", fechaNacimiento, "Ciudad Y", direccion1, 1234567890, "juan@example.com");
        Usuario usuario7 = new Usuario(7, "Camila", fechaNacimiento, "Ciudad Z", direccion1, 1234567890, "juan@example.com");
        Usuario usuario8 = new Usuario(8, "Natalia", fechaNacimiento, "Ciudad W", direccion1, 1234567890, "juan@example.com");

        System.out.println("Información del Usuario:");
        System.out.println(usuario1);

        Sistema sistema = new Sistema(10);
        sistema.registrarUsuarios(usuario1);
        sistema.registrarUsuarios(usuario2);
        sistema.registrarUsuarios(usuario3);
        sistema.registrarUsuarios(usuario4);
        sistema.registrarUsuarios(usuario5);
        sistema.registrarUsuarios(usuario6);
        sistema.registrarUsuarios(usuario7);
        sistema.registrarUsuarios(usuario8);
    

        System.out.println("\nUsuarios registrados:");
        for (int i = 0; i < sistema.getNumUsuarios(); i++) {
            System.out.println(sistema.getRegistro()[i]);
        }

        Usuario usuarioEncontrado = sistema.buscarUsuario(4);
        if (usuarioEncontrado != null) {
            System.out.println("\nUsuario encontrado:");
            System.out.println(usuarioEncontrado);
        } else {
            System.out.println("\nUsuario no encontrado.");
        }

        Usuario usuarioRemovido1 = sistema.removerUsuario(2); 
        Usuario usuarioRemovido2 = sistema.removerUsuario(4);
        System.out.println("\nUsuarios registrados:");
        if (sistema.getNumUsuarios() == 0) {
            System.out.println("No hay usuarios registrados.");
        }
        for (int i = 0; i < sistema.getNumUsuarios(); i++) {
            System.out.println(sistema.getRegistro()[i]);
        }

        for (int i = 0; i < sistema.getNumUsuarios(); i++) {
            System.out.println(sistema.getRegistro()[i].getNombre() + " " + sistema.buscarPosicion(sistema.getRegistro()[i].getId()));
        }
    }
}
