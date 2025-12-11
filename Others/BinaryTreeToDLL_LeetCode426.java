package Others;

//Binary Tree to DLL
//Difficulty: Hard(GeekForGeeks) Accuracy: 53.36% Submissions: 167K+ Points: 8 Average Time: 60m
//Given a root of binary tree (BT), convert it to a Doubly Linked List (DLL) in place using the same node structure. The left and right pointers in the binary tree nodes should be used as prev and next pointers respectively in the resulting DLL .The DLL should be formed by performing an inorder traversal of the binary tree (i.e., Left → Root → Right).The first node in the inorder traversal (i.e., the leftmost node) should become the head of the DLL. Return the head of the resulting DLL.
//        Note: h is the tree's height, and this space is used implicitly for the recursion stack.

public class BinaryTreeToDLL_LeetCode426 {

    static class Node {
        int data;
        Node left, right;

        Node() {
            this.data = 0;
            this.left = this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node bToDLL(Node root) {
        if(root==null)
            return null;
        Node res = new Node(0);
        inorder(root, res);
        res = res.right;
        res.left = null;
        return res;
    }

    Node inorder(Node curr, Node prev){
        if(curr.left!=null){
            prev = inorder(curr.left, prev);
        }
        prev.right = curr;
        curr.left = prev;
        if(curr.right!=null){
            return inorder(curr.right, curr);
        } else {
            return curr;
        }
    }
}