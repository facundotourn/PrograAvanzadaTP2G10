import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.unlam.tp2.BinomioNewton;

public class BinomioTest {

	private BinomioNewton binomio;
	double[] coeficientesObtenidos;
	double[] resultados = { 1, 9, 27, 27 };

	@Before
	public void inicio() {
		binomio = new BinomioNewton(1, 3, 3);
	}

	@Test
	public void gradoCorrecto() {
		coeficientesObtenidos = binomio.obtenerPolinomio();
		assertEquals(4, coeficientesObtenidos.length);
	}

	@Test
	public void coeficientesCorrecto() {
		coeficientesObtenidos = binomio.obtenerPolinomio();
		for (int i = 0; i < coeficientesObtenidos.length; i++) {
			assertEquals(coeficientesObtenidos[i], resultados[i], 0);
		}
	}

	@Test
	public void ObtenerCoeficientePorPosicion() {
		assertEquals(1, binomio.obtenerCoeficienteK(3), 0);
		assertEquals(9, binomio.obtenerCoeficienteK(2), 0);
		assertEquals(27, binomio.obtenerCoeficienteK(1), 0);
		assertEquals(27, binomio.obtenerCoeficienteK(0), 0);
	}

	@Test
	public void Tiempos() {
		for (int i = 0; i < 15; i++) {
			double inicio = System.nanoTime();
			BinomioNewton bin = new BinomioNewton(1, 3, i * 1000);
			double[] coeficientes = bin.obtenerPolinomio();
			double tFinal = System.nanoTime() - inicio;
			System.out.println(i * 1000);
		}

	}
}
