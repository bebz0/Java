// Task 3.9
import java.util.Scanner;

public class Task3_9 {

    static int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[n - 1 - j][i] = a[i][j];
            }
        }
        return b;
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("n must be natural");
            sc.close();
            return;
        }

        int[][] a = new int[n][n];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.print("Angle (90, 180, 270): ");
        int angle = sc.nextInt();
        sc.close();

        if (angle != 90 && angle != 180 && angle != 270) {
            System.out.println("Wrong angle");
            return;
        }

        for (int k = 0; k < angle / 90; k++)
            a = rotate(a);

        System.out.println("Result:");
        print(a);
    }
}
