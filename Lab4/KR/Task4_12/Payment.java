// Task 4.12
import java.util.ArrayList;

public class Payment {
    private ArrayList<Item> items = new ArrayList<Item>();

    public class Item {
        private String name;
        private double price;
        private int count;

        public Item(String name, double price, int count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public double getCost() {
            return price * count;
        }

        public String toString() {
            return name + ": " + price + " x " + count + " = " + getCost();
        }
    }

    public void addItem(String name, double price, int count) {
        items.add(new Item(name, price, count));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++)
            total += items.get(i).getCost();
        return total;
    }

    public void print() {
        System.out.println("Purchase:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ") " + items.get(i));
        }
        System.out.println("Total: " + getTotal());
    }
}
