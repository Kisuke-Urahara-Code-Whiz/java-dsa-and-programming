package Programs;

public class RotatedSortedArray {

    public int findPivot(int[] arr){
        int s = 0;
        int e = arr.length-1;
        if(arr[s]<arr[e]){
            return e;
        }
        int a = 0;
        while(s<e){
            int mid = s + (e - s)/2;
            boolean flag1 = mid+1<arr.length;
            boolean flag2 = mid-1>=0;
            if(flag1){
                if(arr[mid]>arr[mid+1]){
                    a = mid;
                    break;
                }
            }
            if(flag2){
                if(arr[mid]<arr[mid-1]){
                    a = mid-1;
                    break;
                }
            }
            if(arr[mid]>arr[e])
                    s=mid+1;
            else
                    e=mid-1;
        }
        return a;
    }

    public int binarySearch(int[] arr, int s, int e, int ele){
        while(s<=e){
            int mid = s + (e - s)/2;
            if(arr[mid] == ele){
                return mid;
            }
            else{
                if(arr[mid]>ele)
                    e = mid-1;
                else
                    s = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,1,2};
        RotatedSortedArray obj = new RotatedSortedArray();
        int pivot = obj.findPivot(arr);
        int index1 = obj.binarySearch(arr,0,pivot,2);
        if(index1!=-1)
            System.out.println("Index -> "+index1);
        else if(pivot<arr.length){
            int index2 = obj.binarySearch(arr,pivot+1,arr.length-1,2);
            if(index2!=-1)
                System.out.println("Index -> "+index2);
            else
                System.out.println("Index -> -1");
        }
        else
            System.out.println("Index -> -1");
    }
}
