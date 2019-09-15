package com.unlam.tp2;

import static java.lang.Math.*;

public class BinomioNewton {

	private double coefA;
	private double coefB;
	private int n;

	public BinomioNewton(double a, double b, int n) {
		this.coefA = a;
		this.coefB = b;
		this.n = n;
	}

	public double obtenerCoeficienteK(int k) {
		return pow(this.coefA, k) * pow(coefB, this.n - k) * combinatorio(this.n, k);

	}

	public double[] obtenerPolinomio() {
		double[] polinomio = new double[this.n + 1];

		for (int i = 0; i < polinomio.length; i++) {
			double aux = obtenerCoeficienteK(i);
			polinomio[polinomio.length - 1 - i] = aux;
		}

		return polinomio;
	}

	private double combinatorio(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

	//Complejidad O(n)
	private double factorial(int n) {

		if (n == 0 || n == 1)
			return 1;

		double fact = 1;
		for (int i = 0; i < n; i++) {
			fact *= n - i;
		}
		return fact;
	}
}
