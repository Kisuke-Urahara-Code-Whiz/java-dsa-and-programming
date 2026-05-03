package Revision;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,6,3,1,5};
        MaxHeap obj = new MaxHeap(arr.length);
        for (int j : arr) {
            obj.insert(j);
        }
        int x = arr.length-1;
        for(int j : arr){
            arr[x--] = obj.delete();
        }
        System.out.println(Arrays.toString(arr));
    }

}
