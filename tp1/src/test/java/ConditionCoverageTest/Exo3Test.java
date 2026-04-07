package ConditionCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {

    // array == null → TRUE
    @Test
    void testNullTrue() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 0));
    }

    // array[mid] == element → TRUE
    @Test
    void testFoundConditionTrue() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{42}, 42));
    }

    // array[mid] < element → TRUE (cherche à droite)
    @Test
    void testLessConditionTrue() {
        assertEquals(3, BinarySearch.binarySearch(new int[]{1, 2, 3, 8}, 8));
    }

    // array[mid] > element → TRUE (cherche à gauche)
    @Test
    void testGreaterConditionTrue() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{2, 5, 9}, 2));
    }

    // element absent → return -1
    @Test
    void testNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3}, 99));
    }
}