package evt;

import igu.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCesta implements ActionListener{
	VentanaPrincipal vP;

	public AccionCesta(VentanaPrincipal vP) {
		this.vP = vP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vP.getCardLayaout().show(vP.getPanelPrincipal(), "panelCesta");
		
	}
}

