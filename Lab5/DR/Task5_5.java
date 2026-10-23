// Task 5.5
import java.util.Scanner;

public class Task5_5 {

    static boolean isValidEmail(String email) {
        String login = "[A-Za-z0-9._-]{1,32}";
        String company = "[A-Za-z0-9._-]{1,32}";
        String country = "([a-z]{2}|com|net|org)";
        return email.matches(login + "@" + company + "\\." + country);
    }

    public static void main(String[] args) {
        String[] tests = {
            "maksym.mokrytskyi@univ.ua",
            "roman_abyzov@gmail.com",
            "kudermin-roman@ukr.net",
            "kyrylo.batrak@knu.ua",
            "yevhen.poshtak@gmail.com",
            "maksym.mokrytskyi@univ",
            "roman.abyzov.gmail.com",
            "kudermin@@ukr.net",
            "kyrylo.batrak@knu.UA",
            "poshtak.yevhen@mysite.info",
            "maksym mokrytskyi@univ.ua",
            "maksym.mokrytskyi.roman.abyzov.2005@gmail.com"
        };

        for (int i = 0; i < tests.length; i++) {
            if (isValidEmail(tests[i]))
                System.out.println(tests[i] + " - valid");
            else
                System.out.println(tests[i] + " - not valid");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter email: ");
        if (sc.hasNextLine()) {
            String email = sc.nextLine();
            if (isValidEmail(email))
                System.out.println("Valid");
            else
                System.out.println("Not valid");
        }
        sc.close();
    }
}
