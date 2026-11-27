// Task 7.14
import java.util.Scanner;
import java.util.Stack;

public class Task7_14 {
    static int bestArea = 0;
    static int bestTop, bestLeft, bestBottom, bestRight;

    static void largestRectangle(int[] h, int from, int to, int row) {
        Stack<Integer> st = new Stack<Integer>();
        for (int j = from; j <= to + 1; j++) {
            int cur = (j <= to) ? h[j] : 0;
            while (!st.isEmpty() && h[st.peek()] >= cur) {
                int height = h[st.pop()];
                int left = st.isEmpty() ? from : st.peek() + 1;
                int area = height * (j - left);
                if (area > bestArea) {
                    bestArea = area;
                    bestBottom = row;
                    bestTop = row - height + 1;
                    bestLeft = left;
                    bestRight = j - 1;
                }
            }
            if (j <= to)
                st.push(j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows and columns: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n < 1 || m < 1) {
            System.out.println("Wrong size");
            sc.close();
            return;
        }

        int[][] a = new int[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        sc.close();

        int[] h = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && a[i][j] == a[i - 1][j])
                    h[j]++;
                else
                    h[j] = 1;
            }

            int j = 0;
            while (j < m) {
                int k = j;
                while (k + 1 < m && a[i][k + 1] == a[i][j])
                    k++;
                largestRectangle(h, j, k, i);
                j = k + 1;
            }
        }

        System.out.println("Biggest submatrix: " + bestArea + " elements equal to " + a[bestTop][bestLeft]);
        System.out.println("Rows " + bestTop + " - " + bestBottom + ", columns " + bestLeft + " - " + bestRight);
        for (int i = bestTop; i <= bestBottom; i++) {
            for (int j = bestLeft; j <= bestRight; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
