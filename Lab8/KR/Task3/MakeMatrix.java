// Task 3
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MakeMatrix {
    public static void main(String[] args) throws IOException {
        Path file = Path.of(args.length > 0 ? args[0] : "matrix.bin");
        double[][] matrix = {
                {1.5, -2.0, 0.0, -9.5},
                {4.25, 0.0, 3.0, 7.0},
                {-0.5, 9.5, 2.0, -6.75}
        };

        try (DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(file)))) {
            output.writeInt(matrix.length);
            output.writeInt(matrix[0].length);
            for (double[] row : matrix) {
                for (double value : row) {
                    output.writeDouble(value);
                }
            }
        }
        System.out.println("Matrix " + matrix.length + " x " + matrix[0].length + " was written to " + file);
    }
}
