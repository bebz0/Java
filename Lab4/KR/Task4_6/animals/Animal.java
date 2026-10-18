// Task 4.6
package animals;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void sleep() {
        System.out.println(name + " is sleeping");
    }
}
