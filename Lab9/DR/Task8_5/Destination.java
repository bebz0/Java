// Task 8.5
public class Destination {
    private String city;
    private int distance;

    public Destination(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }

    public String getZone() {
        if (distance < 1500)
            return "short";
        if (distance < 4000)
            return "medium";
        return "long";
    }

    public String toString() {
        return city + " (" + distance + " km, " + getZone() + " zone)";
    }
}
