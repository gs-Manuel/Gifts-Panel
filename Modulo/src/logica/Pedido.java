package logica;

public class Pedido {

	private String idCLiente;
	private String codigoRegalo;
	private String fecha;
	private String observaciones;
	private Premio premio;

	/**
	 * Constructor
	 */
	public Pedido(Premio premio, String idCLiente, String fecha, String observaciones) {
		this.premio=premio;
		this.idCLiente = idCLiente;
		this.codigoRegalo = premio.getIdRegalo();
		this.fecha = fecha;
		this.observaciones = observaciones;
	}
	public Pedido(Premio premio, String id) {
		this.premio=premio;
		this.codigoRegalo = premio.getIdRegalo();
		this.idCLiente = id;
	}

	public Pedido(Pedido articuloDelCatalogo) {
		
	}
	@Override
	public String toString() {
		return premio.toString();
	}
	public String toStringFile() {
		if(this.fecha==null||this.fecha.equals("")) {
			if(this.observaciones==null||this.observaciones.equals("")){
				return this.idCLiente +"@"+ this.codigoRegalo+"\n";
			}
		}
		return this.idCLiente +"@"+ this.codigoRegalo+"@"+this.fecha+"@"+this.observaciones+"\n";
	}
	

}
