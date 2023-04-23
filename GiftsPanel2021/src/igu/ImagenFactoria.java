package igu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import logica.Casilla;
import logica.CasillaMultiplicadora;
import logica.CasillaRepetidora;
import logica.CasillaSuma;
import logica.CasillaVacia;

public class ImagenFactoria {
	
	private static final String IMAGEN_50= "src/img/Imagen_50.jpg";
	private static final String IMAGEN_250 = "src/img/Imagen_250.jpg";
	private static final String IMAGEN_1000 = "src/img/Imagen_1000.jpg";
	private static final String IMAGEN_VACIA = "src/img/Imagen_Vacia.jpg";
	private static final String IMAGEN_MULTIPLICADORA = "src/img/Imagen_x2.png";
	private static final String IMAGEN_REPETIDORA = "src/img/Imagen_Repetidora.jpg";

	
	
	/**
	 * Metodo que adapta la imagen de la ruta que se le pasa por parametro al tamaño
	 * del JLabel de la interfaz
	 * 
	 * @param label
	 * @param rutaImagen
	 */
	public static void adaptarLabel(JLabel label, String rutaImagen) {
		Image imgOriginal = null;
		try {
			imgOriginal = new ImageIcon((rutaImagen)).getImage();
		} catch (Exception e) {
			imgOriginal = new ImageIcon((rutaImagen)).getImage();
		}
		Image imgCarrito = imgOriginal.getScaledInstance((int) (label.getWidth()), (int) (label.getHeight()),
				Image.SCALE_FAST);

		label.setIcon(new ImageIcon(imgCarrito));

		label.setDisabledIcon(new ImageIcon(imgCarrito));
	}
	/**
	 * Metodo que adapta la imagen de la ruta que se le pasa por parametro al tamaño
	 * del JLabel de la interfaz
	 * 
	 * @param boton
	 * @param rutaImagen
	 */
	public static void adaptarButton(JButton boton, String rutaImagen) {
		Image imgOriginal = null;
		try {
			imgOriginal = new ImageIcon((rutaImagen)).getImage();
		} catch (Exception e) {
			imgOriginal = new ImageIcon((rutaImagen)).getImage();
		}
		Image imgCarrito = imgOriginal.getScaledInstance((int) (boton.getWidth()), (int) (boton.getHeight()),
				Image.SCALE_FAST);

		boton.setIcon(new ImageIcon(imgCarrito));

		boton.setDisabledIcon(new ImageIcon(imgCarrito));
	}
	public static String getImagen(Casilla casilla) {
		if(casilla instanceof CasillaSuma) {
			switch (((CasillaSuma) casilla).getPuntos()){
				case 50:
					return IMAGEN_50;
				case 250:
					return IMAGEN_250;
				case 1000:
					return IMAGEN_1000;
			}
		}
		else if (casilla instanceof CasillaMultiplicadora) {
			return IMAGEN_MULTIPLICADORA;
		}
		else if(casilla instanceof CasillaVacia) {
			return IMAGEN_VACIA;
		}
		else if(casilla instanceof CasillaRepetidora) {
			return IMAGEN_REPETIDORA;
		}
		return null;
	}
}
