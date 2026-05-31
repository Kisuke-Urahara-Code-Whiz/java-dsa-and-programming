package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {

    public int orangesRotting(int[][] grid) {

        int goodOranges = 0;
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int levelLength = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) goodOranges+=1;
                else if(grid[i][j]==2){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        levelLength = x.size();
        int min = 0;

        while(!x.isEmpty() && goodOranges>0){
            while(levelLength>0) {
                int i = x.remove();
                int j = y.remove();
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    x.add(i + 1);
                    y.add(j);
                    grid[i + 1][j] = 2;
                    goodOranges -= 1;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    x.add(i - 1);
                    y.add(j);
                    grid[i - 1][j] = 2;
                    goodOranges -= 1;
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    x.add(i);
                    y.add(j + 1);
                    grid[i][j + 1] = 2;
                    goodOranges -= 1;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    x.add(i);
                    y.add(j - 1);
                    grid[i][j - 1] = 2;
                    goodOranges -= 1;
                }
                levelLength-=1;
            }
            levelLength = x.size();
            if(levelLength>0) min+=1;
        }

        if(goodOranges>0) return -1;
        else return min;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(new LeetCode994().orangesRotting(grid));
    }
}
