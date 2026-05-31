package LeetCodeEasy;

public class LeetCode3300 {

    public int minElement(int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int i: nums){
            result = Math.min(countSum(i), result);
        }
        return result;
    }

    private int countSum(int n){
        int s = 0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }

}
