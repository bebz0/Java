// Extra task
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers in one line:");
        String line = sc.nextLine();
        sc.close();

        String[] parts = line.trim().split("\\s+");

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("numbers.dat"));
            int count = 0;
            for (String p : parts) {
                if (p.isEmpty()) continue;
                try {
                    out.writeInt(Integer.parseInt(p));
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println(p + " is not an integer, skiped");
                }
            }
            out.close();

            if (count == 0) {
                System.out.println("No numbers entered");
                return;
            }
            System.out.println(count + " numbers were written to numbers.dat");

            DataInputStream in = new DataInputStream(new FileInputStream("numbers.dat"));
            PrintWriter pw = new PrintWriter("output.txt");
            long sum = 0;
            int n = 0;
            while (true) {
                try {
                    int x = in.readInt();
                    pw.print(x + " ");
                    sum += x;
                    n++;
                } catch (EOFException e) {
                    break;
                }
            }
            in.close();

            double avg = (double) sum / n;
            pw.println();
            pw.println("Average: " + avg);
            pw.close();

            System.out.println("Numbers were written to output.txt");
            System.out.println("Average: " + avg);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
