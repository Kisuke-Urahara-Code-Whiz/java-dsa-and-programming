package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode98 extends TreeNode {

    int n;
    int c = 0;
    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        flag = root.left!=null?isValidBST(root.left):flag;
        if(flag){
            if(c==0){
                c = 1;
                n = root.val;
            } else {
                if(n>=root.val)
                    flag = false;
                else
                    n = root.val;
            }
        }
        flag = !flag?flag:root.right!=null?isValidBST(root.right):flag;
        return flag;
    }

}
