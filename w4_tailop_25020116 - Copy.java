import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class w4_tailop_25020116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Integer[] citations = new Integer[n];
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        // Sắp xếp giảm dần
        Arrays.sort(citations, Collections.reverseOrder());

        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        System.out.println(hIndex);
        scanner.close();
    }
}