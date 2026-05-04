package Revision;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        int pivot = arr[mid];
        int s = l;
        int e = r;


        while (s <= e) {

            while (arr[s] < pivot) {
                s++;
            }

            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        
        sort(arr, l, e);
        sort(arr, s, r);
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] arr = new int[]{5, 2, 9, 1, 5, 6};
        obj.sort(arr, 0, arr.length - 1); // r is inclusive
        System.out.println(Arrays.toString(arr));
    }
}
