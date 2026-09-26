// Task 2.1
public class Task2_1 {
    public static void main(String[] args) {
        int a = 0x12345678;
        int b = 0x87654321;

        System.out.println("a = " + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.println();

        System.out.println("a & b = " + Integer.toBinaryString(a & b));
        System.out.println("a | b = " + Integer.toBinaryString(a | b));
        System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b));
        System.out.println("~a = " + Integer.toBinaryString(~a));
        System.out.println("~b = " + Integer.toBinaryString(~b));

        System.out.println();
        System.out.println("a << 1 = " + Integer.toBinaryString(a << 1));
        System.out.println("a >> 1 = " + Integer.toBinaryString(a >> 1));
        System.out.println("a >>> 1 = " + Integer.toBinaryString(a >>> 1));
        System.out.println("b << 1 = " + Integer.toBinaryString(b << 1));
        System.out.println("b >> 1 = " + Integer.toBinaryString(b >> 1));
        System.out.println("b >>> 1 = " + Integer.toBinaryString(b >>> 1));
    }
}
