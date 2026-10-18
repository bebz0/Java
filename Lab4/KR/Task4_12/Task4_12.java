// Task 4.12
public class Task4_12 {
    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.addItem("Bread", 28.5, 2);
        payment.addItem("Milk", 42, 1);

        Payment.Item cheese = payment.new Item("Cheese", 120, 1);
        payment.addItem(cheese);
        payment.addItem(payment.new Item("Apples", 30, 3));

        payment.print();
    }
}
