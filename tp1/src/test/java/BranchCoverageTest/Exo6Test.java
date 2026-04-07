package BranchCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {

    // Branche: n < 1 → true
    @Test
    void testNegativeN() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }

    // Branche: n % 15 == 0 → true
    @Test
    void testFizzBuzzBranch() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    // Branche: n % 15 != 0, n % 3 == 0 → true
    @Test
    void testFizzBranch() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    // Branche: n % 15 != 0, n % 3 != 0, n % 5 == 0 → true
    @Test
    void testBuzzBranch() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
    }

    // Branche: tout faux → return String.valueOf(n)
    @Test
    void testNumberBranch() {
        assertEquals("11", FizzBuzz.fizzBuzz(11));
    }
}