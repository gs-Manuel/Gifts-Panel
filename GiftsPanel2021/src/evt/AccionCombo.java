package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import igu.ImagenFactoria;
import igu.VentanaPrincipal;
import logica.Premio;


public class AccionCombo implements ActionListener{
	VentanaPrincipal vP;

	public AccionCombo(VentanaPrincipal vP) {
		this.vP = vP;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Premio a = (Premio) vP.getComboBox().getSelectedItem();
		ImagenFactoria.adaptarLabel(vP.getLblImagenPremio(), "src/img/"+a.getIdRegalo()+".png");
		vP.getTextPaneDescripcion().setText(a.getDescripcion());
		tienePuntos();
	}
	public void tienePuntos() {
		if((vP.getJuego().tienePuntos(((Premio) vP.getComboBox().getSelectedItem()).getPuntos()))) {
			vP.getBtnAñadir().setEnabled(true);
		}
		else{
			vP.getBtnAñadir().setEnabled(false);
		}
	}
}
