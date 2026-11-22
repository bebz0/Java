// Task 8.8
public class Cashier extends Thread {
    private int desk;
    private Restaurant restaurant;
    private int served = 0;

    public Cashier(int desk, Restaurant restaurant) {
        this.desk = desk;
        this.restaurant = restaurant;
    }

    public int getServed() {
        return served;
    }

    public void run() {
        try {
            while (true) {
                int customer = restaurant.next(desk);
                if (customer == -1)
                    break;
                System.out.println(Task8_8.time() + " Desk " + (desk + 1) + " serves customer " + customer);
                Thread.sleep(Task8_8.random(Task8_8.SERVE_MIN, Task8_8.SERVE_MAX) + desk * Task8_8.SLOWER);
                served++;
            }
        } catch (InterruptedException e) {
            System.out.println("Desk " + (desk + 1) + " was interrupted");
        }
    }
}
