import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] a = new double[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextDouble();

        double min = a[0], max = a[0];

        for (double x : a) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        ArrayList<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++)
            buckets[i] = new ArrayList<>();

        if (min == max) {
            System.out.println(format(a[0]));
            return;
        }

        for (double x : a) {
            int index = (int)((x - min) / (max - min) * n);
            if (index == n)
                index = n - 1;
            buckets[index].add(x);
        }

        for (int i = 0; i < n; i++)
            Collections.sort(buckets[i]);

        boolean first = true;

        for (ArrayList<Double> bucket : buckets) {
            for (double x : bucket) {
                if (!first)
                    System.out.print(" ");
                System.out.print(format(x));
                first = false;
            }
        }

        System.out.println();
    }

    static String format(double x) {
        if (x == Math.floor(x))
            return String.format("%.0f", x);
        return String.format("%.2f", x);
    }
}
