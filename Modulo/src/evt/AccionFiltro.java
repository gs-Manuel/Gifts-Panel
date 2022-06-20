package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import igu.ImagenFactoria;
import igu.VentanaPrincipal;
import logica.Premio;

public class AccionFiltro implements ActionListener {
	VentanaPrincipal vP;

	public AccionFiltro(VentanaPrincipal vP) {
		this.vP = vP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		char tipo = b.getActionCommand().charAt(0);
		DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(vP.getJuego().getArticulos(tipo));
		vP.getComboBox().setModel(modelo);
		vP.comboBoxVacio();
	}
}
