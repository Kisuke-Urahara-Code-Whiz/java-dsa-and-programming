package LeetCodeMedium;

public class LeetCode200 {

    int m;
    int n;
    boolean[][] visited;
    int[][] directions;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(m==1 && n==1){
            if(grid[0][0]=='1') return 1;
            else return 0;
        }

        visited = new boolean[m][n];
        directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j, grid);
                    result+=1;
                }
            }
        }

        return result;
    }

    private void dfs(int x, int y, char[][] grid){
        visited[x][y] = true;
        for(int[] i: directions){
            int newX = x+i[0];
            int newY = y+i[1];
            if(newX>=0 && newX<m && newY>=0 && newY<n && !visited[newX][newY] && grid[newX][newY]=='1')
                dfs(newX, newY, grid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode200().numIslands(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }
        ));
    }
}
