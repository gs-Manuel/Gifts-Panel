package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import igu.VentanaPrincipal;

public class AccionContinuar implements ActionListener {
	VentanaPrincipal vP;

	public AccionContinuar(VentanaPrincipal vP) {
		this.vP = vP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vP.getJuego().compruebaDatos(vP.getTextFieldUsuario().getText()) == 0) {
			if (vP.getJuego().CompruebaCliente(vP.getTextFieldUsuario().getText())==0) {
				vP.getJuego().actualizaFichero();
				vP.getCardLayaout().show(vP.getPanelPrincipal(), "panelJuego");
				vP.getLblNombre().setText(
						vP.getTextos().getString("vp.bienvenido") + " " + vP.getJuego().getCliente().getNombre());
			}
			else{
				vP.enseñaMensaje(vP.getJuego().CompruebaCliente(vP.getTextFieldUsuario().getText()));
			}
		} else {
			vP.enseñaMensaje(vP.getJuego().compruebaDatos(vP.getTextFieldUsuario().getText()));
		}
	}
}
