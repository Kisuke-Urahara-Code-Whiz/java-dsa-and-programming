package LeetCodeMedium;

public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        if(nums.length>1){
            int pivot = -1;
            int r = nums.length-2;
            while(r>=0){
                if(nums[r]<nums[r+1]){
                    pivot = r;
                    break;
                } else r-=1;
            }
            if(pivot!=-1){
                int index = nums.length-1;
                while(index>pivot){
                    if(nums[index]>nums[pivot]) break;
                    else index-=1;
                }
                swap(nums, index, pivot);
                reverse(pivot+1, nums.length-1, nums);
            } else reverse(0, nums.length-1, nums);
        }
    }

    private void reverse(int l, int r, int[] arr){
        while(l<r){
            swap(arr, l, r);
            l+=1;
            r-=1;
        }
    }

    private void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
