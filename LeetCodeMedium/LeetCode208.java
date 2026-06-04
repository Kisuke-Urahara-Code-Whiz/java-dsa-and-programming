package LeetCodeMedium;

public class LeetCode208 {

    class Trie {

        Node root;

        static class Node{
            Node[] nodes;
            boolean eow;

            Node(){
                this.nodes = new Node[26];
                this.eow = false;
            }
        }

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            for(char c: word.toCharArray()){
                if(temp.nodes[c-97]==null) temp.nodes[c-97] = new Node();
                temp = temp.nodes[c-97];
            }
            temp.eow = true;
        }

        public boolean search(String word) {
            Node temp = root;
            for(char c: word.toCharArray()){
                if(temp.nodes[c-97]==null) return false;
                temp = temp.nodes[c-97];
            }
            return temp.eow;
        }

        public boolean startsWith(String prefix) {
            Node temp = root;
            for(char c: prefix.toCharArray()){
                if(temp.nodes[c-97]==null) return false;
                temp = temp.nodes[c-97];
            }
            return true;
        }
    }

}
