package LeetCodeMedium;

public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(m==1 && n==1 && board[0][0]==word.charAt(0) && word.length()==1)
            return true;
        char[] w = word.toCharArray();
        char[] direction = new char[]{'u','d','l','r'};
        boolean[][] used = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                used[i][j] = false;
            }
        }
        boolean flag = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flag = flag || backtrack(board, used, w, 0, i, j, direction);
                if(flag)
                    return flag;
            }
        }
        return flag;
    }

    public boolean backtrack(char[][] board, boolean[][] used, char[] word, int p, int m, int n, char[] direction){
        if(p==word.length)
            return true;
        else if(used[m][n] || board[m][n] != word[p])
            return false;
        else{
            boolean f = false;
            used[m][n] = true;
            for(char c:direction){
                switch (c){
                    case 'u':   if(m-1>-1)
                                    f= f || backtrack(board, used, word, p+1, m-1, n, direction);
                                break;
                    case 'd':   if(m+1<board.length)
                                    f= f || backtrack(board, used, word, p+1, m+1, n, direction);
                                break;
                    case 'r':   if(n+1<board[0].length)
                                    f= f || backtrack(board, used, word, p+1, m, n+1, direction);
                                break;
                    case 'l':   if(n-1>-1)
                                    f= f || backtrack(board, used, word, p+1, m, n-1, direction);
                                break;
                }
                if(f)
                    break;
            }
            used[m][n] = false;
            return f;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a'},
        };
        System.out.println("Board - >");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j< board[0].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
        String word = "ab";
        LeetCode79 obj = new LeetCode79();
        System.out.println("Searching word "+word+" -> "+obj.exist(board,word));

    }

}
