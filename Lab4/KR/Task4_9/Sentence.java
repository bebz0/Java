// Task 4.9
import java.util.ArrayList;

public class Sentence {
    private ArrayList<Word> words = new ArrayList<Word>();

    public Sentence(String s) {
        String[] parts = s.trim().split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() > 0)
                words.add(new Word(parts[i]));
        }
    }

    public void addWord(Word w) {
        words.add(w);
    }

    public int size() {
        return words.size();
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < words.size(); i++) {
            res += words.get(i);
            if (i < words.size() - 1) res += " ";
        }
        return res;
    }
}
