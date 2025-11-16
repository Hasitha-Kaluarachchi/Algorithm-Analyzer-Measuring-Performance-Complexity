package AlgorithmAnalyzer;

import java.util.Random;

public class LinearSearch {

    // Linear Search Algorithm
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;  // Element found
            }
        }
        return -1;  // Element not found
    }

    // Generate random array
    public static int[] generateArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    
}
