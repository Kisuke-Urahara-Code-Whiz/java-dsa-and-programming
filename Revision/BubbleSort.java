package Revision;

import java.util.Arrays;

public class BubbleSort {

    private void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int counter = 0;
            for(int j=0;j<=arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } else counter+=1;
            }
            if(counter==arr.length-i) break;
        }
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int[] arr = new int[]{5,5,4,3,2,1};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
