import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int factor = 1;

        while (a != b) {
            if ((a & 1) == 0 && (b & 1) == 0) {
                a >>= 1;
                b >>= 1;
                factor *= 2;
            } 
            else if ((a & 1) == 0) {
                a >>= 1;
            } 
            else if ((b & 1) == 0) {
                b >>= 1;
            } 
            else if (a > b) {
                a = (a - b) >> 1;
            } 
            else {
                b = (b - a) >> 1;
            }
        }

        System.out.println(a * factor);
    }
}
