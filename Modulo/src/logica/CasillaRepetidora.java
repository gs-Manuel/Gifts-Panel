package logica;

public class CasillaRepetidora extends Casilla{
	@Override
	public int quitarTirada(int tiradas) {
		return tiradas;
	}

	@Override
	public int sumarPuntos(int puntos) {
		return puntos;
	}

	@Override
	public String toString() {
		return "+1";
	}
	

}
