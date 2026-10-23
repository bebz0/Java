// Task 5.6
public class Task5_6 {

    static String removeDigits(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) continue;
            if (c == '+' || c == '-')
                res += c;
            res += c;
        }
        return res;
    }

    static String removePlus(String s) {
        return s.replaceAll("\\+(?=\\d)", "");
    }

    static String removeV(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == 'в' && s.charAt(i - 1) == 'с')
                continue;
            res += s.charAt(i);
        }
        return res;
    }

    static String replacePh(String s) {
        return s.replace("ph", "f");
    }

    static String removeSpaces(String s) {
        return s.replaceAll(" +", " ");
    }

    public static void main(String[] args) {
        String s = "my phone  +380 50 123-45-67,   x+5 - y+z,   свято свобода   alphabet";

        System.out.println("String:          " + s);
        System.out.println("No digits:       " + removeDigits(s));
        System.out.println("No + before digit: " + removePlus(s));
        System.out.println("No v after s:    " + removeV(s));
        System.out.println("ph -> f:         " + replacePh(s));
        System.out.println("No extra spaces: " + removeSpaces(s));
    }
}
