package Tramite;

public class Username {

	
	// aqu� se obtienes la info. para loguearse.
	    private String Usuario; 
		private String contrase�a;
		
		
		//Username constructor
		public Username(String usuario, String contrase�a) {
			
			this.Usuario = usuario;
			this.contrase�a = contrase�a;
					}
       //Met�dos setters/ getters: 
		public String getContrase�a() {
			return contrase�a;
		}
		public void setContrase�a(String contrase�a) {
			this.contrase�a = contrase�a;
		}
		public Username() {
			// TODO Auto-generated constructor stub
		}
		public String getUsuario() {
			return Usuario;
		}
		public void setUsuario(String usuario) {
			Usuario = usuario;
		}
				
		
}


