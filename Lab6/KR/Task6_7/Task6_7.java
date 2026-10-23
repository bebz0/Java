// Task 6.7
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Task6_7 {

    static void createFile(String name, int n) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(name));
        Random rnd = new Random();

        System.out.print("Written to " + name + ": ");
        for (int i = 0; i < n; i++) {
            double x = Math.round((rnd.nextDouble() * 200 - 100) * 100) / 100.0;
            out.writeDouble(x);
            System.out.print(x + " ");
        }
        System.out.println();
        out.close();
    }

    static double sum(String name) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(name));
        double s = 0;
        while (true) {
            try {
                s += in.readDouble();
            } catch (EOFException e) {
                break;
            }
        }
        in.close();
        return s;
    }

    public static void main(String[] args) {
        try {
            createFile("numbers.dat", 10);
            System.out.printf("Sum: %.2f\n", sum("numbers.dat"));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
