package ConditionCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    // s1 null → TRUE
    @Test
    void testS1NullTrue() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "a"));
    }

    // s1 non null, s2 null → TRUE (condition OR)
    @Test
    void testS2NullTrue() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("a", null));
    }

    // s1 non null, s2 non null → false pour les deux conditions
    @Test
    void testBothNonNull() {
        assertTrue(Anagram.isAnagram("ab", "ba"));
    }

    // length différent → true
    @Test
    void testLengthConditionTrue() {
        assertFalse(Anagram.isAnagram("a", "ab"));
    }

    // c != 0 → true
    @Test
    void testCountNotZero() {
        assertFalse(Anagram.isAnagram("aab", "bbc"));
    }
}