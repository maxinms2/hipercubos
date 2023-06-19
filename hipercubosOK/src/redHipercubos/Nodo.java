package redHipercubos;

public class Nodo {


	public String[] matri(int[][] matriz) {
		String[] accion = { "H", "D", "V", "S" };
		String[] camino = new String[4];

		int[] resultado = new int[4];
		for (int i = 0; i < 4; i++) {
			resultado[i] = matriz[i][0] ^ matriz[i][1];
		}

		System.out.println("La matriz resultante de aplicar XOR a cada fila es:");
		for (int i = 0; i < 4; i++) {
			System.out.print(resultado[i] + " ");
		}

		int j = 0;
		for (int i = 3; i >= 0; i--) {
			if (resultado[i] == 0) {
				camino[j] = "N";
			} else {
				camino[j] = accion[j];
			}
			j++;
		}
		return camino;

	}
}

