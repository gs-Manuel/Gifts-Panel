package logica;

public class Cliente {

	// Atributos

	private String id;
	private String nombre;
	private int puedeJugar;

	// Modificadores

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuedeJugar() {
		return puedeJugar;
	}

	public void setPuedeJugar(int puedeJugar) {
		this.puedeJugar = puedeJugar;
	}
	/**
	 * Metodo que retorna si puede o no jugar el cliente
	 * @return
	 */
	public boolean PuedeJugar() {
		if(puedeJugar == 0) {
			return false;
		}
		if(puedeJugar == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Constructor
	 * @param id
	 * @param nombre
	 * @param puedeJugar
	 */

	public Cliente(String id, String nombre, int puedeJugar) {
		this.id = id;
		this.nombre = nombre;
		this.puedeJugar = puedeJugar;
	}

	/**
	 * ToString
	 */

	@Override
	public String toString() {
		String strCliente;
		strCliente = this.id + " - " + this.nombre + " - ";
		if (this.puedeJugar == 0) {
			strCliente += "No puede jugar";
		}
		if(this.puedeJugar == 1) {
			strCliente += "Puede jugar";
		}
		return strCliente;
	}

	public String toStringFile() {
		String strCliente;
		strCliente = this.id + "@" + this.nombre + "@" + this.puedeJugar + "\n";
		return strCliente;
	}
}
