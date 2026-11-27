// Task 8.6
import java.util.Scanner;

public class Task8_6 {
    public static final String STOP = "STOP";
    private static long start;

    public static String time() {
        return String.format("[%5d ms]", System.currentTimeMillis() - start);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("t1 (ms between messages): ");
        int t1 = sc.nextInt();
        System.out.print("t2 (ms to process one message): ");
        int t2 = sc.nextInt();
        System.out.print("Number of messages: ");
        int count = sc.nextInt();
        sc.close();

        if (t1 < 0 || t2 < 0 || count < 1) {
            System.out.println("Wrong input");
            return;
        }

        MessageQueue queue = new MessageQueue();
        Producer producer = new Producer(queue, count, t1);
        Thread consumer = new Thread(new Consumer(queue, t2));

        start = System.currentTimeMillis();
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
        System.out.println(time() + " all messages are processed");
    }
}
