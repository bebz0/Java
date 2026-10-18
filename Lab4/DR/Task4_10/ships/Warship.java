// Task 4.10
package ships;

import java.util.Objects;

public abstract class Warship implements Ship {
    private String name;
    private int speed;
    private int crew;

    public Warship() {
        this("Unknown", 0, 0);
    }

    public Warship(String name, int speed, int crew) {
        this.name = name;
        this.speed = speed;
        this.crew = crew;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    @Override
    public void sail() {
        System.out.println(name + " is sailing, speed " + speed + " knots");
    }

    public abstract void attack();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Warship other = (Warship) obj;
        return speed == other.speed && crew == other.crew && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed, crew);
    }

    @Override
    public String toString() {
        return name + ", speed " + speed + " knots, crew " + crew;
    }
}
