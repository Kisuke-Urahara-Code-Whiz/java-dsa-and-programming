package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode449 extends TreeNode {

    int x = 0;

    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        preorder(root, sb);
        return new String(sb);
    }

    public TreeNode deserialize(String data) {
        int length = data.length()/2;
        int[] inorder = new int[length];
        int[] preorder = new int[length];
        for(int i=0;i<data.length();i++){
            if(i+1<=length)
                inorder[i] = data.charAt(i) - '0';
            else
                preorder[i-length] = data.charAt(i) - '0';
        }
        return buildTree(preorder, inorder);
    }

    public void inorder(TreeNode curr, StringBuilder sb){
        if(curr!=null){
            inorder(curr.left, sb);
            sb.append(curr.val);
            inorder(curr.right, sb);
        }
    }

    public void preorder(TreeNode curr, StringBuilder sb){
        if(curr!=null){
            sb.append(curr.val);
            preorder(curr.left, sb);
            preorder(curr.right, sb);
        }
    }

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
        LeetCode449 obj = new LeetCode449();
        TreeNode root = obj.buildTree(new Integer[]{2,1,3});
        String tree = obj.serialize(root);
        TreeNode ans = obj.deserialize(tree);
    }

}
