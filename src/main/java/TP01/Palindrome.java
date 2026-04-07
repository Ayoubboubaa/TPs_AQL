package TP01;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new NullPointerException("String must not be null");
        }
        s = s.toLowerCase().replaceAll("\\s+", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;  // ✅ CORRIGÉ (était j++ dans le TP = BUG)
            j--;  // ✅ CORRIGÉ (était i-- dans le TP = BUG)
        }
        return true;
    }
}