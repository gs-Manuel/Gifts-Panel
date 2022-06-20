package igu;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal v = new VentanaPrincipal();
					v.setVisible(true);
					System.out.println(v.getJuego().getPanel().getCasillas());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
