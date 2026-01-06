package Programs;

import java.util.Arrays;

public class PivotRotatedSortedArray {

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

    static void main() {
        System.out.println(
                Arrays.toString(new int[]{1,2,3,4,5})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{1,2,3,4,5}));
        System.out.println(
                Arrays.toString(new int[]{2,3,4,5,1})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{2,3,4,5,1}));
        System.out.println(
                Arrays.toString(new int[]{3,4,5,1,2})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{3,4,5,1,2}));
        System.out.println(
                Arrays.toString(new int[]{4,5,1,2,3})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{4,5,1,2,3}));
        System.out.println(
                Arrays.toString(new int[]{5,1,2,3,4})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{5,1,2,3,4}));
        System.out.println(
                Arrays.toString(new int[]{6,1,2,3,4,5})+" -> "+new PivotRotatedSortedArray().findPivot(new int[]{6,1,2,3,4,5}));
    }
}

//4,5,6,7,0,1,2
//3,4,5,6,1,2
//0
//9,0,2,7,8