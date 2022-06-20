package logica;

public class CasillaMultiplicadora extends Casilla{

	@Override
	public int sumarPuntos(int puntos) {
		return puntos * 2;
	}

	@Override
	public int quitarTirada(int tiradas) {
		return tiradas -1;
	}

	@Override
	public String toString() {
		return "x2";
	}
     
}
