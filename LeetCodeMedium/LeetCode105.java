package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode105  extends TreeNode {

    int x = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int p, int q){
        boolean flag = true;
        int a = p;
        while(a<=q && flag){
            if(preorder[x]==inorder[a])
                flag = false;
            else
                a+=1;
        }
        if(!flag){
            TreeNode curr = new TreeNode(preorder[x]);
            int r = a-1;
            int l = a+1;
            if(r>=p) {
                x+=1;
                curr.left = build(preorder, inorder, p, r);
            }
            if(l<=q){
                x+=1;
                curr.right = build(preorder, inorder, l, q);
            }
            return curr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        LeetCode105 obj = new LeetCode105();
        obj.buildTree(preorder, inorder);
    }
}