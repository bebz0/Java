// Task 8.7
public class Client extends Thread {
    private int number;
    private CallCenter center;

    public Client(int number, CallCenter center) {
        this.number = number;
        this.center = center;
    }

    public void run() {
        try {
            int attempt = 1;
            while (true) {
                int operator = center.takeOperator();
                if (operator == -1) {
                    int wait = Task8_7.random(Task8_7.T5, Task8_7.T6);
                    System.out.println(Task8_7.time() + " Client " + number + ": all operators are busy, will call back in " + wait + " ms");
                    Thread.sleep(wait);
                    attempt++;
                } else {
                    int talk = Task8_7.random(Task8_7.T3, Task8_7.T4);
                    System.out.println(Task8_7.time() + " Client " + number + " talks to operator " + (operator + 1)
                            + " (attempt " + attempt + ")");
                    Thread.sleep(talk);
                    center.release(operator);
                    System.out.println(Task8_7.time() + " Client " + number + " finished with operator " + (operator + 1));
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Client " + number + " was interrupted");
        }
    }
}
