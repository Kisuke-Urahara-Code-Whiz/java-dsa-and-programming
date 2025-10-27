package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode543 extends TreeNode {

    int max = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        height(root);
        return max-1;
    }

    public int height(TreeNode node){
        if(node==null)
            return 0;
        else{
            int l = height(node.left);
            int r = height(node.right);
            max = (l+r+1)>max?l+r+1:max;
            return Math.max(l,r)+1;
        }
    }

}
