import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();

        if (y == 0) {
            System.out.println("Division by zero");
            return;
        }

        boolean negative = (x < 0) ^ (y < 0);

        x = Math.abs(x);
        y = Math.abs(y);

        long low = 0;
        long high = x;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * y == x) {
                ans = mid;
                break;
            } else if (mid * y < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (negative) {
            ans = -ans;
        }

        System.out.println(ans);
    }
}
