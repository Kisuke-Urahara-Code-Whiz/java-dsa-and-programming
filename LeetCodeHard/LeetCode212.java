package LeetCodeHard;

import java.util.ArrayList;
import java.util.List;

//Trie+DFS+Trie Pruning after the word is found
public class LeetCode212 {

    List<String> result = new ArrayList<>();
    String[] words;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    boolean[][] visited;
    boolean[] wordsFound;
    int m;
    int n;

    private static class Node{
        Node[] nodes;
        boolean eow;
        int index;
        private int childCount;

        Node(boolean eow){
            this.nodes = new Node[26];
            this.eow = eow;
            this.index = -1;
            this.childCount = 0;
        }

        void setIndex(int index){
            this.index = index;
        }

        void addChildCount(){
            this.childCount+=1;
        }

        void subChildCount(int index) {
            this.childCount-=1;
            this.nodes[index] = null;
        }

        boolean isParent() { return this.childCount!=0; }
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        if(m==1 && n==1){
             for(String i: words){
                 if(i.length()==1 && i.charAt(0)==board[0][0]) result.add(i);
             }
             return result;
        }

        this.words = words;
        Node root = new Node(false);
        for(int i=0; i< words.length; i++){
            Node temp = root;
            for(char j: words[i].toCharArray()){
                int n = j-97;
                if(temp.nodes[n]==null){ temp.nodes[n] = new Node(false); temp.addChildCount(); }
                temp = temp.nodes[n];
            }
            temp.eow = true;
            temp.setIndex(i);
        }

        visited = new boolean[m][n];
        wordsFound = new boolean[words.length];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int asc = board[i][j] - 97;
                if(root.nodes[asc]!=null){
                    boolean flag = dfs(root.nodes[asc], i, j, board);
                    if(flag) root.subChildCount(asc);
                }
            }
        }

        return result;
    }

    private boolean dfs(Node temp, int x, int y, char[][] board){
        visited[x][y] = true;
        if(temp.eow && !wordsFound[temp.index]){
            result.add(words[temp.index]);
            wordsFound[temp.index] = true;
        }
        for (int[] i : directions) {
            if(temp.isParent()) {
                int newX = x + i[0];
                int newY = y + i[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int asc = board[newX][newY] - 97;
                    if (temp.nodes[asc] != null) {
                        boolean flag = dfs(temp.nodes[asc], newX, newY, board);
                        if (flag) temp.subChildCount(asc);
                    }
                }
            } else break;
        }
        visited[x][y] = false;
        return !temp.isParent();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode212().findWords(
                new char[][]{
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                },
                new String[]{"oath","pea","eat","rain"}
        ));
    }

}
