import java.util.Arrays;  //Sort Numbers
import java.util.Random;  // Generate random numbers

package AlgorithmAnalyzer;

public class BinarySearch {

    // Binary Search function
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1; 
    }

    // Generate random integer array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); // random integers between 0-9999
        }
        return arr;
    }

    // Measure binary search performance
    public static double measureBinarySearchTime(int size) {
        int[] arr = generateRandomArray(size);
        Arrays.sort(arr); // sort before binary search

        Random rand = new Random();
        int target = arr[rand.nextInt(size)]; // pick a random element from array

        long startTime = System.nanoTime();
        binarySearch(arr, target);
        long endTime = System.nanoTime();

        double durationMs = (endTime - startTime) / 1_000_000.0; // convert to milliseconds
        return durationMs;
    }

    public static void main(String[] args) {
        int[] inputSizes = {100, 500, 1000};

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int size : inputSizes) {
            double time = measureBinarySearchTime(size);
            System.out.printf("%-11d| %.5f%n", size, time);
        }
    }
}
