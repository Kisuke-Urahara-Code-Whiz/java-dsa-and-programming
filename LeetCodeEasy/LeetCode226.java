package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode226 extends TreeNode {

    public TreeNode invertTree(TreeNode root) {
        inversion(root);
        return root;
    }

    public void swap (TreeNode left, TreeNode right, TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void inversion(TreeNode node){
        if(node!=null){
            inversion(node.left);
            inversion(node.right);
            swap(node.left,node.right,node);
        }
    }

}
