
public class Polinomio {
	private int grado;
	private double[] coeficientes;

//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n y la posicion n contiene al termino independiente. 
	public static void main(String[] args) {
		double[] arrP = { 0,1, 1 };
		Polinomio p = new Polinomio(arrP);
		System.out.println(p.evaluarMSucesivas(7));
	}

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length - 1;
	}

	double evaluarMSucesivas(double x) {
		int i, j;
		double res = 0, aux;
		for (i = 0; i < coeficientes.length; i++) {
			aux = 1;
			for (j = 0; j < coeficientes.length - i - 1; j++) {
				aux *= x;
			}

			res += coeficientes[i] * aux;
		}
		return res;
	}
	/*
	 * double evaluarRecursiva(double x) { }
	 * 
	 * double evaluarRecursivaPar(double x) { }
	 * 
	 * double evaluarProgDinamica(double x) { }
	 * 
	 * double evaluarMejorada(double x) { }
	 * 
	 * double evaluarPow(double x) { } // y a sugerencia de Lucas P double
	 * evaluarHorner( double x) { ... }
	 */
}
