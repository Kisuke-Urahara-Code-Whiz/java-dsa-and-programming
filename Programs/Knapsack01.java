package Programs;

public class Knapsack01 {

    public int knapsack(int[] wts, int[] profits, int w, int n){
        if(n==0 || w==0) return 0;
        else{
            if(wts[n-1]<=w){
                return Math.max(
                        profits[n-1]+knapsack(wts, profits, w-wts[n-1], n-1),
                        knapsack(wts, profits, w, n-1)
                );
            } else return knapsack(wts, profits, w, n-1);
        }
    }

    public int knapsackMemoise(int[] wts, int[] profits, int w, int n){
        int[][] dp = new int[w+1][n+1];
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        return memoisation(dp, wts, profits, w, n);
    }

    public int memoisation(int[][] dp, int[] wts, int[] profits, int w, int n){
        if(n==0 || w==0) return 0;
        else{
            if(dp[w][n]!=-1) return dp[w][n];
            if(wts[n-1]<=w){
                dp[w][n] = Math.max(
                        profits[n-1]+knapsack(wts, profits, w-wts[n-1], n-1),
                        knapsack(wts, profits, w, n-1)
                );
                return dp[w][n];
            } else{
                dp[w][n] = knapsack(wts, profits, w, n-1);
                return dp[w][n];
            }
        }
    }

    public static void main(String[] args) {
        int[] wts = new int[]{1,2,3,4,5};
        int[] profits = new int[]{34,67,45,23,56};
        Knapsack01 obj = new Knapsack01();
        int maxWeight = 7;
        System.out.println("Maximum profit -> " + obj.knapsack(wts, profits, maxWeight, wts.length));
        System.out.println("Maximum profit -> " + obj.knapsackMemoise(wts, profits, maxWeight, wts.length));
    }

}
