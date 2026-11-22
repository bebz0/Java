// Task 8.6
public class Consumer implements Runnable {
    private MessageQueue queue;
    private int t2;

    public Consumer(MessageQueue queue, int t2) {
        this.queue = queue;
        this.t2 = t2;
    }

    public void run() {
        try {
            while (true) {
                String message = queue.take();
                if (message.equals(Task8_6.STOP))
                    break;
                Thread.sleep(t2);
                System.out.println(Task8_6.time() + " processed: " + message);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer was interrupted");
        }
    }
}
