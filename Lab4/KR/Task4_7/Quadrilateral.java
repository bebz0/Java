// Task 4.7
public class Quadrilateral {
    private double[] x;
    private double[] y;

    public Quadrilateral(double x1, double y1, double x2, double y2,
                         double x3, double y3, double x4, double y4) {
        x = new double[]{x1, x2, x3, x4};
        y = new double[]{y1, y2, y3, y4};
    }

    private double side(int i, int j) {
        double dx = x[i] - x[j];
        double dy = y[i] - y[j];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double perimeter() {
        return side(0, 1) + side(1, 2) + side(2, 3) + side(3, 0);
    }

    public double area() {
        double s = 0;
        for (int i = 0; i < 4; i++) {
            int j = (i + 1) % 4;
            s += x[i] * y[j] - x[j] * y[i];
        }
        return Math.abs(s) / 2;
    }

    private boolean same(double a, double b) {
        return Math.abs(a - b) < 0.000001;
    }

    public String getType() {
        double a = side(0, 1);
        double b = side(1, 2);
        double c = side(2, 3);
        double d = side(3, 0);
        double d1 = side(0, 2);
        double d2 = side(1, 3);

        boolean allSides = same(a, b) && same(b, c) && same(c, d);
        boolean opposite = same(a, c) && same(b, d);
        boolean diagonals = same(d1, d2);

        if (allSides && diagonals) return "square";
        if (opposite && diagonals) return "rectangle";
        if (allSides) return "rhombus";
        return "arbitrary";
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 4; i++)
            s += "(" + x[i] + "; " + y[i] + ") ";
        return s;
    }
}
