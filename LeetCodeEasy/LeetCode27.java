package LeetCodeEasy;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int a = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                if(a!=i)
                    nums[a] = nums[i];
                a+=1;
                sum+=1;
            }
        }
        return sum;
    }
}
