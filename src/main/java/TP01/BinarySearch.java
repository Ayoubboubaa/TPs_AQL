package TP01;

public class BinarySearch {
    public static int binarySearch(int[] array, int element) {
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {  // ✅ CORRIGÉ: <= au lieu de
            int mid = (low + high) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] < element) {  // ✅ CORRIGÉ: < strict
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}