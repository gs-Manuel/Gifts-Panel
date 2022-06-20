package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import igu.VentanaPrincipal;
import logica.Pedido;
import logica.Premio;

public class AccionAñadir implements ActionListener{
	VentanaPrincipal vP;

	public AccionAñadir(VentanaPrincipal vP) {
		this.vP = vP;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		puedeComprar();
	}
	public void puedeComprar() {
		Premio p = ((Premio) vP.getComboBox().getSelectedItem());
		if((vP.getJuego().tienePuntos(p.getPuntos()))) {
			vP.getBtnAñadir().setEnabled(true);
			vP.getJuego().añadirACesta(p);
			vP.getTextFieldPuntosPremios().setText(vP.getJuego().getPuntos()+ "");
			vP.ActualizarModelo();
		}
	}
}
