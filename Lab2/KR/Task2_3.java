// Task 2.3
import java.util.Scanner;

public class Task2_3 {

    static void gen(int[] a, boolean[] used, int pos, int n, int k) {
        if (pos == k) {
            for (int i = 0; i < k; i++)
                System.out.print(a[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            a[pos] = i;
            gen(a, used, pos + 1, n, k);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N = ");
        int n = sc.nextInt();
        if (n > 0) {
            System.out.println("Permutaions:");
            gen(new int[n], new boolean[n + 1], 0, n, n);
        } else {
            System.out.println("N must be > 0");
        }

        System.out.print("N K = ");
        int n2 = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        if (k < 1 || k > n2) {
            System.out.println("Wrong N or K");
            return;
        }
        System.out.println("Combinations (" + n2 + ", " + k + "):");
        gen(new int[k], new boolean[n2 + 1], 0, n2, k);
    }
}
