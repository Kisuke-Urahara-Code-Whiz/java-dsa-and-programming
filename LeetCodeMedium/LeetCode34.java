package LeetCodeMedium;

import java.util.Arrays;

public class LeetCode34 { 
    
    //Practically this is better in t.c than the below solution but 0ms in LeetCode anyway
    //space complexity not good as the below solution
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = binarySearch(nums,target,0,nums.length-1);
        int a = 1;
        int b = 1;
        while(a!=-1){
            int temp = binarySearch(nums,target,0,result[0]-1);
            result[0] = temp==-1?result[0]:temp;
            a = temp==-1?temp:a;
        }
        while(b!=-1){
            int temp = binarySearch(nums,target,result[1]+1,nums.length-1);
            result[1] = temp==-1?result[1]:temp;
            b = temp==-1?temp:b;
        }
        return result;
    }

    public int binarySearch(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }

    static void main() {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8},8)));
    }

//    A Second Solution
//    public int[] searchRange(int[] nums, int target) {
//        int l = 0;
//        int r = nums.length-1;
//        int range [] =  new int[2];
//        range[0]=lowerBound(nums,target);
//        range[1]=upperBound(nums,target);
//        return range;
//    }
//
//
//    public int[] searchRangeLog(int[] nums, int target) {
//        int range [] =  new int[2];
//        range[0]=lowerBound(nums,target);
//        range[1]=upperBound(nums,target);
//        return range;
//    }
//
//    public static int lowerBound(int arr[],int target){
//        int l=0;
//        int r=arr.length-1;
//        int lower = -1;
//        while(l<=r){
//            int mid = l+(r-l)/2;
//            lower = arr[mid]==target?mid:lower;
//            if(arr[mid]>=target){
//                r=mid-1;
//            }
//            else{
//                l=mid+1;
//            }
//        }
//        return lower;
//    }
//
//    public static int upperBound(int arr[],int target){
//        int l=0;
//        int r=arr.length-1;
//        int upper = -1;
//        while(l<=r){
//            int mid = l+(r-l)/2;
//            upper = arr[mid]==target?mid:upper;
//            if(arr[mid]<=target){
//                l=mid+1;
//            }
//            else{
//                r=mid-1;
//            }
//        }
//        return upper;
//    }
}