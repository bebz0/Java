// Task 3.15
public class Task3_15 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Task3_15 code");
            return;
        }

        long code = Long.parseLong(args[0]);
        if (code < 0 || code > 99999999999L) {
            System.out.println("Code must have 11 digits");
            return;
        }

        long x = code;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 2; i <= 12; i++) {
            int d = (int)(x % 10);
            if (i % 2 == 0)
                sum2 += d;
            else
                sum1 += d;
            x = x / 10;
        }

        int check = (10 - (sum1 + 3 * sum2) % 10) % 10;
        System.out.println("Check digit: " + check);
        System.out.printf("UPC: %011d%d\n", code, check);
    }
}
