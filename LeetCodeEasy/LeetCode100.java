package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p==null) return false;
        else if(q==null) return false;
        else if(p.val!=q.val) return false;
        else{
            boolean flag = true;
            flag = isSameTree(p.left, q.left);
            if(flag) flag = isSameTree(p.right, q.right);
            return flag;
        }
    }
}
