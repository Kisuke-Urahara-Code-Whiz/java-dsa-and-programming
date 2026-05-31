package LeetCodeMedium;

import java.util.List;

public class LeetCode139 {

    private static class Node{
        Node[] children;
        boolean eow;
        int childrenCount;

        Node(){
            this.children = new Node[26];
            this.eow = false;
            this.childrenCount+=1;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for(String str: wordDict){
            Node temp = root;
            for(char c: str.toCharArray()){
                int index = c-97;
                if(temp.children[index] == null){
                    temp.children[index] = new Node();
                    temp.childrenCount+=1;
                }
                temp = temp.children[index];
            }
            temp.eow = true;
        }

        Node temp = root;
        for(char c: s.toCharArray()){
            if(temp.childrenCount==0) temp = root;
            int index = c-97;
            if(temp.children[index] == null) return false;
            else temp = temp.children[index];
        }

        return temp.eow;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode139().wordBreak("aaaaaaa", List.of("aaaa","aaa")));
    }

}
