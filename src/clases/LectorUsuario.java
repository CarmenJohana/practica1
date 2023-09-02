package clases;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LectorUsuario {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(10);

        try {
            File file = new File("src/clases/usuarios.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                
                long id = Long.parseLong(parts[0]);
                String nombre = parts[1].replaceAll("\"", "");
                String[] fechaParts = parts[2].split("/");
                Fecha fechaNacimiento = new Fecha(
                    Integer.parseInt(fechaParts[0]),
                    Integer.parseInt(fechaParts[1]),
                    Integer.parseInt(fechaParts[2])
                );
                String ciudadNacimiento = parts[3].replaceAll("\"", "");
                String[] direccionParts = parts[4].split(" ");
                String calle = direccionParts[0];
                int noCalle = Integer.parseInt(direccionParts[1]);
                String nomenclatura = direccionParts[2];
                String barrio = direccionParts[3];
                String ciudad = direccionParts[4].replaceAll(",", "");
                Direccion direccion = new Direccion(calle, noCalle, nomenclatura, barrio, ciudad);
                long tel = Long.parseLong(parts[5]);
                String email = parts[6].replaceAll("\"", "");

                Usuario usuario = new Usuario(id, nombre, fechaNacimiento, ciudadNacimiento, direccion, tel, email);
                sistema.registrarUsuarios(usuario);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/clases/usuarios.txt"))) {
            for (int i = 0; i < sistema.getNumUsuarios(); i++) {
                Usuario usuario = sistema.getRegistro()[i];
                if (usuario != null) {
                    String linea = String.format("%d, \"%s\", %02d/%02d/%02d, \"%s\", %s, %d, \"%s\"",
                            usuario.getId(), usuario.getNombre(),
                            usuario.getFecha_nac().getDd(), usuario.getFecha_nac().getMm(), usuario.getFecha_nac().getAa(),
                            usuario.getCiudad_nac(), usuario.getDir(), usuario.getTel(), usuario.getEmail());
                    writer.write(linea);
                    writer.newLine(); // Agregar una nueva línea después de cada usuario
                }
            }
            System.out.println("Usuarios ordenados guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        for (int i = 0; i < sistema.getNumUsuarios(); i++) {
            System.out.println(sistema.getRegistro()[i]);
        }
    }
}