// Task 4.10
package flowers;

public class Lily extends Flower {

    public Lily(double price, int freshness, int stemLength) {
        super(price, freshness, stemLength);
    }

    @Override
    public String getName() {
        return "Lily";
    }
}
