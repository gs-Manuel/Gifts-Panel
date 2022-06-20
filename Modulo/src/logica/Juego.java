package logica;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	private Panel panel = null;
	private int puntos;
	private int tiradas = 3;
	private Cliente cliente;
	private ArrayList<Cliente> totalClientes;
	private ArrayList<Premio> totalPremios;
	private Pedido pedido;
	private Entrega entrega;
	private ArrayList<Premio>filtrado = new ArrayList<Premio>();

	/**
	 * Constructor
	 */
	public Juego() {
		panel = new Panel();
		totalPremios = new ArrayList<Premio>();
		totalClientes = new ArrayList<Cliente>();
		totalClientes = (ArrayList<Cliente>) FileUtil.loadFileCliente("files/clientes.dat", totalClientes);
		totalPremios = (ArrayList<Premio>) FileUtil.loadFilePremio("files/regalos.dat", totalPremios);
		entrega = new Entrega();
		copiaFiltro();
	}
	public boolean tienePuntos(int puntosPremio) {
		if(puntosPremio <= puntos) {
			return true;
		}
		return false;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void añadirACesta(Premio premio) {
		Pedido pedido = new Pedido(premio, cliente.getId());
		entrega.add(pedido);
		puntos = puntos - premio.getPuntos();
	}
	public void añadirACesta(Premio premio, String observaciones, String fecha) {
		Pedido pedido = new Pedido(premio, cliente.getId(), observaciones, fecha);
		entrega.add(pedido);
	}
	public ArrayList<Premio> getFiltrado(){
		return filtrado;
	}
	public void setFiltrado(ArrayList<Premio> filtro) {
		this.filtrado=filtro;
	}
	public void copiaFiltro() {
		for(int i=0; i<totalPremios.size(); i++) {
			filtrado.add(totalPremios.get(i));
		}
	}
	public Premio[] getArticulos(char tipo) {
		ArrayList<Premio>filtroTipo = new ArrayList<Premio>();
		for(Premio a : filtrado) {
			if(a.getSeccion()==tipo) {
				filtroTipo.add(a);
			}
		}
		Premio[] filtro = filtroTipo.toArray(new Premio[filtroTipo.size()]);
		return filtro;
	}
	public Premio[] getArticulos() {
		filtrado.clear();
		for(Premio a:getTotalPremios()) {
			if(a.getPuntos()<=getPuntos()) {
				filtrado.add(a);
			}
		}
		Premio[] filtro = filtrado.toArray(new Premio[filtrado.size()]);
		return filtro;
	}
	
	public ArrayList<Premio> getTotalPremios(){
		return totalPremios;
	}
	public Premio[] getTotalPremiosVector(){
		Premio[] filtro = getTotalPremios().toArray(new Premio[getTotalPremios().size()]);
		return filtro;
	}
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getTiradas() {
		return tiradas;
	}

	public void setTiradas(int tiradas) {
		this.tiradas = tiradas;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public Panel getPanel() {
		return panel;
	}

	/**
	 * Metodo que comprueba la posicion de la casilla que se le pasa por parámetro y
	 * suma los puntos correspondientes
	 * 
	 * @param a
	 */
	public void tirar(int a) {
		Casilla c = panel.getCasillas().get(a);
		puntos = c.sumarPuntos(getPuntos());
		tiradas = c.quitarTirada(tiradas);
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return panel.toString();
	}

	/*
	 * TODO: Metodos únicos
	 */
	/**
	 * Comprueba si el cliente dado puede existe en la base de datos y tiene
	 * permitido jugar
	 * 
	 * @param id
	 * @return
	 */
	public int CompruebaCliente(String id) {
		int error = -1;
		boolean encontrado = false;
		boolean correcto = false;
		for (int i = 0; i < totalClientes.size(); i++) {
			if (totalClientes.get(i).getId().equals(id)) {
				if (totalClientes.get(i).PuedeJugar()) {
					cliente = totalClientes.get(i);
					cliente.setPuedeJugar(0);
					correcto = true;
					error = 0;
				}
				encontrado = true;
			}
		}
		if(encontrado == false) {
			error = 4;
		}
		if (encontrado == true && correcto == false){
			error = 5;
		}
		
		return error;
	}
	/**
	 * Actualiza el fichero de clientes con los que pueden jugar y los que no
	 * @param id
	 * @return
	 */
	public void actualizaFichero() {
		FileUtil.saveToFileCliente("clientes.dat", totalClientes);
	
	}
	public void actualizaEntrega() {
		FileUtil.saveToFileEntrega("entregas.dat", entrega);
		
	}

	public int compruebaDatos(String id) {
		if (id == null) {
			return 1;
		} else if (id.equals("")) {
			return 2;
		} else if (id.length() != 6) {
			return 3;
		}
		return 0;
	}

}
