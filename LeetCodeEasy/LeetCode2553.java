package LeetCodeEasy;

public class LeetCode2553 {

    public int[] separateDigits(int[] nums) {
        int totalLength = 0;
        int[] lengthArr = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            int a = nums[i];
            int length = 0;
            while(a>0){
                length+=1;
                a = a/10;
            }
            lengthArr[i] = length;
            totalLength+=length;
        }
        int[] result = new int[totalLength];
        int ptr = -1;
        for(int i=0;i<nums.length;i++){
            ptr+=lengthArr[i];
            int tempPtr = ptr;
            while(nums[i]>0){
                result[tempPtr--] = nums[i]%10;
                nums[i]/=10;
            }
        }
        return result;
    }

}
