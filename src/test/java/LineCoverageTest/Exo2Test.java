package LineCoverageTest;
import TP01.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testNullFirst() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void testNullSecond() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("ab", "abc"));
    }

    @Test
    void testIsAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testNotAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }
}