package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode230 extends TreeNode {

    int n;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return n;
    }

    public int inorder(TreeNode node, int k){
        if(node!=null){
            if(k!=-1)
                k = inorder(node.left,k);
            if(k!=-1){
                k-=1;
                if(k==0){
                    n = node.val;
                    k=-1;
                }
            }
            if(k!=-1) {
                k = inorder(node.right, k);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        LeetCode230 obj = new LeetCode230();
        TreeNode root = obj.buildTree(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println("Kth smallest element -> "+obj.kthSmallest(root,2));
    }

}
