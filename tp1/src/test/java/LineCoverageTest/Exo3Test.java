package LineCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    @Test
    void testElementFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    void testElementNotFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 4));
    }

    @Test
    void testElementAtEnd() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearch.binarySearch(array, 9));
    }
}