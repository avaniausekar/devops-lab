package integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
public class CalculatorIT {
    
    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testCalculatorOperationsIntegration() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");

        assertEquals(10, calculator.subtract(15, 5), "15 - 5 should equal 10");

        assertEquals(24, calculator.multiply(6, 4), "6 * 4 should equal 24");
        
        assertEquals(3, calculator.divide(9, 3), "9 / 3 should equal 3");
        
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0),
                    "Dividing by zero should throw ArithmeticException");
    }
    
    @Test
    public void testComplexCalculation() {
        int result = calculator.add(
                        calculator.multiply(2, 3),
                        calculator.divide(10, 2)
                    );
        assertEquals(11, result, "(2 * 3) + (10 / 2) should equal 11");
    }
}
