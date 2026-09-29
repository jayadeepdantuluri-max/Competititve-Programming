import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int N = sc.nextInt();

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[V + 1];
        Arrays.fill(dp, V + 1);
        dp[0] = 0;

        for (int amount = 1; amount <= V; amount++) {
            for (int coin : coins) {
                if (coin <= amount) {
                    dp[amount] = Math.min(dp[amount],
                                          dp[amount - coin] + 1);
                }
            }
        }

        if (dp[V] == V + 1) {
            System.out.println("-1");
        } else {
            System.out.println(dp[V]);
        }

        sc.close();
    }
}
