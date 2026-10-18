// Task 4.8
import connection.Connection;
import connection.ConnectionManager;

public class Task4_8 {
    public static void main(String[] args) {
        Connection c = ConnectionManager.getConnection();

        while (c != null) {
            System.out.println("Got " + c);
            c = ConnectionManager.getConnection();
        }

        System.out.println("No more conections, manager is done");
    }
}
