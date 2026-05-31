package LeetCodeEasy;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sColor = image[sr][sc];

        if (sColor == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int m = image.length;
        int n = image[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && image[newRow][newCol] == sColor) {
                    image[newRow][newCol] = color;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }

}
