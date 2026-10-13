// Task 4.5
package points;

import java.util.Objects;

public class MovingPoint extends Point {
    private double dirX;
    private double dirY;
    private double speed;
    private double acceleration;

    public MovingPoint() {
        super();
        dirX = 1;
        dirY = 0;
        speed = 1;
        acceleration = 0;
    }

    public MovingPoint(double x, double y, double dirX, double dirY, double speed) {
        this(x, y, dirX, dirY, speed, 0);
    }

    public MovingPoint(double x, double y, double dirX, double dirY, double speed, double acceleration) {
        super(x, y);
        this.dirX = dirX;
        this.dirY = dirY;
        this.speed = Math.abs(speed);
        this.acceleration = Math.abs(acceleration);
    }

    public double getDirX() {
        return dirX;
    }

    public void setDirX(double dirX) {
        this.dirX = dirX;
    }

    public double getDirY() {
        return dirY;
    }

    public void setDirY(double dirY) {
        this.dirY = dirY;
    }

    public void setDirection(double dirX, double dirY) {
        this.dirX = dirX;
        this.dirY = dirY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = Math.abs(speed);
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = Math.abs(acceleration);
    }

    public boolean isMoving() {
        return (dirX != 0 || dirY != 0) && (speed > 0 || acceleration > 0);
    }

    private double dirLength() {
        return Math.sqrt(dirX * dirX + dirY * dirY);
    }

    public double getVelocity(double t) {
        if (!isMoving()) {
            return 0;
        }
        return speed + acceleration * t;
    }

    public Point getPosition(double t) {
        if (!isMoving()) {
            return new Point(getX(), getY());
        }
        double s = speed * t + acceleration * t * t / 2;
        double len = dirLength();
        return new Point(getX() + dirX / len * s, getY() + dirY / len * s);
    }

    private boolean passesThrough(Point p) {
        double px = p.getX() - getX();
        double py = p.getY() - getY();

        if (!isMoving()) {
            return Math.abs(px) < 0.000001 && Math.abs(py) < 0.000001;
        }

        double ax = dirX / dirLength();
        double ay = dirY / dirLength();
        if (Math.abs(px * ay - py * ax) > 0.000001) {
            return false;
        }
        return px * ax + py * ay >= 0;
    }

    public boolean canIntersect(MovingPoint other) {
        if (!isMoving()) {
            return other.passesThrough(this);
        }
        if (!other.isMoving()) {
            return passesThrough(other);
        }

        double ax = dirX / dirLength();
        double ay = dirY / dirLength();
        double bx = other.dirX / other.dirLength();
        double by = other.dirY / other.dirLength();

        double px = other.getX() - getX();
        double py = other.getY() - getY();
        double cross = ax * by - ay * bx;

        if (Math.abs(cross) < 0.000001) {
            if (Math.abs(px * ay - py * ax) > 0.000001) {
                return false;
            }
            if (ax * bx + ay * by > 0) {
                return true;
            }
            return px * ax + py * ay >= 0;
        }

        double s = (px * by - py * bx) / cross;
        double u = (px * ay - py * ax) / cross;
        return s >= 0 && u >= 0;
    }

    public double distanceTo(MovingPoint other, double t) {
        return getPosition(t).distanceTo(other.getPosition(t));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        MovingPoint other = (MovingPoint) obj;
        return Double.compare(dirX, other.dirX) == 0
                && Double.compare(dirY, other.dirY) == 0
                && Double.compare(speed, other.speed) == 0
                && Double.compare(acceleration, other.acceleration) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dirX, dirY, speed, acceleration);
    }

    @Override
    public String toString() {
        return "Point " + super.toString() + ", direction (" + dirX + "; " + dirY + "), speed "
                + speed + ", acceleration " + acceleration;
    }
}
