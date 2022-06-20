package logica;

public class Premio {

	private String idRegalo;
	private char seccion;
	private String denominacion;
	private String descripcion;
	private int puntos;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param denominacion
	 * @param descripcion
	 * @param seccion
	 * @param puntos
	 */

	public Premio(String id, char seccion, String denominacion, String descripcion, int puntos) {
		this.idRegalo = id;
		this.seccion = seccion;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
		this.puntos = puntos;
	}
	public char getSeccion() {
		return seccion;
	}
	public String getIdRegalo() {
		return idRegalo;
	}
	public void setIdRegalo(String idRegalo) {
		this.idRegalo = idRegalo;
	}
	public String toString() {
		return this.denominacion + " , " + this.puntos;
	}
	public int getPuntos() {
		return puntos;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
}
