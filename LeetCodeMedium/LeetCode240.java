package LeetCodeMedium;

//Diagonal Search

public class LeetCode240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int r = 0;
        int c = 0;

        while(r<rowLength && c<colLength){
            if(matrix[r][c]==target || rowBinarySearch(matrix, rowLength, colLength, r, c, target) || colBinarySearch(matrix, rowLength, colLength, r, c, target)) return true;
            r+=1;
            c+=1;
        }
        return false;
    }

    private boolean rowBinarySearch(int[][] arr, int rowLength, int colLength, int r, int c, int target){
        if(c+1<colLength){
            int left = c+1;
            int right = colLength-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(arr[r][mid]==target) return true;
                else if(arr[r][mid]>target) right=mid-1;
                else left=mid+1;
            }
        }
        return false;
    }

    private boolean colBinarySearch(int[][] arr, int rowLength, int colLength, int r, int c, int target){
        if(r+1<rowLength){
            int left = r+1;
            int right = rowLength-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(arr[mid][c]==target) return true;
                else if(arr[mid][c]>target) right=mid-1;
                else left=mid+1;
            }
        }
        return false;
    }

}
