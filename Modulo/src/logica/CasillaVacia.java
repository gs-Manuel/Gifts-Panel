package logica;

public class CasillaVacia extends Casilla{

	@Override
	public int sumarPuntos(int puntos) {
		return puntos;
	}

	@Override
	public int quitarTirada(int tiradas) {
		return tiradas -1;
	}

	@Override
	public String toString() {
		return 0 + "";
	}
	
}
