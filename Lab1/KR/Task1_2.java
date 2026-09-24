// Task 1.2
public class Task1_2 {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Enter at least 3 arguments");
            return;
        }
        System.out.println("First argument: " + args[0]);
        System.out.println("Second argument: " + args[1]);
        System.out.println("Third argument: " + args[2]);

        double sum = 0;
        int count = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                double x = Double.parseDouble(args[i]);
                sum = sum + x;
                count++;
            } catch (NumberFormatException e) {
                System.out.println(args[i] + " is not a number");
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println("Real numbers entered: " + count);
    }
}
