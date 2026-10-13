// Task 4.9
import java.util.ArrayList;

public class Text {
    private String title;
    private ArrayList<Sentence> sentences = new ArrayList<Sentence>();

    public Text(String title) {
        this.title = title;
    }

    public void add(Sentence s) {
        sentences.add(s);
    }

    public void add(String s) {
        sentences.add(new Sentence(s));
    }

    public void printTitle() {
        System.out.println(title);
    }

    public void print() {
        for (int i = 0; i < sentences.size(); i++)
            System.out.print(sentences.get(i) + " ");
        System.out.println();
    }
}
