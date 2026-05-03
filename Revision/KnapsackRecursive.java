package Revision;

public class KnapsackRecursive {

    public int knapsack(int[] wt, int[] val, int w, int n){
        if(w==0 || n==0)
            return 0;
        if(wt[n-1]<=w){
            return Math.max(
                    val[n-1]+knapsack(wt, val, w-wt[n-1], n-1),
                    knapsack(wt,val,w,n-1)
            );
        } else
            return knapsack(wt,val,w,n-1);
    }

    public static void main(String[] args) {
        System.out.println("Maximum profit -> "+
                new KnapsackRecursive().knapsack(
                        new int[]{1,2,3,4},
                        new int[]{23,45,21,43},
                        4,
                        4
                ));
    }
}
