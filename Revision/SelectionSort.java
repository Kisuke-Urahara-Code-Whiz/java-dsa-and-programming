package Revision;

import java.util.Arrays;

public class SelectionSort {

    private void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int max = 0;
            for(int j=1;j<=arr.length-i-1;j++){
                if(arr[j]>arr[max]) max=j;
            }
            int temp = arr[max];
            arr[max] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int[] arr = new int[]{5,5,4,3,2,1};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
