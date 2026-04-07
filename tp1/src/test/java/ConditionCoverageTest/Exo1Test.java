package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TP01.*;
public class Exo1Test {

    // Condition s == null → TRUE
    @Test
    void testNullConditionTrue() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Condition s == null → FALSE, i < j → FALSE
    @Test
    void testSingleChar() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    // Condition i < j → TRUE, charAt(i) != charAt(j) → TRUE
    @Test
    void testCharsNotEqual() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    // Condition i < j → TRUE, charAt(i) != charAt(j) → FALSE (loop continues)
    @Test
    void testLongPalindrome() {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }
}