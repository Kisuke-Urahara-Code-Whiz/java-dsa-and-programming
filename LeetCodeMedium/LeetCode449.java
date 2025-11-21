package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode449 extends TreeNode {

    private int x = 0;
    private int l = 0;

    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        sb.append('x').append('&');
        preorder(root, sb);
        sb.append('x');
        sb.append(l);
        return new String(sb);
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        int length = 0;
        int index = data.length()-1;
        int pow = 0;
        while(data.charAt(index)!='x'){
            length = length+((data.charAt(index--)-'0')*(int)Math.pow(10,pow++));
        }
        int[] inorder = new int[length];
        int[] preorder = new int[length];
        int num = 0;
        int arrayIndex = 0;
        int counter = 0;
        int pointer = 1;
        while(pointer<(data.length()-1)){
            char c = data.charAt(pointer);
            if(c=='&') {
                counter = 1;
                arrayIndex = 0;
                pointer+=1;
            }
            else if(counter==0){
                if(c=='x') {
                    inorder[arrayIndex] = num;
                    arrayIndex+=1;
                    num = 0;
                } else {
                    num = num*10+(c-'0');
                }
            } else {
                if(c=='x') {
                    preorder[arrayIndex] = num;
                    arrayIndex+=1;
                    num = 0;
                } else {
                    num = num*10+(c-'0');
                }
            }
            pointer+=1;
        }
        return buildTree(preorder, inorder);
    }

    public void inorder(TreeNode curr, StringBuilder sb){
        if(curr.left!=null) inorder(curr.left, sb);
        l+=1;
        sb.append('x').append(curr.val);
        if(curr.right!=null) inorder(curr.right, sb);
    }

    public void preorder(TreeNode curr, StringBuilder sb){
        sb.append('x').append(curr.val);
        if(curr.left!=null) preorder(curr.left, sb);
        if(curr.right!=null) preorder(curr.right, sb);
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
        LeetCode449 obj1 = new LeetCode449();
        TreeNode root = obj.buildTree(new Integer[]{2,1,3});
        String tree = obj.serialize(root);
        System.out.println(tree);
        TreeNode ans = obj1.deserialize(tree);
    }

}
