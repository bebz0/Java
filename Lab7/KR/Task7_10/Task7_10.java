// Task 7.10
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Scanner;

public class Task7_10 {

    static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static String lineKey(int x1, int y1, int x2, int y2) {
        int a = y2 - y1;
        int b = x1 - x2;
        int c = -(a * x1 + b * y1);

        int g = gcd(gcd(a, b), c);
        a /= g;
        b /= g;
        c /= g;
        if (a < 0 || (a == 0 && b < 0)) {
            a = -a;
            b = -b;
            c = -c;
        }
        return a + "x + " + b + "y + " + c + " = 0";
    }

    public static void main(String[] args) {
        int[] x;
        int[] y;
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            int n = sc.nextInt();
            x = new int[n];
            y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find input.txt");
            return;
        }

        HashMap<String, TreeSet<Integer>> lines = new HashMap<String, TreeSet<Integer>>();
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j] && y[i] == y[j]) continue;
                String key = lineKey(x[i], y[i], x[j], y[j]);
                if (!lines.containsKey(key))
                    lines.put(key, new TreeSet<Integer>());
                lines.get(key).add(i);
                lines.get(key).add(j);
            }
        }

        try {
            PrintWriter pw = new PrintWriter("output.txt");
            for (String key : lines.keySet()) {
                String points = "";
                for (int i : lines.get(key))
                    points += "(" + x[i] + "; " + y[i] + ") ";
                String s = key + " - " + lines.get(key).size() + " points: " + points;
                pw.println(s);
                System.out.println(s);
            }
            pw.close();
            System.out.println("Lines: " + lines.size() + ", writen to output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Can't write output.txt");
        }
    }
}
