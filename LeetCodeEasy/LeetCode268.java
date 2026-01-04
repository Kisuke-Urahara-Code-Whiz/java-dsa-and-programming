package LeetCodeEasy;

public class LeetCode268 {

//  Cyclic Sort Approach
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==missing){
                missing = i;
                break;
            }
        }
        return missing;
    }

    public void cyclicSort(int[] arr){
        for(int i=0;i<arr.length;i++){
             while(i!=arr[i] && arr[i]!=arr.length){
                 swap(i, arr[i], arr);
             }
        }
    }

    public void swap(int index1, int index2, int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

//    Sum Approach
//    public int missingNumber(int [] nums){
//        int n = nums.length;
//        int sum = n*(n+1)/2;
//        int news = 0;
//        for(int i = 0;i<nums.length;i++){
//            news += nums[i];
//        }
//        return sum - news;
//    }

    static void main() {
        System.out.println(new LeetCode268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
