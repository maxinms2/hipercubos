package redHipercubos;

import java.awt.Point;

public class NodoRuta implements Cloneable {
	private String nombre;
	private Point punto;
	private String H;
	private String D;
	private String V;
	private String S;
	
	

	public NodoRuta(String nombre) {
		this.nombre = nombre;
	}

	public NodoRuta(String nombre, Point punto, String h, String d, String v, String s) {
		this.nombre = nombre;
		this.punto = punto;
		H = h;
		D = d;
		V = v;
		S = s;
	}

	public String getNombre() {
		return nombre;
	}

	public Point getPunto() {
		return punto;
	}

	public String getH() {
		return H;
	}

	public String getD() {
		return D;
	}

	public String getV() {
		return V;
	}

	public String getS() {
		return S;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
