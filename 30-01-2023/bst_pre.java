class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int upperBound = Integer.MAX_VALUE;
        return tree(preorder, upperBound, new int[]{0});
    }
    public TreeNode tree(int[] preorder, int upperBound, int[] curr){
        if(curr[0]==preorder.length){
            return null;
        }
        if(preorder[curr[0]]>upperBound){
            return null;
        }
        TreeNode node = new TreeNode(preorder[curr[0]++]);
        node.left = tree(preorder, node.val, curr);
        node.right = tree(preorder, upperBound, curr);
        return node;
    }
}