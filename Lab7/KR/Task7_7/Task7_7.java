// Task 7.7
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Task7_7 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Can't read input.txt: " + e.getMessage());
            return;
        }

        System.out.println("From file:");
        for (String s : lines)
            System.out.println("  " + s);

        Collections.sort(lines);

        System.out.println("After Collections.sort():");
        for (String s : lines)
            System.out.println("  " + s);
    }
}
