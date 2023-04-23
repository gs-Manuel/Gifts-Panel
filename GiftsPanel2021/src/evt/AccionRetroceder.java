package evt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import igu.VentanaPrincipal; 

public class AccionRetroceder implements ActionListener{
	private VentanaPrincipal vP;
	public AccionRetroceder(VentanaPrincipal vp) {
		this.vP=vp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		vP.getCardLayaout().show(vP.getPanelPrincipal(), "panelCategorias");
	}

}
