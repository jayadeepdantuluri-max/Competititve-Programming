import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] words = sc.nextLine().split(",");
        String pattern = sc.nextLine().trim();

        boolean found = false;

        for (String word : words) {
            word = word.trim();

            int j = 0;

            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c) && j < pattern.length()
                        && c == pattern.charAt(j)) {
                    j++;
                }
            }

            if (j == pattern.length()) {
                System.out.println(word);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No match found");
        }
    }
}
