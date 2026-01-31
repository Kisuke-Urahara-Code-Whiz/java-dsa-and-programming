package LeetCodeMedium;

import java.util.Arrays;

public class LeetCode852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]>arr[mid+1]) r=mid;
            else if(arr[mid]<arr[mid+1]) l=mid+1;
            else break;
        }
        return l;
    }

    static void main() {
        int[][] mountainArrays = new int[10][];

        mountainArrays[0] = new int[]{1, 3, 2};
        mountainArrays[1] = new int[]{0, 5, 10, 5, 0};
        mountainArrays[2] = new int[]{1, 2, 3, 4, 5, 6, 7, 3};
        mountainArrays[3] = new int[]{2, 10, 8, 6, 4, 2, 0};
        mountainArrays[4] = new int[]{0, 100, 0};
        mountainArrays[5] = new int[]{-5, -1, 3, 0, -2};
        mountainArrays[6] = new int[]{1000, 2000, 5000, 3000, 1000};
        mountainArrays[7] = new int[]{1, 2, 3, 2, 1};
        mountainArrays[8] = new int[]{1, 50, 49, 48, 47, 46};
        mountainArrays[9] = new int[]{0, 2, 4, 6, 8, 10, 15, 10, 5, 0};

        int[] expectedPeaks = new int[10];
        expectedPeaks[0] = 1;
        expectedPeaks[1] = 2;
        expectedPeaks[2] = 6;
        expectedPeaks[3] = 1;
        expectedPeaks[4] = 1;
        expectedPeaks[5] = 2;
        expectedPeaks[6] = 2;
        expectedPeaks[7] = 2;
        expectedPeaks[8] = 1;
        expectedPeaks[9] = 6;

        for(int i=0;i<mountainArrays.length;i++){
            System.out.println(
                    Arrays.toString(
                            mountainArrays[i])+" -> "+new LeetCode852().peakIndexInMountainArray(mountainArrays[i])
                            +"\nExpected Peak -> "+expectedPeaks[i]+"\n");
        }
    }

}
