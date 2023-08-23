package clases;

public class SistemaOrdenado extends Sistema {

	
	
	public SistemaOrdenado(int capacidad) {
		super(capacidad);
		// TODO Auto-generated constructor stub
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
	public static void main(String[] args) {
		Usuario u=new Usuario(12345, "Carmen");
		Usuario u1=new Usuario(1, "Johana");
		Usuario u3=new Usuario(9, "Cas");
		Sistema sistema = new Sistema(3);
		sistema.setRegistro(new Usuario[] {u3,u,u1});
		System.out.println(sistema.getRegistro()[0]);
		
		
		/***
		sistema.asignarCapacidad(3);
		sistema.setRegistro(new Usuario[] {u,u1});
		sistema.registrarUsuarios(u3);
		System.out.println(sistema.getRegistro()[1]);**/
		
	}
	
	
	
}
