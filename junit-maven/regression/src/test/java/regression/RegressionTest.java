package regression;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class RegressionTest {

	private Regression regression;
	private int[] xValues;
	private int[] yValues;
	private final int ARRAY_SIZE = 10;

	@BeforeEach
	public void setUp() {
		regression = new Regression();
		xValues = new int[ARRAY_SIZE];
		yValues = new int[ARRAY_SIZE];

		Random random = new Random();

		for (int i = 0; i < ARRAY_SIZE; i++) {
			xValues[i] = random.nextInt(100); // 0 to 99
			yValues[i] = xValues[i] * 2 + 5; // Linearly dependent for predictable slope (~2)
		}
	}

	@AfterEach
	public void tearDown() {
		regression = null;
		xValues = null;
		yValues = null;
	}

	@Test
	public void testSlopeCalculation() {
		double slope = regression.getValue(xValues, yValues);
		assertTrue(slope > 1.9 && slope < 2.1, "Expected slope to be approximately 2");
	}

	@Test
	public void testNonZeroSlope() {
		double slope = regression.getValue(xValues, yValues);
		assertNotEquals(0, slope, "Slope should not be zero for dependent data");
	}

	@Test
	public void testZeroSlopeForConstantY() {
		for (int i = 0; i < ARRAY_SIZE; i++) {
			yValues[i] = 10; // Constant Y
		}
		double slope = regression.getValue(xValues, yValues);
		assertEquals(0.0, slope, 0.0001, "Slope should be zero if Y is constant");
	}

	@Test
	public void testExceptionForMismatchedArrayLength() {
		int[] invalidY = new int[ARRAY_SIZE - 1]; // shorter array
		assertThrows(IllegalArgumentException.class, () -> {
			regression.getValue(xValues, invalidY);
		});
	}

	@Test
	public void testIdenticalXValues() {
		for (int i = 0; i < ARRAY_SIZE; i++) {
			xValues[i] = 5; // Same value for X
			yValues[i] = i; // Varying Y
		}

		double slope = regression.getValue(xValues, yValues);
		assertEquals(0.0, slope, 0.0001, "Slope should be 0 when all X values are the same");
	}
}
