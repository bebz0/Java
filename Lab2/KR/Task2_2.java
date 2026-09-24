// Task 2.2
import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number, bit and value: ");
        int n = sc.nextInt();
        int bit = sc.nextInt();
        int value = sc.nextInt();
        sc.close();

        if (bit < 1 || bit > 32 || (value != 0 && value != 1)) {
            System.out.println("Wrong input");
            return;
        }

        if (value == 1)
            n = n | (1 << (bit - 1));
        else
            n = n & ~(1 << (bit - 1));

        System.out.println(n + " 0x" + Integer.toHexString(n).toUpperCase() + " " + Integer.toBinaryString(n));
    }
}
