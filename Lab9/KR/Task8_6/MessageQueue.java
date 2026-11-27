// Task 8.6
import java.util.LinkedList;

public class MessageQueue {
    private LinkedList<String> queue = new LinkedList<String>();

    public synchronized void put(String message) {
        queue.addLast(message);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.removeFirst();
    }

    public synchronized int size() {
        return queue.size();
    }
}
