// Task 5.9
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task5_9 {

    static int countWords(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty())
                count += line.split("\\s+").length;
        }
        br.close();
        return count;
    }

    static void clean(String in, String out) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new FileWriter(out));

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            String res = "";
            for (String w : words) {
                if (w.isEmpty()) continue;
                if (w.length() == 1 && Character.isLetter(w.charAt(0))) continue;
                if (!res.isEmpty()) res += " ";
                res += w;
            }
            pw.println(res);
        }
        pw.close();
        br.close();
    }

    static void printFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);
        br.close();
    }

    public static void main(String[] args) {
        try {
            System.out.println("input.txt:");
            printFile("input.txt");
            System.out.println();

            System.out.println("Words in file: " + countWords("input.txt"));

            clean("input.txt", "output.txt");
            System.out.println("Result was writen to output.txt:");
            printFile("output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
