package LeetCodeMedium;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int index1 = binarySearch(nums,0,pivot,target);
        if(index1!=-1)
            return index1;
        else if(pivot<nums.length){
            int index2 = binarySearch(nums,pivot+1,nums.length-1,target);
            if(index2!=-1)
                return index2;
            else
                return -1;
        }
        else
            return -1;
    }

    public int findPivot(int[] arr){
        int s = 0;
        int e = arr.length-1;
        if(arr[s]<arr[e]){
            return e;
        }
        int a = 0;
        while(s<e){
            int mid = s + (e - s)/2;
            boolean flag1 = mid+1<arr.length;
            boolean flag2 = mid-1>=0;
            if(flag1){
                if(arr[mid]>arr[mid+1]){
                    a = mid;
                    break;
                }
            }
            if(flag2){
                if(arr[mid]<arr[mid-1]){
                    a = mid-1;
                    break;
                }
            }
            if(arr[mid]>arr[e])
                s=mid+1;
            else
                e=mid-1;
        }
        return a;
    }

    public int binarySearch(int[] arr, int s, int e, int ele){
        while(s<=e){
            int mid = s + (e - s)/2;
            if(arr[mid] == ele){
                return mid;
            }
            else{
                if(arr[mid]>ele)
                    e = mid-1;
                else
                    s = mid+1;
            }
        }
        return -1;
    }
}
