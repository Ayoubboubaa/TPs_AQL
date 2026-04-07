package ConditionCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    // n < 1 → TRUE
    @Test
    void testNLessThan1True() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-5));
    }

    // n > 3999 → TRUE
    @Test
    void testNGreaterThan3999True() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(5000));
    }

    // n < 1 → FALSE et n > 3999 → FALSE (valeur valide)
    @Test
    void testValidN() {
        assertEquals("X", RomanNumeral.toRoman(10));
    }

    // n >= values[i] → TRUE (while entre)
    @Test
    void testWhileTrue() {
        assertEquals("MM", RomanNumeral.toRoman(2000));
    }

    // Combinaison complexe (plusieurs symboles)
    @Test
    void testComplex() {
        assertEquals("XLII", RomanNumeral.toRoman(42));
    }
}