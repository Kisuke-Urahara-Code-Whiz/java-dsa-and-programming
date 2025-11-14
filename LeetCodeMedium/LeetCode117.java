package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

// THE OUTPUT FUNCTION WORKS LEVEL WISE
// NODE = 1
// LEVEL 1 = 1->NULL
// NODE = NODE.LEFT(IF NOT NULL) ELSE NODE.RIGHT = 2
// LEVEL 2 = 2->3->NULL
// NODE = NODE.LEFT(IF NOT NULL) ELSE NODE.RIGHT = 4
// LEVEL 3 = 4->5->7->NULL

public class LeetCode117 {

    public class Node {
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
    };

    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            Node curr = null;
            for(int i=1;i<=levelLength;i++){
                if(curr!=null){
                    curr.next = queue.poll();
                    curr = curr.next;
                } else {
                    curr = queue.poll();
                }
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            curr.next = null;
            levelLength = queue.size();
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode117 obj = new LeetCode117();

        Integer[] input = {1, 2, 3, 4, 5, null, 7};

        Node root = obj.buildTree(input);

        Node head = obj.connect(root);
    }

    public Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node curr = queue.poll();

            if (i < arr.length && arr[i] != null) {
                curr.left = new Node(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new Node(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
