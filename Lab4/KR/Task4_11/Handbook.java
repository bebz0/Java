// Task 4.11
public class Handbook extends Book {
    private String subject;

    public Handbook(String title, String author, int pages, String subject) {
        super(title, author, pages);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String getType() {
        return "Handbook";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("  subject: " + subject);
    }
}
