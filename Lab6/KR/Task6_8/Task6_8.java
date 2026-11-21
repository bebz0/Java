// Task 6.8
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Task6_8 {
    public static void main(String[] args) {
        Faculty[] faculties = {
            new Faculty("Mechanics and Mathematics", "O. Petrenko", 1200),
            new Faculty("Computer Science", "I. Kovalenko", 1500),
            new Faculty("Physics", "M. Shevchenko", 800)
        };
        Institute institute = new Institute("Kyiv University", faculties);

        System.out.println("Before serialization:");
        System.out.println(institute);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("institute.ser"));
            out.writeObject(institute);
            out.close();
            System.out.println("\nSaved to institute.ser");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("institute.ser"));
            Institute loaded = (Institute) in.readObject();
            in.close();

            System.out.println("\nAfter deserialization:");
            System.out.println(loaded);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
