
public class Polinomio {
	private int grado;
	private double[] coeficientes;

//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n y la posicion n contiene al termino independiente. 
	public static void main(String[] args) {
		double[] arrP = {1,1,1 };
		Polinomio p = new Polinomio(arrP);
		System.out.println(p.evaluarMSucesivas(3));
	}

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length - 1;
	}

	double evaluarMSucesivas(double x) {
		int i, j;
		double res = 0, aux=0;
		System.out.println(coeficientes.length);
		for (i = 0; i < coeficientes.length; i++) {

			for (j = 0; j < coeficientes.length - i; j++) {
				aux = coeficientes[i] * x;
			}
			res += aux;
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
