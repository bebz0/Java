// Task 1.5
import java.util.Locale;
import java.util.Scanner;

public class Task1_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("x = ");
        double x = sc.nextDouble();
        sc.close();

        System.out.println("x^4 + 2x^2 + 1 = " + y1(x));
        System.out.println("x^4 + x^3 + x^2 + x + 1 = " + y2(x));
        System.out.println("x^5 + 5x^4 + 10x^3 + 10x^2 + 5x + 1 = " + y3(x));
        System.out.println("x^9 + x^3 + 1 = " + y4(x));
        System.out.println("16x^4 + 8x^3 + 4x^2 + 2x + 1 = " + y5(x));
        System.out.println("x^5 + x^3 + x = " + y6(x));
    }

    static double y1(double x) {
        double t = x*x + 1;
        return t*t;
    }

    static double y2(double x) {
        double x2 = x * x;
        return (x2 + x) * (x2 + 1) + 1;
    }
    static double y3(double x) {
        double t = x + 1;
        double t2 = t * t;
        return t2 * t2 * t;
    }

    static double y4(double x) {
        double x3 = x * x * x;
        return x3 * (x3 * x3 + 1) + 1;
    }

    static double y5(double x) {
        double t = 2 * x;
        double t2 = t*t;
        return (t2 + t) * (t2 + 1) + 1;
    }

    static double y6(double x) {
        double x2 = x * x;
        return x * (x2 * (x2 + 1) + 1);
    }
}
