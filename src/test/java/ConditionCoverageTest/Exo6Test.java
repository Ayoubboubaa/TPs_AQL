package ConditionCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// NOTE: Pour FizzBuzz, les critères Branch et Condition sont identiques
// car toutes les conditions sont simples. Voir README.md
public class Exo6Test {

    // n < 1 → TRUE
    @Test
    void testConditionNLessThan1True() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    // n % 15 == 0 → TRUE
    @Test
    void testConditionFizzBuzzTrue() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    // n % 15 != 0, n % 3 == 0 → TRUE
    @Test
    void testConditionFizzTrue() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    // n % 5 == 0 → TRUE
    @Test
    void testConditionBuzzTrue() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    // toutes conditions FALSE → retourne le nombre
    @Test
    void testAllConditionsFalse() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }
}