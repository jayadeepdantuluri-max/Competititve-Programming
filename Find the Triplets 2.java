import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        long X = sc.nextLong();

        Arrays.sort(arr);

        boolean found = false;

        for (int i = 0; i < N - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (sum == X) {
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    found = true;

                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1])
                        left++;

                    while (left < right && arr[right] == arr[right + 1])
                        right--;

                } else if (sum < X) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        if (!found) {
            System.out.println("No Triplet Found");
        }

        sc.close();
    }
}
