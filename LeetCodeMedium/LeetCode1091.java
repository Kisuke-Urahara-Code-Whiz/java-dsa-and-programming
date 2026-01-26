package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid.length-1]!=0) return -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int shortestPath = 0;
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        row.add(0);
        col.add(0);
        grid[0][0] = 1;
        int levelLength = row.size();
        while(!row.isEmpty()) {
            shortestPath += 1;
            for (int i = 1; i <= levelLength; i++) {
                int x = row.remove();
                int y = col.remove();
                if (x == grid.length - 1 && y == grid.length - 1) return shortestPath;
                for (int[] directions: dirs) {
                    int newX = x+directions[0];
                    int newY = y+directions[1];
                    boolean xCheck = newX >= 0 && newX < grid.length;
                    boolean yCheck = newY >= 0 && newY < grid.length;
                    if (xCheck && yCheck && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        row.add(newX);
                        col.add(newY);
                    }
                }
            }
            levelLength = row.size();
        }
        return -1;
    }

}
