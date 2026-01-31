package LeetCodeMedium;

public class LeetCode48 {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j<=(matrix[0].length-1)/2) swap(i,j,matrix);
            }
        }
    }

    private void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    private void swap(int m, int n, int[][] matrix){
        int temp = matrix[m][n];
        matrix[m][n] = matrix[m][matrix[0].length-1-n];
        matrix[m][matrix[0].length-1-n] = temp;
    }

}
