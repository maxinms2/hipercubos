package redHipercubos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cubos extends JFrame implements ActionListener {

	Map<String, NodoRuta> nodosRuta = new HashMap();
	String nodoIni = "";
	String[] camino = null;
	NodoRuta nrIni = null;
	NodoRuta nrFin = null;
	NodoRuta nrIniT = null;
	NodoRuta nrFinT = null;
	int incrT = 0;
	String nodoIni2 = "";
	String[] camino2 = null;
	NodoRuta nrIni2 = null;
	NodoRuta nrFin2 = null;
	NodoRuta nrIni2T = null;
	NodoRuta nrFin2T = null;
	String cadCamino = "";
	String cadCamino2 = "";
	int deface = 3;

	Long slepi = 0l;

	Boolean disponible = false;
	List<NodoLista> nodoLista1;
	List<NodoLista> nodoLista2;
	List<NodoLista> nodoLista1T;
	List<NodoLista> nodoLista2T;
	static Object bloqueo = new Object();
	static Object bloqueo2 = new Object();

	static private Polygon[] Poliedro, Poliedro2; // Polígono de la clase Polygon

	static int[] CoordenadasX1 = { 200, 400, 400, 200 };
	static int[] CoordenadasY1 = { 200, 200, 400, 400 };

	static int[] CoordenadasX2 = { 300, 500, 500, 300 };
	static int[] CoordenadasY2 = { 150, 150, 350, 350 };

	static int[] CoordenadasX3 = { 200, 300, 300, 200 };
	static int[] CoordenadasY3 = { 200, 150, 350, 400 };

	static int[] CoordenadasX4 = { 400, 500, 500, 400 };
	static int[] CoordenadasY4 = { 200, 150, 350, 400 };

	static int[] CoordenadasX5 = { 200, 400, 500, 300 };
	static int[] CoordenadasY5 = { 200, 200, 150, 150 };

	static int[] CoordenadasX6 = { 200, 400, 500, 300 };
	static int[] CoordenadasY6 = { 400, 400, 350, 350 };

//Cubo 2
	static int[] CoordenadasX7 = { 950, 750, 750, 950 };
	static int[] CoordenadasY7 = { 200, 200, 400, 400 };

	static int[] CoordenadasX8 = { 1050, 850, 850, 1050 };
	static int[] CoordenadasY8 = { 150, 150, 350, 350 };

	static int[] CoordenadasX9 = { 950, 1050, 1050, 950 };
	static int[] CoordenadasY9 = { 200, 150, 350, 400 };

	static int[] CoordenadasX10 = { 750, 850, 850, 750 };
	static int[] CoordenadasY10 = { 200, 150, 350, 400 };

	static int[] CoordenadasX11 = { 750, 950, 1050, 850 };
	static int[] CoordenadasY11 = { 200, 200, 150, 150 };

	static int[] CoordenadasX12 = { 750, 950, 1050, 850 };
	static int[] CoordenadasY12 = { 400, 400, 350, 350 };

	public Cubos() {
//Crea un polígono de tipo cubo
		Poliedro = new Polygon[6];
		Poliedro2 = new Polygon[6];

		Poliedro[0] = new Polygon(CoordenadasX1, CoordenadasY1, 4);
		Poliedro[1] = new Polygon(CoordenadasX2, CoordenadasY2, 4);
		Poliedro[2] = new Polygon(CoordenadasX3, CoordenadasY3, 4);
		Poliedro[3] = new Polygon(CoordenadasX4, CoordenadasY4, 4);
		Poliedro[4] = new Polygon(CoordenadasX5, CoordenadasY5, 4);
		Poliedro[5] = new Polygon(CoordenadasX6, CoordenadasY6, 4);

// implementar para poliedro 2

		Poliedro2[0] = new Polygon(CoordenadasX7, CoordenadasY7, 4);
		Poliedro2[1] = new Polygon(CoordenadasX8, CoordenadasY8, 4);
		Poliedro2[2] = new Polygon(CoordenadasX9, CoordenadasY9, 4);
		Poliedro2[3] = new Polygon(CoordenadasX10, CoordenadasY10, 4);
		Poliedro2[4] = new Polygon(CoordenadasX11, CoordenadasY11, 4);
		Poliedro2[5] = new Polygon(CoordenadasX12, CoordenadasY12, 4);

		setLayout(null);

		textfield1 = new JTextField("0000,0111");
		textfield1.setBounds(200 + 230, 500, 150, 25);
		add(textfield1);
		textfield2 = new JTextField("0010,0101");
		textfield2.setBounds(200 + 230, 500 + 30, 150, 25);
		add(textfield2);
		boton1 = new JButton("Aceptar");
		boton1.setBounds(500 + 100, 500, 100, 30);
		add(boton1);
		boton1.addActionListener(this);

		// H,D,V,S
		nodosRuta.put("0000",
				new NodoRuta("0000", new Point(CoordenadasX5[3], CoordenadasY5[3]), "0001", "0010", "0100", "1000"));
		nodosRuta.put("0001",
				new NodoRuta("0001", new Point(CoordenadasX5[2], CoordenadasY5[2]), "0000", "0011", "0101", "1001"));
		nodosRuta.put("0010",
				new NodoRuta("0010", new Point(CoordenadasX5[0], CoordenadasY5[0]), "0011", "0000", "0110", "1010"));
		nodosRuta.put("0011",
				new NodoRuta("0011", new Point(CoordenadasX5[1], CoordenadasY5[1]), "0010", "0001", "0111", "1011"));
		// H,D,V,S
		nodosRuta.put("0100",
				new NodoRuta("0100", new Point(CoordenadasX6[3], CoordenadasY6[3]), "0101", "0110", "0000", "1100"));
		nodosRuta.put("0101",
				new NodoRuta("0101", new Point(CoordenadasX6[2], CoordenadasY6[2]), "0100", "0111", "0001", "1101"));
		nodosRuta.put("0110",
				new NodoRuta("0110", new Point(CoordenadasX6[0], CoordenadasY6[0]), "0111", "0100", "0010", "1110"));
		nodosRuta.put("0111",
				new NodoRuta("0111", new Point(CoordenadasX6[1], CoordenadasY6[1]), "0110", "0101", "0011", "1111"));
		// H,D,V,S
		nodosRuta.put("1000",
				new NodoRuta("1000", new Point(CoordenadasX11[3], CoordenadasY11[3]), "1001", "1010", "1100", "0000"));
		nodosRuta.put("1001",
				new NodoRuta("1001", new Point(CoordenadasX11[2], CoordenadasY11[2]), "1000", "1011", "1101", "0001"));
		nodosRuta.put("1010",
				new NodoRuta("1010", new Point(CoordenadasX11[0], CoordenadasY11[0]), "1011", "1000", "1110", "0010"));
		nodosRuta.put("1011",
				new NodoRuta("1011", new Point(CoordenadasX11[1], CoordenadasY11[1]), "1010", "1001", "1111", "0011"));
		// H,D,V,S
		nodosRuta.put("1100",
				new NodoRuta("1100", new Point(CoordenadasX12[3], CoordenadasY12[3]), "1101", "1110", "1000", "0100"));
		nodosRuta.put("1101",
				new NodoRuta("1101", new Point(CoordenadasX12[2], CoordenadasY12[2]), "1100", "1111", "1001", "0101"));
		nodosRuta.put("1110",
				new NodoRuta("1110", new Point(CoordenadasX12[0], CoordenadasY12[0]), "1111", "1100", "1010", "0110"));
		nodosRuta.put("1111",
				new NodoRuta("1111", new Point(CoordenadasX12[1], CoordenadasY12[1]), "1110", "1101", "1011", "0111"));

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white); // Color Blanco
//Rellena el fondo de color Blanco
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.PINK); // Color Cubo

