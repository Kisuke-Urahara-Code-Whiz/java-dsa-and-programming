package Revision;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int l, int r){
        if(l>=r) return;

        int pivot = arr[l+(r-l)/2];
        int s = l;
        int e = r;

        while(s<=e){
            while(arr[s]<pivot){
                s+=1;
            }

            while(arr[e]>pivot){
                e-=1;
            }

            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s+=1;
                e-=1;
            }
        }

        if(l<e) sort(arr, l, e);
        if(s<r) sort(arr, s, r);
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] arr = new int[]{5,2,4,3,5,1};
        obj.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
