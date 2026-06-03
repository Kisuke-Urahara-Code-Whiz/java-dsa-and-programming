package Revision;

public class NQueens {

    int[][] directions = new int[][]{
            {1,0},{1,1},{1,-1}
    }; // Only Disable the same column and the diagonals below the row u are at

    private int[][] findBoard(int m){
        int[][] board = new int[m][m];
        int[][] available = new int[m][m];
        backtrack(board, available, 0);
        return board;
    }

    private boolean backtrack(int[][] board, int[][] available, int row){
        if(row== board.length) return true;
        for(int i=0;i< board.length;i++){
            if(available[row][i]==0) {
                board[row][i] = 1;
                disable(available, row, i);
                if(backtrack(board, available, row+1)) return true;
                enable(available, row, i);
                board[row][i] = 0;
            }
        }
        return false;
    }

    private void disable(int[][] available, int x, int y){
        for(int[] i: directions){
            int tempX = x+i[0];
            int tempY = y+i[1];
            while(tempX>=0 && tempY>=0 && tempX<available.length && tempY<available.length) {
                available[tempX][tempY] += 1;
                tempX += i[0];
                tempY += i[1];
            }
        }
    }

    private void enable(int[][] available, int x, int y){
        for(int[] i: directions){
            int tempX = x+i[0];
            int tempY = y+i[1];
            while(tempX>=0 && tempY>=0 && tempX<available.length && tempY<available.length) {
                available[tempX][tempY] -= 1;
                tempX += i[0];
                tempY += i[1];
            }
        }
    }

    private void display(int[][] board){
        System.out.println("Board --> ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new NQueens().display(new NQueens().findBoard(50));
    }

}
