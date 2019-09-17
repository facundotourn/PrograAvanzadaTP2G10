import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.unlam.tp2.Polinomio;

public class TiempoEjecucionTest {
	private static int[] vec = { 1, 2, 10, 25, 50, 100, 250, 500, 1000, 1500, 2000, 1500, 2000, 2500, 5000, 10000 };
	private long tiemposPolys[][]; // Cada fila es un caso de cierto grado, cada columna es un método

	public TiempoEjecucionTest() {
		this.tiemposPolys = new long[vec.length][7];
	}

	public static void main(String[] args) throws IOException {
		TiempoEjecucionTest test = new TiempoEjecucionTest();
		for (int i = 0; i < vec.length; i++) {
			generarPolinomio(vec[i]);
		}
		test.medirPolys();
		test.grabarPolys("polySpeed.out");
	}

	public static void generarPolinomio(int grado) {
		try {
			FileWriter arch = new FileWriter("polinomio" + grado + ".in");
			PrintWriter pw = new PrintWriter(arch);

			System.out.println("Generando polinomio...");
			pw.println(String.valueOf(grado));
			for (int i = 0; i <= grado; i++) {
				pw.print(String.valueOf(1) + " ");
			}
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void medirPolinomio(Polinomio poly, int fila) {
		long start, end;
		int i;
		System.out.println(poly.getGrado());

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarMSucesivas(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][0] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarRecursiva(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][1] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarRecursivaPar(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][2] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarProgDinamica(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][3] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarMejorada(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][4] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarPow(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][5] = end - start;

		start = System.nanoTime();
		for (i = 0; i < 100; i++)
			poly.evaluarHorner(i);
		end = System.nanoTime();
		this.tiemposPolys[fila][6] = end - start;
	}

	public void medirPolys() {
		for (int i = 0; i < vec.length; i++)
			medirPolinomio(new Polinomio("polinomio" + vec[i] + ".in"), i);
	}

	public void grabarPolys(String path) throws IOException {
		PrintWriter arch = new PrintWriter(new FileWriter(path));
		arch.printf("%60s\n", "Tiempo en ms");
		arch.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "X", "MSucesivas", "Recursiva",
				"RecursivaPar", "PrograDinamica", "Mejorada", "Pow", "Horner");
		for (int i = 0; i < vec.length; i++) {
			arch.printf("%-15d\t", TiempoEjecucionTest.vec[i]);
			for (int j = 0; j < 7; j++) {
				arch.printf("%-15d\t", this.tiemposPolys[i][j]);
			}
			arch.println();
		}
		arch.close();
	}

}
