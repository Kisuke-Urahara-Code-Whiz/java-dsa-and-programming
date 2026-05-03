package Programs;

public class MinimumSubsetDifference{

    public int getSum(int[] arr){
        int sum = 0;
        for(int i:arr){
            sum+=1;
        }
        return sum;
    }

    public int knapsack(int[] arr, int sum, int s, int n){
        if(n==0) return Math.abs(s-(sum-s));
        else return Math.min(
                knapsack(arr, sum, s-arr[n-1], n-1),
                knapsack(arr, sum, s, n-1)
        );
    }

    public int knapsackTopDown(int[] arr, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0) dp[i][j] = Math.abs(j-(sum-j));
                else if(j==0) dp[i][j] = sum;
                else dp[i][j] = -1;
            }
        }
        return memoise(arr, sum, sum, n, dp);
    }

    public int memoise(int[] arr, int sum, int s, int n, int[][] dp) {
        if (dp[n][s] == -1) dp[n][s] = Math.min(
                memoise(arr, sum, s - arr[n - 1], n - 1, dp),
                memoise(arr, sum, s, n - 1, dp)
        );
        return dp[n][s];
    }

    public int knapsackBottomUp(int[] arr, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0) dp[i][j] = Math.abs(j-(sum-j));
                else if(j==0) dp[i][j] = sum;
                else dp[i][j] = -1;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.min(dp[i-1][j-arr[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][sum];
    }
}
