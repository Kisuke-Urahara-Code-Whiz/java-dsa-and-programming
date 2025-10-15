package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    List<Integer> elements = new ArrayList<>();

    public void right(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2){
        if(m<r1 || m>r2 || n<c1 || n>c2)
            return;
        else{
            while(n<=c2){
                elements.add(spiral[m][n]);
                spiral[m][n++] = -101;
            }
            down(spiral,m+1,n-1,r1+1,r2,c1,c2);
        }
    }

    public void down(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2){
        if(m<r1 || m>r2 || n<c1 || n>c2)
            return;
        else{
            while(m<=r2){
                elements.add(spiral[m][n]);
                spiral[m++][n] = -101;
            }
            left(spiral,m-1,n-1,r1,r2,c1,c2-1);
        }
    }

    public void left(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2){
        if(m<r1 || m>r2 || n<c1 || n>c2)
            return;
        else{
            while(n>=c1){
                elements.add(spiral[m][n]);
                spiral[m][n--] = -101;
            }
            up(spiral, m-1, n+1, r1, r2-1, c1, c2);
        }
    }

    public void up(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2){
        if(m<r1 || m>r2 || n<c1 || n>c2)
            return;
        else{
            while(m>=r1){
                elements.add(spiral[m][n]);
                spiral[m--][n] = -101;
            }
            right(spiral, m+1, n+1, r1, r2, c1+1, c2);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        right(matrix, 0, 0, 0, matrix.length-1 , 0, matrix[0].length - 1);
        return elements;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        LeetCode54 obj = new LeetCode54();
        List<Integer> ele = obj.spiralOrder(matrix);
        System.out.println(ele);
    }
}
