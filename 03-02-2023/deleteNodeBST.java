class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key)
            return attach(root);
        TreeNode node = root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left = attach(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right = attach(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return node;
    }
    public TreeNode attach(TreeNode root){
        if(root.left==null)
            return root.right;
        else if(root.right==null)
            return root.left;
        else{
            TreeNode rightChild = root.right;
            TreeNode lastright = lastRight(root.left);
            lastright.right = rightChild;
            return root.left;
        }
    }
    public TreeNode lastRight(TreeNode root){
        if(root.right==null)
            return root;
        return lastRight(root.right);
    }
}