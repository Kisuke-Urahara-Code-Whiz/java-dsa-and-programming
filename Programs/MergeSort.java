package Programs;

import java.util.Arrays;

public class MergeSort {

    private void divide(int[] arr, int l, int r){
        if(r-l!=1){
            int mid = l+(r-l)/2;
            divide(arr, l, mid);
            divide(arr, mid, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r){
        int[] lArr = new int[mid-l];
        int[] rArr = new int[r-mid];

        int a = l;
        int b = mid;

        for(int i=0;i<(mid-l);i++){
            lArr[i] = arr[a++];
        }

        for(int i=0;i<(r-mid);i++){
            rArr[i] = arr[b++];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i<lArr.length && j<rArr.length){
            if(lArr[i]<=rArr[j]) arr[k++] = lArr[i++];
            else arr[k++] = rArr[j++];
        }

        while(i<lArr.length){
            arr[k++] = lArr[i++];
        }

        while(j<rArr.length){
            arr[k++] = rArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,34,45,23,14,54,1};
        System.out.println("Original array -> \n"+ Arrays.toString(arr));
        MergeSort obj = new MergeSort();
        obj.divide(arr, 0, arr.length);
        System.out.println("Sorted array -> \n"+Arrays.toString(arr));
    }

}
