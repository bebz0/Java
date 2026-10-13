// Task 4.10
package ships;

import java.util.Objects;

public class AircraftCarrier extends Warship {
    private int planes;

    public AircraftCarrier() {
        super();
        planes = 0;
    }

    public AircraftCarrier(String name, int speed, int crew) {
        this(name, speed, crew, 0);
    }

    public AircraftCarrier(String name, int speed, int crew, int planes) {
        super(name, speed, crew);
        this.planes = planes;
    }

    public int getPlanes() {
        return planes;
    }

    public void setPlanes(int planes) {
        this.planes = planes;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " launches " + planes + " planes");
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        AircraftCarrier other = (AircraftCarrier) obj;
        return planes == other.planes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planes);
    }

    @Override
    public String toString() {
        return "Aircraft carrier " + super.toString() + ", planes " + planes;
    }
}
