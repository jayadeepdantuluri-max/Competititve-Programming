import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int seen = 0;
        int duplicate = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((seen & bit) != 0) {
                duplicate |= bit;
            } else {
                seen |= bit;
            }
        }

        int printed = 0;

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((duplicate & bit) != 0) {
                if ((printed & bit) == 0) {
                    if (result.length() > 0)
                        result.append(" ");
                    result.append(c);
                    printed |= bit;
                }
            }
        }

        if (result.length() == 0)
            System.out.println("No duplicates");
        else
            System.out.println(result);
    }
}
