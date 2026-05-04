package Revision;

import java.util.Arrays;

public class InsertionSort {

    private void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            while(j>=0 && arr[j]>arr[j+1]){
                swap(arr, j, j+1);
                j-=1;
            }
        }
    }

    private void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
