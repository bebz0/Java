// Task 4.11
public class Task4_11 {
    public static void main(String[] args) {
        Edition[] editions = new Edition[4];
        editions[0] = new Handbook("Java in a Nutshell", "B. Evans", 450, "programming");
        editions[1] = new Encyclopedia("Britannica", "many authors", 32000, 32);
        editions[2] = new Handbook("Math formulas", "I. Bronshtein", 600, "mathematics");
        editions[3] = new Encyclopedia("Animals of the world", "D. Burnie", 620, 1);

        int pages = 0;
        for (int i = 0; i < editions.length; i++) {
            editions[i].printInfo();
            pages += editions[i].getPages();
        }
        System.out.println();
        System.out.println("Total pages: " + pages);

        Book book = new Handbook("Physics", "H. Kuchling", 800, "physics");
        System.out.println(book.getTitle() + " is a " + book.getType());
    }
}
