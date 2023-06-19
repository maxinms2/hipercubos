package redHipercubos;

import javax.swing.JFrame;

//Coordenadas en x para un polígono rojo
public class PruebaPoliedro {


	public static void main(String args[]) {

//Crea una nueva instancia de la clase Polys
		Cubos poliedro = new Cubos();
		

//Titulo del JFrame
		poliedro.setTitle("Red 2 Hipercubos");
//Operación de salida del JFrame
		poliedro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Tamaño del JFrame
		poliedro.setSize(1400, 650);
		poliedro.setLocationRelativeTo(null);
		

//Hace visible el JFrame en la pantalla
		poliedro.setVisible(true);

		//no.matri();
	}
}

