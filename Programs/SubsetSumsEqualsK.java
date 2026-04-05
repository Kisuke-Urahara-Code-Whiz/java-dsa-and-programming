package Programs;

public class SubsetSumsEqualsK {

    public boolean knapsack(int[] arr, int n, int s){
        if(s==0) return true;
        else if(n==0) return false;
        else{
            boolean flag = false;
            if(arr[n-1]<=s){
                flag = knapsack(arr, n-1, s-arr[n-1]);
                if(!flag) knapsack(arr, n-1, s);
            } else flag = knapsack(arr, n-1, s);
            return flag;
        }
    }

    public boolean knapsackTopDown(int[] arr, int n, int s){
        Boolean[][] dp = new Boolean[n+1][s+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else dp[i][j] = null;
            }
        }
        return memoise(arr, n, s, dp);
    }

    public boolean knapsackBottomUp(int[] arr, int n, int s){
        Boolean[][] dp = new Boolean[n+1][s+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else dp[i][j] = null;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=s;j++){
                if (arr[i - 1] <= j) dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s];
    }

    public boolean memoise(int[] arr, int n, int s, Boolean[][] dp){
        if(s==0) return true;
        else if(n==0) return false;
        if(dp[n][s]==null) {
            if (arr[n - 1] <= s) dp[n][s] = memoise(arr, n - 1, s - arr[n - 1], dp) || memoise(arr, n - 1, s, dp);
            else dp[n][s] = memoise(arr, n - 1, s, dp);
        }
        return dp[n][s];
    }
}
