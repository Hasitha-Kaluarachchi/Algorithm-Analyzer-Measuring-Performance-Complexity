import java.util.Random;

public class QuickSort {

    // -----------------------------
    // QUICK SORT IMPLEMENTATION
    // -----------------------------
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot into correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // -----------------------------
    // GENERATE RANDOM ARRAY
    // -----------------------------
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);  // random values
        }
        return arr;
    }

    // -----------------------------
    // MAIN PROGRAM FOR MEMBER 04
    // -----------------------------
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println(" Algorithm: Quick Sort (Member 04)");
        System.out.println("-----------------------------------------");
        System.out.println(" Input Size | Time (ms)");
        System.out.println("-----------------------------------------");

        for (int size : sizes) {
            int[] data = generateRandomArray(size);

            long start = System.nanoTime();
            quickSort(data, 0, data.length - 1);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;

            System.out.printf(" %5d      | %.4f ms%n", size, timeMs);
        }
    }
}