//Dibuja un polígono 
		g.drawPolygon(Poliedro[0]);
		g.drawPolygon(Poliedro[1]);
		g.drawPolygon(Poliedro[2]);
		g.drawPolygon(Poliedro[3]);
//g.fillPolygon(Poliedro[1]);
		g.drawPolygon(Poliedro[4]);
		g.drawPolygon(Poliedro[5]);

// Dibuja poligono 2
		g.drawPolygon(Poliedro2[0]);
		g.drawPolygon(Poliedro2[1]);
		g.drawPolygon(Poliedro2[2]);
		g.drawPolygon(Poliedro2[3]);
//g.fillPolygon(Poliedro[1]);
		g.drawPolygon(Poliedro2[4]);
		g.drawPolygon(Poliedro2[5]);
//g.fillPolygon(Poliedro[2]);

		g.setColor(Color.gray);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("0000", 255, 148);
		g.drawString("0001", 500, 150);
		g.drawString("0010", 180, 200);
		g.drawString("0011", 365, 200);
		g.drawString("0100", 255, 350);
		g.drawString("0101", 500, 350);
		g.drawString("0110", 180, 430);
		g.drawString("0111", 365, 430);
		g.drawString("Ingresa el nodo emisor y receptor separado por coma»", 200, getHeight() / 4 * 3 + 21);

		g.drawString("N= no existe,H=horizontal, V=vertical, D=diagonal, S=Salto ", 200 + 600,
				getHeight() / 4 * 3 + 21);
		g.drawString("Nodo emisor, receptor 1: ", 200, getHeight() / 4 * 3 + 60);
		g.drawString("Nodo emisor, receptor 2: ", 200, getHeight() / 4 * 3 + 90);

		g.drawString(textfield1.getText(), 200 + 300, getHeight() / 4 * 3 + 60);
		g.drawString(textfield2.getText(), 200 + 300, getHeight() / 4 * 3 + 90);

		g.drawString(cadCamino, 200 + 600, getHeight() / 4 * 3 + 60);
		g.drawString(cadCamino2, 200 + 600, getHeight() / 4 * 3 + 90);
		// PINTAR NODOS HIPERCUBO 2

		g.drawString("1000", 820, 148);
		g.drawString("1001", 1050, 150);
		g.drawString("1010", 730, 200);
		g.drawString("1011", 920, 200);
		g.drawString("1100", 800, 350);
		g.drawString("1101", 1050, 350);
		g.drawString("1110", 730, 430);
		g.drawString("1111", 920, 430);
		g.setColor(Color.BLUE);

		if (nodoLista1 != null) {
			for (NodoLista nl : nodoLista1) {
				if (nl.getNrIni() != null && nl.getNrFin() != null) {
					g.drawLine(nl.getNrIni().getPunto().x + deface, nl.getNrIni().getPunto().y + deface,
							nl.getNrFin().getPunto().x + deface, nl.getNrFin().getPunto().y + deface);
				}
			}
		}

		g.setColor(Color.GREEN);
		if (nodoLista2 != null) {
			for (NodoLista nl : nodoLista2) {
				if (nl.getNrIni() != null && nl.getNrFin() != null) {
					g.drawLine(nl.getNrIni().getPunto().x - deface, nl.getNrIni().getPunto().y - deface,
							nl.getNrFin().getPunto().x - deface, nl.getNrFin().getPunto().y - deface);
				}
			}
		}
	}

	private JTextField textfield1;
	private JTextField textfield2;
	private JButton boton1;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			camino = getCamino(textfield1.getText(), true);
			camino2 = getCamino(textfield2.getText(), false);
			System.out.println();
			cadCamino = "";
			for (int i = 0; i < 4; i++) {
				System.out.print(camino[i] + " , ");
				cadCamino += camino[i] + " , ";
			}
			nrIni = nodosRuta.get(nodoIni);
			nrFin = null;
			nodoLista1 = new ArrayList<>();
			System.out.println();
			incrT = 0;
			nrIniT = nodosRuta.get(nodoIni);
			nrFinT = null;
			nodoLista1T = new ArrayList<>();
			for (String accion : camino) {
				// System.out.println("Hilo1: " + Thread.currentThread().getId());
				switch (accion) {
				case "H":
					nrFinT = nodosRuta.get(nrIniT.getH());
					break;
				case "D":
					nrFinT = nodosRuta.get(nrIniT.getD());
					break;
				case "V":
					nrFinT = nodosRuta.get(nrIniT.getV());
					break;
				case "S":
					nrFinT = nodosRuta.get(nrIniT.getS());
					break;
				default:
					nrFinT = new NodoRuta("N");
				}
				nodoLista1T.add(new NodoLista(nrIniT, nrFinT));

				if (!nrFinT.getNombre().equals("N")) {
					nrIniT = nrFinT;
				}

			}

			nrIni2 = nodosRuta.get(nodoIni2);
			nrFin2 = null;
			nodoLista2 = new ArrayList<>();
			nrIni2T = nodosRuta.get(nodoIni2);
			nrFin2T = null;
			nodoLista2T = new ArrayList<>();
			for (String accion : camino2) {
				switch (accion) {
				case "H":
					nrFin2T = nodosRuta.get(nrIni2T.getH());
					break;
				case "D":
					nrFin2T = nodosRuta.get(nrIni2T.getD());
					break;
				case "V":
					nrFin2T = nodosRuta.get(nrIni2T.getV());
					break;
				case "S":
					nrFin2T = nodosRuta.get(nrIni2T.getS());
					break;
				default:
					nrFin2T = new NodoRuta("N");
				}
				nodoLista2T.add(new NodoLista(nrIni2T, nrFin2T));

				if (!nrFin2T.getNombre().equals("N")) {
					nrIni2T = nrFin2T;
				}

			}
			System.out.println("----------temp1---------------" + nodoLista1T.size());
			for (NodoLista nl : nodoLista1T) {
				try {
					System.out.println(nl.getNrIni().getNombre() + "," + nl.getNrFin().getNombre());
				} catch (Exception ex) {
					System.out.println("N" + "," + "N");
				}

			}
			System.out.println("----------temp2---------------" + nodoLista2T.size());
			for (NodoLista nl : nodoLista2T) {
				try {
					System.out.println(nl.getNrIni().getNombre() + "," + nl.getNrFin().getNombre());
				} catch (Exception ex) {
					System.out.println("N" + "," + "N");

				}

			}

			System.out.println("-------------------------");
			Runnable run1 = () -> {

				for (String accion : camino) {
					switch (accion) {
					case "H":
						nrFin = nodosRuta.get(nrIni.getH());
						break;
					case "D":
						nrFin = nodosRuta.get(nrIni.getD());
						break;
					case "V":
						nrFin = nodosRuta.get(nrIni.getV());
						break;
					case "S":
						nrFin = nodosRuta.get(nrIni.getS());
						break;
					default:
						nrFin = null;
					}
					hilo1();
					try {
						System.out.println("sleepi hilo1: " + slepi);
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			};
			Thread t1 = new Thread(run1);
			t1.start();

			System.out.println();
			cadCamino2 = "";
			for (int i = 0; i < 4; i++) {
				System.out.print(camino2[i] + " , ");
				cadCamino2 += camino2[i] + " , ";
			}
			System.out.println();

			Runnable run2 = () -> {

				for (String accion : camino2) {
					switch (accion) {
					case "H":
						nrFin2 = nodosRuta.get(nrIni2.getH());
						break;
					case "D":
						nrFin2 = nodosRuta.get(nrIni2.getD());
						break;
					case "V":
						nrFin2 = nodosRuta.get(nrIni2.getV());
						break;
					case "S":
						nrFin2 = nodosRuta.get(nrIni2.getS());
						break;
					default:
						nrFin2 = null;
					}
					hilo2();

					try {
						System.out.println("sleepi hilo2: " + slepi);
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			};
			Thread t2 = new Thread(run2);
			t2.start();

		}

		boton1.setVisible(false);
		textfield1.setVisible(false);
		textfield2.setVisible(false);
	}

	public void painted(Boolean bl) {

		if (bl) {
			nodoLista1.add(new NodoLista(nrIni, nrFin));

			if (nrFin != null) {
				nrIni = nrFin;
			}

		} else {
			nodoLista2.add(new NodoLista(nrIni2, nrFin2));

			if (nrFin2 != null) {
				nrIni2 = nrFin2;
			}
		}
		System.out.println("flagHilo1: " + disponible);
		System.out.println("painted Hilo: " + Thread.currentThread().getId());
		System.out.println("incrementoT: " + incrT);
		System.out.println("nodolista1: " + nodoLista1.size());
		System.out.println("nodolista2: " + nodoLista2.size());
		try {
			System.out.println("nodolista1T: " + nodoLista1T.get(incrT).getNrIni().getNombre());
			System.out.println("nodolista1T: " + nodoLista1T.get(incrT).getNrFin().getNombre());
			System.out.println("nodolista2T: " + nodoLista2T.get(incrT).getNrIni().getNombre());
			System.out.println("nodolista2T: " + nodoLista2T.get(incrT).getNrFin().getNombre());
		} catch (Exception e) {

		}

		if (incrT < 4 && (((nodoLista1T.get(incrT).getNrIni().getNombre()
				.equals(nodoLista2T.get(incrT).getNrIni().getNombre())
				&& nodoLista1T.get(incrT).getNrFin().getNombre().equals(nodoLista2T.get(incrT).getNrFin().getNombre())
				|| (nodoLista1T.get(incrT).getNrIni().getNombre().equals(nodoLista2T.get(incrT).getNrFin().getNombre())
						&& nodoLista1T.get(incrT).getNrFin().getNombre()
								.equals(nodoLista2T.get(incrT).getNrIni().getNombre()))
						&& !(nodoLista1T.get(incrT).getNrIni().getNombre().equals("N")
								&& nodoLista1T.get(incrT).getNrFin().getNombre().equals("N")))

		))) {
			if (bl) {
				slepi = 4000l;
			} else {
				slepi = 10l;
			}
			repaint();
			System.out.println("puntos iguales");

		} else {
			repaint();
			slepi = 10l;
			System.out.println("puntos noooooooo iguales");
		}
		if (!bl) {
			incrT++;
		}
		System.out.println("sale painted Hilo1: " + Thread.currentThread().getId());
		System.out.println("---------------------------------");

	}

	public synchronized void hilo1() {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		painted(true);
		try {
			Thread.currentThread().sleep(slepi);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.disponible = true;
		notify();

	}

	public synchronized void hilo2() {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		painted(false);
		try {
			Thread.currentThread().sleep(slepi);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.disponible = false;
		notify();
	}

	public String[] getCamino(String cad, Boolean tipoNodo) {
		int[][] matriz = new int[4][2];
		String[] nodosSplit = cad.split(",");
		if (tipoNodo) {
			nodoIni = nodosSplit[0];
		} else {
			nodoIni2 = nodosSplit[0];
		}
		System.out.println("Nodo emisor");
		for (int j = 0; j < 4; j++) {
			String v = nodosSplit[0].substring(j, j + 1);
			matriz[j][0] = Integer.parseInt(nodosSplit[0].substring(j, j + 1));
		}
		System.out.println("Nodo receptor");
		for (int j = 0; j < 4; j++) {

			String v = nodosSplit[0].substring(j, j + 1);
			matriz[j][1] = Integer.parseInt(nodosSplit[1].substring(j, j + 1));
		}
		Nodo no = new Nodo();
		String[] camino = no.matri(matriz);
		return camino;

	}

}
