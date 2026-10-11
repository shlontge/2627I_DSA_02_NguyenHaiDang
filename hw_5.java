import java.util.Random;

public class hw_5 {

    // --- MERGE SORT ---
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
            k++;
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // --- INSERTION SORT ---
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // --- HÀM ĐO THỜI GIAN THỰC THI ---
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000};

        System.out.printf("%-10s %-15s %-20s %-20s\n", "Size (N)", "Data Type", "Insertion Sort (ms)", "Merge Sort (ms)");
        System.out.println("------------------------------------------------------------------");

        for (int n : sizes) {
            int[] randomData = new Random().ints(n, 0, 1000000).toArray();

            // Sao chép bộ dữ liệu giống hệt nhau cho 2 thuật toán
            int[] dataForInsertion = randomData.clone();
            int[] dataForMerge = randomData.clone();

            // Đo thời gian Insertion Sort
            long start = System.currentTimeMillis();
            insertionSort(dataForInsertion);
            long end = System.currentTimeMillis();
            long timeInsertion = end - start;

            // Đo thời gian MergeSort
            start = System.currentTimeMillis();
            mergeSort(dataForMerge, 0, dataForMerge.length - 1);
            end = System.currentTimeMillis();
            long timeMerge = end - start;

            System.out.printf("%-10d %-15s %-20d %-20d\n", n, "Random", timeInsertion, timeMerge);
        }
    }
}
