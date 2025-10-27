package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode114 extends TreeNode {

    //First solution -
    //Time Complexity - O(N)
    //Space Complexity - O(H)

    public void flatten(TreeNode root) {
        if(root != null) {
            flattening(root);
        }
    }

    public TreeNode flattening(TreeNode curr) {
        TreeNode temp = curr;
        if(curr!=null){
            if(curr.left!=null){
                temp =  flattening(curr.left);
                temp.right = curr.right == null? temp.right: curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            if(temp.right!=null){
                temp = flattening(temp.right);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        LeetCode114 obj = new LeetCode114();
        TreeNode root = obj.buildTree(new Integer[]{1,2,5,3,4,null,6});
        obj.flatten(root);
    }
}
