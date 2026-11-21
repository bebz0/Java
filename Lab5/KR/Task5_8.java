// Task 5.8
import java.util.Scanner;

public class Task5_8 {

    static int toNumber(String s) {
        String digits = s.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) return 0;
        return Integer.parseInt(digits);
    }

    static int add(String a, String b) {
        long sum = (long) toNumber(a) + toNumber(b);
        if (sum > Integer.MAX_VALUE)
            throw new NumberFormatException("too big");
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println("\"%^80\" + \"hhhhh20&&&&nd\" = " + add("%^80", "hhhhh20&&&&nd"));

        Scanner sc = new Scanner(System.in);
        System.out.print("First string: ");
        String a = sc.nextLine();
        System.out.print("Second string: ");
        String b = sc.nextLine();
        sc.close();

        try {
            System.out.println("Result: " + add(a, b));
        } catch (NumberFormatException e) {
            System.out.println("Number is to big for int");
        }
    }
}
