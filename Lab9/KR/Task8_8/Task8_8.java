// Task 8.8
import java.util.Random;
import java.util.Scanner;

public class Task8_8 {
    public static final int COME_MIN = 50, COME_MAX = 250;
    public static final int SERVE_MIN = 300, SERVE_MAX = 700;
    public static final int SLOWER = 150;

    private static Random rnd = new Random();
    private static long start;

    public static int random(int from, int to) {
        return from + rnd.nextInt(to - from + 1);
    }

    public static String time() {
        return String.format("[%5d ms]", System.currentTimeMillis() - start);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of cash desks: ");
        int desks = sc.nextInt();
        System.out.print("Number of customers: ");
        int customers = sc.nextInt();
        sc.close();

        if (desks < 1 || customers < 1) {
            System.out.println("Wrong input");
            return;
        }

        Restaurant restaurant = new Restaurant(desks);
        Cashier[] cashiers = new Cashier[desks];
        start = System.currentTimeMillis();

        for (int i = 0; i < desks; i++) {
            cashiers[i] = new Cashier(i, restaurant);
            cashiers[i].start();
        }

        for (int i = 1; i <= customers; i++) {
            restaurant.arrive(i);
            Thread.sleep(random(COME_MIN, COME_MAX));
        }

        restaurant.close();
        for (Cashier c : cashiers)
            c.join();

        System.out.println();
        for (int i = 0; i < desks; i++)
            System.out.println("Desk " + (i + 1) + " served " + cashiers[i].getServed() + " customers");
        System.out.println("Customers changed queue " + restaurant.getMoves() + " times");
    }
}
