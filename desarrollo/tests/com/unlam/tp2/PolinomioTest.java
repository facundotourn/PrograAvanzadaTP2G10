package com.unlam.tp2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.unlam.tp2.Polinomio;

public class PolinomioTest {

	private Polinomio polinomio;
	private double coeficientes[] = { 8, 45, -6, 6, 2 };
	private double valores[] = { 2, 55, 478, 1829, 4858 };

	@Before
	public void inicio() {
		polinomio = new Polinomio(coeficientes);
	}

	@Test
	public void gradoCorrecto() {
		Assert.assertEquals(4, polinomio.getGrado(), 0);
	}

	@Test
	public void coeficientesCorrectos() {
		for (int i = 0; i < polinomio.getGrado(); i++) {
			Assert.assertEquals(this.coeficientes[i], polinomio.getCoeficientes()[i], 0);
		}
	}

	@Test
	public void evaluarMSucesivasTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarMSucesivas(i), 0);
		}
	}

	@Test
	public void evaluarRecursivaTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarRecursiva(i), 0);
		}
	}

	@Test
	public void evaluarRecursivaParTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarRecursivaPar(i), 0);
		}
	}

	@Test
	public void evaluarProgDinamicaTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarProgDinamica(i), 0);
		}
	}

	@Test
	public void evaluarMejoradaTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarMejorada(i), 0);
		}
	}

	@Test
	public void evaluarPowTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarPow(i), 0);
		}
	}

	@Test
	public void evaluarHornerTest() {
		for (int i = 0; i <= this.polinomio.getGrado(); i++) {
			Assert.assertEquals(this.valores[i], this.polinomio.evaluarHorner(i), 0);
		}
	}
}
