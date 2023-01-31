class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(height(root.left)-height(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        int left = height(root.left)+1;
        int right = height(root.right)+1;
        return Math.max(left,right);
    }
}