package Programs;

public class Tree{
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(30);
        tree.insert(7);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.inorder();
        tree.preorder();
        tree.postorder();
    }
}
