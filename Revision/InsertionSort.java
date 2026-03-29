package Revision;

import java.util.Arrays;

public class InsertionSort {

    private void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int[] arr = new int[]{5,4,3,2,1};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
