package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode530 {

    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node){
        if(node.left!=null) inorder(node.left);
        if(prev!=null) result = Math.min(node.val- prev.val, result);
        prev = node;
        if(node.right!=null) inorder(node.right);
    }

    static void main() {
        System.out.println(new LeetCode530().getMinimumDifference(new TreeNode().buildTree(new Integer[]{1,null,2})));
    }
}
