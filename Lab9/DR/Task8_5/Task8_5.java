// Task 8.5
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task8_5 {
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
        System.out.print("Number of terminals: ");
        int terminals = sc.nextInt();
        System.out.print("Number of ladders: ");
        int ladders = sc.nextInt();
        System.out.print("Number of planes: ");
        int planes = sc.nextInt();
        sc.close();

        if (terminals < 0 || ladders < 0 || terminals + ladders == 0 || planes < 1) {
            System.out.println("Wrong input");
            return;
        }

        ArrayList<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination("Lviv", 470));
        destinations.add(new Destination("Warsaw", 690));
        destinations.add(new Destination("Istanbul", 1050));
        destinations.add(new Destination("Paris", 2000));
        destinations.add(new Destination("Dubai", 3500));
        destinations.add(new Destination("New York", 7500));

        String[] models = {"ATR 72", "Embraer 190", "Airbus A320", "Boeing 737", "Boeing 777"};
        int[] capacity = {70, 100, 180, 180, 350};
        int[] range = {1500, 4000, 6100, 5600, 13000};

        Airport airport = new Airport(terminals, ladders, destinations);
        ArrayList<Plane> list = new ArrayList<Plane>();
        start = System.currentTimeMillis();

        for (int i = 0; i < planes; i++) {
            int m = random(0, models.length - 1);
            Plane p = new Plane("PS" + (101 + i), models[m], capacity[m], range[m], airport);
            list.add(p);
            p.start();
            Thread.sleep(random(100, 400));
        }

        for (Plane p : list)
            p.join();

        System.out.println();
        airport.printStats();
    }
}
