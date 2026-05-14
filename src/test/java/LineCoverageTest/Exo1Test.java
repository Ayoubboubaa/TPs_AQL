package LineCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    // Couvre: throw NullPointerException
    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Couvre: return false (pas palindrome)
    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    // Couvre: return true (palindrome)
    @Test
    void testIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    // Couvre: ignore espaces et casse
    @Test
    void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }
}