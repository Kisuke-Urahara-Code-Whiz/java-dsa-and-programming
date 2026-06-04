package GFG_Medium;

public class InsertionSort {

    public void insertionSort(int[] arr){
        int lastIndex = arr.length-1;
        for(int i=1;i<=lastIndex;i++){
            int key = arr[i];
            int swapIndex = i-1;
            while(swapIndex>=0 && arr[swapIndex]>key){
                arr[swapIndex+1] = arr[swapIndex];
                arr[swapIndex] = key;
                swapIndex--;

            }
        }
    }

}
