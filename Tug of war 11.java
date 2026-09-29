import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int[] a;
    static long total;
    static long ans = Long.MAX_VALUE;

    static void solve(int index, int count, long sum) {
        if (count > (n + 1) / 2)
            return;

        if (index == n) {
            int otherCount = n - count;

            if (Math.abs(count - otherCount) <= 1) {
                long diff = Math.abs(total - 2 * sum);
                ans = Math.min(ans, diff);
            }
            return;
        }

        solve(index + 1, count, sum);
        solve(index + 1, count + 1, sum + a[index]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            total += a[i];
        }

        solve(0, 0, 0);

        System.out.println(ans);
    }
}
