package temp;

import co.edu.udea.iw.dto.Usuario;

public class main {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setCedula("1216713123");
		usuario.setEmail("l@udea.edu.co");
		usuario.setNombre("Luis Fernando");
		usuario.setPassword("123");
		
		test te = new test();
		te.insertar(usuario);
        
    }
}
