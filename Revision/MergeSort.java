package Revision;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr, int l, int r){
        if(r-l!=1){
            int mid = l+(r-l)/2;
            sort(arr, l, mid);
            sort(arr, mid, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r){
        int[] lArray = new int[mid-l];
        int[] rArray = new int[r-mid];
        int ptr = 0;
        for(int i=l;i<r;i++){
            if(i<mid){
                lArray[ptr] = arr[i];
            } else {
                rArray[ptr-(mid-l)] = arr[i];
            }
            ptr+=1;
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i<lArray.length && j<rArray.length){
            if(lArray[i]<rArray[j]) arr[k++] = lArray[i++];
            else arr[k++] = rArray[j++];
        }

        while(i<lArray.length){
            arr[k++] = lArray[i++];
        }

        while(j<rArray.length){
            arr[k++] = rArray[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] arr = new int[]{4,3,2,1};
        obj.sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
