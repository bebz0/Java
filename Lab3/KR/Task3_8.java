// Task 3.8
import java.util.Scanner;

public class Task3_8 {

    static void sortRows(int[][] a) {
        int n = a.length;
        for (int r = 0; r < n; r++) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (a[r][j] > a[r][j + 1]) {
                        int tmp = a[r][j];
                        a[r][j] = a[r][j + 1];
                        a[r][j + 1] = tmp;
                    }
                }
            }
        }
    }

    static void sortColumns(int[][] a) {
        int n = a.length;
        for (int c = 0; c < n; c++) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (a[j][c] > a[j + 1][c]) {
                        int tmp = a[j][c];
                        a[j][c] = a[j + 1][c];
                        a[j + 1][c] = tmp;
                    }
                }
            }
        }
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
        int[][] b = new int[n][n];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                b[i][j] = a[i][j];
            }
        }
        sc.close();

        sortRows(a);
        System.out.println("Sorted rows:");
        print(a);

        sortColumns(b);
        System.out.println("Sorted colums:");
        print(b);
    }
}
