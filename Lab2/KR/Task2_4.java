// Task 2.4
import java.util.Scanner;

public class Task2_4 {
    static long factLoop(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++)
            f *= i;
        return f;
    }
    static long factRec(int n) {
        if (n <= 1) return 1;
        return n * factRec(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n < 1)
                System.out.println("The number is not natural!");
            else if (n > 20)
                System.out.println("Number is too big for long");
            else {
                System.out.println("Loop: " + factLoop(n));
                System.out.println("Recursion: " + factRec(n));
            }
        } else {
            System.out.println("The number is not natural!");
        }
        sc.close();
    }
}
