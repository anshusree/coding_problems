class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (root==null) || (issame(root.left,root.right));
    }
    private boolean issame(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null){
            return root1==root2;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return issame(root1.left,root2.right) && issame(root1.right,root2.left);
    }
}