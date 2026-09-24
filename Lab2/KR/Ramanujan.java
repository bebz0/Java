// Task 2.5
public class Ramanujan {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Ramanujan n");
            return;
        }
        long n = Long.parseLong(args[0]);

        for (long a = 1; a*a*a <= n; a++) {
            for (long b = a + 1; a*a*a + b*b*b <= n; b++) {
                long sum = a*a*a + b*b*b;
                for (long c = a + 1; 2*c*c*c < sum; c++) {
                    long d = Math.round(Math.cbrt(sum - c*c*c));
                    if (d > c && c*c*c + d*d*d == sum)
                        System.out.println(sum + " = " + a + "^3 + " + b + "^3 = " + c + "^3 + " + d + "^3");
                }
            }
        }

        System.out.println();
        System.out.println("87539319:");
        int ways = countWays(87539319);
        System.out.println(ways + " ways - its the smallest number that is a sum of two cubes in 3 different ways");
    }

    static int countWays(long x) {
        int count = 0;
        for (long a = 1; 2*a*a*a <= x; a++) {
            long b = Math.round(Math.cbrt(x - a*a*a));
            if (a*a*a + b*b*b == x) {
                System.out.println(x + " = " + a + "^3 + " + b + "^3");
                count++;
            }
        }
        return count;
    }
}
