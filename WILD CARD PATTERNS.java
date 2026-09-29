import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.nextLine().trim();
        String pat = s.nextLine().trim();

        int i = 0, j = 0, star = -1, mark = -1;

        while (i < str.length()) {
            if (j < pat.length() &&
                (pat.charAt(j) == '?' || pat.charAt(j) == str.charAt(i))) {
                i++;
                j++;
            } else if (j < pat.length() && pat.charAt(j) == '*') {
                star = j++;
                mark = i;
            } else if (star != -1) {
                j = star + 1;
                i = ++mark;
            } else {
                System.out.println(0);
                return;
            }
        }

        while (j < pat.length() && pat.charAt(j) == '*')
            j++;

        System.out.println(j == pat.length() ? 1 : 0);
    }
}
