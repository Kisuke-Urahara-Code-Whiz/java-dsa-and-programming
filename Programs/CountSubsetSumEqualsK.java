package Programs;

public class CountSubsetSumEqualsK {

    public int knapsack(int[] arr, int s, int n){
        if(s==0) return 1;
        else if(n==0) return 0;
        else{
            if(arr[n-1]<=s) return knapsack(arr,s-arr[n-1],n-1)+knapsack(arr,s,n-1);
            else return knapsack(arr,s,n-1);
        }
    }

    public int knapsackTopDown(int[] arr, int s, int n){
        int[][] dp = new int[n+1][s+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(j==0) dp[i][j] = 1;
                else if(i==0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        return memoise(arr, s, n, dp);
    }

    public int memoise(int[] arr, int s, int n, int[][] dp){
        if(dp[n][s]==-1){
            if(arr[n-1]<=s)
                dp[n][s] = memoise(arr, s-arr[n-1], n-1, dp) + memoise(arr, s,n-1, dp);
            else
                dp[n][s] = memoise(arr, s, n-1, dp);
        }
        return dp[n][s];
    }

    public int knapsackBottomUp(int[] arr, int s, int n){
        int[][] dp = new int[n+1][s+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(j==0) dp[i][j] = 1;
                else if(i==0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][s];
    }

    public static void main(String[] args) {
        System.out.println(new CountSubsetSumEqualsK().knapsack(
                new int[]{1,2,3}, 2, 3
        ));
    }
}
