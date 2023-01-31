class Solution {
    int res = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }
    void inorder(TreeNode root){
        if(root==null) 
            return;
        inorder(root.left);
        if(prev!=null){
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}