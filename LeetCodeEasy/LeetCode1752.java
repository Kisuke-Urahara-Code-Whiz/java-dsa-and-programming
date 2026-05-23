package LeetCodeEasy;

public class LeetCode1752 {

    public boolean check(int[] nums) {
        if(nums.length<=2) return true;
        else{
            boolean sorted = true;
            int index = 0;
            int length = nums.length;
            while(index!=length){
                if(nums[index]>nums[(index+1)%length]){
                    if(sorted) sorted = false;
                    else return false;
                }
                index+=1;
            }
        }
        return true;
    }

}
