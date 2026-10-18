// Task 4.11
public abstract class Book implements Edition {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public abstract String getType();

    public void printInfo() {
        System.out.println(getType() + " \"" + title + "\", " + author + ", " + pages + " pages");
    }
}
