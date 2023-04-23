package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import igu.ImagenFactoria;
import igu.VentanaPrincipal;

public class AccionBotonPanel implements ActionListener {
	VentanaPrincipal vP;

	public AccionBotonPanel(VentanaPrincipal vP) {
		this.vP = vP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		int posicion = Integer.parseInt(b.getActionCommand());
		ImagenFactoria.adaptarButton(b, ImagenFactoria.getImagen(vP.getJuego().getPanel().getCasilla(posicion)));
		vP.getJuego().tirar(posicion);
		vP.getTextFieldPuntos().setText(vP.getJuego().getPuntos() + "");
		vP.getTextFieldTiradas().setText(vP.getJuego().getTiradas() + "");
		vP.getLblPuntos().setText(vP.getTextos().getString("vj.puntos"));
		inhabilitaBotones(b);
		finalizado();
	}

	public boolean puedeTirar() {
		if (vP.getJuego().getTiradas() > 0) {
			return true;
		} else
			return false;
	}
	public void inhabilitaBotones(JButton b) {
		b.setEnabled(false);
		if (!puedeTirar()) {
			for (int i = 0; i < vP.getJuego().getPanel().getCasillas().size(); i++) {
				vP.getPanelBotones().getComponent(i).setEnabled(false);
			}
		}
	}

	public void finalizado() {
		if (!puedeTirar()) {
			vP.getLblPuntos().setText(vP.getTextos().getString("vj.puntosFinal"));
			JOptionPane.showMessageDialog(vP, vP.getTextos().getString("vj.joptionpane0") +" "+ vP.getJuego().getPuntos()
					+" " + vP.getTextos().getString("vj.joptionpane1"));
			vP.getCardLayaout().show(vP.getPanelPrincipal(), "panelCategorias");
			vP.getTextFieldPuntosPremios().setText(vP.getJuego().getPuntos()+" ");
			ImagenFactoria.adaptarLabel(vP.getLblImagenPremio(), null);
		}
	}
}
