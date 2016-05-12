package co.edu.udea.iw.dto;
/*
 * Clase dto para la tabla encuesta
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */

import java.io.Serializable;
import java.util.Date;

public class Encuesta implements Serializable{
	
	//atributos
	private int id;
	private Usuario usuario;
	private Pqr idPqr;
	private String descripcion;
	private Date fecha;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pqr getIdPqr() {
		return idPqr;
	}
	public void setIdPqr(Pqr idPqr) {
		this.idPqr = idPqr;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
