package Programs;

public class AVLTest {

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        tree.preorder();
        tree.preorderStack();
    }
}
