package clases;

public class Sistema {
	
	
	int numUsuarios;
	Usuario[] registro;
	
	public Sistema(int capacidad){
		registro=new Usuario[capacidad];
	}
	
	
	
	
	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public Usuario[] getRegistro() {
		return registro;
	}


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
				
				// (v1Representante, cantidad )
				//Buscar el representante
			}
			
		}
		
	
	}




	public void registrarUsuarios(Usuario u){
		if(numUsuarios<registro.length && (buscarUsuario(u.getId()))==null) {
		
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
	
	
	public Usuario buscarUsuario(long id) {
		
		
		for (int i=0;i<registro.length;i++) {
			if(registro[i].getId()==id) {
				return registro[i];
			}
		}
		
		return null;
		
	}
	
	
	public void removerUsuario() {
		
		
	}




	
	
	

}
