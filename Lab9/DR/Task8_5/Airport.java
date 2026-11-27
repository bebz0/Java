// Task 8.5
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Airport {
    private Semaphore terminals;
    private Semaphore ladders;
    private ArrayList<Destination> destinations;

    private int[] passengersTo;
    private int arrived = 0;
    private int byTerminal = 0;
    private int byLadder = 0;

    public Airport(int terminalCount, int ladderCount, ArrayList<Destination> destinations) {
        terminals = new Semaphore(terminalCount, true);
        ladders = new Semaphore(ladderCount, true);
        this.destinations = destinations;
        passengersTo = new int[destinations.size()];
    }

    public boolean takePlace() throws InterruptedException {
        while (true) {
            if (terminals.tryAcquire())
                return true;
            if (ladders.tryAcquire())
                return false;
            Thread.sleep(30);
        }
    }

    public void releasePlace(boolean terminal) {
        if (terminal)
            terminals.release();
        else
            ladders.release();
    }

    public ArrayList<Destination> reachable(int range) {
        ArrayList<Destination> list = new ArrayList<Destination>();
        for (Destination d : destinations) {
            if (d.getDistance() <= range)
                list.add(d);
        }
        return list;
    }

    public synchronized void addArrived(int passengers, boolean terminal) {
        arrived += passengers;
        if (terminal)
            byTerminal++;
        else
            byLadder++;
    }

    public synchronized void addDeparted(Destination d, int passengers) {
        passengersTo[destinations.indexOf(d)] += passengers;
    }

    public synchronized void printStats() {
        System.out.println("Planes served at terminals: " + byTerminal);
        System.out.println("Planes served by ladders: " + byLadder);
        System.out.println("Arrived passengers: " + arrived);
        System.out.println("Departed passengers:");
        int total = 0;
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println("  " + destinations.get(i) + ": " + passengersTo[i]);
            total += passengersTo[i];
        }
        System.out.println("  total: " + total);
    }
}
