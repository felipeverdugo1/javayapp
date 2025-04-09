package servlets;

public class Compra {
	private String golosina;
	private double precioUnidad;
	private int cantSeleccionada;

	public Compra(String golosina, double precioUnidad) {
		super();
		this.golosina = golosina;
		this.precioUnidad = precioUnidad;

	}

	public Compra(String golosina, double precioUnidad, int cantSeleccionada) {
		super();
		this.golosina = golosina;
		this.precioUnidad = precioUnidad;
		this.cantSeleccionada = cantSeleccionada;
	}

	public String getGolosina() {
		return golosina;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public int getCantSeleccionada() {
		return cantSeleccionada;
	}

}
