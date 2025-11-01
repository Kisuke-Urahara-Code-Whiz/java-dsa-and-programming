package LeetCodeMedium;

import java.util.*;

public class LeetCode116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelLength = queue.size();
        while(levelLength!=0){
            Node prev = null;
            for(int i=1;i<=levelLength;i++){
                Node node = queue.poll();
                if(prev==null)
                    prev = node;
                else{
                    prev.next = node;
                    prev = node;
                }
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            levelLength = queue.size();
        }
        return root;
    }

}
