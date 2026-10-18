// Task 3.10
import java.util.Scanner;

public class Task3_10 {
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
        System.out.println("Enter matix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        sc.close();

        int max = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > max) max = a[i][j];
            }
        }

        boolean[] delRow = new boolean[n];
        boolean[] delCol = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int rows = 0;
        int cols = 0;
        for (int i = 0; i < n; i++) {
            if (!delRow[i]) rows++;
            if (!delCol[i]) cols++;
        }

        System.out.println("Max element: " + max);
        if (rows == 0 || cols == 0) {
            System.out.println("Nothing left in the matrix");
            return;
        }

        int[][] b = new int[rows][cols];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (delRow[i]) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (delCol[j]) continue;
                b[r][c] = a[i][j];
                c++;
            }
            r++;
        }

        System.out.println("Result:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}
