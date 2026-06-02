package Programs;

import java.util.Arrays;

public class QuickSort {

    private void sort(int[] arr, int l, int r){

        if(l>=r) return;

        int mid = l+(r-l)/2;
        int pivot = arr[mid];
        int s = l;
        int e = r;

        while(s<=e){

            while(arr[s]<pivot){
                s++;
            }

            while(arr[e]>pivot){
                e--;
            }

            while(s<=e){
                swap(arr, s, e);
                s++;
                e--;
            }

            sort(arr, l, e);
            sort(arr, s, r);
        }
    }

    private void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,1};
        System.out.println("Original array -> \n"+ Arrays.toString(arr));
        QuickSort obj = new QuickSort();
        obj.sort(arr,0,arr.length-1);
        System.out.println("Sorted array -> \n"+Arrays.toString(arr));
    }

}
