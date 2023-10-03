/* package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;


public class Sistema {


	private int numUsuarios;
	private Usuario[] registro;

	public Sistema(int capacidad){
		registro=new Usuario[capacidad];
	}


	//Getters y setters

	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public Usuario[] getRegistro() {
		return registro;
	}


	//Inicializa el registro ordenando los iniciales

	public void setRegistro(Usuario[] registro) {


		if(registro.length<=this.registro.length) {
			for(int i=0; i<registro.length;i++) {
				registrarUsuarios(registro[i]);
			}
		}




	} */


	//Ingresa un nuevo usuario
/* 
	public void registrarUsuarios(Usuario u){
		if(numUsuarios<registro.length && (buscarPosicion(u.getId()))==-1) {

			registro[numUsuarios]=u;
			numUsuarios++;

		if(registro[numUsuarios-1].getId()<u.getId()){

			registro[numUsuarios-1]=u;

		}
		if (numUsuarios>1 ){

			int t=numUsuarios-1;
			while(t>0 && registro[t].getId()<registro[t-1].getId()) {
				registro[t]=registro[t-1];
				registro[t-1]=u;
				t--;
			}

		}
			toFile();

		}

	} */




	//Retorna la posición del usuario


	// Si itero sobre el registro.length, me va a dar error porque el array tiene 10 posiciones, pero solo 5 están ocupadas
/* 	public int buscarPosicion(long id) {


		for (int i=0;i<numUsuarios;i++) {
			if(registro[i].getId()==id) {
				return i;
			}
		}

		return -1;

	}

	// Cambié este método
	public Usuario buscarUsuario(long id){

		int posicion = buscarPosicion(id);

		if (posicion != -1) {
			return registro[posicion];
		}
		else {
			return null; // Usuario no encontrado
		}
	} */

	//Elimina el usuario del registro dado su Id
/* 
	public Usuario removerUsuario(long id){

		int posicion =  buscarPosicion(id);

		if (numUsuarios>0 && posicion!= -1) {

			Usuario aux = registro[posicion];
			for (int j = posicion; j < numUsuarios - 1; j++) {
				registro[j] = registro[j + 1];
			}
			registro[numUsuarios - 1] = null;
			numUsuarios--;

			toFile();
			return aux;



		}


		return null;


		} */

/* 	public void toFile() {

		try {
			FileWriter registroTxt = new FileWriter("registro.txt");
			PrintWriter informacion = new PrintWriter(registroTxt);

			for( int i = 0; i < registro.length; i++) {
				if(registro[i] == null) {
					break;
					}
				else {
					if (registro[i].getDir()!=null) {
						informacion.println(registro[i].getId() + ", " + registro[i].getNombre() + ", " + registro[i].getFecha_nac().dd +
								"-" + registro[i].getFecha_nac().mm + "-" + registro[i].getFecha_nac().aa + ", " + registro[i].getCiudad_nac()
								+ ", " + registro[i].getDir().getCalle() + " " + registro[i].getDir().getNoCalle()
								+ " " + registro[i].getDir().getNomenclatura() + " " + registro[i].getDir().getBarrio() + " " + registro[i].getDir().getCiudad()
								+ ", " + registro[i].getTel() + ", " + registro[i].getEmail());
						}
					else {
						informacion.println(registro[i].getId() + ", " + registro[i].getNombre());

					}
					}
				}
			informacion.close();
			System.out.println("Se ha creado el archivo registro.txt");

		} catch(IOException e) {
			  e.printStackTrace();
			}
		} */
	 /***
		public void fromFile(String archivo) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(archivo));
				String linea;
				while ((linea = reader.readLine()) != null) {
					String[] partes = linea.split(", ");
					long id = Long.parseLong(partes[0]);
					String nombre = partes[1];
					int dd = Integer.parseInt(partes[2]);
					int mm = Integer.parseInt(partes[3]);
					int aa = Integer.parseInt(partes[4]);
					String ciudadNac = partes[5];
					String calle = partes[6];
					int noCalle = Integer.parseInt(partes[7]);
					String nomenclatura = partes[8];
					String barrio = partes[9];
					String ciudadDir = partes[10];
					long tel = Long.parseLong(partes[11]);
					String email = partes[12];

					Fecha fechaNacimiento = new Fecha(dd, mm, aa);
					Direccion direccion = new Direccion(calle, noCalle, nomenclatura, barrio, ciudadDir);
					Usuario usuario = new Usuario(id, nombre, fechaNacimiento, ciudadNac, direccion, tel, email);

					registrarUsuarios(usuario);
					System.out.println("Se ha registrado el usuario " + usuario.getNombre());
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
***/
/* 	public void importar(String filename) {
	 File archivo = null;
     FileReader fr = null;
     BufferedReader br = null;

     try {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
        archivo = new File (filename);
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);

        // Lectura del fichero
        String linea;




        while((linea=br.readLine())!=null) {

        	String[] textoSeparado = linea.split(", ");

        	Usuario u1=new Usuario(Long.parseLong(textoSeparado[0]), textoSeparado[1]);

        	if (textoSeparado.length>2) {

        		String[]direccion = textoSeparado[4].split(" ");
        		String[] fecha = textoSeparado[2].split("-");
        		Fecha fechaNacimiento=new Fecha(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]));
        		Direccion dir= new Direccion(direccion[0],Integer.parseInt(direccion[1]),direccion[2], direccion[3], direccion[4]);

        		u1.setEmail(textoSeparado[6]);
        		u1.setTel(Long.parseLong(textoSeparado[5]));
        		u1.setCiudad_nac(textoSeparado[3]);
        		u1.setFecha_nac(fechaNacimiento);
        		u1.setDir(dir);


        	}
        	registrarUsuarios(u1);

        	//System.out.println(linea);



        }


     }
     catch(Exception e){
        e.printStackTrace();
     }finally{
        // En el finally cerramos el fichero, para asegurarnos
        // que se cierra tanto si todo va bien como si salta
        // una excepcion.
        try{
           if( null != fr ){
              fr.close();
           }
        }catch (Exception e2){
           e2.printStackTrace();
        }
     }
  }
} */

