package LeetCodeMedium;

public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int l = 0;
        int r = rowLength*colLength-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            int row = mid/colLength;
            int col = mid%colLength;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) l = mid+1;
            else r = mid-1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode74().searchMatrix(new int[][]{{1, 1},{1,1}}, 2));
    }

}
