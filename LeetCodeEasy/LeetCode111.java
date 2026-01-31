package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null && root.right==null) return 1;
        else return inorder(root);
    }

    private int inorder(TreeNode node){
        if(node.left==null && node.right==null) return 1;
        else if(node.left==null) return inorder(node.right)+1;
        else if(node.right==null) return inorder(node.left)+1;
        else return Math.min(inorder(node.left)+1, inorder(node.right)+1);
    }

}
