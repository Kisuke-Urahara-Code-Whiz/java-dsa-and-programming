package Programs;

public class BST {

    private class Node{

        int value;
        Node right;
        Node left;
        int height;

        Node(int value){
            this.value = value;
            this.height = 0;
        }

        Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public void insert(int value){
        if(root==null){
            root = new Node(value);
        } else {
            insertNode(root, value);
        }
    }

    private void insertNode(Node node, int value){
        if(value == node.value)
            System.out.println("Invalid -> Duplicates cannot be inserted in BST");
        else{
            if(node.value>value){
                if(node.left==null){
                    System.out.println(value+" inserted ");
                    node.left = new Node(value);
                } else  {
                    insertNode(node.left, value);
                }
            } else {
                if(node.right==null){
                    System.out.println(value+" inserted ");
                    node.right = new Node(value);
                } else  {
                    insertNode(node.right, value);
                }
            }
            node.height = 1 + Math.max(
                    (node.left != null ? node.left.height : -1),
                    (node.right != null ? node.right.height : -1)
            );
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
            System.out.print(node.value+" -> ");
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
            System.out.print(node.value+" -> ");
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
            System.out.print(node.value+" -> ");
        }
    }

    public void getHeight(){
        if(root!=null){
            System.out.println("Height of tree is "+root.height);
        } else {
            System.out.println("Empty tree is empty");
        }
    }

}
