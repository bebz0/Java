// Task 4.6
import animals.Animal;
import animals.Zoo;

public class Task4_6 {
    public static void main(String[] args) {
        Animal cat = new Animal("Cat");
        System.out.println("Created outside of the package: " + cat.getName());

        System.out.println("Zoo is in the same package, it can call protected method:");
        Zoo zoo = new Zoo();
        zoo.night(cat);

        // cat.sleep();   error: sleep() has protected access in animals.Animal

        System.out.println("Dog extends Animal, so it can call it too:");
        Dog dog = new Dog("Dog");
        dog.rest();
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void rest() {
        sleep();
    }
}
