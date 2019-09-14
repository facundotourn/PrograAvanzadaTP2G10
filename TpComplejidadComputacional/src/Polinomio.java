
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
		System.out.println(p.evaluarHorner(7));
		System.out.println(p.evaluarRecursivaPar(7));
		System.out.println(p.evaluarProgDinamica(7));
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

			res += this.coeficientes[i] * aux;
		}
		return res;
	}

	double evaluarRecursiva(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++)
			res += this.coeficientes[i] * potenciaRecursiva(x, this.grado - i);

		return res;
	}

	private double potenciaRecursiva(double x, int exp) {
		if (exp == 0)
			return 1;

		return x * potenciaRecursiva(x, exp - 1);
	}

	double evaluarRecursivaPar(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++)
			res += this.coeficientes[i] * potenciaRecursivaPar(x, this.grado - i);

		return res;
	}

	private double potenciaRecursivaPar(double x, int exp) {
		if (exp == 0)
			return 1;

		if (exp % 2 == 0)
			return potenciaRecursivaPar(x * x, exp / 2);
		else
			return x * potenciaRecursivaPar(x, exp - 1);
	}

	double evaluarProgDinamica(double x) {
		double res = 0;
		double[] arr = new double[this.coeficientes.length];

		// Inicializo el array en 1, para que pueda hacer el producto
		arr[0] = 1;
		for (int i = 1; i <= this.grado; i++) {
			arr[i] = x * arr[i - 1];
		}

		// Ahora ya tengo las potencias, paso a calcular mi resultado
		for (int i = 0; i <= this.grado; i++) {
			res += arr[i] * this.coeficientes[this.grado - i];
		}
		
		return res;
	}

	/*
	 * double evaluarMejorada(double x) { }
	 */
	double evaluarPow(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			res += this.coeficientes[i] * Math.pow(x, this.grado - i);
		}

		return res;
	}

	double evaluarHorner(double x) {
		double resultado = 0;

		for (int i = 0; i <= this.grado; i++) {
			resultado = resultado * x + this.coeficientes[i];
		}
		return resultado;
	}

}
