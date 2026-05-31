package Revision;

public class DFS_Trees {

    static class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;

    }

    //all traversals are done considering that the root node is not null
    private void preorder(TreeNode node){
        System.out.println(node.value);
        if(node.left!=null) preorder(node.left);
        if(node.right!=null) preorder(node.right);
    }

    private void inorder(TreeNode node){
        if(node.left!=null) inorder(node.left);
        System.out.println(node.value);
        if(node.right!=null) inorder(node.right);
    }

    private void postorder(TreeNode node){
        if(node.left!=null)postorder(node.left);
        if(node.right!=null) postorder(node.right);
        System.out.println(node.value);
    }
}
