package ConditionCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// NOTE: Pour QuadraticEquation, les critères Branch et Condition donnent les mêmes tests
// car chaque condition est simple (pas de conditions composées avec &&/||)
// Voir README.md
public class Exo4Test {

    @Test
    void testAEqualsZeroTrue() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    void testDeltaLessThanZeroTrue() {
        assertNull(QuadraticEquation.solve(1, 0, 5));
    }

    @Test
    void testDeltaEqualsZeroTrue() {
        double[] r = QuadraticEquation.solve(1, -6, 9);
        assertArrayEquals(new double[]{3.0}, r);
    }

    @Test
    void testDeltaGreaterThanZero() {
        double[] r = QuadraticEquation.solve(1, -5, 4);
        assertEquals(2, r.length);
    }
}