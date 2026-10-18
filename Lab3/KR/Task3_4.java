// Task 3.4
import java.util.Scanner;

public class Task3_4 {

    static int digits(int x) {
        if (x == 0) return 1;
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("n must be > 0");
            sc.close();
            return;
        }

        int[] a = new int[n];
        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        sc.close();

        int min = digits(a[0]);
        for (int i = 1; i < n; i++) {
            if (digits(a[i]) < min)
                min = digits(a[i]);
        }

        System.out.println("Min count of digits: " + min);
        for (int i = 0; i < n; i++) {
            if (digits(a[i]) == min)
                System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
