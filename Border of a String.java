import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();

        for (int len = n - 1; len > 0; len--) {
            boolean found = true;

            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != s.charAt(n - len + i)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println(s.substring(0, len));
                return;
            }
        }
    }
}
