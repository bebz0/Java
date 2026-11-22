// Task 7.6
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Stack;

public class Task7_6 {

    static void printRecord(RandomAccessFile file, long position) throws IOException {
        file.seek(position);
        int id = file.readInt();
        String name = file.readUTF();
        double grade = file.readDouble();
        System.out.println("  #" + id + " " + name + ", grade " + grade + " (position " + position + ")");
    }

    public static void main(String[] args) {
        String[] names = {"Kudermin Roman", "Abyzov Roman", "Mokrytskyi Maksym",
                          "Batrak Kyrylo", "Poshtak Yevhen", "Ivanenko Olena"};
        double[] grades = {91.5, 78, 84.5, 69, 88, 95};

        Stack<Long> index = new Stack<Long>();

        try {
            RandomAccessFile file = new RandomAccessFile("records.dat", "rw");
            file.setLength(0);

            for (int i = 0; i < names.length; i++) {
                index.push(file.getFilePointer());
                file.writeInt(i + 1);
                file.writeUTF(names[i]);
                file.writeDouble(grades[i]);
            }
            System.out.println("Written " + index.size() + " records to records.dat");
            System.out.println("Index (start of every record): " + index);

            Scanner sc = new Scanner(System.in);
            System.out.print("Which record to read (1 - " + index.size() + "): ");
            int k = sc.nextInt();
            sc.close();

            if (k < 1 || k > index.size()) {
                System.out.println("No such record");
            } else {
                System.out.println("Record " + k + ":");
                printRecord(file, index.get(k - 1));
            }

            System.out.println("All records, taking positions from the stack:");
            while (!index.isEmpty()) {
                printRecord(file, index.pop());
            }

            file.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
