package LeetCodeHard;

public class LeetCode1095 {

    interface MountainArray {
      public default int get(int index) { return 0; }
      public default int length() { return 0; }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        return binarySearch(mountainArr, target, findPeak(mountainArr));
    }

    public int findPeak(MountainArray arr) {
        int l = 0;
        int r = arr.length()-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr.get(mid)>arr.get(mid+1)) r=mid;
            else if(arr.get(mid)<arr.get(mid+1)) l=mid+1;
            else break;
        }
        return l;
    }

    public int binarySearch(MountainArray arr, int search, int peakIndex){
        int result = asc(arr, search, 0, peakIndex);
        if(result==-1) result = desc(arr, search, peakIndex+1, arr.length()-1);
        return result;
    }

    public int asc(MountainArray arr, int search, int l, int r){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr.get(mid)==search) return mid;
            else if(arr.get(mid)>search) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int desc(MountainArray arr, int search, int l, int r){
        if(l-r==0){
            if(arr.get(l)==search) return l;
            else return -1;
        } else {
            while(l<=r){
                int mid = l+(r-l)/2;
                if(arr.get(mid)==search) return mid;
                else if(arr.get(mid)>search) l=mid+1;
                else r=mid-1;
            }
            return -1;
        }
    }

}
