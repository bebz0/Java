// Task 3.6
import java.util.Scanner;

public class Task3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x,y,m for every object (empty line to finish):");

        double sumX = 0;
        double sumY = 0;
        double sumM = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.length() == 0) break;

            String[] parts = line.split(",");
            if (parts.length != 3) {
                System.out.println("Wrong line: " + line);
                continue;
            }

            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            double m = Double.parseDouble(parts[2].trim());

            sumX += x * m;
            sumY += y * m;
            sumM += m;
        }
        sc.close();

        if (sumM == 0) {
            System.out.println("Total mass is 0, can't find the center");
        } else {
            double cx = sumX / sumM;
            double cy = sumY / sumM;
            System.out.println("Center of mass: (" + cx + ", " + cy + ", " + sumM + ")");
        }
    }
}
