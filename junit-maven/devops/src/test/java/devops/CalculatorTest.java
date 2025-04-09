package devops;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    int a = (int) (Math.random() * 100);
    int b = (int) (Math.random() * 100); 

    @Test
    public void testAddition() {
        assertEquals(a + b, calculator.add(a, b));
    }

    @Test
    public void testSubtraction() {
        assertEquals(a - b, calculator.subtract(a, b));
    }

    @Test
    public void testMultiplication() {
        assertEquals(a * b, calculator.multiply(a, b));
    }

    @Test
    public void testDivision() {
        assertEquals(a / b, calculator.divide(a, b));
    }

    @Test
    public void testDivisionByZeroThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(a, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

