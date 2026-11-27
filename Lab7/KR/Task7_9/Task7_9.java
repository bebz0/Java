// Task 7.9
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task7_9 {

    static List<Integer> count(List<Integer> people, int n, int m) {
        for (int i = 1; i <= n; i++)
            people.add(i);

        List<Integer> order = new ArrayList<Integer>();
        int idx = 0;
        while (!people.isEmpty()) {
            idx = (idx + m - 1) % people.size();
            order.add(people.remove(idx));
        }
        return order;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        System.out.print("m = ");
        int m = sc.nextInt();
        sc.close();

        if (n < 1 || m < 1) {
            System.out.println("N and m must be > 0");
            return;
        }

        List<Integer> order1 = count(new ArrayList<Integer>(), n, m);
        List<Integer> order2 = count(new LinkedList<Integer>(), n, m);

        if (n <= 100) {
            System.out.println("ArrayList:  " + order1);
            System.out.println("LinkedList: " + order2);
        }
        System.out.println("Same result: " + order1.equals(order2));

        int big = 100000;
        System.out.println();
        System.out.println("Speed test, N = " + big + ", m = " + m + ":");

        long start = System.nanoTime();
        count(new ArrayList<Integer>(), big, m);
        long timeArray = (System.nanoTime() - start) / 1000000;

        start = System.nanoTime();
        count(new LinkedList<Integer>(), big, m);
        long timeLinked = (System.nanoTime() - start) / 1000000;

        System.out.println("ArrayList:  " + timeArray + " ms");
        System.out.println("LinkedList: " + timeLinked + " ms");
        if (timeArray < timeLinked)
            System.out.println("ArrayList is faster");
        else
            System.out.println("LinkedList is faster");
    }
}
