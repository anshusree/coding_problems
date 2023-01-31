class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return tree(preorder, inorder, inMap, 0, preorder.length, 0, inorder.length, new int[]{0});
    }
    public TreeNode tree(int[] preorder, int[] inorder, HashMap<Integer,Integer> inMap, int ps, int pe, int is, int ie, int[] curr){
        if(curr[0]==preorder.length || pe<ps || ie<is){
            return null;
        }
        TreeNode node = new TreeNode(preorder[curr[0]]);
        int inPlace = inMap.get(preorder[curr[0]++]);
        int countLeft = inPlace - is;
        node.left = tree(preorder, inorder, inMap, ps+1, ps+countLeft, is, inPlace-1, curr);
        node.right = tree(preorder, inorder, inMap, ps+countLeft+1, pe, inPlace+1, ie, curr);
        return node;
    }
}