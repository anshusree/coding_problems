class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        preorder(root1);
        preorder(root2);
        Collections.sort(list);
        return list;
    }
    public void preorder(TreeNode root){
        if(root==null) return;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}