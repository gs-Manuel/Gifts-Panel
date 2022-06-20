package logica;

import java.util.ArrayList;

public class Entrega {

	private ArrayList<Pedido> listaPedido;

	/**
	 * Constructor
	 */
	public Entrega() {
		listaPedido = new ArrayList<Pedido>();
	}

	// MetodosUnicos
	/**
	 * Añadir a la lista de entrega
	 * 
	 * @param articuloDelCatalogo
	 * @param unidades
	 */
	public void add(Pedido articuloDelCatalogo) {
		if (articuloDelCatalogo != null) {
			listaPedido.add(articuloDelCatalogo);
		}
	}

	public void remove(Pedido pedido) {
		listaPedido.remove(pedido);
	}
	public void removeEntrega() {
		listaPedido = new ArrayList<Pedido>();
	}

	public ArrayList<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(ArrayList<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	@Override
	public String toString() {
		String local= "";
		for(Pedido p:listaPedido) {
			local += p.toStringFile();
		}
		return local;
	}

}
