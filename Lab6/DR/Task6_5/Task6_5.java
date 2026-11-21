// Task 6.5
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task6_5 {

    static void createF(String name, int n) throws IOException {
        int[] a = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n / 2; i++)
            a[i] = rnd.nextInt(99) + 1;
        for (int i = n / 2; i < n; i++)
            a[i] = -(rnd.nextInt(99) + 1);

        for (int i = n - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        DataOutputStream out = new DataOutputStream(new FileOutputStream(name));
        for (int i = 0; i < n; i++)
            out.writeInt(a[i]);
        out.close();
    }

    static void print(String title, String name) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(name));
        System.out.print(title + ": ");
        while (true) {
            try {
                System.out.print(in.readInt() + " ");
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println();
        in.close();
    }

    static int copyNegatives(String f, String h) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(h));
        int count = 0;
        while (true) {
            try {
                int x = in.readInt();
                if (x < 0) {
                    out.writeInt(x);
                    count++;
                }
            } catch (EOFException e) {
                break;
            }
        }
        in.close();
        out.close();
        return count;
    }

    static int nextPositive(DataInputStream in) throws IOException {
        int x = in.readInt();
        while (x < 0)
            x = in.readInt();
        return x;
    }

    static void byGroups(String f, String h, String g, int group, int negCount) throws IOException {
        DataInputStream pos = new DataInputStream(new FileInputStream(f));
        DataInputStream neg = new DataInputStream(new FileInputStream(h));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(g));

        for (int i = 0; i < negCount / group; i++) {
            for (int j = 0; j < group; j++)
                out.writeInt(nextPositive(pos));
            for (int j = 0; j < group; j++)
                out.writeInt(neg.readInt());
        }

        pos.close();
        neg.close();
        out.close();
    }

    static void positivesFirst(String f, String h, String g) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(g));

        DataInputStream in = new DataInputStream(new FileInputStream(f));
        while (true) {
            try {
                int x = in.readInt();
                if (x >= 0) out.writeInt(x);
            } catch (EOFException e) {
                break;
            }
        }
        in.close();

        in = new DataInputStream(new FileInputStream(h));
        while (true) {
            try {
                out.writeInt(in.readInt());
            } catch (EOFException e) {
                break;
            }
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers (must be divisible by 4): ");
        int n = sc.nextInt();
        sc.close();

        if (n < 4 || n % 4 != 0) {
            System.out.println("Wrong count");
            return;
        }

        try {
            createF("f.dat", n);
            print("F", "f.dat");

            int neg = copyNegatives("f.dat", "h.dat");
            print("H", "h.dat");
            System.out.println();

            byGroups("f.dat", "h.dat", "g1.dat", 1, neg);
            print("G (signs alternate)  ", "g1.dat");

            positivesFirst("f.dat", "h.dat", "g2.dat");
            print("G (positives first)  ", "g2.dat");

            byGroups("f.dat", "h.dat", "g3.dat", 2, neg);
            print("G (two and two)      ", "g3.dat");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
