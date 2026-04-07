package LineCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {

    @Test
    void testInvalidN() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testNumber() {
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }
}