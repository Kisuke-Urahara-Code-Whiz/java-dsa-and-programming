package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }

    private int preorder(TreeNode node, int value){
        if(node.left==null && node.right==null) return value*10+node.val;
        else if(node.left==null) return preorder(node.right, value*10+node.val);
        else if(node.right==null) return preorder(node.left, value*10+node.val);
        else return preorder(node.right, value*10+node.val)+preorder(node.left, value*10+node.val);
    }

}
