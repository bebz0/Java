// Task 4.10
import ships.AircraftCarrier;
import ships.Ship;
import ships.Warship;

import java.util.Scanner;

public class Task4_10_DR {

    static AircraftCarrier[] createCarriers() {
        AircraftCarrier[] arr = new AircraftCarrier[5];
        arr[0] = new AircraftCarrier("Enterprise", 33, 4600, 90);
        arr[1] = new AircraftCarrier("Charles de Gaulle", 27, 1950, 40);
        arr[2] = new AircraftCarrier("Queen Elizabeth", 25, 1600, 60);
        arr[3] = new AircraftCarrier("Nimitz", 30, 5000);
        arr[4] = new AircraftCarrier();
        arr[3].setPlanes(85);
        return arr;
    }

    static void printWithMorePlanes(AircraftCarrier[] arr, int planes) {
        System.out.println("Carriers with more than " + planes + " planes:");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPlanes() > planes) {
                System.out.println("  " + arr[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  nothing found");
        }
    }

    public static void main(String[] args) {
        AircraftCarrier[] carriers = createCarriers();

        System.out.println("All ships:");
        for (int i = 0; i < carriers.length; i++) {
            System.out.println("  " + carriers[i]);
        }
        System.out.println();

        Ship ship = carriers[0];
        ship.sail();
        Warship warship = carriers[1];
        warship.sail();
        warship.attack();
        System.out.println();

        AircraftCarrier copy = new AircraftCarrier("Enterprise", 33, 4600, 90);
        System.out.println("Is the copy equal to the first ship: " + copy.equals(carriers[0]));
        System.out.println("Same hash codes: " + (copy.hashCode() == carriers[0].hashCode()));
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of planes: ");
        int planes = sc.nextInt();
        sc.close();

        printWithMorePlanes(carriers, planes);
    }
}
