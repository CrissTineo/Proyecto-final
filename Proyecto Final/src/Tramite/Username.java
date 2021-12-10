package Tramite;

public class Username {

	
	// aquí se obtienes la info. para loguearse.
	    private String Usuario; 
		private String contraseña;
		
		
		//Username constructor
		public Username(String usuario, String contraseña) {
			
			this.Usuario = usuario;
			this.contraseña = contraseña;
					}
       //Metódos setters/ getters: 
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
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


