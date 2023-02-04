class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Preorder(root);
        TreeNode node = root;
        node.left = null;
        node.right = null;
        for(int i = 1; i<list.size(); i++){
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
    }
    void Preorder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        Preorder(root.left);
        Preorder(root.right);
    }
}