package Programs;

public class AVLTest {

    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i : new int[]{30, 70, 20, 40, 60, 80, 10, 25, 35, 45}) {
            tree.insert(i);
        }
        tree.preorderStack();
        tree.BFS();
    }
}
