// Task 4.10
package flowers;

public class Rose extends Flower {
    private boolean thorns;

    public Rose(double price, int freshness, int stemLength, boolean thorns) {
        super(price, freshness, stemLength);
        this.thorns = thorns;
    }

    public boolean hasThorns() {
        return thorns;
    }

    @Override
    public String getName() {
        return "Rose";
    }

    @Override
    public String toString() {
        if (thorns) {
            return super.toString() + ", with thorns";
        }
        return super.toString() + ", no thorns";
    }
}
