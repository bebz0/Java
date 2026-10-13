// Task 4.5
import points.MovingPoint;

import java.util.Locale;
import java.util.Scanner;

public class Task4_5 {

    static MovingPoint[] createPoints() {
        MovingPoint[] arr = new MovingPoint[5];
        arr[0] = new MovingPoint(0, 0, 1, 1, 2, 0.5);
        arr[1] = new MovingPoint(10, 0, -1, 1, 3);
        arr[2] = new MovingPoint(0, 5, 1, 0, 1, 1);
        arr[3] = new MovingPoint(0, 8, 1, 0, 4);

        arr[4] = new MovingPoint();
        arr[4].setDirX(0);
        arr[4].setDirY(1);
        arr[4].setSpeed(2);
        return arr;
    }

    static void printFasterThan(MovingPoint[] arr, double t, double v) {
        System.out.println("Points with velocity more than " + v + " at t = " + t + ":");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getVelocity(t) > v) {
                System.out.println("  " + arr[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  no such points");
        }
    }

    public static void main(String[] args) {
        MovingPoint[] points = createPoints();

        for (int i = 0; i < points.length; i++) {
            System.out.println((i + 1) + ". " + points[i]);
        }

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter time t: ");
        double t = sc.nextDouble();
        System.out.print("Enter velocity for search: ");
        double v = sc.nextDouble();
        sc.close();

        if (t < 0) {
            System.out.println("Time can not be negative");
            return;
        }

        System.out.println();
        for (int i = 0; i < points.length; i++) {
            System.out.println("Point " + (i + 1) + ": position " + points[i].getPosition(t)
                    + ", velocity " + points[i].getVelocity(t)
                    + ", acceleration " + points[i].getAcceleration());
        }

        System.out.println();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].canIntersect(points[j])) {
                    System.out.println("Trajectoris of points " + (i + 1) + " and " + (j + 1) + " can intersect");
                } else {
                    System.out.println("Trajectoris of points " + (i + 1) + " and " + (j + 1) + " do not intersect");
                }
            }
        }

        System.out.println();
        System.out.println("Distance between points 1 and 2 at t = " + t + ": "
                + points[0].distanceTo(points[1], t));

        System.out.println();
        printFasterThan(points, t, v);
    }
}
