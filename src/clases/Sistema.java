package clases;

public class Sistema {


	int numUsuarios;
	Usuario[] registro;

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

					this.registro[i]=registro[i];

					//Copiamos el array
			}

			long idMax=registro[0].getId();

			for(int i=0;i<registro.length-1;i++) {

				for(int j=i+1; j<registro.length;j++) {

					if (registro[i].getId()>registro[j].getId()) {

						Usuario temp=registro[i];
						registro[i]=registro[j];
						registro[j]=temp;


					}
				}
			}

		}


	}


	//Ingresa un nuevo usuario

	public void registrarUsuarios(Usuario u){
		if(numUsuarios<registro.length && (buscarUsuario(u.getId()))==-1) {

			registro[numUsuarios]=u;
			numUsuarios++;

		if(registro[numUsuarios-1].getId()<u.getId()){

			registro[numUsuarios-1]=u;

		}
		if (numUsuarios>1){

			int t=numUsuarios-1;
			while(t>0 && registro[t].getId()>registro[t-1].getId()) {
				registro[t]=registro[t-1];
				registro[t-1]=u;
				t--;
			}
		}

		}

	}




	//Retorna la posición del usuario


	public int buscarPosicicion(long id) {


		for (int i=0;i<registro.length;i++) {
			if(registro[i].getId()==id) {
				return i;
			}
		}

		return null;

	}


	public Usuario buscarUsuario(long id){

	    return registro[buscarPosicion(id)];


	}

	//Elimina el usuario del registro dado su Id

	public Usuario removerUsuario(long id){

		int posicion=buscarUsuario(id);

		if (numUsuarios>0 && posicion!=null) {

			Usuario aux = registro[posicion];
			for (int j =  posicion ; j<numUsuarios-1; j++) {

				registro[j]=registro[j+1];

			registro[numUsuarios-1]=null;
			numUsuarios--;
			return aux;

			}
		}

		return null;








		}



	}

