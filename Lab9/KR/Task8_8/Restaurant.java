// Task 8.8
import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurant {
    private ArrayList<LinkedList<Integer>> queues = new ArrayList<LinkedList<Integer>>();
    private boolean open = true;
    private int moves = 0;

    public Restaurant(int desks) {
        for (int i = 0; i < desks; i++)
            queues.add(new LinkedList<Integer>());
    }

    public synchronized void arrive(int customer) {
        int best = 0;
        for (int i = 1; i < queues.size(); i++) {
            if (queues.get(i).size() < queues.get(best).size())
                best = i;
        }
        queues.get(best).addLast(customer);
        System.out.println(Task8_8.time() + " Customer " + customer + " stands to desk " + (best + 1) + "   " + state());
        notifyAll();
    }

    public synchronized int next(int desk) throws InterruptedException {
        rebalance(desk);
        while (queues.get(desk).isEmpty() && open) {
            wait();
            rebalance(desk);
        }
        if (queues.get(desk).isEmpty())
            return -1;

        int customer = queues.get(desk).removeFirst();
        rebalance(desk);
        return customer;
    }

    private void rebalance(int desk) {
        while (true) {
            int longest = 0;
            for (int i = 1; i < queues.size(); i++) {
                if (queues.get(i).size() > queues.get(longest).size())
                    longest = i;
            }
            if (queues.get(longest).size() < queues.get(desk).size() + 2)
                return;

            int customer = queues.get(longest).removeLast();
            queues.get(desk).addLast(customer);
            moves++;
            System.out.println(Task8_8.time() + " Customer " + customer + " moves from desk " + (longest + 1)
                    + " to desk " + (desk + 1) + "   " + state());
        }
    }

    public synchronized void close() {
        open = false;
        notifyAll();
    }

    public synchronized int getMoves() {
        return moves;
    }

    private String state() {
        String s = "";
        for (int i = 0; i < queues.size(); i++)
            s += (i + 1) + ":" + queues.get(i) + " ";
        return s;
    }
}
