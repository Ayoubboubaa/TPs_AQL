package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TP01.*;
public class Exo3Test {

    // Branche: array == null
    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }

    // Branche: low <= high → false dès le début (tableau vide)
    @Test
    void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    // Branche: array[mid] == element → return mid
    @Test
    void testFoundAtMid() {
        assertEquals(1, BinarySearch.binarySearch(new int[]{1, 5, 9}, 5));
    }

    // Branche: array[mid] < element → low = mid + 1
    @Test
    void testSearchRight() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 3, 7}, 7));
    }

    // Branche: array[mid] > element → high = mid - 1
    @Test
    void testSearchLeft() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 3, 7}, 1));
    }
}