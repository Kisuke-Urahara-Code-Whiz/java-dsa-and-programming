package LeetCodeMedium;

public class LeetCode33 {

    private int findPivot(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]<arr[l]) r = mid;
            else if(arr[mid]>arr[r]) l = mid+1;
            else break;
        }
        return l;
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot==0) return binarySearch(nums, target, 0, nums.length-1);
        else{
            int ans = binarySearch(nums, target, 0, pivot-1);
            if(ans==-1) ans = binarySearch(nums, target, pivot, nums.length-1);
            return ans;
        }
    }

    private int binarySearch(int[] arr, int target, int l , int r){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
