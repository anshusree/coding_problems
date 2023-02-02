class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        inorder(root,k);
        return res.get(k-1);
    }
    public void inorder(TreeNode root, int k){
        if(root==null) return;
        inorder(root.left,k);
        res.add(root.val);
        inorder(root.right,k);
        return;
    }
}