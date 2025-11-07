package Programs;

import java.util.Stack;

public class AVL {

    private class Node{
        int val;
        Node left;
        Node right;
        int height;

        Node(int value){
            this.val = value;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }

    private Node root;

    public void insert(int val){
        root = createNode(val,root);
    }
    private Node createNode(int val, Node curr){
        if(curr==null)
            return new Node(val);
        else if(curr.val==val){
            System.out.println("No Duplicate Values allowed!");
            return curr;
        } else if(curr.val>val){
            curr.left = createNode(val,curr.left);
            if(curr.right==null){
                curr.height = curr.left.height+1;
            } else {
                curr.height = Math.max(curr.left.height,curr.right.height)+1;
            }
            return curr;
        } else {
            curr.right = createNode(val,curr.right);
            if(curr.left==null){
                curr.height = curr.right.height+1;
            } else {
                curr.height = Math.max(curr.left.height,curr.right.height)+1;
            }
            return curr;
        }
    }

    public void inorder(){
        if(root!=null){
            System.out.println("Inorder Traversal -> ");
            inorderTraversal(root);
            System.out.print("null\n");
        }
    }

    private void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.left);
            System.out.print(node.val+" -> ");
            inorderTraversal(node.right);
        }
    }

    public void preorder(){
        if(root!=null){
            System.out.println("Preorder Traversal -> ");
            preorderTraversal(root);
            System.out.print("null\n");
        }
    }

    private void preorderTraversal(Node node){
        if(node!=null){
            System.out.print(node.val+" -> ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorder(){
        if(root!=null){
            System.out.println("Postorder Traversal -> ");
            postorderTraversal(root);
            System.out.print("null\n");
        }
    }

    private void postorderTraversal(Node node){
        if(node!=null){
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val+" -> ");
        }
    }

    public void getHeight(){
        if(root!=null){
            System.out.println("Height of tree is "+root.height);
        } else {
            System.out.println("Empty tree is empty");
        }
    }

    public void preorderStack(){
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        System.out.print("Preorder Traversal:\n");

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.val + " -> ");

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        System.out.println("NULL");
    }

}