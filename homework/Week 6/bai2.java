import java.util.Scanner;
import java.util.Random;

public class FindTheMedian {

    // Hàm tìm phần tử trung vị (Median) sử dụng thuật toán QuickSelect
    public static int findMedian(int[] ar) {
        int k = ar.length / 2;
        int lo = 0;
        int hi = ar.length - 1;

        // Tráo ngẫu nhiên mảng để tránh trường hợp xấu nhất O(N^2)
        shuffle(ar);

        while (hi > lo) {
            int j = partition(ar, lo, hi);
            if (j == k) {
                break;
            } else if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }
        return ar[k];
    }

    // Hàm phân hoạch (Partition) theo chuẩn Sedgewick (QuickSort)
    private static int partition(int[] ar, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = ar[lo];

        while (true) {
            while (ar[++i] < pivot) {
                if (i == hi) break;
            }
            while (pivot < ar[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(ar, i, j);
        }
        exch(ar, lo, j);
        return j;
    }

    // Hàm đổi chỗ 2 phần tử
    private static void exch(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Hàm tráo ngẫu nhiên mảng
    private static void shuffle(int[] ar) {
        Random rand = new Random();
        for (int i = ar.length; i > 0; i--) {
            int index = rand.nextInt(i);
            exch(ar, index, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = scanner.nextInt();
            }
            System.out.println(findMedian(ar));
        }
        scanner.close();
    }
}