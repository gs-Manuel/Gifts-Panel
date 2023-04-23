package logica;

import java.util.ArrayList;
import java.util.Collections;

public class Panel {

	// Atributos

	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();;
	
	// Modificadores

	public ArrayList<Casilla> getCasillas() {
		return casillas; 
	}

	public void setCasillas(ArrayList<Casilla> casillas) {
		this.casillas = casillas;
	}
	
	public Casilla getCasilla(int pos) {
		return casillas.get(pos);
	}

	//Constructor
	public Panel() {
		casillas.add(new CasillaSuma(1000));
		casillas.add(new CasillaSuma(250));
		casillas.add(new CasillaSuma(250));
		casillas.add(new CasillaSuma(250));
		casillas.add(new CasillaSuma(250));
		casillas.add(new CasillaSuma(250));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaSuma(50));
		casillas.add(new CasillaMultiplicadora());
		casillas.add(new CasillaRepetidora());
		casillas.add(new CasillaRepetidora());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		casillas.add(new CasillaVacia());
		desordenar();
	}

	/**
	 * Metodos unicos
	 */
	public void desordenar() {
		Collections.shuffle(casillas);
	}
	@Override
	public String toString() {
		return "Panel [casillas=" + casillas + "]";
	}

}
