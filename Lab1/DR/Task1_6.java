// Task 1.6
import java.util.Scanner;

public class Task1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a strng: ");
        String s = scanner.nextLine();

        int i = 0;
        while(i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) == '*'))
            i++;

        String num = s.substring(i);
        try {
            double x = Double.parseDouble(num);
            System.out.println("Cube: " + x*x*x);
        } catch (NumberFormatException e) {
            System.out.println("Can't read the number");
        }

        scanner.close();
    }
}
