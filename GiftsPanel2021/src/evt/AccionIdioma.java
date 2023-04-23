package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;

import igu.VentanaPrincipal;

public class AccionIdioma implements ActionListener{
	VentanaPrincipal vP;
	public AccionIdioma(VentanaPrincipal vP) {
		this.vP=vP;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String idioma = b.getActionCommand();
		switch (idioma) {
		case ("es"):{
			Locale localizacion = new Locale("es");
			vP.localizar(localizacion);
			break;
		}
		case ("en"):
			Locale localizacion = new Locale("en");
			vP.localizar(localizacion);
			break;
		}
	}
}