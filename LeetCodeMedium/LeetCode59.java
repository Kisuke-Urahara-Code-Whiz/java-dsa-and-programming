package LeetCodeMedium;

public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        if(n==1){
            return new int[][]{{1}};
        }
        int[][] spiral = new int[n][n];
        right(spiral, 0, 0, 0, n-1 , 0 , n-1, 1);
        return spiral;
    }

    public static void right(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2, int a){
        if(spiral[m][n]!=0)
            return;
        else{
            while(n<=c2){
                spiral[m][n++] = a++;
            }
            down(spiral,m+1,n-1,r1+1,r2,c1,c2,a);
        }
    }

    public static void down(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2, int a){
        if(spiral[m][n]!=0)
            return;
        else{
            while(m<=r2){
                spiral[m++][n] = a++;
            }
            left(spiral,m-1,n-1,r1,r2,c1,c2-1,a);
        }
    }

    public static void left(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2, int a){
        if(spiral[m][n]!=0)
            return;
        else{
            while(n>=c1){
                spiral[m][n--] = a++;
            }
            up(spiral, m-1, n+1, r1, r2-1, c1, c2, a);
        }
    }

    public static void up(int[][] spiral, int m, int n, int r1, int r2, int c1, int c2, int a){
        if(spiral[m][n]!=0)
            return;
        else{
            while(m>=r1){
                spiral[m--][n] = a++;
            }
            right(spiral, m+1, n+1, r1, r2, c1+1, c2, a);
        }
    }

}
