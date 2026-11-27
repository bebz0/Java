// Task 8.6
public class Producer extends Thread {
    private MessageQueue queue;
    private int count;
    private int t1;

    public Producer(MessageQueue queue, int count, int t1) {
        this.queue = queue;
        this.count = count;
        this.t1 = t1;
    }

    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                Thread.sleep(t1);
                String message = "Message " + i;
                queue.put(message);
                System.out.println(Task8_6.time() + " sent:      " + message + "  (in queue: " + queue.size() + ")");
            }
            queue.put(Task8_6.STOP);
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted");
        }
    }
}
