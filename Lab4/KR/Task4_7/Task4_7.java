// Task 4.7
public class Task4_7 {
    public static void main(String[] args) {
        Quadrilateral[] arr = {
            new Quadrilateral(0, 0, 2, 0, 2, 2, 0, 2),
            new Quadrilateral(1, 0, 2, 1, 1, 2, 0, 1),
            new Quadrilateral(0, 0, 5, 0, 5, 5, 0, 5),
            new Quadrilateral(0, 0, 4, 0, 4, 2, 0, 2),
            new Quadrilateral(0, 0, 6, 0, 6, 1, 0, 1),
            new Quadrilateral(0, 0, 2, 1, 4, 0, 2, -1),
            new Quadrilateral(0, 0, 1, 3, 0, 6, -1, 3),
            new Quadrilateral(0, 0, 5, 0, 4, 3, 1, 2),
            new Quadrilateral(0, 0, 3, 0, 5, 4, 0, 2)
        };

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "- " + arr[i].getType() + ", area = " + arr[i].area()
                    + ", perimeter = " + arr[i].perimeter());
        }
        System.out.println();

        String[] types = {"square", "rectangle", "rhombus", "arbitrary"};

        for (int t = 0; t < types.length; t++) {
            int count = 0;
            Quadrilateral minArea = null, maxArea = null;
            Quadrilateral minPer = null, maxPer = null;

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].getType().equals(types[t])) continue;
                count++;

                if (minArea == null || arr[i].area() < minArea.area()) minArea = arr[i];
                if (maxArea == null || arr[i].area() > maxArea.area()) maxArea = arr[i];
                if (minPer == null || arr[i].perimeter() < minPer.perimeter()) minPer = arr[i];
                if (maxPer == null || arr[i].perimeter() > maxPer.perimeter()) maxPer = arr[i];
            }

            System.out.println(types[t] + ": " + count);
            if (count > 0) {
                System.out.println("  max area: " + maxArea + "= " + maxArea.area());
                System.out.println("  min area: " + minArea + "= " + minArea.area());
                System.out.println("  max perimeter: " + maxPer + "= " + maxPer.perimeter());
                System.out.println("  min perimeter: " + minPer + "= " + minPer.perimeter());
            }
        }
    }
}
