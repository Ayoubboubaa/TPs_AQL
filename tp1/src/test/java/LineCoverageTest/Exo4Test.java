package LineCoverageTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TP01.*;
public class Exo4Test {

    @Test
    void testAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    void testDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta = -4
    }

    @Test
    void testDeltaZero() {
        double[] result = QuadraticEquation.solve(1, -2, 1); // delta = 0, racine = 1
        assertArrayEquals(new double[]{1.0}, result);
    }

    @Test
    void testDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -5, 6); // racines 3 et 2
        assertEquals(2, result.length);
    }
}