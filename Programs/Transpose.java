package Programs;

import java.util.Scanner;

public class Transpose {

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows -> ");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns -> ");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println("Enter "+i+" "+j+" -> ");
                matrix[i][j] = sc.nextInt();
            }
        }
        displayMatrix(matrix);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        displayMatrix(matrix);
    }

    static void displayMatrix(int[][] matrix){
        System.out.println("Matrix -> ");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
