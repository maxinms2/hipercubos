package redHipercubos;

public class NodoLista {
	private NodoRuta nrIni;
	private NodoRuta nrFin;
	public NodoLista(NodoRuta nrIni, NodoRuta nrFin) {
		super();
		this.nrIni = nrIni;
		this.nrFin = nrFin;
	}
	public NodoRuta getNrIni() {
		return nrIni;
	}
	public NodoRuta getNrFin() {
		return nrFin;
	}
	
	

}
