// Task 4.10
package flowers;

public class Tulip extends Flower {
    private String color;

    public Tulip(double price, int freshness, int stemLength, String color) {
        super(price, freshness, stemLength);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return "Tulip";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }
}
