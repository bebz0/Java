// Task 4.9
public class Task4_9 {
    public static void main(String[] args) {
        Text text = new Text("My day");
        text.add("Today I woke up early.");
        text.add(new Sentence("Then I went to the university."));

        System.out.print("Title: ");
        text.printTitle();
        System.out.print("Text: ");
        text.print();

        Sentence s = new Sentence("In the evening I did my Java");
        s.addWord(new Word("homework."));
        text.add(s);

        System.out.print("After adding: ");
        text.print();
    }
}
