// Task 8.7
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task8_7 {
    public static final int T1 = 100, T2 = 300;
    public static final int T3 = 400, T4 = 900;
    public static final int T5 = 200, T6 = 500;

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
        System.out.print("Number of operators N: ");
        int n = sc.nextInt();
        System.out.print("Number of clients: ");
        int clients = sc.nextInt();
        sc.close();

        if (n < 1 || clients < 1) {
            System.out.println("Wrong input");
            return;
        }

        System.out.println("New call every " + T1 + "-" + T2 + " ms, talk " + T3 + "-" + T4
                + " ms, call back after " + T5 + "-" + T6 + " ms");

        CallCenter center = new CallCenter(n);
        ArrayList<Client> list = new ArrayList<Client>();
        start = System.currentTimeMillis();

        for (int i = 1; i <= clients; i++) {
            Client c = new Client(i, center);
            list.add(c);
            c.start();
            if (i < clients)
                Thread.sleep(random(T1, T2));
        }

        for (Client c : list)
            c.join();

        System.out.println();
        System.out.println("Served clients: " + center.getServed());
        System.out.println("Times clients had to call back: " + center.getCallsBack());
    }
}
