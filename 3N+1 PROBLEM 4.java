import java.io.*;
import java.util.*;
public class Solution {
    public static int cycleLength(int n) {
        int count = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int start = Math.min(i, j);
        int end = Math.max(i, j);
        int maxCycle = 0;
        for (int k = start; k <= end; k++) {
            int length = cycleLength(k);
            if (length > maxCycle) {
                maxCycle = length;
            }
        }
        System.out.println(i + " " + j + " " + maxCycle);
        sc.close();
    }
}
