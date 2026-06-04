package GFG_Medium;

public class Knapsack01 {

    public int knapsackRecusrive(int[][] dp, int[] wt, int[] val, int n, int w){
        if(w==0 || n==0) return 0;
        if(dp[n][w]!=-1) return dp[n][w];
        if(wt[n-1]<=w){
            dp[n][w] = Math.max(
                    val[n-1] + knapsackRecusrive(dp, wt, val, n-1, w-wt[n-1]),
                    knapsackRecusrive(dp, wt, val, n-1, w)
            );
        } else dp[n][w] = knapsackRecusrive(dp, wt, val, n-1, w);
        return dp[n][w];
    }

    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
}