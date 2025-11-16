import java.util.Random;
public class BubbleSort {// Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;  // optimization
        }
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

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);

            long start = System.nanoTime();

            bubbleSort(arr);

            long end = System.nanoTime();
            double timeMs = (end - start) / 1_000_000.0;

            System.out.println(size + "        | " + timeMs);
        }
    }
}
