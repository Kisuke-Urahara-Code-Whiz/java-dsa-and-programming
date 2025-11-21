package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode112 extends TreeNode {

    int s = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root!=null){
            s = s+root.val;
            boolean flag = root.left!=null?hasPathSum(root.left,targetSum):s==targetSum?true:false;
            flag = flag?flag:root.right!=null?hasPathSum(root.right,targetSum):s==targetSum?true:false;
            s = s-root.val;
            return flag;
        } else {
            return false;
        }
    }

}
