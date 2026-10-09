// Task 3.5
import java.util.Scanner;

public class Task3_5 {

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        long rev = 0;
        int y = x;
        while (y > 0) {
            rev = rev * 10 + y % 10;
            y = y / 10;
        }
        return rev == x;
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

        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isPalindrome(a[i])) {
                count++;
                if (count <= 2)
                    res = a[i];
            }
        }

        if (count == 0)
            System.out.println("No palindroms");
        else
            System.out.println("Palindrome: " + res);
    }
}
