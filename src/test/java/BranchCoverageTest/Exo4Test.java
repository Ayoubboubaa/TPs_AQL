package BranchCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo4Test {

    // Branche: a == 0 → true
    @Test
    void testAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }

    // Branche: delta < 0 → true
    @Test
    void testNegativeDelta() {
        assertNull(QuadraticEquation.solve(2, 1, 5));
    }

    // Branche: delta == 0 → true
    @Test
    void testZeroDelta() {
        double[] r = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1.0}, r);
    }

    // Branche: delta > 0 → deux racines
    @Test
    void testPositiveDelta() {
        double[] r = QuadraticEquation.solve(1, -3, 2);
        assertEquals(2, r.length);
    }
}