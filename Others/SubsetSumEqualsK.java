package Others;

public class SubsetSumEqualsK {

    public boolean isSubsetSum(int arr[], int sum) {
        boolean[][] dp = new boolean[arr.length+1][sum+1];

        for(int i=0;i<=arr.length;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[arr.length][sum];
    }

}
