package LeetCodeMedium;

//Transpose and Reverse

public class LeetCode48 {

    private void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    private void reverse(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            int a = 0;
            int b = matrix.length - 1;
            while(a<b){
                int temp = matrix[i][a];
                matrix[i][a++] = matrix[i][b];
                matrix[i][b--] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

}
