// Task 1.4
import java.util.Locale;
import java.util.Scanner;

public class Task1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Enter number (0 - 10000): ");
        double x = sc.nextDouble();

        if (x < 0 || x > 10000) {
            System.out.println("Wrong number");
        }
        else {
            double res = Math.pow(x, 8);
            System.out.printf("%25.4f\n", res);
        }
        sc.close();
    }
}
