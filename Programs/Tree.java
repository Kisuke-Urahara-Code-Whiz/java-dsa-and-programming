package Programs;

public class Tree{
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(110);
        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.getHeight();
    }
}
