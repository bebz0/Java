// Task 8.5
import java.util.ArrayList;

public class Plane extends Thread {
    private String flight;
    private String model;
    private int capacity;
    private int range;
    private Airport airport;

    public Plane(String flight, String model, int capacity, int range, Airport airport) {
        this.flight = flight;
        this.model = model;
        this.capacity = capacity;
        this.range = range;
        this.airport = airport;
    }

    public void run() {
        try {
            int arriving = Task8_5.random(capacity / 2, capacity);
            System.out.println(Task8_5.time() + " " + flight + " (" + model + ", " + capacity + " seats, range "
                    + range + " km) landed with " + arriving + " passengers");

            boolean terminal = airport.takePlace();
            int perPassenger = terminal ? 2 : 4;
            System.out.println(Task8_5.time() + " " + flight + " goes to " + (terminal ? "a terminal" : "a ladder"));

            Thread.sleep(arriving * perPassenger);
            airport.addArrived(arriving, terminal);

            ArrayList<Destination> list = airport.reachable(range);
            Destination d = list.get(Task8_5.random(0, list.size() - 1));
            int boarding = Task8_5.random(capacity / 2, capacity);
            System.out.println(Task8_5.time() + " " + flight + " boards " + boarding + " passengers to " + d.getCity());
            Thread.sleep(boarding * perPassenger);

            airport.releasePlace(terminal);
            airport.addDeparted(d, boarding);
            System.out.println(Task8_5.time() + " " + flight + " took off to " + d);
        } catch (InterruptedException e) {
            System.out.println(flight + " was interrupted");
        }
    }
}
