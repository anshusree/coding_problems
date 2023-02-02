class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode inorder(TreeNode root){
        if(root==null) return null;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
        return root;
    }
    public TreeNode buildBST(int l, int r){
        if(l>r) return null;
        int mid = (l+r)/2;
        TreeNode root = list.get(mid);
        root.left = buildBST(l, mid-1);
        root.right = buildBST(mid+1, r);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildBST(0,list.size()-1);
    }
}