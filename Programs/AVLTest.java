package Programs;

public class AVLTest {

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(5);
        tree.inorder();
        tree.insert(1);
        tree.insert(6);
        tree.inorder();
        tree.getHeight();
    }
}
