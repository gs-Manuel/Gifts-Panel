package logica;

public class CasillaSuma extends Casilla{
	int puntos;
	
	public CasillaSuma(int puntos) {
		super();
		this.puntos = puntos;
	}
	public int getPuntos() {
		return puntos;
	}

	@Override
	public int sumarPuntos(int puntos) {
		return puntos+this.puntos;
	}

	@Override
	public int quitarTirada(int tiradas) {
		return tiradas -1;
	}
	@Override
	public String toString() {
		return puntos + "";
	}

}
