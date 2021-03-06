package co.edu.udea.iw.util.mail;

import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;

/*
 * Esta clase encapsula la logica para enviar las notificaciones por correo electronico
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public class Mail {
	/*
	 * Envia un mensaje via correo electronico
	 * @param correo Correo electronico del destinatario
	 * @param usuario Usuario que realiza la peticion
	 * @param pqr Solicitud realizada por el usuario
	 */
	public static void send(String correo, Usuario usuario,Pqr pqr){
		System.out.println("mensaje enviado");
	}
	public static void send(String correo, String mensaje){
		System.out.println(mensaje);
	}
}
