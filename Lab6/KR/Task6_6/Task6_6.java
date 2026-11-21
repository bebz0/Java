// Task 6.6
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task6_6 {

    static void swapZeroOne(String f, String g) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(f));
        BufferedWriter out = new BufferedWriter(new FileWriter(g));

        String line;
        while ((line = in.readLine()) != null) {
            String res = "";
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '0')
                    res += '1';
                else if (c == '1')
                    res += '0';
                else
                    res += c;
            }
            out.write(res);
            out.newLine();
        }
        in.close();
        out.close();
    }

    static void printFile(String name) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(name));
        String line;
        while ((line = in.readLine()) != null)
            System.out.println(line);
        in.close();
    }

    public static void main(String[] args) {
        try {
            swapZeroOne("input.txt", "output.txt");

            System.out.println("F (input.txt):");
            printFile("input.txt");
            System.out.println();
            System.out.println("G (output.txt):");
            printFile("output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
