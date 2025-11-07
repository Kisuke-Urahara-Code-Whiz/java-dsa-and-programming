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
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            Node curr = root.left;
            Node prev = root;
            System.out.print("Preorder Traversal : \n"+root.val+" -> ");
            while(!stack.isEmpty()){
                if(curr==null) {
                    prev = curr;
                    curr = stack.peek();
                    while(!stack.isEmpty() && curr.right==prev && curr!=null){
                        prev = stack.pop();
                        if(!stack.isEmpty())
                            curr = stack.peek();
                        else
                            curr = null;
                    }
                    if(curr!=null){
                        prev = curr;
                        curr = curr.right;
                    }
                } else if(curr.right==prev){
                    prev = curr;
                    if(!stack.isEmpty())
                        curr = stack.pop();
                } else {
                    System.out.print(curr.val+" -> ");
                    prev = curr;
                    stack.push(prev);
                    curr = curr.left;
                }
            }
            System.out.println("NULL");
        }
    }

}