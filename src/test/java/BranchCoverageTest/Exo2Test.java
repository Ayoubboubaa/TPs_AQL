package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TP01.*;
public class Exo2Test {

    // Branche: s1 == null → true
    @Test
    void testS1Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    // Branche: s2 == null → true (s1 non null)
    @Test
    void testS2Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    // Branche: longueurs différentes → return false
    @Test
    void testDiffLength() {
        assertFalse(Anagram.isAnagram("a", "ab"));
    }

    // Branche: c != 0 → return false
    @Test
    void testNotAnagram() {
        assertFalse(Anagram.isAnagram("abc", "abd"));
    }

    // Branche: tout passe → return true
    @Test
    void testIsAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }
}