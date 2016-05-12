package co.edu.udea.iw.util.mail;

import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;

/*
 * Esta clase encapsula la logica para enviar las notificaciones por correo electronico
 * @author LUIS FERNANDO OROZCO
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
}
