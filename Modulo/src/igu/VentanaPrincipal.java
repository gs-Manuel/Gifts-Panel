package igu;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SwingConstants;
import evt.AccionContinuar;
import evt.AccionFiltro;
import evt.AccionIdioma;
import evt.AccionRetroceder;
import evt.AccionSiguiente;
import evt.EstadoCheckBox;
import evt.AccionAñadir;
import evt.AccionBotonPanel;
import evt.AccionCesta;
import evt.AccionCombo;
import logica.Entrega;
import logica.FileUtil;
import logica.Juego;
import logica.Pedido;
import logica.Premio;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.DropMode;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AccionIdioma aIdioma;
	private AccionContinuar aContinuar;
	private AccionBotonPanel ABP;
	private AccionCombo aCBx;
	private AccionCesta aCesta;
	private AccionFiltro aFiltro;
	private EstadoCheckBox eCheckBox;
	private AccionAñadir aAñadir;
	private AccionRetroceder aRetroceder;
	private AccionSiguiente aSiguiente;

	private CardLayout c = null;

	private ResourceBundle textos;

	private Juego juego;

	DefaultListModel<Pedido> modelo;

	private JPanel contentPane;
	private JPanel panelFijo;
	private JPanel panelPrincipal;
	private JPanel panelInicio;
	private JPanel panelJuego;
	private JLabel lblImagen;
	private JPanel panelIdiomas;
	private JButton btnES;
	private JButton btnEN;
	private JPanel panel_0;
	private JLabel lblAyuda;
	private JPanel panelAdaptativo1;
	private JLabel lblEspacio0;
	private JButton btnContinuar;
	private JLabel lblEspacio1;
	private JPanel panelTexto;
	private JPanel panel_1;
	private JLabel lblNombre;
	private JLabel lblIntroduccion;
	private JTextField textFieldUsuario;
	private JPanel panel_2;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JPanel panelInfo;
	private JPanel panelBotones;
	private JLabel lblPuntos;
	private JTextField textFieldPuntos;
	private JLabel lblTiradas;
	private JTextField textFieldTiradas;
	private JPanel panelCategorias;
	private JPanel panelCheckBox;
	private JCheckBox chckbxOptables;
	private JLabel lblPuntos1;
	private JCheckBox chckbxTodos;
	private JPanel panelAdaptativo2;
	private JTextField textFieldPuntosPremios;
	private JPanel panelCesta;
	private JPanel panelFiltros;
	private JPanel panelPremios;
	private JButton btnAlimentacion;
	private JButton btnDeportes;
	private JButton btnElectronica;
	private JButton btnJuguetes;
	private JButton btnViajes;
	private JPanel panelCombo;
	private JComboBox<Premio> comboBox;
	private JButton btnAñadir;
	private JButton btnCesta;
	private JPanel panelImagenPremio;
	private JPanel panelAdaptativo4;
	private JPanel panelAdaptativo3;
	private JLabel lblVacia;
	private JLabel lblImagenPremio;
	private JLabel lblVacia3;
	private JLabel lblNewLabel;
	private JPanel panelAdaptativo5;
	private JPanel panelAdaptativoPremios;
	private JPanel panelAdaptativoPuntos;
	private JPanel panelAdaptativoVolver;
	private JButton btnRetroceder;
	private JLabel lblVacia2;
	private JLabel lblVacia5;
	private JList<Pedido> listPremios;
	private JPanel panelEliminar;
	private JLabel lblNewLabel_1;
	private JButton btnSiguiente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JPanel panelPuntos;
	private JLabel lblVacia4;
	private JPanel panelObservaciones;
	private JLabel lblObservaciones;
	private JPanel panelDescripcion;
	private JLabel lblVacia6;
	private JTextPane textPaneDescripcion;
	private JTextPane textPaneObservaciones;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnVaciar;

	// TODO: Constructor
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/navidad.jpg")));
		setBackground(new Color(0, 0, 0));

		aIdioma = new AccionIdioma(this);
		aContinuar = new AccionContinuar(this);
		ABP = new AccionBotonPanel(this);
		aCesta = new AccionCesta(this);
		aCBx = new AccionCombo(this);
		eCheckBox = new EstadoCheckBox(this);
		aFiltro = new AccionFiltro(this);
		aAñadir = new AccionAñadir(this);
		aRetroceder = new AccionRetroceder(this);
		aSiguiente = new AccionSiguiente(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 660);
		juego = new Juego();
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelFijo(), BorderLayout.NORTH);
		contentPane.add(getPanelPrincipal(), BorderLayout.CENTER);
		Locale localizacion = Locale.getDefault(Locale.Category.FORMAT);
		localizar(localizacion);
	}

	public void localizar(Locale localizacion) {
		try {
			textos = ResourceBundle.getBundle("rcs/textos", localizacion);
		} catch (Exception e) {
			localizacion = new Locale("es");
			textos = ResourceBundle.getBundle("rcs/textos", localizacion);
			System.out.println("Except");
		}
		this.setTitle(textos.getString("vp.titulo"));
		lblAyuda.setText(textos.getString("vp.ayuda"));
		btnContinuar.setText(textos.getString("vp.continuar"));
		lblNombre.setText(textos.getString("vp.bienvenido"));
		lblIntroduccion.setText(textos.getString("vp.introduccion"));
		lblPuntos.setText(textos.getString("vj.puntosInicial"));
		lblTiradas.setText(textos.getString("vj.tiradas"));
		lblPuntos1.setText(textos.getString("vc.puntos"));
		btnAlimentacion.setText(textos.getString("vc.alimentacion"));
		btnDeportes.setText(textos.getString("vc.deportes"));
		btnElectronica.setText(textos.getString("vc.Electronica"));
		btnJuguetes.setText(textos.getString("vc.Juguetes"));
		btnViajes.setText(textos.getString("vc.Viajes"));
		chckbxOptables.setText(textos.getString("vc.optables"));
		chckbxTodos.setText(textos.getString("vc.todos"));
		btnAñadir.setText(textos.getString("vc.añadir"));
		btnCesta.setText(textos.getString("vc.cesta"));

		// String imagenBandera = "/img/" + ;
		// setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource(imagenBandera)));

		Date fechaHora = new Date();
		DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.LONG, localizacion);
		lblFecha.setText(formatoFecha.format(fechaHora) + "  ");

		DateFormat formatoHora = DateFormat.getTimeInstance(DateFormat.LONG, localizacion);
		lblHora.setText(formatoHora.format(fechaHora));
	}

	/**
	 * M�todo que dependiendo del entero que recibe por parametro, muestra por
	 * pantalla el tipo de problema que tiene
	 * 
	 * @param i
	 */
	public void enseñaMensaje(int i) {
		if (i == 1) {
			JOptionPane.showMessageDialog(this, getTextos().getString("vp.enseñaMensaje1"));
		}
		if (i == 2) {
			JOptionPane.showMessageDialog(this, getTextos().getString("vp.enseñaMensaje2"));
		}
		if (i == 3) {
			JOptionPane.showMessageDialog(this, getTextos().getString("vp.enseñaMensaje3"));
		}
		if (i == 4) {
			JOptionPane.showMessageDialog(this, getTextos().getString("vp.enseñaMensaje4"));
		}
		if (i == 5) {
			JOptionPane.showMessageDialog(this, getTextos().getString("vp.enseñaMensaje5"));
		}
	}

	public Juego getJuego() {
		return juego;
	}

	public CardLayout getCardLayaout() {
		return c;
	}

	public ResourceBundle getTextos() {
		return textos;
	}

	private JPanel getPanelFijo() {
		if (panelFijo == null) {
			panelFijo = new JPanel();
			panelFijo.setForeground(Color.BLACK);
			panelFijo.setBackground(new Color(152, 251, 152));
			panelFijo.add(getPanel_0());
			panelFijo.add(getPanel_1_1());
			panelFijo.add(getPanel_2());
			panelFijo.add(getPanelIdiomas());
		}
		return panelFijo;
	}

	// TODO: Panel Principal
	public JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setForeground(Color.BLACK);
			panelPrincipal.setBackground(Color.WHITE);
			c = new CardLayout();
			panelPrincipal.setLayout(c);
			panelPrincipal.add(getPanelInicio(), "panelInicio");
			panelPrincipal.add(getPanelJuego(), "panelJuego");
			panelPrincipal.add(getPanelCategorias(), "panelCategorias");
			panelPrincipal.add(getPanelCesta(), "panelCesta");
		}
		return panelPrincipal;
	}

	private JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setForeground(Color.BLACK);
			panelInicio.setBackground(Color.WHITE);
			panelInicio.setLayout(new GridLayout(3, 1, 0, 0));
			panelInicio.add(getPanelTexto());
			panelInicio.add(getLblAyuda());
			panelInicio.add(getPanel_1());
		}
		return panelInicio;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			lblImagen.setForeground(Color.BLACK);
			lblImagen.setBackground(Color.WHITE);
			lblImagen.setSize(new Dimension(60, 50));
			ImagenFactoria.adaptarLabel(lblImagen, "src/img/regalo.jpg");
		}
		return lblImagen;
	}

	private JPanel getPanelIdiomas() {
		if (panelIdiomas == null) {
			panelIdiomas = new JPanel();
			panelIdiomas.setForeground(Color.BLACK);
			panelIdiomas.setBackground(new Color(152, 251, 152));
			panelIdiomas.add(getBtnES());
			panelIdiomas.add(getBtnEN());
		}
		return panelIdiomas;
	}

	private JButton getBtnES() {
		if (btnES == null) {
			btnES = new JButton("");
			btnES.setHorizontalTextPosition(SwingConstants.CENTER);
			btnES.setSize(new Dimension(30, 30));
			btnES.setForeground(Color.BLACK);
			btnES.setBackground(Color.WHITE);
			btnES.setActionCommand("es");
			btnES.addActionListener(aIdioma);
			ImagenFactoria.adaptarButton(btnES, "src/img/Bandera_Espana.jpg");
		}
		return btnES;
	}

	private JButton getBtnEN() {
		if (btnEN == null) {
			btnEN = new JButton("");
			btnEN.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEN.setSize(new Dimension(30, 30));
			btnEN.setForeground(Color.BLACK);
			btnEN.setBackground(Color.WHITE);
			btnEN.setActionCommand("en");
			btnEN.addActionListener(aIdioma);
			ImagenFactoria.adaptarButton(btnEN, "src/img/Bandera_Inglaterra.jpg");
		}
		return btnEN;
	}

	private JPanel getPanel_0() {
		if (panel_0 == null) {
			panel_0 = new JPanel();
			panel_0.setForeground(Color.BLACK);
			panel_0.setBackground(new Color(152, 251, 152));
			panel_0.setBorder(null);
			panel_0.setLayout(new GridLayout(0, 2, 0, 0));
			panel_0.add(getLblImagen());
		}
		return panel_0;
	}

	private JLabel getLblAyuda() {
		if (lblAyuda == null) {
			lblAyuda = new JLabel("");
			lblAyuda.setFont(new Font("Arial", Font.BOLD, 15));
			lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAyuda;
	}

	private JPanel getPanel_1() {
		if (panelAdaptativo1 == null) {
			panelAdaptativo1 = new JPanel();
			panelAdaptativo1.setBackground(Color.WHITE);
			panelAdaptativo1.setLayout(new GridLayout(1, 3, 0, 0));
			panelAdaptativo1.add(getLblEspacio0());
			panelAdaptativo1.add(getBtnContinuar());
			panelAdaptativo1.add(getLblEspacio1());
		}
		return panelAdaptativo1;
	}

	private JLabel getLblEspacio0() {
		if (lblEspacio0 == null) {
			lblEspacio0 = new JLabel("");
			lblEspacio0.setBackground(Color.WHITE);
		}
		return lblEspacio0;
	}

	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("");
			btnContinuar.setEnabled(true);
			btnContinuar.addActionListener(aContinuar);
			btnContinuar.setForeground(new Color(0, 0, 0));
			btnContinuar.setBackground(new Color(152, 251, 152));
		}
		return btnContinuar;
	}

	private JLabel getLblEspacio1() {
		if (lblEspacio1 == null) {
			lblEspacio1 = new JLabel("");
			lblEspacio1.setBackground(Color.WHITE);
		}
		return lblEspacio1;
	}

	private JPanel getPanelTexto() {
		if (panelTexto == null) {
			panelTexto = new JPanel();
			panelTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelTexto.setBackground(Color.WHITE);
			panelTexto.setLayout(new GridLayout(1, 2, 0, 0));
			panelTexto.add(getLblIntroduccion());
			panelTexto.add(getTextFieldUsuario());
		}
		return panelTexto;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBackground(new Color(152, 251, 152));
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			panel_1.add(getLblNombre());
		}
		return panel_1;
	}

	public JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre del sujeto");
		}
		return lblNombre;
	}

	private JLabel getLblIntroduccion() {
		if (lblIntroduccion == null) {
			lblIntroduccion = new JLabel("");
			lblIntroduccion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIntroduccion;
	}

	public JTextField getTextFieldUsuario() {
		if (textFieldUsuario == null) {
			textFieldUsuario = new JTextField();
			textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			textFieldUsuario.setColumns(10);
			textFieldUsuario.requestFocus();
			textFieldUsuario.grabFocus();
		}
		return textFieldUsuario;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(152, 251, 152));
			panel_2.setLayout(new GridLayout(0, 2, 0, 0));
			panel_2.add(getLblFecha());
			panel_2.add(getLblHora());
		}
		return panel_2;
	}

	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("");
		}
		return lblFecha;
	}

	private JLabel getLblHora() {
		if (lblHora == null) {
			lblHora = new JLabel("");
		}
		return lblHora;
	}
	// TODO: Panel Juego

	public void crearBotones() {
		for (int i = 0; i < getJuego().getPanel().getCasillas().size(); i++) {
			panelBotones.add(nuevoBoton(i));
		}
		panelBotones.validate();
		repaint();
	}

	private JButton nuevoBoton(int i) {
		JButton bt = new JButton("");
		bt.setActionCommand(String.valueOf(i));
		bt.setEnabled(true);
		bt.setBackground(Color.LIGHT_GRAY);
		bt.addActionListener(ABP);
		bt.setSize(new Dimension(100, 100));
		ImagenFactoria.adaptarButton(bt, "src/img/interrogacion.jpg");
		return bt;
	}

	private JPanel getPanelJuego() {
		if (panelJuego == null) {
			panelJuego = new JPanel();
			panelJuego.setForeground(Color.BLACK);
			panelJuego.setBackground(Color.WHITE);
			panelJuego.setLayout(new BorderLayout(0, 0));
			panelJuego.add(getPanelInfo(), BorderLayout.NORTH);
			panelJuego.add(getPanelBotones(), BorderLayout.CENTER);
		}
		return panelJuego;
	}

	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.setBackground(Color.WHITE);
			panelInfo.add(getLblPuntos());
			panelInfo.add(getTextFieldPuntos());
			panelInfo.add(getLblTiradas());
			panelInfo.add(getTextFieldTiradas());
		}
		return panelInfo;
	}

	public JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(Color.WHITE);
			panelBotones.setLayout(new GridLayout(5, 5, 0, 0));
			crearBotones();
		}
		return panelBotones;
	}

	public JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("");
		}
		return lblPuntos;
	}

	public JTextField getTextFieldPuntos() {
		if (textFieldPuntos == null) {
			textFieldPuntos = new JTextField();
			textFieldPuntos.setText("0");
			textFieldPuntos.setBackground(Color.WHITE);
			textFieldPuntos.setEditable(false);
			textFieldPuntos.setColumns(10);
		}
		return textFieldPuntos;
	}

	public JLabel getLblTiradas() {
		if (lblTiradas == null) {
			lblTiradas = new JLabel("");
		}
		return lblTiradas;
	}

	public JTextField getTextFieldTiradas() {
		if (textFieldTiradas == null) {
			textFieldTiradas = new JTextField();
			textFieldTiradas.setText("3");
			textFieldTiradas.setColumns(10);
		}
		return textFieldTiradas;
	}

	// TODO: panel categorias
	private JPanel getPanelCategorias() {
		if (panelCategorias == null) {
			panelCategorias = new JPanel();
			panelCategorias.setBackground(Color.WHITE);
			panelCategorias.setLayout(new BorderLayout(0, 0));
			panelCategorias.add(getPanelCheckBox(), BorderLayout.NORTH);
			panelCategorias.add(getPanelAdaptativo2(), BorderLayout.CENTER);
		}
		return panelCategorias;
	}

	private JPanel getPanelCheckBox() {
		if (panelCheckBox == null) {
			panelCheckBox = new JPanel();
			panelCheckBox.setBackground(new Color(224, 255, 255));
			panelCheckBox.add(getChckbxOptables());
			panelCheckBox.add(getChckbxTodos());
			panelCheckBox.add(getLblPuntos1());
			panelCheckBox.add(getTextFieldPuntosPremios());
		}
		return panelCheckBox;
	}

	private JCheckBox getChckbxOptables() {
		if (chckbxOptables == null) {
			chckbxOptables = new JCheckBox("");
			chckbxOptables.setActionCommand("Optables");
			chckbxOptables.addItemListener(eCheckBox);
		}
		return chckbxOptables;
	}

	private JLabel getLblPuntos1() {
		if (lblPuntos1 == null) {
			lblPuntos1 = new JLabel("New label");
		}
		return lblPuntos1;
	}

	public JCheckBox getChckbxTodos() {
		if (chckbxTodos == null) {
			chckbxTodos = new JCheckBox("");
			chckbxTodos.setSelected(true);
			chckbxTodos.setActionCommand("Todos");
			chckbxTodos.addItemListener(eCheckBox);
		}
		return chckbxTodos;
	}

	private JPanel getPanelAdaptativo2() {
		if (panelAdaptativo2 == null) {
			panelAdaptativo2 = new JPanel();
			panelAdaptativo2.setBackground(Color.WHITE);
			panelAdaptativo2.setLayout(new BorderLayout(0, 0));
			panelAdaptativo2.add(getPanelFiltros(), BorderLayout.WEST);
			panelAdaptativo2.add(getPanelPremios(), BorderLayout.CENTER);
		}
		return panelAdaptativo2;
	}

	public JTextField getTextFieldPuntosPremios() {
		if (textFieldPuntosPremios == null) {
			textFieldPuntosPremios = new JTextField();
			textFieldPuntosPremios.setBackground(Color.WHITE);
			textFieldPuntosPremios.setEditable(false);
			textFieldPuntosPremios.setColumns(10);
		}
		return textFieldPuntosPremios;
	}

	public JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.setBackground(Color.WHITE);
			panelFiltros.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltros.add(getBtnAlimentacion());
			panelFiltros.add(getBtnDeportes());
			panelFiltros.add(getBtnElectronica());
			panelFiltros.add(getBtnJuguetes());
			panelFiltros.add(getBtnViajes());
		}
		return panelFiltros;
	}

	private JPanel getPanelPremios() {
		if (panelPremios == null) {
			panelPremios = new JPanel();
			panelPremios.setBackground(Color.WHITE);
			panelPremios.setLayout(new BorderLayout(0, 0));
			panelPremios.add(getPanelCombo_1(), BorderLayout.NORTH);
			panelPremios.add(getPanelImagenPremio(), BorderLayout.CENTER);
		}
		return panelPremios;
	}

	private JButton getBtnAlimentacion() {
		if (btnAlimentacion == null) {
			btnAlimentacion = new JButton("");
			btnAlimentacion.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
			btnAlimentacion.setForeground(new Color(0, 0, 0));
			btnAlimentacion.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAlimentacion.setSize(new Dimension(150, 90));
			btnAlimentacion.setActionCommand("A");
			btnAlimentacion.setBackground(new Color(224, 255, 255));
			btnAlimentacion.addActionListener(aFiltro);
		}
		return btnAlimentacion;
	}

	private JButton getBtnDeportes() {
		if (btnDeportes == null) {
			btnDeportes = new JButton("");
			btnDeportes.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
			btnDeportes.setForeground(new Color(0, 0, 0));
			btnDeportes.setHorizontalTextPosition(SwingConstants.CENTER);
			btnDeportes.setSize(new Dimension(150, 90));
			btnDeportes.setActionCommand("D");
			btnDeportes.setBackground(new Color(224, 255, 255));
			btnDeportes.addActionListener(aFiltro);
		}
		return btnDeportes;
	}

	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("");
			btnElectronica.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
			btnElectronica.setForeground(new Color(0, 0, 0));
			btnElectronica.setHorizontalTextPosition(SwingConstants.CENTER);
			btnElectronica.setSize(new Dimension(150, 90));
			btnElectronica.setActionCommand("E");
			btnElectronica.setBackground(new Color(224, 255, 255));
			btnElectronica.addActionListener(aFiltro);
		}
		return btnElectronica;
	}

	private JButton getBtnJuguetes() {
		if (btnJuguetes == null) {
			btnJuguetes = new JButton("");
			btnJuguetes.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
			btnJuguetes.setForeground(new Color(0, 0, 0));
			btnJuguetes.setHorizontalTextPosition(SwingConstants.CENTER);
			btnJuguetes.setSize(new Dimension(150, 90));
			btnJuguetes.setBackground(new Color(224, 255, 255));
			btnJuguetes.setActionCommand("J");
			btnJuguetes.addActionListener(aFiltro);
		}
		return btnJuguetes;
	}

	private JButton getBtnViajes() {
		if (btnViajes == null) {
			btnViajes = new JButton("");
			btnViajes.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
			btnViajes.setForeground(new Color(0, 0, 0));
			btnViajes.setHorizontalTextPosition(SwingConstants.CENTER);
			btnViajes.setBackground(new Color(224, 255, 255));
			btnViajes.setSize(new Dimension(150, 90));
			btnViajes.setActionCommand("V");
			btnViajes.addActionListener(aFiltro);
		}
		return btnViajes;
	}

	private JPanel getPanelCombo_1() {
		if (panelCombo == null) {
			panelCombo = new JPanel();
			panelCombo.setBackground(new Color(152, 251, 152));
			panelCombo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelCombo.add(getComboBox());
			panelCombo.add(getBtnAñadir());
			panelCombo.add(getBtnCesta_1());
		}
		return panelCombo;
	}

	public JComboBox<Premio> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<Premio>();
			comboBox.addActionListener(aCBx);
			DefaultComboBoxModel<Premio> modelo = new DefaultComboBoxModel<Premio>(getJuego().getTotalPremiosVector());
			comboBox.setModel(modelo);
			comboBox.setSelectedIndex(0);
		}
		return comboBox;
	}

	public JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("");
			btnAñadir.setEnabled(false);
			btnAñadir.setBackground(Color.WHITE);
			btnAñadir.addActionListener(aAñadir);
		}
		return btnAñadir;
	}

	private JPanel getPanelImagenPremio() {
		if (panelImagenPremio == null) {
			panelImagenPremio = new JPanel();
			panelImagenPremio.setLayout(new GridLayout(2, 1, 0, 0));
			panelImagenPremio.add(getPanelAdaptativo3());
			panelImagenPremio.add(getPanelAdaptativo4());
		}
		return panelImagenPremio;
	}

	private JPanel getPanelAdaptativo4() {
		if (panelAdaptativo4 == null) {
			panelAdaptativo4 = new JPanel();
			panelAdaptativo4.setBackground(Color.WHITE);
			panelAdaptativo4.setLayout(new GridLayout(0, 3, 0, 0));
			panelAdaptativo4.add(getLblVacia3());
			panelAdaptativo4.add(getPanelDescripcion());
			panelAdaptativo4.add(getLblVacia4());
		}
		return panelAdaptativo4;
	}

	private JPanel getPanelAdaptativo3() {
		if (panelAdaptativo3 == null) {
			panelAdaptativo3 = new JPanel();
			panelAdaptativo3.setBackground(Color.WHITE);
			panelAdaptativo3.setLayout(new GridLayout(1, 3, 0, 0));
			panelAdaptativo3.add(getLblVacia());
			panelAdaptativo3.add(getLblImagenPremio());
			panelAdaptativo3.add(getPanelObservaciones());
		}
		return panelAdaptativo3;
	}

	private JLabel getLblVacia() {
		if (lblVacia == null) {
			lblVacia = new JLabel("");
			lblVacia.setBackground(Color.WHITE);
		}
		return lblVacia;
	}

	public JLabel getLblImagenPremio() {
		if (lblImagenPremio == null) {
			lblImagenPremio = new JLabel("");
			lblImagenPremio.setIcon(null);
			lblImagenPremio.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagenPremio.setSize(new Dimension(95, 100));
		}
		return lblImagenPremio;
	}

	private JLabel getLblVacia3() {
		if (lblVacia3 == null) {
			lblVacia3 = new JLabel("");
			lblVacia3.setBackground(Color.WHITE);
		}
		return lblVacia3;
	}

	public boolean comboBoxVacio() {
		if (getComboBox().getItemCount() > 0) {
			getComboBox().setSelectedIndex(0);
			ImagenFactoria.adaptarLabel(getLblImagenPremio(),
					"src/img/" + ((Premio) getComboBox().getSelectedItem()).getIdRegalo() + ".png");
			getTextPaneDescripcion().setText(((Premio) getComboBox().getSelectedItem()).getDescripcion());
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "No tiene suficientes puntos para optar a premios de esta categor�a");
			return false;
		}
	}

	// TODO: Panel Cesta
	private JButton getBtnCesta_1() {
		if (btnCesta == null) {
			btnCesta = new JButton("");
			btnCesta.setBackground(Color.WHITE);
			btnCesta.addActionListener(aCesta);
		}
		return btnCesta;
	}

	private JPanel getPanelCesta() {
		if (panelCesta == null) {
			panelCesta = new JPanel();
			panelCesta.setBackground(Color.WHITE);
			panelCesta.setLayout(new BorderLayout(0, 0));
			panelCesta.add(getLblNewLabel(), BorderLayout.NORTH);
			panelCesta.add(getPanelAdaptativo5(), BorderLayout.CENTER);
		}
		return panelCesta;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tu cesta de regalos");
			lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}

	private JPanel getPanelAdaptativo5() {
		if (panelAdaptativo5 == null) {
			panelAdaptativo5 = new JPanel();
			panelAdaptativo5.setBackground(Color.WHITE);
			panelAdaptativo5.setLayout(new GridLayout(3, 1, 0, 0));
			panelAdaptativo5.add(getPanel_3());
			panelAdaptativo5.add(getPanel_3_1());
			panelAdaptativo5.add(getPanelAdaptativoVolver());
		}
		return panelAdaptativo5;
	}

	private JPanel getPanel_3() {
		if (panelAdaptativoPremios == null) {
			panelAdaptativoPremios = new JPanel();
			panelAdaptativoPremios.setBackground(Color.WHITE);
			panelAdaptativoPremios.setLayout(new GridLayout(1, 4, 0, 0));
			panelAdaptativoPremios.add(getScrollPane());
			panelAdaptativoPremios.add(getPanelEliminar());
		}
		return panelAdaptativoPremios;
	}

	private JPanel getPanel_3_1() {
		if (panelAdaptativoPuntos == null) {
			panelAdaptativoPuntos = new JPanel();
			panelAdaptativoPuntos.setBackground(Color.WHITE);
			panelAdaptativoPuntos.setLayout(new GridLayout(0, 4, 0, 0));
			panelAdaptativoPuntos.add(getLblNewLabel_1());
			panelAdaptativoPuntos.add(getLblNewLabel_2());
			panelAdaptativoPuntos.add(getPanelPuntos());
			panelAdaptativoPuntos.add(getLblNewLabel_4());
		}
		return panelAdaptativoPuntos;
	}

	private JPanel getPanelAdaptativoVolver() {
		if (panelAdaptativoVolver == null) {
			panelAdaptativoVolver = new JPanel();
			panelAdaptativoVolver.setBackground(Color.WHITE);
			panelAdaptativoVolver.setLayout(new GridLayout(0, 4, 0, 0));
			panelAdaptativoVolver.add(getLblVacia2());
			panelAdaptativoVolver.add(getBtnRetroceder());
			panelAdaptativoVolver.add(getBtnSiguiente());
			panelAdaptativoVolver.add(getLblVacia5());
		}
		return panelAdaptativoVolver;
	}

	private JButton getBtnRetroceder() {
		if (btnRetroceder == null) {
			btnRetroceder = new JButton("Retroceder");
			btnRetroceder.setFont(new Font("Arial", Font.BOLD, 13));
			btnRetroceder.setBackground(new Color(250, 128, 114));
			btnRetroceder.addActionListener(aRetroceder);
		}
		return btnRetroceder;
	}

	private JLabel getLblVacia2() {
		if (lblVacia2 == null) {
			lblVacia2 = new JLabel("");
			lblVacia2.setBackground(Color.WHITE);
		}
		return lblVacia2;
	}

	private JLabel getLblVacia5() {
		if (lblVacia5 == null) {
			lblVacia5 = new JLabel("");
			lblVacia5.setBackground(Color.WHITE);
		}
		return lblVacia5;
	}

	public JList<Pedido> getListPremios() {
		if (listPremios == null) {
			listPremios = new JList<Pedido>();
			modelo = new DefaultListModel<Pedido>();
			listPremios.setModel(modelo);
			listPremios.setForeground(Color.BLACK);
			listPremios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return listPremios;
	}

	public DefaultListModel<Pedido> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<Pedido> modelo) {
		this.modelo = modelo;
	}

	private JPanel getPanelEliminar() {
		if (panelEliminar == null) {
			panelEliminar = new JPanel();
			panelEliminar.setBackground(Color.WHITE);
			panelEliminar.add(getBtnEliminar());
			panelEliminar.add(getBtnVaciar());
		}
		return panelEliminar;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Imagen");
		}
		return lblNewLabel_1;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Continuar");
			btnSiguiente.addActionListener(aSiguiente);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(confirmarCancelacion()) {
						juego.actualizaEntrega();

					}
				}
			});
			btnSiguiente.setBackground(new Color(152, 251, 152));
			btnSiguiente.setForeground(new Color(0, 0, 0));
			btnSiguiente.setFont(new Font("Arial", Font.BOLD, 13));
		}
		return btnSiguiente;
	}

	protected boolean confirmarCancelacion() {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(this, "Confirmar pedido");
		if(resp == JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
		
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Descripcion");
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
		}
		return lblNewLabel_4;
	}

	private JPanel getPanelPuntos() {
		if (panelPuntos == null) {
			panelPuntos = new JPanel();
			panelPuntos.setBackground(new Color(255, 255, 255));
		}
		return panelPuntos;
	}

	private JLabel getLblVacia4() {
		if (lblVacia4 == null) {
			lblVacia4 = new JLabel("");
		}
		return lblVacia4;
	}

	private JPanel getPanelObservaciones() {
		if (panelObservaciones == null) {
			panelObservaciones = new JPanel();
			panelObservaciones.setBackground(Color.WHITE);
			panelObservaciones.setLayout(new GridLayout(2, 1, 0, 0));
			panelObservaciones.add(getLblObservaciones());
			panelObservaciones.add(getTextPaneObservaciones());
		}
		return panelObservaciones;
	}

	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel("Observaciones al vendedor");
			lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lblObservaciones;
	}

	private JPanel getPanelDescripcion() {
		if (panelDescripcion == null) {
			panelDescripcion = new JPanel();
			panelDescripcion.setBackground(Color.WHITE);
			panelDescripcion.setLayout(new GridLayout(2, 1, 0, 0));
			panelDescripcion.add(getLblVacia6());
			panelDescripcion.add(getTextPaneDescripcion());
		}
		return panelDescripcion;
	}

	private JLabel getLblVacia6() {
		if (lblVacia6 == null) {
			lblVacia6 = new JLabel("");
		}
		return lblVacia6;
	}

	public JTextPane getTextPaneDescripcion() {
		if (textPaneDescripcion == null) {
			textPaneDescripcion = new JTextPane();
			textPaneDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
			textPaneDescripcion.setEditable(false);
			textPaneDescripcion.setText("");
		}
		return textPaneDescripcion;
	}

	public JTextPane getTextPaneObservaciones() {
		if (textPaneObservaciones == null) {
			textPaneObservaciones = new JTextPane();
			textPaneObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		return textPaneObservaciones;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getListPremios());
		}
		return scrollPane;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					juego.getEntrega().remove(getListPremios().getSelectedValue());
					ActualizarModelo();
				}
			});
		}
		return btnEliminar;
	}

	public void ActualizarModelo() {
		ArrayList<Pedido> laEntrega = getJuego().getEntrega().getListaPedido();
		getModelo().removeAllElements();
		for (int i = 0; i < laEntrega.size(); i++) {
			getModelo().addElement(laEntrega.get(i));
		}
		getListPremios().setModel(getModelo());
		
	}

	private JButton getBtnVaciar() {
		if (btnVaciar == null) {
			btnVaciar = new JButton("Vaciar todo");
			btnVaciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					juego.getEntrega().removeEntrega();
					ActualizarModelo();
				}
			});
		}
		return btnVaciar;
	}
}
