// Task 5.7
import java.util.Scanner;

public class Task5_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        sc.close();

        String res = text.replaceAll("\\b(small|large)\\b", "very $1");
        System.out.println(res);
    }
}
