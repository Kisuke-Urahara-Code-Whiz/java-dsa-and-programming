package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode104 extends TreeNode {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return height(root);
    }

    public int height(TreeNode node){
        if(node==null)
            return 0;
        else
            return 1+Math.max(height(node.left),height(node.right));
    }

}
