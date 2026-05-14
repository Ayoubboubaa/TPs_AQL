package BranchCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    // Branche: s == null → exception
    @Test
    void testNullBranch() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Branche: while(i < j) → false dès le début (chaîne vide ou 1 char)
    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    // Branche: while(i < j) → true, charAt(i) != charAt(j) → true → return false
    @Test
    void testNotPalindromeBranch() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    // Branche: while(i < j) → true, charAt(i) == charAt(j) → continue → return true
    @Test
    void testIsPalindromeBranch() {
        assertTrue(Palindrome.isPalindrome("aba"));
    }
}