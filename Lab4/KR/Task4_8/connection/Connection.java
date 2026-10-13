// Task 4.8
package connection;

public class Connection {
    private int id;

    Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Connection #" + id;
    }
}
