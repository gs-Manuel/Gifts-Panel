package evt;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import igu.VentanaPrincipal;
import logica.Premio;

public class EstadoCheckBox implements ItemListener {
	private VentanaPrincipal vP;

	public EstadoCheckBox(VentanaPrincipal vP) {
		this.vP = vP;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox cB = (JCheckBox) e.getSource();
		if (cB.getActionCommand().equals("Optables")) {
			if (cB.isSelected()) {
				DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(vP.getJuego().getArticulos());
				vP.getComboBox().setModel(modelo);
				vP.comboBoxVacio();
			} else {
				DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(
						vP.getJuego().getTotalPremiosVector());
				vP.getComboBox().setModel(modelo);
			}
		}
		if (cB.getActionCommand().equals("Todos")) {
			if (cB.isSelected()) {
				DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(
						vP.getJuego().getTotalPremiosVector());
				vP.getComboBox().setModel(modelo);
			} else {
				DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(
						vP.getJuego().getTotalPremiosVector());
				vP.getComboBox().setModel(modelo);
			}
		}
	}

}
