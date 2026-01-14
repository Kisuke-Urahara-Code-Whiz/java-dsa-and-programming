package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode112 extends TreeNode {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        else if(targetSum-root.val==0 && root.left==null && root.right==null) return true;
        else{
            boolean flag = false;
            if(root.left!=null) flag=hasPathSum(root.left,targetSum-root.val);
            if(root.right!=null && !flag) flag=hasPathSum(root.right, targetSum-root.val);
            return flag;
        }
    }

}
