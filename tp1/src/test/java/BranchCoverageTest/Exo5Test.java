package BranchCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    // Branche: n < 1 → true
    @Test
    void testNLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    // Branche: n > 3999 → true
    @Test
    void testNGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    // Branche: n >= values[i] → true plusieurs fois (while exécuté)
    @Test
    void testRepeatSymbol() {
        assertEquals("III", RomanNumeral.toRoman(3));
    }

    // Branche: symbole soustraction (CM, CD, etc.)
    @Test
    void testSubtractionSymbol() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("CM", RomanNumeral.toRoman(900));
    }

    // Branche: n >= values[i] → false (while non exécuté, passe au suivant)
    @Test
    void testSkipSymbol() {
        assertEquals("V", RomanNumeral.toRoman(5));
    }
}