// Task 4.8
package connection;

public class ConnectionManager {
    private static Connection[] connections = new Connection[5];
    private static int next = 0;

    static {
        for (int i = 0; i < connections.length; i++)
            connections[i] = new Connection(i + 1);
    }

    public static Connection getConnection() {
        if (next < connections.length) {
            Connection c = connections[next];
            next++;
            return c;
        }
        return null;
    }
}
