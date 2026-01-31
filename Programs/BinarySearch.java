package Programs;

public class BinarySearch {

    public int binarySearch(int[] arr, int search){
        if(arr.length==1 && arr[0]==search) return 0;
        else if(arr.length == 1) return -1;
        else{
            if(arr[0]<arr[1]) return asc(arr,search);
            return desc(arr,search);
        }
    }

    public int asc(int[] arr, int search){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==search) return mid;
            else if(arr[mid]>search) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int desc(int[] arr, int search){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==search) return mid;
            else if(arr[mid]>search) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }

    static void main() {
        for(int i=0;i<=21;i++) {
            System.out.println("Index = " + new BinarySearch().binarySearch(new int[]{0,3,6,8,15,21}, i));
        }
    }
}
