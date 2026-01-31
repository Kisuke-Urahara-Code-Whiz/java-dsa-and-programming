package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode2265 {

    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return result;
    }

    private int postorder(TreeNode node){
        int count = 1;
        int sum = node.val;
        if(node.left!=null){
            count+=postorder(node.left);
            sum+=node.left.val;
        }
        if(node.right!=null){
            count+=postorder(node.right);
            sum+=node.right.val;
        }
        if(sum/count==node.val) result+=1;
        node.val = sum;
        return count;
    }

}
