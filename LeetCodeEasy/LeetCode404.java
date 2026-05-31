package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode404 {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        preorder(root);
        return sum;
    }

    private boolean preorder(TreeNode node){
        if(node.left==null && node.right==null) return true;
        if(node.left!=null) if(preorder(node.left)) sum+=node.left.val;
        if(node.right!=null) preorder(node.right);
        return false;
    }

}
