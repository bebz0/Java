// Task 3.7
import java.util.Scanner;

public class ParityCheck {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ParityCheck N");
            return;
        }
        int n = Integer.parseInt(args[0]);
        if (n < 1) {
            System.out.println("N must be > 0");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int[] colSum = new int[n];
        int badRows = 0;
        int badRow = -1;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                rowSum += x;
                colSum[j] += x;
            }
            if (rowSum % 2 != 0) {
                badRows++;
                badRow = i;
            }
        }
        sc.close();

        int badCols = 0;
        int badCol = -1;
        for (int j = 0; j < n; j++) {
            if (colSum[j] % 2 != 0) {
                badCols++;
                badCol = j;
            }
        }

        if (badRows == 0 && badCols == 0)
            System.out.println("Matrix has the parity property");
        else if (badRows == 1 && badCols == 1)
            System.out.println("Corrupted bit: (" + badRow + ", " + badCol + ")");
        else
            System.out.println("Matrix is corrupted");
    }
}
