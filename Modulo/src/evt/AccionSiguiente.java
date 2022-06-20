package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import igu.VentanaPrincipal;

public class AccionSiguiente implements ActionListener{
	private VentanaPrincipal vP;
	public AccionSiguiente(VentanaPrincipal vp) {
		this.vP=vp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		vP = new VentanaPrincipal();
	}
}

