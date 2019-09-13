
public class Polinomio {
	private int grado;
	private double[] coeficientes;

//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n y la posicion n contiene al termino independiente. 
	public static void main(String[] args) {
		double[] arrP = { 8, 45, 6, 6, 2 };
		Polinomio p = new Polinomio(arrP);
		System.out.println(p.evaluarMSucesivas(7));
		System.out.println(p.evaluarPow(7));
		System.out.println(p.evaluarRecursiva(7));
		System.out.println(p.evaluarRecursivaPar(7));
	}

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length - 1;
	}

	double evaluarMSucesivas(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			double aux = 1;
			for (int j = 0; j <= this.grado - i - 1; j++) {
				aux *= x;
			}

			res += coeficientes[i] * aux;
		}
		return res;
	}

	double evaluarRecursiva(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++)
			res += coeficientes[i] * potenciaRecursiva(x, this.grado - i);
			
		return res;
	}

	private double potenciaRecursiva(double x, int exp) {
		if (exp == 0) return 1;
		
		return x * potenciaRecursiva(x, exp - 1);
	}
	
	double evaluarRecursivaPar(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++)
			res += coeficientes[i] * potenciaRecursivaPar(x, this.grado - i);
		
		return res;
	}
	
	private double potenciaRecursivaPar(double x, int exp) {
		if (exp == 0) return 1;
		
		if (exp % 2 == 0) 
			return potenciaRecursivaPar(x * x, exp / 2);
		else 
			return x * potenciaRecursivaPar(x, exp - 1);
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
