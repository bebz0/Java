// Task 7.5
import java.util.Scanner;

public class Task7_5 {

    static IntSet readSet(Scanner sc, String name) {
        System.out.print(name + " (numbers in one line): ");
        IntSet set = new IntSet();
        String[] parts = sc.nextLine().trim().split("\\s+");
        for (String p : parts) {
            if (p.isEmpty()) continue;
            try {
                set.add(Integer.parseInt(p));
            } catch (NumberFormatException e) {
                System.out.println(p + " is not an integer, skipped");
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntSet a = readSet(sc, "A");
        IntSet b = readSet(sc, "B");
        sc.close();

        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("A union B = " + a.union(b));
        System.out.println("A intersection B = " + a.intersection(b));

        IntSet c = new IntSet(new int[]{1, 2, 3, 4, 5});
        IntSet d = new IntSet(new int[]{4, 5, 6, 7});
        System.out.println();
        System.out.println(c + " union " + d + " = " + c.union(d));
        System.out.println(c + " intersection " + d + " = " + c.intersection(d));
    }
}
