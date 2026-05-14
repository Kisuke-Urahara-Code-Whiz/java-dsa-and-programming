package LeetCodeEasy;

public class LeetCode2784 {

    public boolean isGood(int[] nums) {
        if(nums.length == 1) return false;
        int length = nums.length;
        int maxVal = length-1;
        int[] occurences = new int[maxVal];
        for(int i: nums){
            if(i>maxVal) return false;
            else if(i==maxVal){
                if(occurences[i-1]==2) return false;
                occurences[i-1]+=1;
            } else {
                if(occurences[i-1]==1) return false;
                occurences[i-1]+=1;
            }
        }
        return true;
    }

}
