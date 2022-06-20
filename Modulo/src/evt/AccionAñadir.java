package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import igu.VentanaPrincipal;
import logica.Pedido;
import logica.Premio;

public class AccionA�adir implements ActionListener{
	VentanaPrincipal vP;

	public AccionA�adir(VentanaPrincipal vP) {
		this.vP = vP;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		puedeComprar();
	}
	public void puedeComprar() {
		Premio p = ((Premio) vP.getComboBox().getSelectedItem());
		if((vP.getJuego().tienePuntos(p.getPuntos()))) {
			vP.getBtnA�adir().setEnabled(true);
			vP.getJuego().a�adirACesta(p);
			vP.getTextFieldPuntosPremios().setText(vP.getJuego().getPuntos()+ "");
			vP.ActualizarModelo();
		}
	}
}
