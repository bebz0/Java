// Task 1.6
import java.util.Locale;
import java.util.Scanner;

public class Task1_6 {

    static double length(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx*dx + dy*dy);
    }

    static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double s = p * (p - a) * (p - b) * (p - c);
        if (s < 0) return 0;
        return Math.sqrt(s);
    }

    public static void main(String[] args) {
        double a = 3;
        double b = 3.5 + 3 * Math.pow(2, -111);
        double c = b;
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("Perimeter = " + perimeter(a, b, c));
        System.out.println("Area = " + area(a, b, c));
        System.out.println();

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter points A, B, C:");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();
        sc.close();

        double ab = length(x1, y1, x2, y2);
        double bc = length(x2, y2, x3, y3);
        double ca = length(x3, y3, x1, y1);

        if (ab + bc > ca && ab + ca > bc && bc + ca > ab)
            System.out.println("Area of ABC = " + area(ab, bc, ca));
        else
            System.out.println("Points are on one line, its not a triangle");
    }
}
