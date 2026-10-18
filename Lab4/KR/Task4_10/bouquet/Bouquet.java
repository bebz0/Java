// Task 4.10
package bouquet;

import flowers.Flower;
import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers = new ArrayList<Flower>();
    private ArrayList<Accessory> accessories = new ArrayList<Accessory>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public double getPrice() {
        double sum = 0;
        for (Flower f : flowers) {
            sum += f.getPrice();
        }
        for (Accessory a : accessories) {
            sum += a.getPrice();
        }
        return sum;
    }

    public void sortByFreshness() {
        for (int i = 0; i < flowers.size() - 1; i++) {
            for (int j = 0; j < flowers.size() - 1 - i; j++) {
                if (flowers.get(j).getFreshness() < flowers.get(j + 1).getFreshness()) {
                    Flower tmp = flowers.get(j);
                    flowers.set(j, flowers.get(j + 1));
                    flowers.set(j + 1, tmp);
                }
            }
        }
    }

    public ArrayList<Flower> findByStemLength(int min, int max) {
        ArrayList<Flower> result = new ArrayList<Flower>();
        for (Flower f : flowers) {
            if (f.getStemLength() >= min && f.getStemLength() <= max) {
                result.add(f);
            }
        }
        return result;
    }

    public void print() {
        System.out.println("Flowers:");
        for (Flower f : flowers) {
            System.out.println("  " + f);
        }
        System.out.println("Accessories:");
        for (Accessory a : accessories) {
            System.out.println("  " + a);
        }
    }
}
