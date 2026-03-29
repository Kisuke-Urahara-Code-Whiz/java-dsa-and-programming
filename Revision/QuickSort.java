package Revision;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int l, int r){
        if(r-l==1) return;

        int pivot = arr[l+(r-l)/2];
        int s = l;
        int e = r;

        while(s<e){
            while(arr[s]<pivot){
                s+=1;
            }

            while(arr[e]>pivot){
                e-=1;
            }

            if(s<e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s+=1;
                e-=1;
            }
        }

        sort(arr, l, s-1);
        sort(arr, e+1, r);
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] arr = new int[]{5,5,4,3,2,1};
        obj.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
