package Revision;

import java.util.Arrays;

public class MergeSort {

    public int[] divide(int arr[], int l, int r){
        if(r-l==1) return arr;
        int mid = l+(r-l)/2;
        int arr1[] = new int[mid-l];
        int arr2[] = new int[r-mid];
        int counter = 0;
        for(int i=0;i<(mid-l);i++){
            arr1[i] = arr[counter++];
        }
        for(int i=0;i<(r-mid);i++){
            arr2[i] = arr[counter++];
        }
        return conquer(divide(arr1, l, mid), divide(arr2, mid, r));
    }

    public int[] conquer(int[] arr1, int[] arr2){
        int arr[] = new int[arr1.length+ arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]>arr2[j]) arr[k++] = arr2[j++];
            else arr[k++] = arr1[i++];
        }
        while(i<arr1.length){
            arr[k++] = arr1[i++];
        }
        while(j<arr2.length){
            arr[k++] = arr2[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        System.out.println(Arrays.toString(obj.divide(new int[]{5,4,3,2,1}, 0, new int[]{5,4,3,2,1}.length)));
    }
}
