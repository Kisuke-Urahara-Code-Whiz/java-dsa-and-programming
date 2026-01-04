package Programs;

import java.util.Arrays;

public class CyclicSort {

    public int[] cyclicSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1) swap(i, arr[i]-1, arr);
        }
        return arr;
    }

    public void swap(int index1, int index2, int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
     }

    static void main() {
        System.out.println(Arrays.toString(new CyclicSort().cyclicSort(new int[]{1,3,4,2})));
    }
}
