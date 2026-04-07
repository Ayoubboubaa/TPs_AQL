package LineCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    @Test
    void testInvalidLow() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testInvalidHigh() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testSimple() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }

    @Test
    void testComplex() {
        assertEquals("MCMXCIX", RomanNumeral.toRoman(1999));
    }

    @Test
    void testMax() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
}