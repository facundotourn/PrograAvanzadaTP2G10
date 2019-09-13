
public class Polinomio {
	private int grado;
	private double[] coeficientes;

//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n y la posicion n contiene al termino independiente. 
	public static void main(String[] args) {
		double[] arrP = { 5, -4, 1 };
		Polinomio p = new Polinomio(arrP);
		System.out.println(p.evaluarMSucesivas(7));
		System.out.println(p.evaluarPow(7));
		System.out.println(p.evaluarRecursiva(7));
	}

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length - 1;
	}

	double evaluarMSucesivas(double x) {
		int i, j;
		double res = 0, aux;
		for (i = 0; i <= this.grado; i++) {
			aux = 1;
			for (j = 0; j <= this.grado - i - 1; j++) {
				aux *= x;
			}

			res += coeficientes[i] * aux;
		}
		return res;
	}

	double evaluarRecursiva(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			res += coeficientes[i] * recursiva(x, grado - i);
		}
		return res;
	}

	private double recursiva(double x, int i) {
		if (i == 1) {
			return x;
		} else if (i == 0) {
			return 1;
		} else {

			return x * recursiva(x, i - 1);
		}
	}

	/*
	 * 
	 * double evaluarRecursivaPar(double x) { }
	 * 
	 * double evaluarProgDinamica(double x) { }
	 * 
	 * double evaluarMejorada(double x) { }
	 */
	double evaluarPow(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			res += this.coeficientes[i] * Math.pow(x, this.grado - i);
		}

		return res;
	}
	/*
	 * // y a sugerencia de Lucas P double evaluarHorner( double x) { ... }
	 */
}
