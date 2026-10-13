// Task 4.10
import bouquet.Accessory;
import bouquet.Bouquet;
import flowers.Flower;
import flowers.Lily;
import flowers.Rose;
import flowers.Tulip;

import java.util.ArrayList;
import java.util.Scanner;

public class Task4_10 {

    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose(60, 7, 55, true));
        bouquet.addFlower(new Rose(75, 9, 70, false));
        bouquet.addFlower(new Tulip(35, 5, 30, "yellow"));
        bouquet.addFlower(new Tulip(35, 10, 32, "red"));
        bouquet.addFlower(new Lily(90, 8, 60));
        bouquet.addAccessory(new Accessory("Ribbon", 15));
        bouquet.addAccessory(new Accessory("Paper", 40));

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println();
            System.out.println("1 - show boquet");
            System.out.println("2 - price");
            System.out.println("3 - sort flowers by freshness");
            System.out.println("4 - find flowers by stem length");
            System.out.println("0 - exit");
            System.out.print("> ");
            choice = sc.nextInt();

            if (choice == 1) {
                bouquet.print();
            } else if (choice == 2) {
                System.out.println("Price: " + bouquet.getPrice());
            } else if (choice == 3) {
                bouquet.sortByFreshness();
                bouquet.print();
            } else if (choice == 4) {
                System.out.print("Min length: ");
                int min = sc.nextInt();
                System.out.print("Max length: ");
                int max = sc.nextInt();

                ArrayList<Flower> found = bouquet.findByStemLength(min, max);
                if (found.size() == 0) {
                    System.out.println("Nothing found");
                }
                for (Flower f : found) {
                    System.out.println(f);
                }
            } else if (choice != 0) {
                System.out.println("Wrong choice");
            }
        }

        sc.close();
    }
}
