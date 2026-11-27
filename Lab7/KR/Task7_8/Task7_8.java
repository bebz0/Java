// Task 7.8
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Task7_8 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Task7_8 word1 word2 ...");
            return;
        }

        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null)
                text += line + " ";
            br.close();
        } catch (IOException e) {
            System.out.println("Can't read input.txt: " + e.getMessage());
            return;
        }

        String[] words = text.toLowerCase().split("\\W+");

        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (String arg : args)
            counts.put(arg.toLowerCase(), 0);

        int total = 0;
        for (String w : words) {
            if (w.isEmpty()) continue;
            total++;
            if (counts.containsKey(w))
                counts.put(w, counts.get(w) + 1);
        }

        System.out.println("Words in text: " + total);
        for (String arg : args) {
            int c = counts.get(arg.toLowerCase());
            double freq = total == 0 ? 0 : (double) c / total;
            System.out.printf("%-12s %3d times, frequency %.4f (%.2f%%)\n", arg, c, freq, freq * 100);
        }
    }
}
