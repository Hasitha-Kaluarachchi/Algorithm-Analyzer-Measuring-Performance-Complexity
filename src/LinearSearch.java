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

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);

            int key = arr[size - 1];  // search last element 
            long start = System.nanoTime();

            linearSearch(arr, key);

            long end = System.nanoTime();
            double timeMs = (end - start) / 1_000_000.0;

            System.out.println(size + "        | " + timeMs);
        }
    }
}
